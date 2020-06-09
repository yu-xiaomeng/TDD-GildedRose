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

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // quality, expectedQuality, sellIn, expectedSellIn
                { 12, 13, 15,14 }, { 50, 50, 15, 14 }, {12, 14, 8, 7}, {49, 50, 8, 7}, {12, 15, 3, 2}, {48, 50, 3, 2}, {12, 0, 0, -1}
        });
    }

    @Parameter
    public double quality;

    @Parameter(1)
    public double expectedQuality;

    @Parameter(2)
    public int sellIn;

    @Parameter(3)
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
