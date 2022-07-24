import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final Ingredient ingredient;
    private final String name;
    private final IngredientType type;
    private final float price;

    public IngredientParameterizedTest(Ingredient ingredient, IngredientType type, String name, float price) {
        this.ingredient = ingredient;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {new Ingredient(SAUCE, "сычуаньский", 10), SAUCE, "сычуаньский", 10},
                {new Ingredient(FILLING, "котлета из индейки", 10000), FILLING, "котлета из индейки", 10000},
                {new Ingredient(SAUCE, "Кетчуп", 40), SAUCE, "Кетчуп", 40},
                {new Ingredient(FILLING, "Лист салата", 1), FILLING, "Лист салата", 1},
        };
    }

    @Test
    public void testIngredient() {
        assertEquals(ingredient.getType(), type);
        assertEquals(ingredient.getName(), name);
        assertEquals(ingredient.getPrice(), price, 0.0f);
    }
}