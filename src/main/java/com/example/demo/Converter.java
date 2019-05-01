package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		Employee emp = new Employee();
		List<Employee> list = new ArrayList<>();
		list.add(emp);
		String jsonInString = mapper.writeValueAsString(list);
		System.out.println(jsonInString);
	}

}
