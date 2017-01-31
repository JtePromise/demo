package com;

import com.dao.CustomRepositoryFactoryBean;
import com.dao.UserRepository;
import com.dao.model.Users;
import com.example.AuthorSetting;
import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@EnableCaching
public class DemoApplication {
	@Autowired
	private AuthorSetting authorSetting;

	@Autowired
	private TestService testService;

	@RequestMapping("/index")
	public String index(Model model,String name) {
		model.addAttribute("aaa","123");
		Users user = new Users();
		System.out.println("ok");
	//	System.out.println(testService.getUsers(name));

		return "index";
	}

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			return "error";
		}

		return "login";
	}

	@RequestMapping("/chat")
	public String chat(Principal principal,String msg) {

		return "chat";
	}

	@RequestMapping(value = "/json",produces = {MediaType.APPLICATION_JSON_VALUE})
	public String json(Model model) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("abc","sdfd");

		model.addAttribute("sss",map);
		return "jsonView";
	}


	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.setShowBanner(false);
		app.run();
	}


}
