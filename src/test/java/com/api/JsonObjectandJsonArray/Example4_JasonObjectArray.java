package com.api.JsonObjectandJsonArray;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Example4_JasonObjectArray {
	
	
	public static void main(String[] args) throws IOException, ParseException {
		
		
		FileReader fr = new FileReader(new File("src/test/resources/Example4.json"));
		
		JSONParser jp = new JSONParser();
		Object parse = jp.parse(fr);

//Type cast Object to JSONObject
		JSONObject jo = (JSONObject)parse;

		System.out.println(jo.get("id"));
		System.out.println(jo.get("type"));
		System.out.println(jo.get("name"));
		System.out.println(jo.get("ppu"));
		
//Batters convert from Object
		Object batters = jo.get("batters");
		JSONObject jo1 = (JSONObject)batters;
//Batter convert from Array
		Object batter = jo1.get("batter");
		JSONArray ja1 = (JSONArray)batter;
		
		for(int i=0; i<ja1.size(); i++) {
			
			Object jo2 = ja1.get(i);
			JSONObject jo3 = (JSONObject)jo2;
			System.out.println(jo3.get("id") + " " + jo3.get("type"));
		}
		
//Topping convert from array
		Object topping = jo.get("topping");
		JSONArray ja2 = (JSONArray)topping;
		
		for(int j=0; j<ja2.size();j++) {
			Object ja3 = ja2.get(j);
			JSONObject jo4 = (JSONObject)ja3;
			System.out.println(jo4.get("id") + " " + jo4.get("type"));
		}
		
		
	}

}
