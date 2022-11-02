package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    private Bun bun;
    private Ingredient ingredient;

    @Test //addIngredient
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals("Размер массива не совпадает", burger.ingredients.size(), 1);
    }

    @Test // removeIngredient
    public void removeIngredientTest() {
        for (int i = 0; i < 5; i++) {
            burger.addIngredient(ingredient);
        }
        burger.ingredients.remove(0);
        assertEquals("Размер массива не совпадает", burger.ingredients.size(), 4);
    }

    //moveIngredient
    //getPrice()
    // getReceipt()
}
