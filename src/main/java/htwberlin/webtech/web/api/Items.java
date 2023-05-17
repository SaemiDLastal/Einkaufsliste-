package htwberlin.webtech.web.api;

import jakarta.persistence.*;


@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    @ManyToOne
    @JoinColumn(name = "grocery_list_id")
    private GroceryList groceryList;

    public Items(Long id, String name, String category, GroceryList groceryList) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.groceryList = groceryList;
    }

    protected Items() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }
}
