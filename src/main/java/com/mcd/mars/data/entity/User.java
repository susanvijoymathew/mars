package com.mcd.mars.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Details")
public class User {
    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column private String firstName;
    @Column private String lastName;
    @Column private String emailAddress;
    @Column private long roleId;
    @Column private String active;

    public User() {
    	this(null, null, null, -1, null);
    }

    public User(String firstName, String lastName, String emailAddress, long roleId, String active) {
    	super();
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.roleId = roleId;
    	this.emailAddress = emailAddress;
    	this.active = active;
    }

    public long getId() {
    	return id;
    }

    public String getFirstName() {
    	return firstName;
    }

    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }

    public String getLastName() {
    	return lastName;
    }

    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }

    public String getEmailAddress() {
    	return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
    	this.emailAddress = emailAddress;
    }

    public long getRoleId() {
    	return roleId;
    }

    public void setRoleId(long roleId) {
    	this.roleId = roleId;
    }

    public String getActive() {
    	return active;
    }

    public void setHomeAddress(String active) {
    	this.active = active;
    }
    
    @Override
	public String toString() {
		return "User - [id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + ", emailAddress: " + emailAddress + ", roleId: " + roleId + ", active: " + active + " ]";
	}
}
