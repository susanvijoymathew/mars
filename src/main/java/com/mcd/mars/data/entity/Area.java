package com.mcd.mars.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@Override
	public String toString() {
		long pId = (parent != null) ? parent.getId() : -1;
		return "Area - [id: " + id + ", name: " + name + ", type: " + type + ", parentId: " + pId + "]";
	}

	@Override
	public int compareTo(Area o) {
		// TODO Auto-generated method stub
		return (int) (this.getParent().getId() - o.getParent().getId());
	}
}
