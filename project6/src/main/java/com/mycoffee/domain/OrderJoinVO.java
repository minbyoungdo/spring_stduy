package com.mycoffee.domain;


import java.util.Date;

import lombok.Data;

@Data
public class OrderJoinVO {
	private String oid;//주문번호
	private String userid;//손님
	private String did;//배달원
	private int totalprice;//총 가격
	private int status;//code
	private Date registdate;
	private Date updatedate;
	private Date orderdate;
	private String pid;//프로덕트 아이디
	private int pieces;//갯수
	private int price;//프로덕트 단일 가격
}
