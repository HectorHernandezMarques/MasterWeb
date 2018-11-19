package com.hectorhernandezmarques.masterweb;

import com.hectorhernandezmarques.masterweb.models.MyOrder;
import com.hectorhernandezmarques.masterweb.models.OrderElement;
import com.hectorhernandezmarques.masterweb.repositories.MyOrderRepository;
import com.hectorhernandezmarques.masterweb.repositories.OrderElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NewOrderController {
    @Autowired
    private MyOrderRepository myOrderRepository;
    @Autowired
    private OrderElementRepository myOrderElementRepository;

    @RequestMapping("/neworder")
    public RedirectView showOrder(Model model, @RequestParam String title, @RequestParam List<String> orderElementNames) {
        MyOrder newOrder = new MyOrder(title);

        List<OrderElement> orderElements = new ArrayList<>();
        for (String orderElementName : orderElementNames) {
            orderElements.add(new OrderElement(orderElementName));
        }

        newOrder.setOrderElements(orderElements);

        myOrderRepository.save(newOrder);

        return new RedirectView("/");
    }
}
