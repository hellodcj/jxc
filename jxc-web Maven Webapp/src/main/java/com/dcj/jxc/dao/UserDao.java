package com.dcj.jxc.dao;

import org.springframework.stereotype.Repository;

import com.dcj.basic.dao.BaseDao;
import com.dcj.jxc.model.User;

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

}
