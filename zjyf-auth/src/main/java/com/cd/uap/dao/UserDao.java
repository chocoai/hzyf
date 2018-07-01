package com.cd.uap.dao;

import com.cd.uap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserDao extends JpaRepository<User, String>,JpaSpecificationExecutor<User> {
	
	public User findBySjh(String sjh);

	public boolean existsBySjh(String sjh);

}
