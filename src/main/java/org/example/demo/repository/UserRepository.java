package org.example.demo.repository;

import java.util.List;
import java.util.Collection;
import org.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	@Query("FROM User u WHERE u.username like \'james17%\'")
	List<User> getUsers();
}