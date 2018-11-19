package com.hectorhernandezmarques.masterweb;

import com.hectorhernandezmarques.masterweb.models.MyOrder;
import com.hectorhernandezmarques.masterweb.models.OrderElement;
import com.hectorhernandezmarques.masterweb.repositories.MyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class EditOrderController {


    @Autowired
    MyOrderRepository myOrderReporsitory;

    @RequestMapping("/editorder")
    public RedirectView editOrder(Model model, @RequestParam(required = false) Set<Integer> strikedElements, @RequestParam String title, @RequestParam List<String> orderElementNames, @RequestParam long id) {
        strikedElements = strikedElements == null ? new HashSet<>() : strikedElements;

        MyOrder newOrder = myOrderReporsitory.getOne(id);
        newOrder.setTitle(title);

        for (long strikedElement : strikedElements) {
            System.out.println(strikedElement);
        }

        List<OrderElement> orderElements = new ArrayList<>();
        int index = 0;
        for (String orderElementName : orderElementNames) {
            orderElements.add(new OrderElement(orderElementName, strikedElements.contains(index + 1)));
            index++;
        }

        newOrder.setOrderElements(orderElements);

        myOrderReporsitory.save(newOrder);

        return new RedirectView("/order?id=" + id);
    }
}
