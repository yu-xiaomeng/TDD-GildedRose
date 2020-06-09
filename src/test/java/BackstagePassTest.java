import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class BackstagePassTest {

    @Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // testName, quality, expectedQuality, sellIn, expectedSellIn
                {"should_quality_increase_by_1_sellIn_decrease_by_1_when_update_given_sellIn_greater_than_10_and_quality_between_0_and_50", 12, 13, 15, 14 },
                {"should_quality_remain_50_sellIn_decrease_by_1_when_update_given_sellIn_greater_than_10_and_quality_is_50", 50, 50, 15, 14 },
                {"should_quality_increase_by_2_sellIn_decrease_by_1_when_update_given_sellIn_between_5_10_and_quality_between_0_and_50", 12, 14, 8, 7},
                {"should_quality_is_50_sellIn_decrease_by_1_when_update_given_sellIn_between_5_10_and_quality_is_49", 49, 50, 8, 7},
                {"should_quality_increase_by_3_sellIn_decrease_by_1_when_update_given_sellIn_between_0_5_and_quality_between_0_and_50", 12, 15, 3, 2},
                {"should_quality_is_50_sellIn_decrease_by_1_when_update_given_sellIn_between_0_5_and_quality_is_48",48, 50, 3, 2},
                {"should_quality_is_0_sellIn_decrease_by_1_when_update_given_sellIn_is_0_and_quality_between_0_and_50", 12, 0, 0, -1}
        });
    }
    @Parameter(0)
    public String testName;

    @Parameter(1)
    public double quality;

    @Parameter(2)
    public double expectedQuality;

    @Parameter(3)
    public int sellIn;

    @Parameter(4)
    public int expectedSellIn;

    @Test
    public void test() {
        // Given
        Goods goods = new Goods("Backstage Pass", quality, sellIn);

        // When
        goods.updateByDay();

        // Then
        double updatedQuality = goods.getQuality();
        int updatedSellIn = goods.getSellIn();
        assertThat(updatedQuality).isEqualTo(expectedQuality);
        assertThat(updatedSellIn).isEqualTo(expectedSellIn);
    }
}
