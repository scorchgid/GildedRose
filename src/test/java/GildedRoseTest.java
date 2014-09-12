//import static GildedRose.items;
import Action.Action;
import Data.GildedRose;
import Object.Item;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
/** @author Edited By - Gideon Sassoon */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GildedRoseTest {
//<< -- Test Setup -- >>
        @Rule public TestName testName = new TestName();
        @Before public void setup() {
            ;
            GildedRose.setItems(new ArrayList<Item>());
            GildedRose.getItems().clear();
            TestCounter.increaseTestCase();
            System.out.println(testName.getMethodName());
            System.out.println("--------------------------------------------");
        }
        @Test public void aa_printTestValues() {
		assertTrue(true);
            System.out.println(
                    "These tests are using the following values:  sellIn, quality "     + " \n\n" +
                    "Item 1 " + "+5 Dexterity Vest, 10, 20"                             + " \n" +
                    "Item 2 " + "Aged Brie, 2, 0"                                       + " \n" +
                    "Item 3 " + "Elixir of the Mongoose, 5, 7"                          + " \n" +
                    "Item 4 " + "Sulfuras, Hand of Ragnaros, 0, 80"                     + " \n" +
                    "Item 5 " + "Backstage passes to a TAFKAL80ETC concert, 15, 20"     + " \n" +
                    "Item 6 " + "Conjured Mana Cake, 3, 6"
                    );
	}
        @After public void endOfLine(){
            System.out.println("======================================================");
        }
//----------------------------------------------------------------------------//
//      
//<< -- Test QUALITY of item Decreases normal speed-------------------------- >>
        //Check each item does not equal zero
        @Test public void ba_testQualityDecreasesOnDexterityVest(){
            Item item = new Item ("+5 Dexterity Vest", 10, 20);
            GildedRose.getItems().add(item);
            System.out.println("+5 Dexterity Vest Quality is now (Before method): "+ item.getQuality()+ " and sell is at: "+item.getSellIn());
            Action.updateQuality();
            int check = item.getQuality();
            System.out.println("+5 Dexterity Vest Quality is now: "+ item.getQuality()+ " and sell is at: "+item.getSellIn());
            assertEquals(19, check);
        } 
        @Test public void bb_testQualityDecreasesOnElixirOfTheMongoose(){
            
            Item item = new Item ("Elixir of the Mongoose", 5, 7);
            GildedRose.getItems().add(item);
            System.out.println("Elixir of the Mongoose Quality is now (Before method): "+item.getQuality()+ " and sell is at: "+item.getSellIn());
            Action.updateQuality();
            int check = item.getQuality();
            System.out.println("Elixir of the Mongoose Quality is now: "+item.getQuality()+ " and sell is at: "+item.getSellIn());
            assertEquals(6, check);
        }
        // @Test       Not needed     Sulfuras, Hand of Ragnaros
        @Test public void bd_testQualityDecreasesOnConjuredManaCake(){
                    Item item = new Item ("Conjured Mana Cake", 3, 6);
                    GildedRose.getItems().add(item);
                    System.out.println("Conjured Mana Cake Quality is now (Before method): "+item.getQuality()+ " and sell is at: "+item.getSellIn());
                    Action.updateQuality();
                    int check = item.getQuality();
                    System.out.println("Conjured Mana Cake Quality is now: "+item.getQuality()+ " and sell is at: "+item.getSellIn());
                    assertEquals(5, check);
                }
        //*Quality of item increases
        @Test public void be_testQualityIncreasesOnAgedBrie(){
            Item item = new Item ("Aged Brie", 2, 0);
            GildedRose.getItems().add(item);
            System.out.println("Aged Brie Quality is now (Before method): "+ item.getQuality() + " and sell is at: "+item.getSellIn());
            Action.updateQuality();
            int check = item.getQuality();
            System.out.println("Aged Brie Quality is now: "+item.getQuality()+ " and sell is at: "+item.getSellIn());
            assertEquals(1, check);
        }
        @Test public void bf_testQualityDecreasesOnBackstagePasses(){
            Item item = new Item ("Backstage passes to a TAFKAL80ETC concert", 15, 20);
            GildedRose.getItems().add(item);
            System.out.println("Backstage passes to a TAFKAL80ETC concert is now (Before method : "+item.getQuality()+ " and sell is at: "+item.getSellIn());
            Action.updateQuality();
            int check = item.getQuality();
            System.out.println("Backstage passes to a TAFKAL80ETC concert is now: "+item.getQuality()+ " and sell is at: "+item.getSellIn());
            assertEquals(21, check);
        }
//----------------------------------------------------------------------------//
//
//<< -- Test QUALITY x2 fast as time limit approaches------------------------->>
        @Test public void ca_testQualityIncreaseOVERRIDEOnBackstagePasses5DayLeft(){
            Item item = new Item ("Backstage passes to a TAFKAL80ETC concert", 15, 20);
            GildedRose.getItems().add(item);
            System.out.println("Backstage passes to a TAFKAL80ETC concert OVERRIDE 5 Days sell in is at (Before method): " + item.getSellIn()+ " and quality is at: "+item.getQuality());
            for (int i = item.getSellIn(); i>4; i--) {
                Action.updateQuality();
                i = item.getSellIn();
                System.out.println("Backstage passes to a TAFKAL80ETC concert OVERRIDE 5 Days sell in is at: " + item.getSellIn()+ " and quality is at: "+item.getQuality());
                }
            int check = item.getQuality();
            assertEquals(35, check);
        }
        @Test public void cb_testQualityIncreaseOVERRIDEOnBackstagePasses1DayLeft(){
            Item item = new Item ("Backstage passes to a TAFKAL80ETC concert", 15, 20);
            GildedRose.getItems().add(item);
            System.out.println("Backstage passes to a TAFKAL80ETC concert OVERRIDE 2 Days sell in is at (Before method): " + item.getSellIn()+ " and quality is at: "+item.getQuality());
            for (int i = item.getSellIn(); i >1; i--) {
                Action.updateQuality();
                i = item.getSellIn();
                System.out.println("Backstage passes to a TAFKAL80ETC concert OVERRIDE 2 Days sell in is at: " + item.getSellIn()+ " and quality is at: "+item.getQuality());
                }
            int check = item.getQuality();
            assertEquals(44, check);
        }
//----------------------------------------------------------------------------//
//
//<< -- Test AFTER SELLIN is NEGATIVE 1 QUALITY decreases x2----------------->>
        @Test public void da_testQualityDecreaseOVERRIDEOnDexterityVest(){
            Item item = new Item ("+5 Dexterity Vest", 10, 20);
            GildedRose.getItems().add(item);
            System.out.println("+5 Dexterity Vest sell in is at (Before method): "+item.getSellIn()+ " and quality is at: "+item.getQuality());
            for (int i = item.getSellIn(); i >-1; i--) {
                Action.updateQuality();
                System.out.println("+5 Dexterity Vest sell in is at: "+item.getSellIn()+ " and quality is at: "+item.getQuality());
                }
            int check = item.getQuality();  
            assertEquals(8, check);
        }
        @Test public void db_testQualityDecreasesOVERRIDEOnElixirOfTheMongoose(){
            Item item = new Item ("Elixir of the Mongoose", 5, 7);
            GildedRose.getItems().add(item);
            System.out.println("Elixir of the Mongoose sell in is at (Before method): " + item.getSellIn()+ " and quality is at: "+item.getQuality());
            for (int i = item.getSellIn(); i >-1; i--) {
                Action.updateQuality();
                System.out.println("Elixir of the Mongoose sell in is at: " + item.getSellIn()+ " and quality is at: "+item.getQuality());
                }
            int check = item.getQuality();
            assertEquals(0, check);
        }
        @Test public void dc_testQualityIncreaseOVERRIDEOnConjuredManaCake(){
            Item item = new Item ("Conjured Mana Cake", 3, 6);
            GildedRose.getItems().add(item);            
            System.out.println("Conjured Mana Cake sell in is at (Before method): "+item.getSellIn()+ " and quality is at: "+item.getQuality());
            for (int i = item.getSellIn(); i >-1; i--) {
                Action.updateQuality();
                System.out.println("Conjured Mana Cake sell in is at: "+item.getSellIn()+ " and quality is at: "+item.getQuality());
                }
            int check = item.getQuality();
            assertEquals(1, check); 
        }         
        //*Quality of item increases but does not go over 50
        @Test public void dd_testQualityIncreaseOVERRIDEOnAgedBrie(){
            Item item = new Item ("Aged Brie", 2, 0);
            GildedRose.getItems().add(item);
            System.out.println("Aged Brie OVERRIDE sell in is at (Before method): "+ item.getSellIn()+ " and quality is at: "+item.getQuality());
            for (int i = item.getSellIn(); i<60; i++) {
                Action.updateQuality();
                System.out.println("Aged Brie OVERRIDE sell in is at: "+ item.getSellIn()+ " and quality is at: "+item.getQuality());
                }
            int check = item.getQuality();
            assertEquals(50, check);
        }
        //*Quality of item drops to 0 after sellby date expires         
        @Test public void de_testQualityDropsTo0OnBackstagePasses(){
            Item item = new Item ("Backstage passes to a TAFKAL80ETC concert", 15, 20);
            GildedRose.getItems().add(item);            
            System.out.println("Backstage passes to a TAFKAL80ETC concert sell in is at ()Before method): "+item.getSellIn()+ " and quality is at: "+item.getQuality());
            for (int i = item.getSellIn(); i >-1; i--) {
                Action.updateQuality();
                System.out.println("Backstage passes to a TAFKAL80ETC concert sell in is at: "+item.getSellIn() + " and quality is at: "+item.getQuality());
                }
            int check = item.getQuality();
            assertEquals(0, check); 
        }
//----------------------------------------------------------------------------//
//
//<< -- Test Quality does not go beyond 0------------------------------------->>       
        @Test public void ea_testQualityStopAtZeroDoesNotGoNegativeOnDexterityVest(){
            Item item = new Item ("+5 Dexterity Vest", 10, 20);
            GildedRose.getItems().add(item);
            System.out.println("+5 Dexterity Vest Zero Drop is at (Before method): "+ item.getSellIn()+ " and quality is at: "+item.getQuality());
            for (int i = item.getSellIn();i>-11; i--){
                Action.updateQuality();
                System.out.println("+5 Dexterity Vest Zero Drop is at: "+ item.getSellIn() + " and quality is at: "+item.getQuality());
            }
            int check = item.getQuality();
            assertEquals(0, check);
        }
        @Test public void eb_testQualityStopAtZeroDoesNotGoNegativeOnElixirOfTheMongoose(){
            Item item = new Item ("Elixir of the Mongoose", 5, 7);
            GildedRose.getItems().add(item);
            System.out.println("Elixir of the Mongoose is at (Before method): "+ item.getSellIn()+ " and quality is at: "+item.getQuality());
            for (int i = item.getSellIn();i>-11;i--){
            Action.updateQuality();
            System.out.println("Elixir of the Mongoose is at: "+ item.getSellIn()+ " and quality is at: "+item.getQuality());
            }
            int check = item.getQuality();
            assertEquals(0, check);
        }        
        @Test public void ec_testQualityStopAtZeroDoesNotGoNegativeOnConjuredManaCake(){
            Item item = new Item ("Conjured Mana Cake", 3, 6);
            GildedRose.getItems().add(item);
            System.out.println("Conjured Mana Cake (Before method): "+ item.getSellIn()+ " and quality is at: "+item.getQuality());
            for (int i = item.getSellIn();i>-11;i--){
                Action.updateQuality();
                System.out.println("Conjured Mana Cake: "+ item.getSellIn()+ " and quality is at: "+item.getQuality());
            }
            int check = item.getQuality();
            assertEquals(0, check);        
        }      
        @Test public void ed_testQualityStopAtZeroDoesNotGoNegativeOnAgedBrie(){
            Item item = new Item ("Conjured Mana Cake", 3, 6);
            GildedRose.getItems().add(item);
            System.out.println("Conjured Mana Cake (Before method): "+ item.getSellIn()+ " and quality is at: "+item.getQuality());
            for (int i = item.getSellIn();i>-11;i--){
                Action.updateQuality();
                System.out.println("Conjured Mana Cake: "+ item.getSellIn()+ " and quality is at: "+item.getQuality());
            }
            int check = item.getQuality();
            assertEquals(0, check);        
        }      
        @Test public void ec_testQualityStopAtZeroDoesNotGoNegativeOnnBackstagePasses(){
            Item item = new Item ("Backstage passes to a TAFKAL80ETC concert", 15, 20);
            GildedRose.getItems().add(item);
            System.out.println("Backstage passes to a TAFKAL80ETC concert (Before method): "+ item.getSellIn()+ " and quality is at: "+item.getQuality());
            for (int i = item.getSellIn();i>-11;i--){
                Action.updateQuality();
                System.out.println("Backstage passes to a TAFKAL80ETC concert: "+ item.getSellIn()+ " and quality is at: "+item.getQuality());
            }
            int check = item.getQuality();
            assertEquals(0, check);        
        }
//----------------------------------------------------------------------------//
//
//<< -- Test QUALITY does not change------------------------------------------>>
        @Test public void fa_testQualityStaysOnSulfurasHandOfRagnaros(){
            Item item = new Item ("Sulfuras, Hand of Ragnaros", 0, 80);
            GildedRose.getItems().add(item);
            System.out.println("Sulfuras, Hand of Ragnaros Quality is now (Before method): "+item.getQuality()+ " and sell is at: "+item.getSellIn());
            Action.updateQuality();
            int check = item.getQuality();
            System.out.println("Sulfuras, Hand of Ragnaros Quality is now: "+item.getQuality()+ " and sell is at: "+item.getSellIn());
            assertEquals(80, check);
            }
//----------------------------------------------------------------------------//
//
//<<  -- Absolute Rubbish----------------------------------------------------->>       
        static {/*
        public void testQualityValueDecressesOnAll throws InterruptedException 
        {    
            System.out.println("Start of QVDA");
            List<Item> itemsa = GildedRose.items;
            int itemSize = itemsa.size();
            
            for (int i = 0; i < itemSize; i++) {
                System.out.println("This test is for: " + itemsa.toString());
                Thread.sleep(4000);
//                for (Item source : GildedRose.items) 
//                {    
//                    int testcase = source.getQuality();
//                    System.out.println("The Current value is: " + testcase);
//                    GildedRose.updateQuality();
//                    assertEquals(testcase, source.getQuality());
//                }
            }
        
            System.out.println("Test Case " + "Get method here");
            System.out.println(items.get(i));
            String itemName = 
            GildedRose.items.add(i1);
            int check = i1.getQuality();
            System.out.println("testValueEND");
        }
                
        @Test
        public void testSellInValueNumberOfDaysLeftToSell() {
        
            Item i2 = new Item ("+5 Dexterity Vest", 10, 20);
            GildedRose.items.add(i2);
            GildedRose.updateQuality();
            int check = i2.getSellIn();
            assertEquals(9, check);
            System.out.println("testSellInEND");
        }
        @After
        public void end() {
            System.out.println("END OF LINE");
        }*/}
}