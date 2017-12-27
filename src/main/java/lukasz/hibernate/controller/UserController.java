package lukasz.hibernate.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lukasz.hibernate.entity.Tweet;
import lukasz.hibernate.entity.User;
import lukasz.hibernate.repository.TweetRepository;
import lukasz.hibernate.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private TweetRepository tweetRepo;
	
	@GetMapping("/add")
	public String addForm(Model m) {
		m.addAttribute("user", new User());
		return "user/addUser";
	}
	
	@PostMapping("/add")
	public String addFormPost(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "user/addUser";
		}
		this.userRepo.save(user);
		return "redirect:/user/all";
	}
	
	@GetMapping("/all")
	public String list(Model m) {
		m.addAttribute("users", availableUsers());
		return "/user/list";
	}
	
	@GetMapping("{id}/edit")
	@Transactional
	public String edit(@PathVariable long id, Model m) {
		User user = this.userRepo.getOne(id);
		m.addAttribute("user", user);
		return "user/addUser";
	}
	
	@PostMapping("/{id}/edit")
	public String editPost(@ModelAttribute User user) {
		userRepo.save(user);
		return "redirect:/user/all";
	}
	
	@GetMapping("/{id}/delete")
	@Transactional
	public String delete(@PathVariable long id) {
		this.userRepo.delete(id);
		return "redirect:/user/all";
	}
	
	@GetMapping("/{id}/tweets")
	public String showtweets(@PathVariable long id, Model m) {
		User user = userRepo.findOne(id);
		List<Tweet> tweets = user.getTweets();
		m.addAttribute("tweets", tweets);
		m.addAttribute("user", user);
		return "/user/usertweets";
	}
	
	@GetMapping("/search-tweets")
	public String search(@RequestParam String start, Model m) {
		List<Tweet> tweets = tweetRepo.findStartingWith(start);
		m.addAttribute("tweets", tweets);
		m.addAttribute("start", start);
		return "user/foundtweets";
	}
	
	//Model attributes
	@ModelAttribute("availableUsers")
	public List<User> availableUsers() {
		return userRepo.findAll();
	}
	
}
