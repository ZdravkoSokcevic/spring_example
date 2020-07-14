package org.example.demo.service;

import org.example.demo.model.User;
import org.example.demo.repository.UserRepository;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@Service
public class UserService implements IUserService
{
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll()
	{
		List<User> us = (List<User>) repository.findAll();
		List<User> users= new ArrayList();
		for(int x=0 ; x<100; x++)
		{
			users.add(us.get(x));
		}
		return users;
	} 
}
