package com.example.eventticket.controller;

import com.example.eventticket.entity.Concert;
import com.example.eventticket.service.IConcertService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {

    private final IConcertService concertService;

    // Xem trang chủ
    @GetMapping
    public String viewHomePage(Model model,
                               @RequestParam(required = false) String keyword,
                               @RequestParam(required = false) String location,
                               @RequestParam(required = false) LocalDateTime startTime) {

        List<Concert> concerts = concertService.searchConcerts(keyword, location, startTime);
        model.addAttribute("concerts", concerts);
        return "home";
    }

//    // Xem chi tiết sự kiện
//    @GetMapping("/concert/{id}")
//    public String viewConcertDetails(@PathVariable Long id, Model model) {
//        Concert concert = concertService.getConcertById(id);
//        model.addAttribute("concert", concert);
//        return "concert-detail";
//    }

    // Xử lý đăng nhập/đăng ký (chuyển hướng tới trang đăng ký/đăng nhập)
    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String viewRegisterPage() {
        return "register";
    }
}

