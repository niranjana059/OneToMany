package com.niranjan.app.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;
import com.niranjan.app.dto.AddressDTO;
import com.niranjan.app.dto.EmployeeDTO;


public class EmployeeDAO {
	public static final SessionFactory factory=HibernateUtil.getSessionFactory();

	public void createEmployee(EmployeeDTO dto){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.save(dto);
			//dto.setName("Rakesh");
			tx.commit();			
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}


	public EmployeeDTO fetchEmployeeById(int id){
		EmployeeDTO dto=new EmployeeDTO();
		Session session=factory.openSession();
		try{
			dto=session.get(EmployeeDTO.class, id);
			Set<AddressDTO> set=dto.getAddresses();
			for(AddressDTO address:set){
				System.out.println(address);
			}
			return dto;
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return dto;
	}

	public int updateEmployee(long salary,int pincode,int id){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			EmployeeDTO dto=session.get(EmployeeDTO.class, id);
			if(dto!=null){
				System.out.println("record found");
				dto.setSalary(salary);
				Set<AddressDTO> set=dto.getAddresses();
				Set<AddressDTO> set_modified=new HashSet<AddressDTO>();
				for(AddressDTO address:set){
					address.setPincode(pincode);
					set_modified.add(address);
					
				}
				dto.setAddresses(set_modified);
				session.update(dto);
				tx.commit();
				System.out.println("updated successfully");
			}else{
				System.out.println("record not found");
			}

		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return 0;
	}

	public int deleteEmployee(int id){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			EmployeeDTO dto=session.get(EmployeeDTO.class, id);
			if(dto!=null){
				System.out.println("record found");
				session.delete(dto);
				tx.commit();
				System.out.println("record deleted successfully");
			}
			else{
				System.out.println("record not found");
			}
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return 0;
	}

}
