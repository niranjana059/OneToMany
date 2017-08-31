package com.niranjan.app.util;

import java.util.Set;

import com.niranjan.app.dao.EmployeeDAO;
import com.niranjan.app.dto.AddressDTO;
import com.niranjan.app.dto.EmployeeDTO;

public class FetchTest {

	public static void main(String[] args) {
	EmployeeDAO dao=new EmployeeDAO();
	EmployeeDTO dto=dao.fetchEmployeeById(1);
	/*Set<AddressDTO> set=dto.getAddresses();
	for(AddressDTO address:set){
		System.out.println(address);
	}*/
	System.out.println(dto);
	}

}
