package org.example.demo.service;

import org.example.demo.model.User;
import java.util.List;

public interface IUserService 
{
	List<User> findAll();
}