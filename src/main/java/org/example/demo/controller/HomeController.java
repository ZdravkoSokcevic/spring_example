package org.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.example.demo.repository.UserRepository;
import org.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import org.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/users")
public class HomeController
{
	private static Integer perPage = 10;
	@Autowired
	private UserService u;

    @Autowired
    private UserRepository ur;

	@RequestMapping("/nesto")
	public String home()
	{
		System.out.println("Tu si");
		return "index";
	}

	@GetMapping("/paginate/{page}")
	public ModelAndView usersWithPaginate(@PathVariable(value="page") int page, ModelAndView model)
	{
		List<User> users = ur.getWithPaginate(PageRequest.of(page,HomeController.perPage));
		Integer maxNum = ur.getUserNumber();
		Integer maxPageNum = (int) maxNum / (int) HomeController.perPage;
		System.out.println("Broj strana max " + maxPageNum.toString());
		System.out.println(users.get(0).first_name);

		model.addObject("currentPageNum", page);
		model.addObject("maxPageNum", maxPageNum);
		model.addObject("users", users);
		model.setViewName("users");
		return model;

	}

	@GetMapping("/proba/{page}")
	public List<User> limit(@PathVariable(value="page") int page)
	{
		Logger log = LoggerFactory.getLogger(this.getClass());
		List<User> users = ur.getWithPaginate(PageRequest.of(page,10));
		return users;
	}

}