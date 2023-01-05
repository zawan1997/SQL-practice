package sql.practice.sess.sqlprac.Models;

public class Items {
    //Follow the schema 
    private Integer itemId;
    private String description;
    private Integer quantity;

    //Constructor to instantiate LineItem properties  
    public Items(String description, Integer quantity) {
        //Dont need to create itemId because its auto increment
        this.description = description;
        this.quantity = quantity;
    } 
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

  

    

}
