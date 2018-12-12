package com.mcd.mars.utility;

import java.util.ArrayList;
import java.util.List;

import com.mcd.mars.data.entity.Area;

public final class AreaUtil {
	/**
	 * Returns areas under the requested Area. The requested area is not included.
	 * 
	 * @param loc - Area to search under
	 * @param includeSearchArea - specifies if Area to which areaId belongs should be included in the list.
	 * @param allAreas - complete list of areas available in the application
	 * @return - A list of areas that come under the requested area name and type.
	 */
	public static List<Area> getAreasOf(Area loc, boolean includeSearchArea, List<Area> allAreas) {
		ArrayList<Area> results = new ArrayList<Area>();
		boolean found = false;
		
		for (Area a : allAreas) {
			if (!found && (a.getName().equals(loc.getName()) && a.getType().equals(loc.getType())) ) {
				if (includeSearchArea)
					results.add(a);
				found = true;
				continue;
			}
			if (found) {
				// World is the root level, followed by Continent, then Country, then State or Province,
				// lastly, City. So, if we are seeing an area with the same level as the base in this
				// method or lower, we have all the children of the base area we were asked to find.
				if (a.getLevel() <= loc.getLevel())
					break;
				results.add(a);
			}
		}
		
		return results;
	}
	
	/**
	 * Returns areas under the requested Area by name and type. The requested area is not included.
	 * 
	 * @param name - name of the area interested
	 * @param type - type of the area interested - in case, name isn't unique
	 * @param includeSearchArea - specifies if Area to which areaId belongs should be included in the list.
	 * @param allAreas - complete list of areas available in the application
	 * @return - A list of areas that come under the requested area name and type.
	 */
	public static List<Area> getAreasOf(String name, String type, boolean includeSearchArea, List<Area> allAreas) {
		ArrayList<Area> results = new ArrayList<Area>();
		int baseLevel = -1;
		boolean found = false;
		
		for (Area a : allAreas) {
			if (!found && (a.getName().equals(name) && a.getType().equals(type))) {
				if (includeSearchArea)
					results.add(a);
				
				baseLevel = a.getLevel();
				found = true;				
				continue;
			}
			if (found) {
				// World is the root level, followed by Continent, then Country, then State or Province,
				// lastly, City. So, if we are seeing an area with the same level as the base in this
				// method or lower, we have all the children of the base area we were asked to find.
				if (a.getLevel() <= baseLevel)
					break;
				results.add(a);
			}
		}
		
		return results;
	}
	
	/**
	 * 
	 * @param areaId - id of the area interested in
	 * @param includeSearchArea - specifies if Area to which areaId belongs should be included in the list.
	 * @param allAreas - complete list of areas available in the application
	 * @return - A list of areas that come under the requested area id. If id is 0 or less, full area
	 * list is returned. If requested areaId cannot be found, then null is returned.
	 */
	public static List<Area> getAreasOf(long areaId, boolean includeSearchArea, List<Area> allAreas) {
		if (areaId <= 0)
			return allAreas;
		
		for (Area a : allAreas) {
			if (a.getId() == areaId) {
				return getAreasOf(a, includeSearchArea, allAreas);
			}
		}
		
		return null;
	}
}
