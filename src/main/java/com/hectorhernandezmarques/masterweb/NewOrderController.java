package com.hectorhernandezmarques.masterweb;

import com.hectorhernandezmarques.masterweb.models.MyOrder;
import com.hectorhernandezmarques.masterweb.repositories.MyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class NewOrderController {
    @Autowired
    private MyOrderRepository myOrderRepository;

    @RequestMapping("/neworder")
    public RedirectView showOrder(Model model, @RequestParam String title) {
        myOrderRepository.save(new MyOrder(title));
        model.addAttribute("myorders", myOrderRepository.findAll());

        return new RedirectView("/");
    }
}
