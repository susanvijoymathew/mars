package com.mcd.mars.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mcd.mars.data.entity.Area;

public class MarsDataUtility {
	public final static String DATE_PATTERN = "MM-dd-yyyy";

	private final static String ROOT = "Root";
	private final static String CITY = "City"; // should be an enumeration
	
	public static Date getAsDate(String dateStr) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
		return simpleDateFormat.parse(dateStr);
	}
	
	public static void createAreaMap(List<Area> locations) {
		Map<Area, ArrayList<Area>> areaMap = new HashMap<Area, ArrayList<Area>>();
		
		for (Area a : locations) {
			// City doesn't have children. If it ever does, the following line should be updated.
			if (!areaMap.containsKey(a) && !a.getType().equals(CITY))
				areaMap.put(a, new ArrayList<Area>());
			
			if (!a.getType().equals(ROOT)) {
				Area parent = a.getParent();
				
				ArrayList<Area> children = areaMap.containsKey(parent) ? areaMap.get(parent) : new ArrayList<Area>();
				children.add(a);
				areaMap.put(parent, children);
			}
		}
		
		for (Area a : areaMap.keySet()) {
			System.out.println(a);
			ArrayList<Area> children = areaMap.get(a);
			for (Area c : children) {
				System.out.println("\t" + c);
			}
			System.out.println("\t\t***********************************************************");
		}
	}
}
