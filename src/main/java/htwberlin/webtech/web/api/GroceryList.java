package htwberlin.webtech.web.api;

public class GroceryList {

        private Long id;

        private String title;

        public GroceryList(Long id, String title) {
            this.id = id;
            this.title = title;
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
}
