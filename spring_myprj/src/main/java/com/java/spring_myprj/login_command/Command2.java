package com.java.spring_myprj.login_command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

public interface Command2 {
	 public String execute(Model model, HttpServletRequest request, BCryptPasswordEncoder passwordEncoder);

}
