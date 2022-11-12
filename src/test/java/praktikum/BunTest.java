package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    // Переменные для конструктора
    private final String name;
    private final float price;

    //Конструктор класса
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    // Параметры для теста
    @Parameterized.Parameters(name = "Булочка: {0} с ценой {1}")
    public static Object[][] createBumData() {
        return new Object[][]{
                {"NewBum", 0},
                {"Положительная булочка", 4.1E1f},
                {"Отрицательная булочка", -4.1E1f},
                {"Дробная булочка", 4.1E-1f},
        };
    }

    // Тесты
    @Test // Булочке присвоено правильное имя
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals("Имя объекта и введеное имя не совпали", name, bun.getName());
    }

    @Test // Булочке проставлена верная цена
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals("Цена объекта и введеная цена не совпали", price, bun.getPrice(), 0);
    }
}