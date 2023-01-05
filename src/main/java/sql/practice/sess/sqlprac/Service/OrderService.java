package sql.practice.sess.sqlprac.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import sql.practice.sess.sqlprac.Exception.OrderException;
import sql.practice.sess.sqlprac.Models.PurchaseOrder;
import sql.practice.sess.sqlprac.Repository.ItemRepo;
import sql.practice.sess.sqlprac.Repository.PurchaseOrderRepo;

public class OrderService {
    @Autowired
    private PurchaseOrderRepo poRepo;

    @Autowired
    private ItemRepo itRepo;

    // If there is a need to produce error message for incorrect input
    @Transactional(rollbackFor = OrderException.class)
    public void createNewOrder(PurchaseOrder po) throws OrderException {

        // Generate the OrderId
        String orderId = UUID.randomUUID().toString().substring(0, 8);

        po.setOrderId(orderId);

        // create the purchaseOrder`

        poRepo.insertPurchaseOrder(po);

        if (po.getItems().size() > 5)
            throw new OrderException("Cannot order more than 5");

        itRepo.addItems(po.getItems(), orderId);

    }
}
