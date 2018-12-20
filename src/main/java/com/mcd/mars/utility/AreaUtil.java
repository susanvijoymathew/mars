package com.mcd.mars.utility;

import java.util.ArrayList;
import java.util.List;

import com.mcd.mars.data.entity.Area;

public final class AreaUtil {
	/**
	 * Returns areas under the requested Area. The requested area is included in the resulting list if
	 * the boolean flag is set.
	 * 
	 * @param loc - Area to search under
	 * @param includeSearchArea - specifies if Area to which areaId belongs should be included in the list.
	 * @param allAreas - complete list of areas available in the application
	 * @return - A list of areas that come under the requested area name and type.
	 */
	public static List<Area> getAreasOf(Area loc, boolean includeSearchArea, List<Area> allAreas) {
		ArrayList<Area> results = new ArrayList<Area>();
		
		for (Area a : allAreas) {
			if (a.getName().equals(loc.getName()) && a.getType().equals(loc.getType())) {
				if (includeSearchArea)
					results.add(a);
				
				getDescendants(a, results);
			}
		}
		
		return results;
	}
	
	/**
	 * Returns areas under the requested Area by name and type. The requested area is included in the
	 * resulting list if the boolean flag is set.
	 * 
	 * @param name - name of the area interested
	 * @param type - type of the area interested - in case, name isn't unique
	 * @param includeSearchArea - specifies if Area to which areaId belongs should be included in the list.
	 * @param allAreas - complete list of areas available in the application
	 * @return - A list of areas that come under the requested area name and type.
	 */
	public static List<Area> getAreasOf(String name, String type, boolean includeSearchArea, List<Area> allAreas) {
		ArrayList<Area> results = new ArrayList<Area>();
		
		for (Area a : allAreas) {
			if (a.getName().equals(name) && a.getType().equals(type)) {
				if (includeSearchArea)
					results.add(a);
				
				getDescendants(a, results);
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
	
	private static void getDescendants(Area parent, List<Area> results) {
		// Sort the children to be safe; in case a new area is added in the future.
		List<Area> children = (List<Area>) parent.getChildren();
		children.sort( (Area o1, Area o2) -> o1.getName().compareTo(o2.getName()) );
		
		for (Area a : children) {
			results.add(a);
			getDescendants(a, results);
		}
	}
}
