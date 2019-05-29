package com.francetech.mawerTest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.francetech.mawerTest.model.Mower;
import com.francetech.mawerTest.service.MawerService;

@RestController
public class MawerRessource {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(MawerRessource.class);

	@Autowired
	MawerService mowerService; 
	
    @RequestMapping(method = RequestMethod.GET, value = "/mawers")
    @ResponseBody
	public List<String> getMawerPosition() {
    	
        LOGGER.info("get mower position");
        
		List<Mower> mowerPositions = mowerService.getMowerPositionList();
		
		return mowerPositions.stream().map(tableau -> tableau.getLocation()).collect(Collectors.toList());
	}

}
