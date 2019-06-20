package com.zr.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zr.demo.dao.UserDao;
import com.zr.demo.producer.IMessageProducerService;

import com.zr.demo.service.UserService;
import com.zr.model.User;

@RestController
public class MainController {
	
	@Autowired  
    private UserService  userService;
	
	@Autowired
	private IMessageProducerService  iMessageProducerService;
	

	 
	@RequestMapping(value = "/abc")
	public User home() {
		return userService.selectUserById(1);
	}
	
	
	@RequestMapping(value = "/q")
	public void q() {
		for (int x = 0; x < 10; x++) {
            this.iMessageProducerService.sendMessage1("study - " + x);
        }
	}
	

	
	
	@RequestMapping(value = "/r")
	public List<User> r() {
		return userService.findAllUsers();
	}
	
	
	@RequestMapping(value = "/testwar")
	public String testwar() {
		return "helloWorld";
	}
	
	

	
	
	
	
	

}
