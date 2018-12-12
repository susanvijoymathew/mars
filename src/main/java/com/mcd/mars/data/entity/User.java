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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (int) (roleId ^ (roleId >>> 32));
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
		User other = (User) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (roleId != other.roleId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User - [id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + ", emailAddress: " + emailAddress + ", roleId: " + roleId + ", active: " + active + " ]";
	}
}
