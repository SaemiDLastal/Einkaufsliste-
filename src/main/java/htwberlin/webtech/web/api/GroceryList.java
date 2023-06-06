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
        @OneToMany(cascade = CascadeType.ALL)
        private ArrayList<Item> items;


        public GroceryList(Long id, String title, ArrayList<Item> items) {
            this.id = id;
            this.title = title;
            this.items = items;
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

        public ArrayList<Item> getItems() {
            return items;
        }

        public void setItems(ArrayList<Item> items) {
            this.items = items;
        }
}
