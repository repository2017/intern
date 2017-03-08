package com.people.net;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SearchController {

	@Autowired
	SearchService searchServ;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String handleEmptyGet(ModelMap model){
		return "search";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String showSearch(){
		return "search";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String handleRequest(@RequestParam String search,
			ModelMap model){
		List<UserInfo> inf = searchServ.listPeople(search);
		model.put("inf", inf);
		return "info";
	}
	
	@RequestMapping(value = "/delete-person", method = RequestMethod.GET)
	public String doGetDeletePerson(ModelMap model, @RequestParam int id){
		searchServ.deletePerson(id);
		return "redirect:search";
	}
	
	@RequestMapping(value = "/add-person", method = RequestMethod.GET)
	public String doGetForm(ModelMap model){
		model.put("userinfo", new UserInfo());
		return "userpage";
	}
	

	@RequestMapping(value = "/update-person", method = RequestMethod.GET)
	public String doGetUpdate(ModelMap model, @RequestParam int id){
		UserInfo userInfo = searchServ.getUserInfo(id);
		System.out.println(userInfo.getName());
		model.put("userinfo", userInfo);
		return "userpage";
	}
	
	@RequestMapping(value = "/update-person", method = RequestMethod.POST)
	public String doPostUpdate(ModelMap model, @ModelAttribute("userinfo") @Valid UserInfo userinfo, BindingResult result){

		if(result.hasErrors()){
			return "userpage";
		}
		
		searchServ.updateData(userinfo);
		return "redirect:search";
	
	}
	
	
	@RequestMapping(value = "/add-person", method = RequestMethod.POST)
	public String addPersonPost(ModelMap model, @ModelAttribute("userinfo") @Valid UserInfo userinfo, BindingResult result){
		if(result.hasErrors()){
			return "userpage";
		}
		searchServ.addData(userinfo);
		return "redirect:search";
	}
	
	
}
