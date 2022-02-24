package in.nareshit.ajeet.hc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nareshit.ajeet.hc.entity.Specialization;
import in.nareshit.ajeet.hc.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {
	@Autowired
	private ISpecializationService service;
	/***1. show Register Page
	 * **/
	@GetMapping("/register")
	public String displayRegister() {
		return "SpecializationRegister";
		
	}
	/***2.On Submit Form Save Data
	 * **/
	@PostMapping("/save")
	public String saveForm(
			@ModelAttribute Specialization specialization,
			Model model) {
		Long id = service.saveSpecialization(specialization);
		String message="Record is  ("+id+") created";
		model.addAttribute("message", message);
		return "SpecializationRegister";
		
		
	}
	/**
	 * 3.Display All Specialization**/
	@GetMapping("/all")
	public String viewAll(Model model,
			@RequestParam(value="message",required=false)String message) {
		List<Specialization> list = service.getAllSpecializations();
		model.addAttribute("list", list);
		model.addAttribute("message",message);
		return "SpecializationData";
		
	}
/***
 * 4. Delete By Id**/
	@GetMapping("/delete")
	public String deleteData(@RequestParam Long id,
			RedirectAttributes attrbutes) {
		service.removeSpecialization(id);
		attrbutes.addAttribute("message", "Record ("+id+") is Removed");
		return "redirect:all";
		
	}
	/****
	 * 5. Fetch Data From Edit Page
	 * ****/
	@GetMapping("/edit")
	public String showEditPage(
			@RequestParam Long id, 
			Model model)
	{
		Specialization spec = service.getOneSpecialization(id);
		model.addAttribute("specialization", spec);
		return "SpecializationEdit";
		
	}
}
