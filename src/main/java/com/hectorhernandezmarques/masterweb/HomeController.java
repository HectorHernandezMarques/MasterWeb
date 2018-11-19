package com.hectorhernandezmarques.masterweb;


import com.hectorhernandezmarques.masterweb.models.MyOrder;
import com.hectorhernandezmarques.masterweb.models.OrderElement;
import com.hectorhernandezmarques.masterweb.repositories.MyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MyOrderRepository myOrderRepository;

    @PostConstruct
    public void init() {
        MyOrder initialOrder = new MyOrder("Initial Order");
        List<OrderElement> initialElements = new ArrayList<>();
        initialElements.add(new OrderElement("Milk", false));
        initialElements.add(new OrderElement("JavaScript", true));
        initialElements.add(new OrderElement("Bread", false));
        initialOrder.setOrderElements(initialElements);
        myOrderRepository.save(initialOrder);
    }

    HomeController(){
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("myorders", myOrderRepository.findAll());
        return "home_template";
    }
}
