import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class BurgerTest {
    List<Bun> buns;
    Burger burger;
    Database database;
    List<Ingredient> ingredients;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp() {
        burger = new Burger();
        database = new Database();
        ingredients = database.availableIngredients();
        buns = database.availableBuns();
    }

    @Test
    public void setBunTest() {
        burger.setBuns(buns.get(0));
        collector.checkThat(burger.getPrice(), equalTo(buns.get(0).getPrice() * 2));
    }

    @Test
    public void setIngredientTest() {
        burger.addIngredient(ingredients.get(0));
        collector.checkThat(1, equalTo(burger.ingredients.size()));
        collector.checkThat(burger.ingredients.get(0).getName(), equalTo(ingredients.get(0).getName()));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.removeIngredient(0);
        collector.checkThat(1, equalTo(burger.ingredients.size()));
        collector.checkThat(burger.ingredients.get(0).getName(), equalTo(ingredients.get(1).getName()));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.moveIngredient(0, 1);
        collector.checkThat(burger.ingredients.get(0).getName(), equalTo(ingredients.get(1).getName()));
        collector.checkThat(burger.ingredients.get(1).getName(), equalTo(ingredients.get(0).getName()));
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(0));
        String strPrice = String.format("%nPrice: %f%n", burger.getPrice());
        collector.checkThat(burger.getReceipt(), containsString(buns.get(0).getName()));
        collector.checkThat(burger.getReceipt(), containsString(ingredients.get(0).getName()));
        collector.checkThat(burger.getReceipt(), containsString(ingredients.get(1).getName()));
        collector.checkThat(burger.getReceipt(), containsString(strPrice));
    }

}
