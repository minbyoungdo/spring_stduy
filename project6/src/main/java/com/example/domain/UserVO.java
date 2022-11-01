package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class UserVO {
	private String uid;
	private String passwd;
	private String name;
	private String address;
	private String phone;
}
