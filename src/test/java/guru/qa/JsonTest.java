package guru.qa;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.model.IceCreamModel;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {

    String jsonFileName = "ice_cream.json";
    ClassLoader classLoader = JsonTest.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void readJsonTest() throws Exception {
        try (InputStream stream = classLoader.getResourceAsStream(jsonFileName);
             Reader reader = new InputStreamReader(stream)) {

            IceCreamModel iceCream = objectMapper.readValue(reader, IceCreamModel.class);

            assertThat(iceCream.getProductName()).isEqualTo("Pineapple coconut ice cream");
            assertThat(iceCream.getIngredients()).containsSequence("Cream", "Skim milk", "Cane sugar",
                    "Pineapple", "Egg yolks", "Natural flavor", "Rum", "Salt");
            assertThat(iceCream.getIngredients()).doesNotContain("Alcohol");
            assertThat(iceCream.getNutritionFacts().getCalories()).isEqualTo(290);
            assertThat(iceCream.getNutritionFacts().getCarbohydrate().getTotalCarbohydrate()).isEqualTo(32.0f);
            assertThat(iceCream.getNutritionFacts().getMinerals().getCalcium()).isEqualTo(120.0f);
        }
    }
}
