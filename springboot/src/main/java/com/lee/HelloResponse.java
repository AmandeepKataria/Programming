package com.lee;

public class HelloResponse {
	private String hello = "hello";
	
	public HelloResponse(){
		
	}
	
	public HelloResponse(String name){
		hello = hello + " " + name;
	}

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}
	
}
