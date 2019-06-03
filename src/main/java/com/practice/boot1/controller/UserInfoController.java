package com.practice.boot1.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.boot1.service.UserInfoService;
import com.practice.boot1.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins="*")
@Slf4j
@Controller
public class UserInfoController {
	
//	List<UserInfoVO> selectUserInfoList();
//	UserInfoVO selectUserInfo(UserInfoVO ui);
//	int insertUserInfo(UserInfoVO ui);
//	int updateUserInfo(UserInfoVO ui);
//	int deleteUserInfo(UserInfoVO ui);

	@Resource
	private UserInfoService uis;
	
	@GetMapping("/userinfos")
	public @ResponseBody List<UserInfoVO> selectUserInfoList() {
		List<UserInfoVO> uiList = uis.selectUserInfoList();
		log.info("uiList=>{}",uiList);
		return uiList;
	}
	@GetMapping("/userinfo")
	public @ResponseBody UserInfoVO selectUserInfo(@RequestBody UserInfoVO ui) {
		UserInfoVO dbUi = uis.selectUserInfo(ui);
		log.info("select uiIn=>{}",ui);
		log.info("select uiOut=>{}",dbUi);
		return dbUi;
	}
	@PostMapping("/userinfo")
	public @ResponseBody int insertUserInfo(@RequestBody UserInfoVO ui) {
		log.info("insert uiIn=>{}",ui);
		return uis.insertUserInfo(ui);
	}
	@PutMapping("/userinfo")
	public @ResponseBody int updateUserInfo(@RequestBody UserInfoVO ui) {
		log.info("update uiIn=>{}",ui);
		return uis.updateUserInfo(ui);
	}
	@DeleteMapping("/userinfo")
	public @ResponseBody int deleteUserInfo(@RequestBody UserInfoVO ui) {
		log.info("delete uiIn=>{}",ui);
		return uis.deleteUserInfo(ui);
	}
	@PostMapping("/login")
	public @ResponseBody UserInfoVO login(@RequestBody UserInfoVO ui) {
		log.info("login uiIn=>{}",ui);
		return uis.login(ui);
	}
}
