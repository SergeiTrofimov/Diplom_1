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

    Bun bun = Mockito.mock(Bun.class); // мок для булочки

    Ingredient ingredient = Mockito.mock(Ingredient.class); //мок для ингридиента


    private Burger createBurger(int size) { // Создаем бургер из моков
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (int i = 0; i < size; i++) {
            burger.addIngredient(ingredient);
        }
        return burger;
    }


    @Test // Добавляем ингридикент
    public void addIngredientTest() {
        Burger burger = createBurger(0);
        burger.addIngredient(ingredient);
        assertEquals("Размер массива не совпадает", burger.ingredients.size(), 1);
    }

    @Test // Удлаляем ингридиент
    public void removeIngredientTest() {
        Burger burger = createBurger(5);
        burger.removeIngredient(0);
        assertEquals("Размер массива не совпадает", burger.ingredients.size(), 4);
    }

    @Test //Двигаем ингридиент
    public void moveIngredientTest() {
        Burger burger = Mockito.spy(createBurger(5));
        burger.moveIngredient(0, 4);
        assertEquals("Размер массива не совпадает", burger.ingredients.size(), 5);
    }

    @Test //узнаем цену ингридиента
    public void getPriceTest() {
        Burger burger = createBurger(5);
        List<Ingredient> ingredients = new ArrayList<>();
        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        System.out.println(burger.getPrice());
    }

    @Test
    public void getReceiptTest()// получаем состав бургера
    {
        Burger burger = Mockito.spy(createBurger(5));
        Mockito.when(bun.getName()).thenReturn("Тестовая булочка");
        Mockito.when(ingredient.getName()).thenReturn("Тестовый ингридиент");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.doReturn(40f).when(burger).getPrice();
        System.out.println(burger.getReceipt());
        System.out.println(burger.getPrice());
    }
}