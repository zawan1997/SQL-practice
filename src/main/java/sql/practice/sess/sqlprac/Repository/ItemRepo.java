package sql.practice.sess.sqlprac.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static sql.practice.sess.sqlprac.Repository.Queries.*;

import sql.practice.sess.sqlprac.Models.Items;

@Repository 
public class ItemRepo {
    @Autowired
    private JdbcTemplate template;

    public void addItems(List<Items> items, String orderId) {
        //mapping them to a list
        List <Object[]> data = items.stream()
            .map(it -> {
                Object[] i = new Object[3];
                i[0] = it.getDescription();
                i[1] = it.getQuantity();
                i[2] = orderId;
                return i;
            })
            .toList();

            template.batchUpdate(SQL_INSERT_LINE_ITEM, data);
    }

}
