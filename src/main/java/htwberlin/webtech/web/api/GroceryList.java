package htwberlin.webtech.web.api;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class GroceryList {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;

        private String title;
        @OneToMany(mappedBy = "groceryList", cascade = CascadeType.ALL)
        private List<Items> items;




        public GroceryList(Long id, String title, List<Items> items) {
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

        public List<Items> getItems() {
            return items;
        }

        public void setItems(List<Items> items) {
            this.items = items;
        }
}
