package se.ifmo.ru.Lab4.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import se.ifmo.ru.Lab4.entities.Point
import java.util.concurrent.atomic.AtomicLong

@RestController
class GetPointsController {
    private val counter = AtomicLong()

    @GetMapping("/points")
    fun greeting(): Point {
        return Point("me", 123.0,123.0, 123.0)
    }
}