package com.main.dao;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.model.Registration;

@Repository
public class DaoImpl implements DaoIntf{
@Autowired
EntityManager entityManager;


public void saveEmp(Registration reg) {
	entityManager.persist(reg);
	
}


public List<Registration> display() {
	List<Registration>ls=entityManager.createQuery("from Registration").getResultList();
	return ls;
}


public Registration edit(int id) {
	Query sql=entityManager.createQuery("from Registration where id=?");
	sql.setParameter(1, id);
	List<Registration>ls=sql.getResultList();
	Registration rs=new Registration();
	Iterator itr=ls.iterator();
	while (itr.hasNext()) {
		rs=(Registration) itr.next();	
	}
	return rs;
}


@Override
public Registration check(Registration reg) {
	Query sql=entityManager.createQuery("from Registration where userName=? and password=?");
	sql.setParameter(1, reg.getUserName());
	/*String s=new String(Base64.getDecoder().decode(reg.getPassword()));*/	
	/*System.out.println(s);*/
	sql.setParameter(2, Base64.getEncoder().encodeToString(reg.getPassword().getBytes()));
	List<Registration>ls=sql.getResultList();
	Registration rs=new Registration();
	Iterator itr=ls.iterator();
	while (itr.hasNext()) {
		rs=(Registration) itr.next();	
	}
	return rs;
}



public void update(int id) {
	
	Query sql=entityManager.createNativeQuery("update fourth_table set account_no=?,account_type=?,balance=?,created_date=? where four_id=?");
	sql.setParameter(1, "100"+id);
	sql.setParameter(2, "savings");
	sql.setParameter(3, "1000");
	sql.setParameter(4,LocalDate.now());
	sql.setParameter(5, id);
	sql.executeUpdate();	
}
}
