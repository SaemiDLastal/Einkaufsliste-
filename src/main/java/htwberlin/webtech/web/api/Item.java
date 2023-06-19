package htwberlin.webtech.web.api;

        import jakarta.persistence.*;

        import java.util.ArrayList;
        import java.util.List;


@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;

    @ManyToMany(mappedBy = "itemList", cascade = CascadeType.ALL)
    private List<GroceryList> groceryList= new ArrayList<>();



    public Item(Long id, String name, String category,List<GroceryList> groceryList) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.groceryList = groceryList;
    }

    public Item() {
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

    public void setGroceryList(List<GroceryList> groceryLists) {
        this.groceryList = groceryLists;
    }

    public List<GroceryList> getGroceryList() {
        return groceryList;
    }


    public void add(GroceryList groceryList) {

    }



    public Item get(int i) {
        return null;
    }

}
