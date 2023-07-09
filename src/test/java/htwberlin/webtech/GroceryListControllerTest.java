package htwberlin.webtech;


import com.fasterxml.jackson.databind.ObjectMapper;
import htwberlin.webtech.web.GroceryListRestController;
import htwberlin.webtech.web.api.GroceryList;
import htwberlin.webtech.web.service.GroceryListService;
import htwberlin.webtech.web.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import java.util.List;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(GroceryListRestController.class)
public class GroceryListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryListService groceryListService;

    @MockBean
    private ItemService itemService;

    @Test
    public void createGroceryListTest() throws Exception {
        GroceryList groceryList = new GroceryList();
        groceryList.setTitle("Test");
        // Mock des Service-Verhaltens
        when(groceryListService.createGroceryList(any(GroceryList.class))).thenReturn(groceryList);
        // Aufruf und Überprüfung
        this.mockMvc.perform(post("/api/groceryList")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"Title\":\"Test\"}"))
                .andExpect(status().isOk());
        verify(groceryListService, times(1)).createGroceryList(any(GroceryList.class));

    }

    @Test
    public void findGroceryListByIdTest() throws Exception{
        Long GroceryListId = 1L;
        GroceryList groceryList = new GroceryList();
        groceryList.setId(GroceryListId);
        when(groceryListService.findGroceryListById(GroceryListId)).thenReturn(groceryList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/groceryList/{id}", GroceryListId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(GroceryListId));


        verify(groceryListService, times(1)).findGroceryListById(GroceryListId);
    }
    @Test
    public void testDeleteGroceryList() throws Exception {
        // Mock des Service-Verhaltens
        doNothing().when(groceryListService).deleteGroceryList(anyLong());
        // Aufruf und Überprüfung
        this.mockMvc.perform(delete("/api/groceryList/1"))
                .andExpect(status().isOk());
    }


}
