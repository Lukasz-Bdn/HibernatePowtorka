package lukasz.hibernate.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;

import lukasz.hibernate.entity.Tweet;
import lukasz.hibernate.entity.User;
import lukasz.hibernate.repository.TweetRepository;
import lukasz.hibernate.repository.UserRepository;

@Controller
@RequestMapping("/tweet")
public class TweetController {
	@Autowired
	private TweetRepository tweetRepo;
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/addform")
	public String addTweet(Model m) {
		Tweet tweet = new Tweet();
		m.addAttribute("tweet", tweet);
		return "tweet/addTweet";
	}
	
	@PostMapping("/addform")
	public String addTweetPost(@Valid @ModelAttribute Tweet tweet, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "tweet/addTweet";
		}
		tweet.setCreated(new Date());
		tweetRepo.save(tweet);
		return "redirect:/tweet/all";
	}
	
	@GetMapping("/all")
	public String list(Model m) {
		return "/tweet/list";
	}
	
	@GetMapping("{id}/edit")
	public String edit(@PathVariable long id, Model m) {
		Tweet tweet = tweetRepo.findOne(id);
		m.addAttribute("tweet", tweet);
		return "tweet/addTweet";
	}
	
	@PostMapping("{id}/edit")
	public String editPost(@ModelAttribute Tweet tweet) {
		tweetRepo.save(tweet);
		return "redirect:/tweet/all";
	}
	
	@GetMapping("{id}/delete")
	@Transactional
	public String delete(@PathVariable long id) {
		this.tweetRepo.delete(id);;
		return "redirect:/tweet/all";
	}
	
//	@GetMapping("${id}/showall")
//	public String showall(@PathVariable long id, Model m) {
//		List<Tweet> tweets = tweetRepo.findAllByUserId(id);
//		m.addAttribute("tweets", tweets);
//		m.addAttribute("user", userRepo.findOne(id));
//		return "/tweet/usertweets";
//	}
	
	//Model attributes
	@ModelAttribute("availableUsers")
	public List<User> availableUsers() {
		return userRepo.findAll();
	}
	
	@ModelAttribute("availableTweets")
	public List<Tweet> availableTweets() {
		return tweetRepo.findAll();
	}
}
