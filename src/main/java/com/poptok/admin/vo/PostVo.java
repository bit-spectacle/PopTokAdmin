package com.poptok.admin.vo;

public class PostVo {
	private int postNo;
	private int userNo;
	private int viewsCnt;
	private int likeCnt;
	private int commentCnt;
	private String content; 
	private String image; 
	private String kakaoLink; 
	private String postDate;
	private String tag;
	private double latitude; 
	private double longitude;
	private int poststatus;
	
	private String businessName;
	private String nickname;
	
	
	// getter / setter
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getViewsCnt() {
		return viewsCnt;
	}
	public void setViewsCnt(int viewsCnt) {
		this.viewsCnt = viewsCnt;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getKakaoLink() {
		return kakaoLink;
	}
	public void setKakaoLink(String kakaoLink) {
		this.kakaoLink = kakaoLink;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getPoststatus() {
		return poststatus;
	}
	public void setPoststatus(int poststatus) {
		this.poststatus = poststatus;
	}
	
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
		
}
