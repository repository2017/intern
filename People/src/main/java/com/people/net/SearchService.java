package com.people.net;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.people.net.dao.ManagerDao;

/**
 * SEARCH SERVICE ENGINE
 * RETURNS
 * WHAT WE NEED
 * 	works with the daos
 *  in full transaction mode
 * 
 * 
 * @author nikolai
 * 
 * 
 *
 */
@Service
@Transactional
public class SearchService{
	
	@Autowired
	ManagerDao managerDAO;
	//2,3 dao
	


	public List<UserInfo> listPeople(String search)
	{
		List<UserInfo> people = managerDAO.listUsers();
		List<UserInfo> resultList = new LinkedList<UserInfo>();
		for (Iterator iterator = people.iterator(); iterator.hasNext();) {
			UserInfo temp = (UserInfo) iterator.next();
			if(temp.getName().equalsIgnoreCase(search))
			{
				resultList.add(temp);
			}
		}
		return resultList;
	}



	public ManagerDao getManagerDAO() {
		return managerDAO;
	}



	public void setManagerDAO(ManagerDao managerDAO) {
		this.managerDAO = managerDAO;
	}



	public void deletePerson(int id) {
		this.managerDAO.deletePersonAndConnected(id);
		}



	public void addData(UserInfo info) {
		managerDAO.addAll(info);
	}



	public UserInfo getUserInfo(int id) {
		return managerDAO.createByMergeUserInfo(id);
	}



	public void updateData(UserInfo userinfo) {
		managerDAO.updateAll(userinfo);
	}
}
