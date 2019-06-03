package com.practice.boot1.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.practice.boot1.auth.MakeJWT;
import com.practice.boot1.mapper.UserInfoMapper;
import com.practice.boot1.service.UserInfoService;
import com.practice.boot1.util.SHAEncoder;
import com.practice.boot1.vo.UserInfoVO;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoMapper uim;

	@Override
	public List<UserInfoVO> selectUserInfoList() {

		return uim.selectUserInfoList();
	}

	@Override
	public UserInfoVO selectUserInfo(UserInfoVO ui) {

		return uim.selectUserInfo(ui);
	}

	@Override
	public int insertUserInfo(UserInfoVO ui) {
		Map<String, String> encodeMap = SHAEncoder.encode(ui.getUiPwd());
		ui.setSalt(encodeMap.get("salt"));
		ui.setUiPwd(encodeMap.get("pwd"));
		int result = uim.insertUserInfo(ui);
		return result;
	}

	@Override
	public int updateUserInfo(UserInfoVO ui) {

		return uim.updateUserInfo(ui);
	}

	@Override
	public int deleteUserInfo(UserInfoVO ui) {

		return uim.deleteUserInfo(ui);
	}

	@Override
	public UserInfoVO login(UserInfoVO ui) {
		if (ui.getUiId() != null) {
			if (ui.getUiPwd() != null) {
				UserInfoVO dbui = uim.selectUserInfo(ui);
				try {
					if (dbui.getSalt() != null) {
						Map<String, String> encodeData = SHAEncoder.encode(ui.getUiPwd(), dbui.getSalt());
						ui.setSalt(encodeData.get("salt"));
						ui.setUiPwd(encodeData.get("pwd"));
						if (ui.getUiId().equals(dbui.getUiId()) && ui.getUiPwd().equals(dbui.getUiPwd())) {
							if(dbui.getSalt()!=null) {
								ui.setTokken(MakeJWT.makeJWT(dbui.getSalt(), ui));
								ui.setUiPwd("");
								return ui;
							}
						}
					}
				}catch(Exception e) {
					return ui;
				}
			}
		}
		return ui;
	}
}
