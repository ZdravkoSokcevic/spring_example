package org.example.demo;

import java.util.List;
import java.util.Collection;
import org.example.demo.model.User;
import org.example.demo.repository.UserRepository;
import org.example.demo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@SpringBootApplication
@RestController
public class DemoApplication{
    
    @Autowired
    private UserService u;

    @Autowired
    private UserRepository ur;

	public static void main(String[] args) {
		try {
		        SpringApplication.run(DemoApplication.class, args);
	    } catch (Exception e) {
		        e.printStackTrace(); 
	    }
		// new SpringApplicationBuilder(DemoApplication.class).web(WebApplicationType.NONE).run(args);
		System.out.println(args.toString());
	}


	// @Override
 //    public void configureViewResolvers(ViewResolverRegistry registry) {
 //        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
 //        resolver.setPrefix("/webapp/WEB-INF/view/");
 //        resolver.setSuffix(".jsp");
 //        resolver.setViewClass(JstlView.class);
 //        registry.viewResolver(resolver);
 //    }

	@GetMapping("/test")
	public List<User> test(@RequestParam(value="name", defaultValue="") String name, @RequestParam(value="lname", defaultValue="") String lname) 
	{
		List<User> users = ur.getUsers();
		return users;
		// int count = 2;
		// if(!name.isEmpty() && !lname.isEmpty())
		// 	count++;

		// Ucenik[] ucenici= new Ucenik[count];
		// ucenici[0]= new Ucenik("Zdravko", "Sokcevic");
		// ucenici[1] = new Ucenik("Pera", "Peric");

		// if(!name.isEmpty() && !lname.isEmpty())
		// 	ucenici[2] = new Ucenik(name, lname);
		// return ucenici;
	}

	@GetMapping("/users/{page}")
	public List<User> limit(@PathVariable(value="page") int page)
	{
		List<User> users = ur.getWithPaginate(PageRequest.of(page,10));
		return users;
	}

	@GetMapping("/users/list")
	public String returnView(Model model)
	{
		model.addAttribute("message", "Prva stranica");
		return "index";
	}

}
