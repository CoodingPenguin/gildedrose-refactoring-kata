package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality > 0) {
                    if (item.name != "Sulfuras, Hand of Ragnaros") {
                        item.decreaseQuality()
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.increaseQuality()

                    if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.increaseQuality()
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.increaseQuality()
                            }
                        }
                    }
                }
            }

            if (item.name != "Sulfuras, Hand of Ragnaros") {
                item.decreaseSellIn()
            }

            if (item.sellIn < 0) {
                if (item.name != "Aged Brie") {
                    if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.quality > 0) {
                            if (item.name != "Sulfuras, Hand of Ragnaros") {
                                item.decreaseQuality()
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality
                    }
                } else {
                    if (item.quality < 50) {
                        item.increaseQuality()
                    }
                }
            }
        }
    }

    private fun Item.decreaseQuality() {
        this.quality -= 1
    }

    private fun Item.increaseQuality() {
        this.quality += 1
    }

    private fun Item.decreaseSellIn() {
        this.sellIn -= 1
    }

}

