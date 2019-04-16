package com.main.controller;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.main.service.ServiceIntf;
import com.main.model.Registration;


@Controller
public class MainController {
@Autowired
ServiceIntf service;

@RequestMapping("/Reg")
public ModelAndView register(@ModelAttribute("reg") Registration reg)
{
	return new ModelAndView("Registration");
}
@RequestMapping("/save")
public ModelAndView save(@ModelAttribute("reg") Registration reg)
{
	reg.setPassword(Base64.getEncoder().encodeToString(reg.getPassword().getBytes()));
	service.saveEmp(reg);
	return new ModelAndView("redirect:/login");
}

@RequestMapping("/login")
public ModelAndView Login(@ModelAttribute("reg") Registration reg)
{
	return new ModelAndView("LoginPage");
}

@RequestMapping("/check")
public ModelAndView check(HttpServletRequest request,@ModelAttribute("reg") Registration reg)
{
	Registration r=service.check(reg);
	if(r.getFirstName()!=null)
	{
		HttpSession session=request.getSession();
		session.setAttribute("regis", r);
		return new ModelAndView("Success","r",r);
	}
	else
	{
		return new ModelAndView("LoginPage");
	}
	
}
@RequestMapping("/savings")
public ModelAndView savings(HttpServletRequest request,@ModelAttribute("reg") Registration reg)
{
	int id=Integer.parseInt(request.getParameter("id"));
	service.update(id);
	Registration r= service.edit(id);
	return new ModelAndView("Success","r",r);
}
/*@RequestMapping("/display")
public ModelAndView Display(@ModelAttribute("reg") Registration reg)
{
	List<Registration>ls=service.display();
	return new ModelAndView("DisplayPage","ls",ls);
	
}
@RequestMapping("/edit")
public ModelAndView edit(HttpServletRequest request,@ModelAttribute("reg") Registration reg)
{
	List<Registration>ls=service.display();
	int id=Integer.parseInt(request.getParameter("id"));
	System.out.println("id "+id);
	Registration r= service.edit(id);
	System.out.println("first name "+r.getFirstName());
	ModelAndView m= new ModelAndView("EditPage","ls",ls);
	m.addObject("r", r);
	return m;

}*/

}
