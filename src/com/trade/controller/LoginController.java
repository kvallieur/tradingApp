package com.trade.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	 
	@RequestMapping("/authenticate")
	public ModelAndView authenticateUser(HttpServletRequest request,HttpServletResponse res) { 
		ModelAndView model = null;
        String name=request.getParameter("userName");  
        String password=request.getParameter("password");  
          
        if(password.equals("admin")){  
        	String message = name;  
        	model = new ModelAndView("adminHome");
        	model.addObject("message", message);
        }
        else{  
        	model = new ModelAndView("login");
        	model.addObject("error","username or password error. Try Again.");  
        } 
        
        return model;
    }  
      
	@RequestMapping("/login")
	public ModelAndView displayLogin(HttpServletRequest request,HttpServletResponse res) { 
        return new ModelAndView("login");
    } 
	
	
	@RequestMapping("/register")
	public ModelAndView displayRegister(HttpServletRequest request,HttpServletResponse res) { 
        return new ModelAndView("register");
    }
}  

	


