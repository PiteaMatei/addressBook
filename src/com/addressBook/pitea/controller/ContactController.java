package com.addressBook.pitea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.addressBook.pitea.entity.Contact;
import com.addressBook.pitea.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	//inject the contact service
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/list")
	public String listContacts(Model theModel) {
		
		//get contacts from the dao
		List<Contact> theContacts = contactService.getContacts();
		
		//add the contacts to the model
		theModel.addAttribute("contacts", theContacts);
		
		return "list-contacts";
	}
	

	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Contact theContact = new Contact();
		
		theModel.addAttribute("contact", theContact);
		
		return "contact-form";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("contact") Contact theContact) {
		
		//save contact
		contactService.saveContact(theContact);
		
		return "redirect:/contact/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("contactId") int theId, Model theModel) {
		
		//get the contact from contact service
		Contact theContact = contactService.getContact(theId);
		
		//set contact as a model to prepulate the form
		theModel.addAttribute("contact", theContact);
		
		
		//sending data to the form
		return "contact-form";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("contactId") int theId) {
		
		//delete the contact
		contactService.deleteContact(theId);
		
		return "redirect:/contact/list";
	}
	
}
