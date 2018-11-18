package com.hectorhernandezmarques.masterweb;

import com.hectorhernandezmarques.masterweb.repositories.MyOrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewOrderFormController {

    @RequestMapping("/neworderform")
    public String showOrder(Model model) {
        return "new_order_form_template";
    }
}
