package com.api.DeserilizationExample4;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Example4_Deserilization {
	
	
	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader(new File("src/test/resources/Example4.json"));
		ObjectMapper om = new ObjectMapper();
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		Root4 r4 = om.readValue(fr, Root4.class);
		
		System.out.println(r4.getId());
		System.out.println(r4.getType());
		System.out.println(r4.getName());
		System.out.println(r4.getPpu());
		
		Batters4 batters = r4.getBatters();
		ArrayList<Batter4> batter = batters.getBatter();
		
		for(int i=0; i<batter.size();i++) {
			Batter4 b = batter.get(i);
		System.out.println(b.getId() +" "+ b.getType());
		}
		
		ArrayList<Topping4> topping = r4.getTopping();
		
		for(int j=0; j<topping.size(); j++) {
			Topping4 tv = topping.get(j);
			System.out.println(tv.getId() +" "+ tv.getType());
		}
		
	}

}
