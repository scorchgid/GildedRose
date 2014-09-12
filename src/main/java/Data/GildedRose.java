package Data;
import Action.Action;
import Object.Item;
import java.util.ArrayList;
import java.util.List;
/** @author Edited By - Gideon Sassoon */
public class GildedRose {
    private static List<Item> Items = null; /**
     * @param args */
    public static void main(String[] args) {    
        System.out.println("OMGHAI!");
        Items = new ArrayList<>();
        Items.add(new Item("+5 Dexterity Vest", 10, 20));                           // Line!!!!
        Items.add(new Item("Aged Brie", 2, 0));                                     // Line 29 Line 72
        Items.add(new Item("Elixir of the Mongoose", 5, 7));                        // Line!!!!
        Items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));                   // Line 33, Line 65
        Items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));   //Line 29 Line 45 Line 74
        Items.add(new Item("Conjured Mana Cake", 3, 6));                            // Line!!!!
        Action.updateQuality();
    }
    public static List<Item> getItems() {
        return Items;
    }
    public static void setItems(List<Item> item) {
        Items = item;
    }       
}