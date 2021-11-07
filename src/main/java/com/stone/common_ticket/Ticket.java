package com.stone.common_ticket;

import java.util.Date;

import com.stone.common_exhibition.Exhibition;
import com.stone.common_member.Member;

public class Ticket {

	int no; // PK NN AI
	int adult; // NN
	int teen; // NN
	int kid; // NN
	int price; // NN
	Date wdate;
	int state; // NN
	Member member;
	Exhibition exhibition;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getTeen() {
		return teen;
	}
	public void setTeen(int teen) {
		this.teen = teen;
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Exhibition getExhibition() {
		return exhibition;
	}
	public void setExhibition(Exhibition exhibition) {
		this.exhibition = exhibition;
	}
}