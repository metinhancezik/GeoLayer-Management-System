package com.example.demo01.Controllers;

import com.example.demo01.Entities.User;
import com.example.demo01.DTOs.UserDto;
import com.example.demo01.NormalClasses.iSValid;
import com.example.demo01.Services.CustomUserDetailsService;
import com.example.demo01.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final CustomUserDetailsService customUserDetailsService;
    private final UserService userService;

    @Autowired
    public UserController(UserService userService,CustomUserDetailsService customUserDetailsService) {
        this.userService = userService;
        this.customUserDetailsService=customUserDetailsService;
    }

    @GetMapping("/signup")
    public String showSignUpPage() {
        return "signup.html"; // Bu, signup.html sayfasını döndürür
    }

    @GetMapping("/checkUsername")
    @ResponseBody
    public iSValid checkUsername(@RequestParam String username) {
        iSValid isvalid = new iSValid();
        String Ourvalue;
        if (userService.isUsernameAvailable(username)){
            Ourvalue="YES";
            isvalid.setIsValidValue(Ourvalue);
        }
        else {
            Ourvalue="NO";
            isvalid.setIsValidValue(Ourvalue);
        }

        return isvalid;
    }


    @PostMapping("/signup")
    public String signUpUser(@ModelAttribute User user, Model model) {
        if (userService.isUsernameAvailable(user.getUsername())) {
            userService.saveUser(user);
            return "redirect:/success";
        } else {

            model.addAttribute("error", "Kullanıcı adı zaten alınmış!");
            return "signup";
        }
    }



    @GetMapping("/success")
    public String succesFunc() {
        return "succes.html"; }


    @GetMapping("/userInfo")
    public String youEnteredFunc() {
        return "userInfo.html"; }


    @GetMapping("/userInformation")
    @ResponseBody
    public UserDto userInfoFunc() {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        User user = customUserDetailsService.findByUsername(userDetails.getUsername());

        UserDto userDto = new UserDto();
        userDto.setUserPassword(user.getUserPassword());
        userDto.setId(user.getId());
        userDto.setUserFirstName(user.getUserFirstName());
        userDto.setUserLastName(user.getUserLastName());
        userDto.setUsername(user.getUsername());
        userDto.setUserMail(user.getUserMail());
        userDto.setRole(user.getRole());
        userDto.setStatus(user.getStatus());

        return userDto;
    }





    @PostMapping("/userUpdate")
        public ResponseEntity<User> updateUser(@RequestBody User user) {
            if(userService.doesUserExist(user.getId())) {
                try {
                    User updatedUser = userService.saveUser(user);
                    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }





    @RequestMapping("/")
    public String baslangic(){
        return "index.html";
    }

}
