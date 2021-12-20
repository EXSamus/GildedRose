package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GildedRoseTest {
	@Test
    void test1() {
		Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),//
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),//
                
                new Item("Conjured +5 Dexterity Leather Armor", 4, 35), 
                new Item("Conjured Mana Cake", 3, 6),
				new Item("Mana Cake", 3, 6),
				new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20)};
		
		Item[] items1 = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),//
                new Item("Conjured Mana Cake", 3, 6),
				new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
       
        GildedRose app = new GildedRose(items);
        
        GildedRose test2 = new GildedRose(items1);
       
        
        //ConjuredCheck 	test
        
        assertEquals(false, app.conjuredCheck(app.items[0].name), "test rat�" );
        assertEquals(false, app.conjuredCheck(app.items[5].name), "test rat�" );
        assertEquals(true, app.conjuredCheck(app.items[7].name), "test rat�" );
        assertEquals(false, app.conjuredCheck(app.items[8].name), "test rat�" );
        
        //specialItemCheck	test
        
        assertEquals(false, app.specialItemCheck(app.items[0]), "test rat�" );
        assertEquals(true, app.specialItemCheck(app.items[1]), "test rat�" );
        assertEquals(true, app.specialItemCheck(app.items[5]), "test rat�" );
        assertEquals(false, app.specialItemCheck(app.items[6]), "test rat�" );
        
        //specialItemUpdate	test
        
        test2.specialItemUpdate(test2.items[1]);
        test2.specialItemUpdate(test2.items[2]);
        
        assertEquals(1, test2.items[1].quality, "test rat�" );
        assertEquals(21, test2.items[2].quality, "test rat�" );
        
         
        //normalItemUpdate 	test
        
        test2.normalItemUpdate(test2.items[0]);
        test2.normalItemUpdate(test2.items[3]);
        
        assertEquals(19, test2.items[0].quality, "test rat�" );
        assertEquals(4, test2.items[3].quality, "test rat�" );
        
        //sellInUpdate 		test
        
        test2.sellInUpdate(test2.items[0]);
        test2.sellInUpdate(test2.items[1]);
        test2.sellInUpdate(test2.items[2]);
        test2.sellInUpdate(test2.items[3]);
        
        assertEquals(9, test2.items[0].sellIn, "test rat�" );
        assertEquals(1, test2.items[1].sellIn, "test rat�" );
        assertEquals(14, test2.items[2].sellIn, "test rat�" );
        assertEquals(2, test2.items[3].sellIn, "test rat�" );
        
        //afterSellInCheck	test
        
        test2.afterSellInCheck(test2.items[4]);
        assertEquals(0, test2.items[4].sellIn, "test rat�" );
        
        //updateQuality		test
        
        app.updateQuality();
        assertEquals(19, app.items[0].quality, "test qualit� rat� : objet 0");
        assertEquals(1, app.items[1].quality, "test qualit� rat� : objet 1" );
        assertEquals(21, app.items[5].quality, "test qualit� rat� : objet 5" );
        assertEquals(33, app.items[6].quality, "test qualit� rat� : objet 6" );
        assertEquals(4, app.items[7].quality, "test qualit� rat� : objet 7" );
        assertEquals(0, app.items[9].quality, "test qualit� rat� : objet 9" );
        
        
    }
}
