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
        sellIn = sellIn - 1;
        decreaseQuality();

        if(sellIn < 0){
            decreaseQuality();
        }
    }

    private void decreaseQuality() {
        if(quality > 0){
            quality = quality -1;
        }
    }
}

