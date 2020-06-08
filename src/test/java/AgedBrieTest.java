import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AgedBrieTest {
    @Test
    public void should_quality_increase_by_1_sellIn_decrease_by_1_when_update_given_sellIn_greater_than_0_and_quality_between_0_and_50() {
        // Given
        double quality = 10;
        int sellIn = 20;
        Goods goods = new Goods("Aged Brie", quality, sellIn);

        // When
        goods.updateByDay();

        // Then
        double updatedQuality = goods.getQuality();
        int updatedSellIn = goods.getSellIn();
        assertThat(updatedQuality).isEqualTo(quality + 1);
        assertThat(updatedSellIn).isEqualTo(sellIn - 1);
    }

    @Test
    public void should_quality_remain_50_sellIn_decrease_by_1_when_update_given_sellIn_greater_than_0_and_quality_is_50() {
        // Given
        double quality = 50;
        int sellIn = 20;
        Goods goods = new Goods("Aged Brie", quality, sellIn);

        // When
        goods.updateByDay();

        // Then
        double updatedQuality = goods.getQuality();
        int updatedSellIn = goods.getSellIn();
        assertThat(updatedQuality).isEqualTo(50);
        assertThat(updatedSellIn).isEqualTo(sellIn - 1);
    }

    @Test
    public void should_quality_increase_by_2_sellIn_decrease_by_1_when_update_given_sellIn_is_0_and_quality_less_than_49() {
        // Given
        double quality = 46;
        int sellIn = 0;
        Goods goods = new Goods("Aged Brie", quality, sellIn);

        // When
        goods.updateByDay();

        // Then
        double updatedQuality = goods.getQuality();
        int updatedSellIn = goods.getSellIn();
        assertThat(updatedQuality).isEqualTo(quality + 2);
        assertThat(updatedSellIn).isEqualTo(sellIn - 1);
    }

    @Test
    public void should_quality_is_50_sellIn_decrease_by_1_when_update_given_sellIn_is_0_and_quality_is_49() {
        // Given
        double quality = 49;
        int sellIn = 0;
        Goods goods = new Goods("Aged Brie", quality, sellIn);

        // When
        goods.updateByDay();

        // Then
        double updatedQuality = goods.getQuality();
        int updatedSellIn = goods.getSellIn();
        assertThat(updatedQuality).isEqualTo(50);
        assertThat(updatedSellIn).isEqualTo(sellIn - 1);
    }
}
