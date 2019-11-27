package com.mingkai.mmpt.enums;

/**
 * 问卷排序类型
 */
public enum MmptQueryType {

	//贷款状态：0-初始化 1-进件申请失败 2-进件请求成功
	NEW(1,"按时间最新"),
	CHOICE(2,"按精选"),
	CLICK_NUM(3,"按点击次数"),
	BUYED_NUM(4,"按购买次数");


	MmptQueryType(Integer value, String name){
		this.value=value;
		this.name=name;
	}

	private Integer value;
	private String name;
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



}
