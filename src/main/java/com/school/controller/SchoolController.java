package com.school.controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.model.Course;
import com.school.model.User;
import com.school.service.IStudentService;
import com.school.service.IUserService;

@Controller
public class SchoolController {

	@Autowired
	private User user;

	@Autowired
	private IUserService userService;

	@Autowired
	private IStudentService studentService;

	ModelAndView mv= new ModelAndView();

	@RequestMapping("/")
	public ModelAndView login(HttpSession session) {

		String principle= SecurityContextHolder.getContext().getAuthentication().getName();
		Collection<? extends GrantedAuthority> permissions= SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		System.out.println(principle);
		for(GrantedAuthority permission:permissions) {
			System.out.println(permission);
		}
		mv.addObject("name",principle);
		mv.addObject("permissions",permissions);
		mv.setViewName("home");

		session.setAttribute("loggedInUser", principle);
		return mv;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addNewUser(@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam("selectRole") String role, @RequestParam("selectCourse") String course,  @RequestParam("address") String address,
			HttpServletRequest request) {

		if(course==null || course.isEmpty())
			userService.registerNewUserAccount(userName, password, role);
		else
			userService.registerNewStudentAccount(userName, password, role, course, address);

		mv.setViewName("home");
		mv.addObject("loggedInUser", request.getSession().getAttribute("loggedInUser"));
		return mv;

	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView showAddUserForm(HttpServletRequest request) {

		mv.addObject("loggedInUser", request.getSession().getAttribute("loggedInUser"));
		mv.setViewName("registration");
		List<String> courseNames= new ArrayList<String>();
		for(Course course:studentService.findAllCourses()) {
			courseNames.add(course.getName());
		}
		mv.addObject("courseList", courseNames);
		return mv;

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchUser(HttpServletRequest request) {
		mv.setViewName("searchUser");
		mv.addObject("loggedInUser", request.getSession().getAttribute("loggedInUser"));
		return mv;

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView showSearch(@RequestParam(value="userName", required=true) String username, HttpServletRequest request) {
		mv.addObject("user", userService.searchUser(username));
		mv.setViewName("showSearch");
		mv.addObject("loggedInUser", request.getSession().getAttribute("loggedInUser"));
		return mv;

	}


	@RequestMapping(value = "/updateStudent", method = RequestMethod.GET)
	public ModelAndView getUpdateStudent(HttpServletRequest request) {
		
		mv.setViewName("update");
		mv.addObject("loggedInUser", request.getSession().getAttribute("loggedInUser"));
		return mv;

	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public ModelAndView updateStudent(@RequestParam Map<String, String> params,HttpServletRequest request) {
		String who=  (String) request.getSession().getAttribute("loggedInUser");
		String whatUpdate= params.get("what");
		String value= params.get(whatUpdate);
		studentService.update(who,whatUpdate, value);
		mv.setViewName("update");
		mv.addObject("loggedInUser", request.getSession().getAttribute("loggedInUser"));
		return mv;

	}
}
