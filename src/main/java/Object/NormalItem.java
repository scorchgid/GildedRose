package Object;
import Data.GildedRose;
/** @author Gideon Sassoon */
public class NormalItem extends Item{
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    void updateQuality(int i){
        if (GildedRose.getItems().get(i).getQuality() > 0) {
            GildedRose.getItems().get(i).setQuality(GildedRose.getItems().get(i).getQuality() - 1);
        if (GildedRose.getItems().get(i).getSellIn() < 0) {
            if (GildedRose.getItems().get(i).getQuality() > 0) {
                GildedRose.getItems().get(i).setQuality(GildedRose.getItems().get(i).getQuality() - 1);
                }
            }
        }
    }    
} // Can we neaten this?
