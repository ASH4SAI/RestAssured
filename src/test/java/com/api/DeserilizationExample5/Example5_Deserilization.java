package com.api.DeserilizationExample5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Example5_Deserilization {
	
	
	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader(new File("src/test/resources/Example5.json"));
		ObjectMapper om = new ObjectMapper();
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		TypeReference<ArrayList<Root5>> tr = new TypeReference<ArrayList<Root5>>() {};
		
		List<Root5> rv = om.readValue(fr, tr);
		
		for (int i=0;i<rv.size();i++) {
			Root5 r5 = rv.get(i);
			System.out.println(r5.getId());
			System.out.println(r5.getType());
			System.out.println(r5.getName());
			System.out.println(r5.getPpu());
			
			System.out.println("**********Batters**********");
			Batters5 batters = r5.getBatters();
			ArrayList<Batter5> batter = batters.getBatter();
			
			for (Batter5 batter5 : batter) {
				System.out.println(batter5.getId() +" "+ batter5.getType());
			}
			
			System.out.println("**********Topping**********");
			ArrayList<Topping5> topping = r5.getTopping();
			
			for (Topping5 topping5 : topping) {
				
				System.out.println(topping5.getId() +" "+ topping5.getType());
				
			}
		}
		
	}

}
