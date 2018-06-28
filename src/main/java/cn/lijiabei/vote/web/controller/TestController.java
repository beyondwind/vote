package cn.lijiabei.vote.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

	@RequestMapping("/test.htm")
	public ModelAndView test(@RequestParam(value = "v", defaultValue = "") String v) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/screen/test");
		modelAndView.addObject("value", v);
		return modelAndView;
	}

}
