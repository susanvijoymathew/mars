package com.mcd.mars.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mcd.mars.utility.MarsConstants;

@Entity
public class Area implements Comparable<Area> {
	
	@Id @Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column private String name;

	// This should actually be an enumeration.
	// May be, even a separate table in DB.
	@Column private String type;
	
	// Determines how far to intend when showing the area names.
	@Column private int level;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Area parent;
	
	public Area() {
		this(null, null, 0, null);
	}
	
	public Area(String name, String type, int level, Area parent) {
		this.name = name;
		this.type = type;
		this.parent = parent;
		this.level = level;
	}

    public long getId() { return id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getType() { return type; }
	public void setType(String type) { this.type = type; }

	// World is the root level, followed by Continent, then Country, then State or Province,
	// lastly, City. So, if we are seeing an area with the same level as the base in this
	// method or lower, we have all the children of the base area we were asked to find.
	public int getLevel() { return level; }
	public void setLevel(int level) { this.level = level; }
	
	public Area getParent() { return parent; }
	public void setParent(Area parent) { this.parent = parent; }

	/*
	public Collection<Area> getChildren() {
		return children;
	}

	public void setChildren(Collection<Area> children) {
		this.children = children;
	}
	*/
	// Based on the level, spaces are added to the front of the name.
	public String getIndentedName() {
		if (level == 0)
			return name;
		
		return new String(new char[level * 4]).replace("\0", MarsConstants.SPACE) + name;
	}
	
	@Override
	public String toString() {
		long pId = (parent != null) ? parent.getId() : -1;
		return "Area - [id: " + id + ", name: " + name + ", type: " + type + ", parentId: " + pId + ", level: " + level + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + level;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Area other = (Area) obj;
		if (level != other.level)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int compareTo(Area other) {
		// First comparison is by parent Id. Then, by level, and then, by area name.
		// If parent is null, looking at the root Area.
		if (getParent() == null)
			return -1;
		else if (other.getParent() == null)
			return 1;
		
		int result = Long.compare(getParent().getId(), other.getParent().getId());
		if (result != 0) {
			result = Integer.compare(getLevel(), other.getLevel());
			return (result != 0 ? result : getName().compareTo(other.getName()));
		}
		
		return 0;
	}
}
