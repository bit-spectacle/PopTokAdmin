package com.poptok.admin.util;

import java.util.ArrayList;

public class MenuItem {
	private String caption;
	private String url;
	private String iconClass;
	private String urlNick;
	private ArrayList<MenuItem> subMenu;

	public MenuItem(String caption, String url, String iconClass, ArrayList<MenuItem> subMenu) {
		this.caption = caption;
		this.url = url;
		this.iconClass = iconClass;
		this.subMenu = subMenu;
		this.urlNick = String.join("", this.url.split("/")); 
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public String getUrlNick() {
		return urlNick == null || urlNick.isEmpty() ? String.join("", this.url.split("/")) : urlNick;
	}

	public void setUrlNick(String urlNick) {
		this.urlNick = urlNick;
	}

	public ArrayList<MenuItem> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(ArrayList<MenuItem> subMenu) {
		this.subMenu = subMenu;
	}
	
	

}