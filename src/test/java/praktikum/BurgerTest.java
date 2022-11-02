package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Bun bun = Mockito.mock(Bun.class);

    Ingredient ingredient = Mockito.mock(Ingredient.class);

    private Burger createBurger(int size) {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (int i = 0; i < size; i++) {
            burger.addIngredient(ingredient);
        }
        return burger;
    }


    @Test //addIngredient
    public void addIngredientTest() {
        Burger burger = createBurger(0);
        burger.addIngredient(ingredient);
        assertEquals("Размер массива не совпадает", burger.ingredients.size(), 1);
    }

    @Test // removeIngredient
    public void removeIngredientTest() {
        Burger burger = createBurger(5);
        burger.removeIngredient(0);
        assertEquals("Размер массива не совпадает", burger.ingredients.size(), 4);
    }

    @Test //moveIngredient
    public void moveIngredientTest() {
        Burger burger = createBurger(5);
        burger.moveIngredient(0, 4);
        // Mockito.verify(burger.ingredients, Mockito.times(1)).add(ingredient);
    }

    @Test //getPrice()
    public void getPriceTest() {
        Burger burger = createBurger(5);
        List<Ingredient> ingredients = new ArrayList<>();
        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        System.out.println(burger.getPrice());
    }

    @Test
    public void getReceiptTest()// getReceipt()
    {   Burger burger = createBurger(5);
        Mockito.when(bun.getName()).thenReturn("Тестовая булочка");
        Mockito.when(ingredient.getName()).thenReturn("Тестовый ингридиент");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        //Mockito.when(burger.getPrice()).thenReturn(1f);
        System.out.println("Размер = " + burger.ingredients.size());
        System.out.println(burger.getReceipt());
        System.out.println(burger.getPrice());
    }

    @Test
    public void getTest()// getReceipt()
    {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(burger.getPrice()).thenReturn(1f);
        System.out.println(burger.getPrice());
    }
}
