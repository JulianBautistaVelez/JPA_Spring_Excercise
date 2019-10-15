package com.julian.bootmvchibernate.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.julian.bootmvchibernate.model.Post;
import com.julian.bootmvchibernate.model.User;
import com.julian.bootmvchibernate.service.GeneralService;

@Controller
public class EjercicioController {

	@Autowired
	@Qualifier("userService")
	public GeneralService<User> userService;
	
	@Autowired
	@Qualifier("postService")
	public GeneralService<Post> postService;
	
	private static final Logger logger = LoggerFactory.getLogger(EjercicioController.class);
	
	/*
	public EjercicioController(UserService service) {
		this.userService = service;
	}*/
	
	/*****************USERS URLS**********************************************************/
	@RequestMapping("/")
	public String handleRequest(Model model) throws Exception {
		return VerListaUsers(model);
	}
	
	@RequestMapping("/users")
	public String VerListaUsers(Model model) throws Exception {
		logger.info("-- en listado de usuarios");
		List<User> listUsers = userService.list();
		model.addAttribute("userlist", listUsers);
		return "index";
	}
	
	@RequestMapping(value = "/users/new")
	public String newUser(Model model) {
		logger.info("-- en NEW Usuario");
		model.addAttribute("user", new User());
		return "addUser";		
	}
	
	@PostMapping("/saveUser")
	//@RequestMapping(value = "users/save",method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user) {
		logger.info("-- en SAVE");
		userService.add(user);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		logger.info("-- en DELETE");
		userService.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable("id") int id, Model model) {
		logger.info("-- en EDIT");
		User user = userService.get(id);
		model.addAttribute("user", user);
		return "addUser";
	}
	
	/*************************************POSTS URLS***********************************/
	@RequestMapping("/posts")
	public String VerListaPosts(Model model) throws Exception {
		logger.info("-- en listado de posts");
		List<Post> postUsers = postService.list();
		model.addAttribute("postslist", postUsers);
		return "posts";
	}
	
	@RequestMapping(value = "/posts/new")
	public String newPost(Model model) {
		logger.info("-- en NEW Usuario");
		model.addAttribute("post", new Post());
		model.addAttribute("users", userService.list());
		logger.info("-- -- -- LISTA DE USUARIOS -- -- --");
		System.out.println(userService.list());
		return "addPost";		
	}
	
	@PostMapping("/savePost")
	public String savePost(@ModelAttribute Post post) {
		logger.info("-- en SAVE");
		
		postService.add(post);
		return "redirect:/posts";
	}
	
	@GetMapping("/post/edit/{id}")
	public String editPost(@PathVariable("id") int id, Model model) {
		logger.info("-- en EDIT");
		Post post = postService.get(id);
		model.addAttribute("post", post);
		return "addPost";
	}
	
	@GetMapping("/post/delete/{id}")
	public String deletePost(@PathVariable("id") int id, Model model) {
		logger.info("-- en DELETE");
		postService.delete(id);
		return "redirect:/posts";
	}
	/******************************METODOS CHAPUZA QUE FUNCIONAN**********************************************************/
	@RequestMapping(value = "/posts/new/mod")
	public String createPostMod(Model model) {
		logger.info("-- en SAVE");
		model.addAttribute("newPost", new Post());
		model.addAttribute("users", userService.list());
		return "addPost";
	}
	
	@RequestMapping(value = "/posts/new/mod", method = RequestMethod.POST)
	public String newPostMod(Model model, @Valid @ModelAttribute("newPost") Post newPost, BindingResult result) {
		 if(result.hasErrors()){
			 
		        int idUsuario = Integer.parseInt((String) result.getFieldError().getRejectedValue());
		        newPost.setUser(userService.get(idUsuario));
		        postService.add(newPost);
		    }else {
		        postService.add(newPost);
		    }
		return "redirect:/posts";		
	}
	
	
	
}
