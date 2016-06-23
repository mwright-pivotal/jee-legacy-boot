package com.pivotal.legacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.Date;
import java.util.Map;

/**
 * Created by mwright on 6/20/16.
 */
@Controller
public class WelcomeController {
    @Autowired
    private DataSource jndiDataSource;

    @Autowired
    private ContactsRepository contactsRepository;

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/foo")
    public String foo(Map<String, Object> model) {
        throw new RuntimeException("Foo");
    }

    @RequestMapping("/contacts")
    public String contacts(Map<String, Object> model) {
        Contact contact = new Contact();
        model.put("contact",contact);
        return "addContact";
    }

    @RequestMapping(value = "/contact_create.html", method = RequestMethod.POST)
    public String createContact(@ModelAttribute("contact") @Valid Contact form, BindingResult result) {
        if (result.hasErrors()) {
            return "addContact";
        }
        try {
            contactsRepository.save(form);
        } catch (Exception e) {
            e.printStackTrace();
            result.reject("contact.error.exists");
            return "addContact";
        }
        return "redirect:/";
    }
}
