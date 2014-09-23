package Action;
import Data.GildedRose;
import Data.GildedRose;
/** @author Gideon Sassoon */
public class ActionOLD {
    public static void updateQuality() {
        for (int i = 0; i < GildedRose.getItems().size(); i++) {
            if ((!"Aged Brie".equals(GildedRose.getItems().get(i).getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(GildedRose.getItems().get(i).getName())) {
                if (GildedRose.getItems().get(i).getQuality() > 0) {
                    if (!"Sulfuras, Hand of Ragnaros".equals(GildedRose.getItems().get(i).getName())) {
                        GildedRose.getItems().get(i).setQuality(GildedRose.getItems().get(i).getQuality() - 1);
                    }
                }
            } else {
                if (GildedRose.getItems().get(i).getQuality() < 50) {
                    GildedRose.getItems().get(i).setQuality(GildedRose.getItems().get(i).getQuality() + 1);
                    if ("Backstage passes to a TAFKAL80ETC concert".equals(GildedRose.getItems().get(i).getName())) {
                        if (GildedRose.getItems().get(i).getSellIn() < 11) {
                            if (GildedRose.getItems().get(i).getQuality() < 50) {
                                GildedRose.getItems().get(i).setQuality(GildedRose.getItems().get(i).getQuality() + 1);
                            }
                        }
                        if (GildedRose.getItems().get(i).getSellIn() < 6) {
                            if (GildedRose.getItems().get(i).getQuality() < 50) {
                                GildedRose.getItems().get(i).setQuality(GildedRose.getItems().get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }
            if (!"Sulfuras, Hand of Ragnaros".equals(GildedRose.getItems().get(i).getName())) {
                GildedRose.getItems().get(i).setSellIn(GildedRose.getItems().get(i).getSellIn() - 1);
            }
            if (GildedRose.getItems().get(i).getSellIn() < 0) {
                if (!"Aged Brie".equals(GildedRose.getItems().get(i).getName())) {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(GildedRose.getItems().get(i).getName())) {
                        if (GildedRose.getItems().get(i).getQuality() > 0) {
                            if (!"Sulfuras, Hand of Ragnaros".equals(GildedRose.getItems().get(i).getName())) {
                                GildedRose.getItems().get(i).setQuality(GildedRose.getItems().get(i).getQuality() - 1);
                            }
                        }
                    } 
                    else {
                        GildedRose.getItems().get(i).setQuality(GildedRose.getItems().get(i).getQuality() - GildedRose.getItems().get(i).getQuality());
                    }
                } else {
                    if (GildedRose.getItems().get(i).getQuality() < 50) {
                        GildedRose.getItems().get(i).setQuality(GildedRose.getItems().get(i).getQuality() + 1);
                    }
                }
            }
        }
    }   
}