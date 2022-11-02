package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

     Bun bun= Mockito.mock(Bun.class);

     Ingredient ingredient = Mockito.mock(Ingredient.class);



    @Test //addIngredient
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals("Размер массива не совпадает", burger.ingredients.size(), 1);
    }

    @Test // removeIngredient
    public void removeIngredientTest() {
        Burger burger = new Burger();
        for (int i = 0; i < 5; i++) {
            burger.addIngredient(ingredient);
        }
        burger.removeIngredient(0);
        assertEquals("Размер массива не совпадает", burger.ingredients.size(), 4);
    }

    @Test //moveIngredient
    public void moveIngredientTest() {
        Burger burger = new Burger();
        for (int i = 0; i < 5; i++) {
            burger.addIngredient(ingredient);
        }
        burger.moveIngredient(0, 4);
       // Mockito.verify(burger.ingredients, Mockito.times(1)).add(ingredient);
    }

    @Test //getPrice()
    public void getPriceTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
       List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            burger.addIngredient(ingredient);
        }
        Mockito.when(bun.getPrice()).thenReturn(5f);
     Mockito.when(ingredient.getPrice()).thenReturn(1f);
       System.out.println(burger.getPrice());
    }

    @Test
    public void getReceiptTest()// getReceipt()
    {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (int i = 0; i < 5; i++) {
            burger.addIngredient(ingredient);
        }
        Mockito.when(bun.getName()).thenReturn("Тестовая булочка");
        Mockito.when(ingredient.getName()).thenReturn("Тестовый ингридиент");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(burger.getPrice()).thenReturn(5f);
        System.out.println(burger.getReceipt());
        System.out.println(burger.getPrice());
    }
}
