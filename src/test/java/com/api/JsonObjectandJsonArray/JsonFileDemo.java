package com.api.JsonObjectandJsonArray;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileDemo {

	public static void main(String[] args) throws IOException, ParseException {

		FileReader fr = new FileReader(new File("src/test/resources/jsonFile.json"));
		
		JSONParser jp = new JSONParser();
		Object parse = jp.parse(fr);
		
//Type cast Object to JSONObject
		JSONObject jo = (JSONObject)parse;
		
		System.out.println(jo.get("name"));
		System.out.println(jo.get("age"));
		System.out.println(jo.get("status"));
//		System.out.println(jo.get("address"));
//		System.out.println(jo.get("courses"));
		
		Object object = jo.get("address");
//Type cast Object  JSONObject
		JSONObject jo1 = (JSONObject)object;
		System.out.println(jo1.get("state"));
		System.out.println(jo1.get("city"));

		Object object2 = jo.get("courses");
//Type cast Object2 to JSONArray
		JSONArray jo2 = (JSONArray)object2;
		
		for (int i = 0; i < jo2.size(); i++) {
			
			System.out.println(jo2.get(i));
			
		}
	}

}
