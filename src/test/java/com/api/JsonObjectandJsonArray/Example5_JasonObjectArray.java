package com.api.JsonObjectandJsonArray;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Example5_JasonObjectArray {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader fr = new FileReader(new File("src/test/resources/Example5.json"));
		
		JSONParser jp = new JSONParser();
		Object parse = jp.parse(fr);

//Type cast Object to JSONArray	
		JSONArray jo = (JSONArray)parse;

		for(int i=0; i<jo.size(); i++) {
			
			Object jo1 = jo.get(i);
			JSONObject jo2 = (JSONObject)jo1;
			System.out.println(jo2.get("id"));
			System.out.println(jo2.get("type"));
			System.out.println(jo2.get("name"));
			System.out.println(jo2.get("ppu"));
			
//Batters convert from Object
			Object batters = jo2.get("batters");
			JSONObject jo3 = (JSONObject)batters;
			
//Batter convert from Array
			Object batter = jo3.get("batter");
			JSONArray ja1 = (JSONArray)batter;

			for(int j=0; j<ja1.size(); j++) {

				Object jo4 = ja1.get(j);
				JSONObject jo5 = (JSONObject)jo4;
				System.out.println(jo5.get("id") + " " + jo5.get("type"));
			}

//Topping convert from array
			Object topping = jo2.get("topping");
			JSONArray ja2 = (JSONArray)topping;

			for(int k=0; k<ja2.size();k++) {
				Object ja3 = ja2.get(k);
				JSONObject jo6 = (JSONObject)ja3;
				System.out.println(jo6.get("id") + " " + jo6.get("type"));
			}

		}

	}

}
