package com.hectorhernandezmarques.masterweb;

import com.hectorhernandezmarques.masterweb.repositories.MyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditOrderFormController {

    @Autowired
    MyOrderRepository myOrderReporsitory;

    @RequestMapping("/editorderform")
    public String editOrderForm(Model model, @RequestParam long id) {
        model.addAttribute("myorder", myOrderReporsitory.getOne(id));

        return "edit_order_form_template";
    }
}
