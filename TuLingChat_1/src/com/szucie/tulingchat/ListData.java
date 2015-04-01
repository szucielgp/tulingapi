package com.szucie.tulingchat;

public class ListData {

	private String text;
//	public static String SEND = "1";
//	public static String RECIVE="2";//使用String的时候在遍历时发现每一项都是2，
	public static int SEND = 1;
	public static int RECIVE = 2;
//	private static int flag;将其写成了static的，所以跟全局变量一样，当第二次在new listdata的时候，变为2，所以所有的都变成了2，static位于静态存储区，公用一个变量
	private  int flag;
	private String time;
	public ListData(String text,int flag,String time) {
		this.text = text;
		this.flag = flag;
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
