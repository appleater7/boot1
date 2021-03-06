package com.practice.boot1.service;

import java.util.List;

import com.practice.boot1.vo.UserInfoVO;

public interface UserInfoService {
	List<UserInfoVO> selectUserInfoList();
	UserInfoVO selectUserInfo(UserInfoVO ui);
	int insertUserInfo(UserInfoVO ui);
	int updateUserInfo(UserInfoVO ui);
	int deleteUserInfo(UserInfoVO ui);
	UserInfoVO login(UserInfoVO ui);
}
