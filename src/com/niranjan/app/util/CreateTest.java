package com.niranjan.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import com.niranjan.app.dao.EmployeeDAO;
import com.niranjan.app.dto.AddressDTO;
import com.niranjan.app.dto.EmployeeDTO;

public class CreateTest {
public static void main(String[] args) throws ParseException{
	EmployeeDTO dto=new EmployeeDTO();	
	dto.setName("Niranjan");
	dto.setDob(new SimpleDateFormat("dd-MM-yyy").parse("04-01-1993"));
	dto.setSalary(35000);
	dto.setPermanent(true);
	
	AddressDTO dto2=new AddressDTO();
	dto2.setCity("Davanagere");
	dto2.setState("karnataka");
	dto2.setPincode(577213);
	
	AddressDTO dto3=new AddressDTO();
	dto3.setCity("Hyderabad");
	dto3.setState("Telangana");
	dto3.setPincode(560003);
	
	Set<AddressDTO> addresses=new HashSet<AddressDTO>();
	addresses.add(dto2);
	addresses.add(dto3);
	
	dto.setAddresses(addresses);	
	EmployeeDAO dao=new EmployeeDAO();
	dao.createEmployee(dto);
}
}
