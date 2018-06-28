package cn.lijiabei.vote.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.lijiabei.vote.biz.service.AuthService;
import cn.lijiabei.vote.web.annotation.LoginAnnotation;

@LoginAnnotation
@Controller
@RequestMapping("/")
public class UserController extends BaseController {

	@Autowired
	private AuthService authService;

	@RequestMapping("/userInfo.htm")
	public ModelAndView test(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/screen/user");
		return modelAndView;
	}

}
