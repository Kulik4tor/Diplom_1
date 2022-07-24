import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private final String name = "Булочка с сыром";
    private final float price = 4.7E-23f;
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest() {
        String actualResult = bun.getName();
        assertEquals(name, actualResult);
    }

    @Test
    public void getPriceTest() {
        float actualResult = bun.getPrice();
        assertEquals(price, actualResult, 0.0f);
    }
}
