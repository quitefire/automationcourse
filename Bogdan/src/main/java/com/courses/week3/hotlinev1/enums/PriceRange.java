package com.courses.week3.hotlinev1.enums;

public enum PriceRange {
    $2500_3500(1, 2500, 3500),
    $3500_5000(2, 3500, 5000);

    private final int index;
    private final int minPrice;
    private final int maxPrice;

    PriceRange(int index, int minPrice, int maxPrice) {
        this.index = index;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public int getIndex() {
        return index;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }
}