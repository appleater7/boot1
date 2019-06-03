package com.practice.boot1.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.practice.boot1.vo.UserInfoVO;

@MapperScan
public interface UserInfoMapper {
	List<UserInfoVO> selectUserInfoList();
	UserInfoVO selectUserInfo(UserInfoVO ui);
	int insertUserInfo(UserInfoVO ui);
	int updateUserInfo(UserInfoVO ui);
	int deleteUserInfo(UserInfoVO ui);
}
