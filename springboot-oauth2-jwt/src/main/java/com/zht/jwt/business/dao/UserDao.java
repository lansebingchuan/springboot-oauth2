package com.zht.jwt.business.dao;

import com.zht.jwt.business.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xw on 2017/3/17.
 * 2017-03-17 19:59
 */
public interface UserDao extends JpaRepository<User, Integer> {

	User findOneByUsername(String userName);

}