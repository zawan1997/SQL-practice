package sql.practice.sess.sqlprac.Controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpSession;
import sql.practice.sess.sqlprac.Exception.OrderException;
import sql.practice.sess.sqlprac.Models.Items;
import sql.practice.sess.sqlprac.Models.PurchaseOrder;

@Controller
public class BasketController {
    // Putting things into the cart

    @PostMapping
    public String postCart(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession sess)
            throws OrderException {

        List<Items> items = (List<Items>) sess.getAttribute("cart");
        if (null == items) {
            items = new LinkedList<>();
            sess.setAttribute("cart", items);
        }

        //if there is nothing in the list, then session will add a new list. If not...

        String item = form.getFirst("item");
        Integer quantity = Integer.parseInt(form.getFirst("quantity"));
        items.add(new Items(item, quantity));
        
        PurchaseOrder po = new PurchaseOrder();
        po.setName(form.getFirst("name"));
        for (Items it : items)
        po.setItems(items);

        sess.setAttribute("checkoutCart", po);
        model.addAttribute("items", items);

        return "cart_template";
    }

}
