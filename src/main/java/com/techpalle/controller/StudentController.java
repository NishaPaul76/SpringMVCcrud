package com.techpalle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpalle.dao.StudentDao;
import com.techpalle.model.Student;

@Controller
public class StudentController 
{
	@RequestMapping(value="student",params = "show")
	public ModelAndView displayAllStudent() 
	{
		ModelAndView mv = new ModelAndView ();
		
		//call the Dao method
		ArrayList<Student> alstud = StudentDao.getAllStudent();
		
		//We need redirect user to display.jsp with ArrayList Data:
		mv.addObject("student", alstud);
		
		mv.setViewName("display.jsp");
		
		return mv;
	}
	@RequestMapping(value="student",params = "reg")
	public ModelAndView getRegisterPage() 
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("register.jsp");
		return mv;
	}
	
	
	@RequestMapping("insert")
	//we have used Request to read the data which is coming from browser
	public ModelAndView insertStudentServlet(HttpServletRequest req) 
	{
		ModelAndView mv = new ModelAndView();
		
		String n = req.getParameter("tbName");
		String e= req.getParameter("tbEmail");
		String p =req.getParameter("tbPass");
		long m = Long .parseLong(req.getParameter("tbMobile"));
		
		Student stud =new Student (n,e,p,m);
		
		StudentDao.insertStudent(stud);
		
		mv = displayAllStudent() ;
		
		return mv;
	}
}
