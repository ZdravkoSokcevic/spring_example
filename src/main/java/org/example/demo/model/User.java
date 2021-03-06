package org.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User
{
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long user_id;
	public String username;
	public String first_name;
	public String last_name;
	public String Gender;
	public Integer status;

	private String password;

	public Long getId()
	{
		return this.user_id;
	}

	@Column(name="username")
	public String getUsername()
	{
		return this.username;
	}

	@Column(name="first_name")
	public String getFirstName()
	{
		return this.first_name;
	}

	@Column(name="last_name")
	public String getLastName()
	{
		return this.last_name;
	}

	@Column(name="gender")
	public String getGender()
	{
		return this.Gender;
	}

	@Column(name="status")
	public Integer getStatus()
	{
		return this.status;
	}
}