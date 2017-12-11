package com.poptok.admin.vo;

public class UserVo {
	private int userNo;
	private String email;
	private String nickname;
	private String password;
	private String role;
	private String joinDate;
	private String lastlogin;
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}
	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", email=" + email + ", nickname=" + nickname + ", password=" + password
				+ ", role=" + role + ", joinDate=" + joinDate + ", lastlogin=" + lastlogin + "]";
	}
	
}
