package com.mingkai.mmpt.enums;

/**
 * 问卷排序类型
 */
public enum MmptType {

	//
	SEX(1,"两性"),
	EMOTION(2,"情感"),
	NATURE(3,"性格"),
	HEALTHY(4,"健康"),
	PARENTING(5,"亲子"),
	ABILITY(6,"能力");



	MmptType(Integer value, String name){
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
