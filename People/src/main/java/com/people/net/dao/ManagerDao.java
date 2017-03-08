package com.people.net.dao;

import java.util.List;

import com.people.net.UserInfo;
import com.people.net.model.PersonPersistenceModel;

public interface ManagerDao {

	List<UserInfo> listUsers();

	void deletePersonAndConnected(int id);

	void addAll(UserInfo info);

	UserInfo createByMergeUserInfo(int id);

	void updateAll(UserInfo userinfo);
	

}
