package ukr.dsa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ukr.dsa.model.Contact;
import ukr.dsa.model.User;
import ukr.dsa.model.json.JSONConverter;
import ukr.dsa.services.impl.ContactServiceImpl;
import ukr.dsa.services.impl.UserDetailsServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ContactServiceImpl contactService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = "/index")
    public String index(Model model){
        List<Contact> listContact = contactService.getContactListFromUserLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("contactList", listContact);
        return "index";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteContact(@PathVariable("id") Integer id){
        contactService.deleteContact(id);
        return "redirect:/index";
    }

    @ModelAttribute("contact")
    public Contact loadEmptyContact(){
        return new Contact();
    }

    @RequestMapping(value = "/new")
    public String create(Model model)
    {
        return "create";
    }
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(@Valid Contact contact, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "create";
        }
        contact.setUser(userDetailsService.getUser(SecurityContextHolder.getContext().getAuthentication().getName()));
        contactService.createContact(contact);
        JSONConverter.toJSON(contact);
        return "redirect:/index";
        }

}
