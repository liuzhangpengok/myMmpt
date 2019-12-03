package com.mingkai.mmpt.enums;

/**
 * 问卷排序类型
 */
public enum ActivityType {

	//
	SHARE(1,2000L,"分享"),
	CLICK_SHARE(2,1000L,"点击分享");

	ActivityType(Integer value,Long balance, String name){
		this.value=value;
		this.name=name;
		this.balance=balance;

	}

	private Integer value;
	private String name;
	private Long balance;


	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
}
