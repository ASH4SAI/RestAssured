package com.api.Deserilization;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileDemo {

	public static void main(String[] args) throws IOException, ParseException {

		FileReader fr = new FileReader(new File("src/test/resources/JsonFile.json"));
		ObjectMapper om = new ObjectMapper();
		Root rv = om.readValue(fr, Root.class);
		
		System.out.println(rv.getName());
		System.out.println(rv.getAge());
		System.out.println(rv.getStatus());
	//Address
		Address address = rv.getAddress();
		System.out.println(address.getCity());
		System.out.println(address.getState());
	//Courses
		ArrayList<String> courses = rv.getCourses();
		for(int i=0; i<courses.size();i++) {
			String values = courses.get(i);
			System.out.println(values);
		}
		
		
	}
	
}