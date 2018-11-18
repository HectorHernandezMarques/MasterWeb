package com.hectorhernandezmarques.masterweb;

import com.hectorhernandezmarques.masterweb.repositories.MyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowOrderController {

    @Autowired
    private MyOrderRepository myOrderRepository;

    @RequestMapping("/order")
    public String showOrder(Model model, @RequestParam long id) {
        model.addAttribute("myorder", myOrderRepository.findOne(id));

        return "show_order_template";
    }
}
