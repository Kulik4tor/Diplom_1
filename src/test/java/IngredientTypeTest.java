import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void sauceTypeTest() {
        IngredientType sauce = IngredientType.SAUCE;
        assertEquals("SAUCE", sauce.name());
    }

    @Test
    public void fillingTypeTest() {
        IngredientType filling = IngredientType.FILLING;
        assertEquals("FILLING", filling.name());
    }
}

