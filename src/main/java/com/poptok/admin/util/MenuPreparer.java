package com.poptok.admin.util;

import java.util.ArrayList;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

public class MenuPreparer implements ViewPreparer {
	
	@Override
	public void execute(Request context, AttributeContext attributeContext) throws PreparerException {
		ArrayList<MenuItem> menu = MenuJsonReader.GetMenuList();
		attributeContext.putAttribute("leftMenu", new Attribute(menu), true);
	}

	
}
