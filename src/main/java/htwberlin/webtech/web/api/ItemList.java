package htwberlin.webtech.web.api;

public class ItemList {
    private long id;
    private long groceryListId;
    private long itemId;
    private int quantity;

    public ItemList(long id, long groceryListId, long itemId, int quantity) {
        this.id = id;
        this.groceryListId = groceryListId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public ItemList() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGroceryListId() {
        return groceryListId;
    }

    public void setGroceryListId(long groceryListId) {
        this.groceryListId = groceryListId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
