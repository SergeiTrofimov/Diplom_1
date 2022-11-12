package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    // Переменные
    public IngredientType type;
    public String name;
    public float price;

    //Конструктор класса
    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    // Данные для параметризованного теста
    @Parameterized.Parameters(name = "Ингридиент типа: {0} называется {1} с ценой {2}")
    public static Object[][] createBumData() {
        return new Object[][]{
                {IngredientType.FILLING, "Положительный наполнитель", 4.1E1f},
                {IngredientType.SAUCE, "Отрицательная соус", -4.1E1f}
        };
    }

    @Test // У ингридиента правилен верный тип
    public void getIngredientTypeTest() {
       Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Имя объекта и введеное имя не совпали", type, ingredient.getType());
    }

    @Test // Ингридиенту присвоено правильное имя
    public void getIngredientNameTest() {
       Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Имя объекта и введеное имя не совпали", name, ingredient.getName());
    }

    @Test // Ингридиенту проставлена верная цена
    public void getIngredientTest() {
       Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Цена объекта и введеная цена не совпали", price, ingredient.getPrice(), 0);
    }
}