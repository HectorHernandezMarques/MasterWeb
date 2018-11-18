package com.hectorhernandezmarques.masterweb;

import com.hectorhernandezmarques.masterweb.repositories.MyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DeleteOrderController {
    @Autowired
    private MyOrderRepository myOrderRepository;

    @RequestMapping("/deleteorder")
    public RedirectView showOrder(Model model, @RequestParam long id) {
        myOrderRepository.delete(id);
        return new RedirectView("/");
    }
}
