package sql.practice.sess.sqlprac.Repository;

public class Queries {

    public static String SQL_INSERT_PURCHASE_ORDER = "insert into purchase_order(order_id, name, order_date) values (?, ?, SYSDATE())";
    public static String SQL_INSERT_LINE_ITEM = "insert into line_item(description, quantity, order_id) values (?, ?, ?)";
    public static String SQL_SELECT_ALL_ORDER_ID = "select order_id";
}

