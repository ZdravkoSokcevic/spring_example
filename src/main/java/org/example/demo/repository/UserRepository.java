package org.example.demo.repository;

import java.util.List;
import java.util.Collection;
import org.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	@Query("FROM User u WHERE u.username like \'james17%\'")
	List<User> getUsers();

	@Query("FROM User u")
	List<User> getWithPaginate(Pageable page);

	@Query("SELECT COUNT(u.id) FROM User u")
	Integer getUserNumber();
}