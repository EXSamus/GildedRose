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
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                
                new Item("Conjured +5 Dexterity Leather Armor", 4, 35), 
                new Item("Conjured Mana Cake", 3, 6),
				new Item("Mana Cake", 3, 6),
				new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20)};
		
				
       
        GildedRose app = new GildedRose(items);
        
        assertEquals(false, app.conjuredCheck(app.items[0].name), "test raté" );
        assertEquals(false, app.conjuredCheck(app.items[5].name), "test raté" );
        assertEquals(true, app.conjuredCheck(app.items[7].name), "test raté" );
        assertEquals(false, app.conjuredCheck(app.items[8].name), "test raté" );
        
        app.updateQuality();
        assertEquals(19, app.items[0].quality, "test qualité raté : objet 0");
        assertEquals(1, app.items[1].quality, "test qualité raté : objet 1" );
        assertEquals(21, app.items[5].quality, "test qualité raté : objet 5" );
        assertEquals(33, app.items[6].quality, "test qualité raté : objet 6" );
        assertEquals(4, app.items[7].quality, "test qualité raté : objet 7" );
        assertEquals(0, app.items[9].quality, "test qualité raté : objet 9" );
        
        
    }
}
