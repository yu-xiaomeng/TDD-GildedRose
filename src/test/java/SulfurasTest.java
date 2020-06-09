import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SulfurasTest {
    @Test
    public void should_quality_and_sellIn_remain_the_same_when_update_given_sellIn_and_quality_between_0_50() {
        // Given
        double quality = 20;
        int sellIn = 10;
        Goods goods = new Goods("Sulfuras", quality, sellIn);

        // When
        goods.updateByDay();

        // Then
        double updatedQuality = goods.getQuality();
        int updatedSellIn = goods.getSellIn();
        assertThat(updatedQuality).isEqualTo(quality);
        assertThat(updatedSellIn).isEqualTo(sellIn);
    }

}
