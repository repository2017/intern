package com.people.net.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.people.net.UserInfo;
import com.people.net.model.AddressPersistenceModel;
import com.people.net.model.EmailPersistenceModel;
import com.people.net.model.PersonPersistenceModel;

@Repository
public class ManagerDaoImpl implements ManagerDao{
	
	@Autowired
	SessionFactory sFactory;
	
	public void setsFactory(SessionFactory sFactory) {
		this.sFactory = sFactory;
	}

	@Override
	public List<UserInfo> listUsers() {
		Session session = this.sFactory.getCurrentSession();
		List<PersonPersistenceModel> personList = session.createQuery("from PersonPersistenceModel").list();
		System.out.println(personList.size());
		List<UserInfo> resultList = new LinkedList<>();
		
		for (Iterator iterator = personList.iterator(); iterator.hasNext();) {
			PersonPersistenceModel person = (PersonPersistenceModel) iterator.next();
			resultList.add(new UserInfo(person.getName(), person.getPin(), "" + person.getId()));
		}
		
		System.out.println(resultList.size());
		return resultList;
	}

	@Override
	public void deletePersonAndConnected(int id) {
		Session session = this.sFactory.getCurrentSession();
		Query query = session.createQuery("delete AddressPersistenceModel where t_people_id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		
		Query query2 = session.createQuery("delete EmailPersistenceModel where t_people_id = :id");
		query2.setParameter("id", id);
		query2.executeUpdate();
		
		Query query3 = session.createQuery("delete PersonPersistenceModel where id = :id");
		query3.setParameter("id", id);
		query3.executeUpdate();
		
		
		
	}

	@Override
	public void addAll(UserInfo info) {

		Session session = this.sFactory.getCurrentSession();
		PersonPersistenceModel person = new PersonPersistenceModel();
		person.setName(info.getName());
		person.setPin(info.getPin());
		
		System.out.println("-------------------------------------" + person.getName());
		
		EmailPersistenceModel email = new EmailPersistenceModel();
		email.setEmail(info.getEmail());
		email.setEmailType(info.getEmailType());
		email.setPerson(person);
		
		AddressPersistenceModel address = new AddressPersistenceModel();
		address.setAddrInfo(info.getAddress());
		address.setAddrType(info.getAddressType());
		address.setPerson(person);

		int emailID = (Integer) session.save(address);
		int addressID = (Integer) session.save(email);
		
		
		
	}

	@Override
	public UserInfo createByMergeUserInfo(int personId) {
		Session session = this.sFactory.getCurrentSession();
		PersonPersistenceModel person =  (PersonPersistenceModel) session.get(PersonPersistenceModel.class,personId);
		
		//hardcoded get0 as we have One to One constraint
		EmailPersistenceModel email = (EmailPersistenceModel)session.createQuery("from EmailPersistenceModel as mail where mail.person.id = " + personId).list().get(0);


		//hardcoded get0 as we have One to One constraint
		AddressPersistenceModel addr = (AddressPersistenceModel)session.createQuery("from AddressPersistenceModel as addr where addr.person.id = " + personId).list().get(0);

		UserInfo infToReturn = new UserInfo(
				person.getId(),
				person.getName(),
				person.getPin(),
				email.getEmail(),
				email.getEmailType(),
				addr.getAddrType(),
				addr.getAddrInfo());
		
		return infToReturn;
	}

	@Override
	public void updateAll(UserInfo info) {
		
		
		int personId = info.getId();
		Session session = this.sFactory.getCurrentSession();
		PersonPersistenceModel person =  (PersonPersistenceModel) session.get(PersonPersistenceModel.class,personId);
		
		//hardcoded get0 as we have One to One constraint
		EmailPersistenceModel email = (EmailPersistenceModel)session.createQuery("from EmailPersistenceModel as mail where mail.person.id = " + personId).list().get(0);


		//hardcoded get0 as we have One to One constraint
		AddressPersistenceModel addr = (AddressPersistenceModel)session.createQuery("from AddressPersistenceModel as addr where addr.person.id = " + personId).list().get(0);
		
		
		//the real update 
		person.setName(info.getName());
		person.setPin(info.getPin());
		email.setEmail(info.getEmail());
		email.setEmailType(info.getEmailType());
		addr.setAddrInfo(info.getAddress());
		addr.setAddrType(info.getAddressType());
		
		
		
	}

	
}
