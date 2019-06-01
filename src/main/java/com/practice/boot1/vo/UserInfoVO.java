package com.practice.boot1.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("ui")
@Data
public class UserInfoVO {
	private Integer uiNo;
	private String uiId;
	private String uiPwd;
	private String uiName;
	private String tokken;
	private String salt;
}
