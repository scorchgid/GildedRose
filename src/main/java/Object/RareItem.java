package Object;
import Data.GildedRose;
/** @author Gideon Sassoon */
public class RareItem extends Item {
    public RareItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }   
    void updateQuality(int i){
         GildedRose.getItems().get(i).setSellIn(GildedRose.getItems().get(i).getSellIn() - 1);
         if (GildedRose.getItems().get(i).getQuality() < 50) {
             GildedRose.getItems().get(i).setQuality(GildedRose.getItems().get(i).getQuality() + 1);
         }
    }
}