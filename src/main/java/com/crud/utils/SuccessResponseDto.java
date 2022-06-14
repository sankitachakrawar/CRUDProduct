package com.crud.utils;

public class SuccessResponseDto {

	
private String string;
private String string2;
private Object object;
public SuccessResponseDto(String string, String string2, Object object) {
	super();
	this.string = string;
	this.string2 = string2;
	this.object = object;
}
public SuccessResponseDto() {
	super();
}
public String getString() {
	return string;
}
public void setString(String string) {
	this.string = string;
}
public String getString2() {
	return string2;
}
public void setString2(String string2) {
	this.string2 = string2;
}
public Object getObject() {
	return object;
}
public void setObject(Object object) {
	this.object = object;
} 


}
