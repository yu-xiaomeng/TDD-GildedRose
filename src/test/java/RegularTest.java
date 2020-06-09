import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegularTest {

    @Test
    public void should_quality_and_sellIn_decrease_by_1_when_update_given_sellIn_greater_than_0_and_quality_between_0_and_50() {
        // Given
        double quality = 10;
        int sellIn = 20;
        Goods goods = new Goods("regular", quality, sellIn);

        // When
        goods.updateByDay();

        // Then
        double updatedQuality = goods.getQuality();
        int updatedSellIn = goods.getSellIn();
        assertThat(updatedQuality).isEqualTo(quality - 1);
        assertThat(updatedSellIn).isEqualTo(sellIn - 1);
    }

    @Test
    public void should_quality_remain_0_and_sellIn_decrease_by_1_when_update_given_sellIn_greater_than_0_and_quality_is_0() {
        // Given
        double quality = 0;
        int sellIn = 20;
        Goods goods = new Goods("regular", quality, sellIn);

        // When
        goods.updateByDay();

        // Then
        double updatedQuality = goods.getQuality();
        int updatedSellIn = goods.getSellIn();
        assertThat(updatedQuality).isEqualTo(0);
        assertThat(updatedSellIn).isEqualTo(sellIn - 1);
    }

    @Test
    public void should_quality_decrease_by_2_and_sellIn_decrease_by_1_when_update_given_sellIn_is_0_quality_between_0_and_50() {
        // Given
        double quality = 8;
        int sellIn = 0;
        Goods goods = new Goods("regular", quality, sellIn);

        // When
        goods.updateByDay();

        // Then
        double updatedQuality = goods.getQuality();
        int updatedSellIn = goods.getSellIn();
        assertThat(updatedQuality).isEqualTo(quality - 2);
        assertThat(updatedSellIn).isEqualTo(sellIn - 1);
    }

    @Test
    public void should_quality_is_0_and_sellIn_decrease_by_1_when_update_given_sellIn_is_0_quality_is_1() {
        //Given
        double quality = 1;
        int sellIn = 0;
        Goods goods = new Goods("regular", quality, sellIn);

        // When
        goods.updateByDay();

        // Then
        double updatedQuality = goods.getQuality();
        int updatedSellIn = goods.getSellIn();
        assertThat(updatedQuality).isEqualTo(0);
        assertThat(updatedSellIn).isEqualTo(sellIn - 1);
    }

}

