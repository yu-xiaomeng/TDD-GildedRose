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
            updateAgedBrieByDay();
        } else if ("Sulfuras".equals(name)) {

        } else if("Backstage Pass".equals(name)) {
            updateBackstagePassByDay();
        } else {
            updateRegularByDay();
        }

    }
    private void updateBackstagePassByDay() {
        decreaseSellInByOne();
        increaseQualityByOne();
        if(sellIn <= 10) {
            increaseQualityByOne();
        }
        if (sellIn <= 5) {
            increaseQualityByOne();
        }
        if (sellIn < 0){
            quality = 0;
        }

    }

    private void updateRegularByDay() {
        decreaseSellInByOne();
        decreaseQualityByOne();

        if(sellIn < 0){
            decreaseQualityByOne();
        }
    }

    private void updateAgedBrieByDay() {
        decreaseSellInByOne();
        if(sellIn <= 0){
            increaseQualityByOne();
        }
        if(quality < 50){
            increaseQualityByOne();
        }
    }

    private void decreaseSellInByOne() {
        sellIn = sellIn - 1;
    }

    private void increaseQualityByOne() {
        if(quality < 50){
            quality = quality + 1;
        }

    }

    private void decreaseQualityByOne() {
        if(quality > 0){
            quality = quality -1;
        }
    }
}

