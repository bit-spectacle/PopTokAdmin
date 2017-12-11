package com.poptok.admin.util;

public class PageParam {
	private String nowPage;
	private String pageSize;
	private String searchOption;
	private String searchText;
	private int totalCount;
	
	public PageParam() {
		this.nowPage = "1";
		this.pageSize = "10";
		this.searchOption = "";
		this.searchText = "";
		this.totalCount = 0;
	}
	
	public PageParam(String nowPage, String pageSize, String searchOption, String searchText) {
		super();
		this.nowPage = nowPage;
		this.pageSize = pageSize;
		this.searchOption = searchOption;
		this.searchText = searchText;
		this.totalCount = 0;
	}
	public String getNowPage() {
		return nowPage;
	}
	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "PageParam [nowPage=" + nowPage + ", pageSize=" + pageSize + ", searchOption=" + searchOption
				+ ", searchText=" + searchText + ", totalCount=" + totalCount + "]";
	}
	
	public String toParameter() {
		return String.format("nowPage={0}&pageSize={1}&searchOption={2}&searchText={3}",
				nowPage,
				pageSize,
				searchOption,
				searchText);
	}
}
