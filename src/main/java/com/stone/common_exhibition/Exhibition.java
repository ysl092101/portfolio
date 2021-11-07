package com.stone.common_exhibition;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Exhibition {

	int no; // PK NN AI
	String title; // NN
	String place; // NN
	String hall;
	String startday; // NN
	String endday; // NN
	String age; // NN
	int adultfee; // NN
	int teenfee; // NN
	int kidfee; // NN
	MultipartFile posterFile; // 업로드할 때 파일 매칭
	byte[] poster; // NN DB열 매칭
	Date wdate;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public String getStartday() {
		return startday;
	}
	public void setStartday(String startday) {
		this.startday = startday;
	}
	public String getEndday() {
		return endday;
	}
	public void setEndday(String endday) {
		this.endday = endday;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getAdultfee() {
		return adultfee;
	}
	public void setAdultfee(int adultfee) {
		this.adultfee = adultfee;
	}
	public int getTeenfee() {
		return teenfee;
	}
	public void setTeenfee(int teenfee) {
		this.teenfee = teenfee;
	}
	public int getKidfee() {
		return kidfee;
	}
	public void setKidfee(int kidfee) {
		this.kidfee = kidfee;
	}
	public MultipartFile getPosterFile() {
		return posterFile;
	}
	public void setPosterFile(MultipartFile posterFile) {
		this.posterFile = posterFile;
	}
	public byte[] getPoster() {
		try {
			if (posterFile != null) { return posterFile.getBytes(); }
		}
		catch (Exception e) {}
		return poster;
	}
	public void setPoster(byte[] poster) {
		this.poster = poster;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
}