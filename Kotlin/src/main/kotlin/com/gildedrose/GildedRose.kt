package com.gildedrose


class GildedRose(var items: List<Item>) {

    companion object {
        const val AGED_BRIE = "Aged Brie"
        const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
        const val SULFURAS = "Sulfuras, Hand of Ragnaros"
    }

    fun updateQuality() {
        items.forEach { item ->
            when (item.name) {
                AGED_BRIE -> {
                    if (item.quality < 50) {
                        item.increaseQuality(1)

                    }
                    item.decreaseSellIn()
                }

                BACKSTAGE -> {
                    if (item.quality < 50) {
                        if (item.sellIn < 11) {
                            item.increaseQuality(2)
                        }

                        if (item.sellIn < 6 && item.quality < 50) {
                            item.increaseQuality(3)
                        }
                    }
                    item.decreaseSellIn()

                }

                SULFURAS -> {

                }

                else -> {
                    if (item.quality > 0) {
                        item.decreaseQuality(1)
                    }
                    item.decreaseSellIn()

                }
            }

            if (item.sellIn < 0) {
                if (item.name != AGED_BRIE) {
                    if (item.name != BACKSTAGE) {
                        if (item.quality > 0 && item.name != SULFURAS) {
                            item.decreaseQuality(1)
                        }
                    } else {
                        item.quality = 0
                    }
                } else if (item.quality < 50) {
                    item.increaseQuality(1)
                }
            }
        }
    }

    private fun Item.decreaseQuality(qualityAmount: Int) {
        this.quality -= qualityAmount
    }

    private fun Item.increaseQuality(qualityAmount: Int) {
        this.quality += qualityAmount
    }

    private fun Item.decreaseSellIn() {
        this.sellIn -= 1
    }

}

