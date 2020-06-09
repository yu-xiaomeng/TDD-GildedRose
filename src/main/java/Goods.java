public class Goods {
    private String name;
    private double quality;
    private int sellIn;

    public Goods(String name, double quality, int sellIn) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
    }


    public double getQuality() {
        return quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void updateByDay() {
        if("Aged Brie".equals(name)){
            decreaseSellInByOne();
            if(sellIn <= 0){
                increaseQualityByOne();
            }
            if(quality < 50){
                increaseQualityByOne();
            }
        } else if ("Sulfuras".equals(name)) {

        } else {
            decreaseSellInByOne();
            decreaseQualityByOne();

            if(sellIn < 0){
                decreaseQualityByOne();
            }
        }

    }

    private void decreaseSellInByOne() {
        sellIn = sellIn - 1;
    }

    private void increaseQualityByOne() {
        quality = quality + 1;
    }

    private void decreaseQualityByOne() {
        if(quality > 0){
            quality = quality -1;
        }
    }
}

