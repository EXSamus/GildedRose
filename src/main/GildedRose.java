package main;

class GildedRose {
    Item[] items;
    
    String[] specialItemName = {"Aged Brie",
    		"Backstage passes to a TAFKAL80ETC concert",
    		"Sulfuras, Hand of Ragnaros"};
    
    public GildedRose(Item[] items) {
        this.items = items;
    }
    
  //---------------------------
    /**
     *
     * Vérifie si l'item est un objet "Conjured"
     * 
     * @param	String	nom de l'item
     * @return	boolean	true si l'item est "Conjured" sinon false
     * 
     * */
    public boolean conjuredCheck(String item) {
		String[] s = item.split(" ");
		
		for(int i = 0; i<s.length; i++) {
			if(s[i].equals("Conjured")) {
				return true;
			}
		}
		return false;
    }
  //---------------------------
    /**
    *
    * Vérifie si l'item est un objet fait partie des objets spéciaux
    * 
    * @param	String	nom de l'item
    * @return	boolean	true si l'item est spécial sinon false
    * 
    * */
    public boolean specialItemCheck(Item item) {
    	for (int i = 0; i < specialItemName.length; i++) {
    		if(item.name.equals(specialItemName[i])) {
    			return true;
    		}
    	}
    	return false;
    }
  //---------------------------  
    /**
    *
    * Mets à jour la qualité d'un objet spécial
    * 
    * @param	Item	l'objet Item
    * 
    * */
    public void specialItemUpdate(Item item) {
    	if (item.quality < 50) {
            item.quality ++;
    	}
    	if(item.name.equals("Backstage passes to a TAFKAL80ETC concert" )) {
    		if (item.sellIn < 11) { // Si il ne reste que 10 jours
                if (item.quality < 50) {
                    item.quality ++;
                }
            }    
            if (item.sellIn < 6) { // Si il ne reste que 5 jours
                if (item.quality < 50) {
                    item.quality ++;
                }
            }
    	}
    }
  //---------------------------   
    /**
    *
    * Mets à jour la qualité d'un objet normal ou "Conjured"
    * 
    * @param	Item	l'objet Item
    * 
    * */
    public void normalItemUpdate(Item item) {
    	if(conjuredCheck(item.name)) {
    		item.quality = item.quality - 2;
    	} else if(item.quality>0){
    		item.quality --;
    	}   	
    }
  //---------------------------

    public void sellInUpdate(Item item) {
    	if(!item.name.equals("Sulfuras, Hand of Ragnaros") ) {
    		item.sellIn --;
    	} else {
    		item.sellIn = 0;
    	}
    }
    
//---------------------------
    
    public void afterSellInCheck(Item item) {
    	if (item.sellIn <= 0 && item.name.equals("Backstage passes to a TAFKAL80ETC concert" )){
    			item.quality = 0;
    		}	
    	
    }
  //---------------------------  
    
    public void updateQuality() {
    	// début de la boucle
    	// déplacement dans le tableau d'Item
        for (int i = 0; i < items.length; i++) {
            if (specialItemCheck(items[i])){
                
            	specialItemUpdate(items[i]);
            	  	
            } else {
            	normalItemUpdate(items[i]);
            }
            
            sellInUpdate(items[i]);
            
            afterSellInCheck(items[i]);
        }
     
    }
}