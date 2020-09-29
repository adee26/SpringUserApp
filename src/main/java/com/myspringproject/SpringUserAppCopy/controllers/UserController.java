package com.myspringproject.SpringUserAppCopy.controllers;

import com.myspringproject.SpringUserAppCopy.entities.Country;
import com.myspringproject.SpringUserAppCopy.entities.User;
import com.myspringproject.SpringUserAppCopy.repositories.CountryRepository;
import com.myspringproject.SpringUserAppCopy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public UserController(UserRepository userRepository, CountryRepository countryRepository) {
        this.userRepository = userRepository;
        this.countryRepository = countryRepository;
    }

    @GetMapping("/")
    public String updateTable(Model model) {
        List<User> userList = userRepository.findAll();
//        User user = new User();
//        user.setName("John");
//        user.setEmail("john@gmail.com");
//        user.setCountry("England");
//        userList.add(user);
        model.addAttribute("users", userList);
        return "index";
    }

    @GetMapping("/signUp")
    public String showSignUpForm(User user) {
        return "user-add";
    }

    @PostMapping("/signUp")
    public String adduser(@Valid User user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "user-add";
        }
        userRepository.save(user);
        List<User> userList = userRepository.findAll();
        List<Country> countryList = countryRepository.findAll();
        model.addAttribute("users", userList);
        model.addAttribute("countries", countryList);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            return "usernotfound";
        }
        List<User> userList = userRepository.findAll();
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String getUserToEdit(@PathVariable("id") long id, Model model){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            model.addAttribute("user", user.get());
            return "user-edit";
        }else{
           return "usernotfound";
       }

        //return "user-edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        // user = userRepository.findById(id).orElseThrow();
        if (result.hasErrors()) {
            user.setId(id);
            return "user-edit";
        }

//        User user1 = userOptional.get();
//        if(userOptional.isPresent()){
//            if(result.hasErrors()){
//                return "user-edit";
//            }
//            return "user-edit";
//        }else{
//            return "usernotfound";
//        }

        userRepository.save(user);
        List<User> userList = userRepository.findAll();
        model.addAttribute("users", userList);
        return "index";
    }

}


