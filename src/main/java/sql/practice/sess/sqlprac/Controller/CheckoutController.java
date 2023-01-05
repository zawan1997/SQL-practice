package sql.practice.sess.sqlprac.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sql.practice.sess.sqlprac.Exception.OrderException;
import sql.practice.sess.sqlprac.Models.Items;
import sql.practice.sess.sqlprac.Models.PurchaseOrder;
import sql.practice.sess.sqlprac.Service.OrderService;

@Controller
@RequestMapping(path = "/checkout")
public class CheckoutController {
    @Autowired
    OrderService orderSvc;

    @PostMapping
    public String postCheckout(Model model, HttpSession sess) throws OrderException {

        List<Items> items = (List<Items>) sess.getAttribute("cart");
        PurchaseOrder po = (PurchaseOrder) sess.getAttribute("checkoutCart");

        sess.invalidate();
        orderSvc.createNewOrder(po);
        model.addAttribute("total", items.size());

        return "checkout";
    }
}
