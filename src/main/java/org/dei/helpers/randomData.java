package org.dei.helpers;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Locale;

public class randomData {
    static Faker faker = new Faker(new Locale("ID"));

    public static String getFirstName() {
        return faker.name().firstName();
    }
    public static String getLastName() {
        return faker.name().lastName();
    }
    public static String getPostalCode() {
        return faker.address().zipCode();
    }

    public static boolean isPriceSorted(List<WebElement> itemPrices) {
        for (int i = 0; i < itemPrices.size() - 1; i++) {
            double value1 = extractNumericValue(itemPrices.get(i));
            double value2 = extractNumericValue(itemPrices.get(i + 1));

            if (value1 < value2) {
                return false;
            }
        }
        return true;
    }

    private static double extractNumericValue(WebElement element) {
        String priceText = element.getText().replace("$", "");
        return Double.parseDouble(priceText);
    }
}