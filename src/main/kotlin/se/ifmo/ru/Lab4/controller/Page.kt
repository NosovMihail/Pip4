package se.ifmo.ru.Lab4.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import se.ifmo.ru.Lab4.entities.Point
import java.util.concurrent.atomic.AtomicLong

@Controller
class Page {
    //private val counter = AtomicLong()

    @RequestMapping("/pointcheck")
    fun greeting(): String {
        return "pointcheck.html";
    }
}