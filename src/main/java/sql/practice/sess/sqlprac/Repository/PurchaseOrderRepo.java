package sql.practice.sess.sqlprac.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sql.practice.sess.sqlprac.Models.PurchaseOrder;
import static sql.practice.sess.sqlprac.Repository.Queries.*;

import java.util.LinkedList;
import java.util.List;


@Repository
public class PurchaseOrderRepo {
    @Autowired
    private JdbcTemplate template;

    //Inserting the purchase order into the database
    public boolean insertPurchaseOrder(PurchaseOrder po) {
        return template.update(SQL_INSERT_PURCHASE_ORDER,
        po.getOrderId(), po.getName()) > 0;
    }

    //Retrieving all purchase orders
    public List<PurchaseOrder> getAllOrderID() {
        final List<PurchaseOrder> orders = new LinkedList<>();
        SqlRowSet rs = null;
        rs = template.queryForRowSet(SQL_SELECT_ALL_ORDER_ID);
        if (rs==null) {
            rs = null; 
        } else {
            while (rs.next()) {
                //orders.add(PurchaseOrder.create(rs));
            }
        }
        return orders;
    }
}
