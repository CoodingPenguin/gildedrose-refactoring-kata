package com.gildedrose


class GildedRose(var items: List<Item>) {

    companion object {
        const val AGED_BRIE = "Aged Brie"
        const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
        const val SULFURAS = "Sulfuras, Hand of Ragnaros"
    }

    fun updateQuality() {
        items.forEach { item ->
            if (item.name != AGED_BRIE && item.name != BACKSTAGE) {
                if (item.quality > 0) {
                    if (item.name != SULFURAS) {
                        item.decreaseQuality()
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.increaseQuality()

                    if (item.name == BACKSTAGE) {
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

            if (item.name != SULFURAS) {
                item.decreaseSellIn()
            }

            if (item.sellIn < 0) {
                if (item.name != AGED_BRIE) {
                    if (item.name != BACKSTAGE) {
                        if (item.quality > 0) {
                            if (item.name != SULFURAS) {
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

