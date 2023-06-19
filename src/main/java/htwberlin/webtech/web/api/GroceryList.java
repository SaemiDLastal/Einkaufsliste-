package htwberlin.webtech.web.api;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class GroceryList {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;

        private String title;
        @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinTable(
                name = "groceryList_item",
                joinColumns = @JoinColumn(name = "groceryList_id"),
                inverseJoinColumns = @JoinColumn(name = "item_id"))
        private List<Item> itemList= new ArrayList<>();


        public GroceryList(Long id, String title, List<Item> itemList) {
            this.id = id;
            this.title = title;
            this.itemList = itemList;
        }

    public GroceryList() {

    }

        public Long getId() {
        return id;
    }

        public void setId(Long id) {
        this.id = id;
    }

        public String getTitle() {
        return title;
    }

        public void setTitle(String title) {
        this.title = title;
    }

        public List<Item> getItemList() {
            return itemList;
        }

        public void setItemList(List<Item> item) {
            this.itemList = item;
        }

    @Override
    public String toString() {
        return "GroceryList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", itemList=" + itemList.get(0).getName() +
                '}';
    }

    public void addItem(Item item) {
            itemList.add(item);
            //item.getGroceryList().add(this);
        }






}
