package com.poptok.admin.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MenuJsonReader {
	
	private static ServletContext context = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getServletContext();
	private static String path = context.getRealPath("/WEB-INF/menudata/menu.json");
	private static Type arrType = new TypeToken<ArrayList<MenuItem>>() {}.getType();
	
	public static ArrayList<MenuItem> GetMenuList() {
		String json = "";
		
	    try {
			json = Files.toString(new File(path), Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		Gson gson = new Gson();
		ArrayList<MenuItem> menu = gson.fromJson(json, arrType);
		SetTitlePath(menu);

		return menu;
	}
	
	private static void SetTitlePath(ArrayList<MenuItem> menu)
	{
		context.setAttribute("category", "");
		context.setAttribute("title", "");
		
		String uri = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getRequestURI();
		for (MenuItem menuItem : menu) {
			String menuUrl = menuItem.getUrl();
			if(uri.equals(menuUrl) || uri.equals("/admin/") ) {
				context.setAttribute("title", menuItem.getCaption());
				break;
			}
			else if(uri.contains(menuUrl) && !uri.equals("/admin/")  && !menuUrl.equals("/admin/")) {
				if(menuItem.getSubMenu() == null) {
					context.setAttribute("title", menuItem.getCaption());
					break;					
				}
				else if(menuItem.getSubMenu() != null) {
					for (MenuItem subMenu : menuItem.getSubMenu()  ) {
						if(uri.equals(subMenu.getUrl())) {
							context.setAttribute("title", subMenu.getCaption());
							context.setAttribute("category", menuItem.getCaption());
							break;
						}
					}	
				}
			}
		}
	}

}
