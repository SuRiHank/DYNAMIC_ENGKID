package com.webtoeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoiController {

    // Xử lý yêu cầu GET đến trang /listGoi
    @GetMapping("/listGoi")
    public String listGoi() {
        // Trả về tên của trang JSP để hiển thị
        return "client/listGoi"; // listGoi.jsp trong thư mục WEB-INF/views/
    }
    @GetMapping("/muaTC")
    public String muaTC() {
        // Trả về tên của trang JSP để hiển thị
        return "client/muaTC"; // listGoi.jsp trong thư mục WEB-INF/views/
    }
}
