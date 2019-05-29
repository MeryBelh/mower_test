package com.francetech.mawerTest.util;


import java.util.List;
import java.util.Optional;

public class FileValidator {
	

    
	public static void validateLawn(List<String> lines){
				
		Optional.ofNullable(lines).orElseThrow(() ->new IllegalArgumentException("empty file"));
		
		String[] xy = lines.get(0).split(" ");
		if(xy.length != 2)
			  throw new IllegalArgumentException("not the right format");
		
		if(lines.size() <3) {
			throw new IllegalArgumentException("no suffisant lines");
			}
		
	}
	
	
	
}
