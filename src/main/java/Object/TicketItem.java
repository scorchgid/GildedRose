package Object;

import Data.GildedRose;

/** @author Gideon Sassoon */
public class TicketItem extends RareItem {
    public TicketItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }    
    @Override
    void updateQuality(int i){
        GildedRose.getItems().get(i).setSellIn(GildedRose.getItems().get(i).getSellIn() - 1);
        GildedRose.getItems().get(i).setQuality(GildedRose.getItems().get(i).getQuality() - GildedRose.getItems().get(i).getQuality());
        if (GildedRose.getItems().get(i).getQuality() < 50) {
                        GildedRose.getItems().get(i).setQuality(GildedRose.getItems().get(i).getQuality() + 1);
        }
    }   
}
