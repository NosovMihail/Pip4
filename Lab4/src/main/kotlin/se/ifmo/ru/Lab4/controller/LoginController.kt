package se.ifmo.ru.Lab4.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController{
    @GetMapping("/login")
    fun login(@RequestParam(value = "login") login: String,
              @RequestParam(value = "password" )password: String): String{
        System.out.println("Hey oh they sent us smth")
        return "Your login is $login and $password is your password"
    }
}