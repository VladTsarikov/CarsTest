package cars.pageObject.pages;

import framework.BaseForm;
import framework.Characteristic;
import framework.elements.Button;
import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

public class ResearchPage extends BaseForm {

    private static Button btnSearch = new Button(By.xpath("//input[@value='Search']"));
    private static ComboBox comboBox;
    private Label lblComparisons = new Label(By.xpath("//div[@id='ta-linkcards-container']//a[@data-linkname='compare-cars']"));
    private static String path = "//div[@class='hsw-%s']//select";
    private static int count = 1;

    public ResearchPage() {
        super(By.xpath("//h1[@class='cui-alpha'][contains(text(),'Make Smart Choices')]"));
    }

    static Map<String,String> values;

    private static void selectRandomValue() {

        values = new HashMap<>();

        for (Characteristic category : Characteristic.values()) {

            comboBox = new ComboBox(By.xpath(String.format(path, category.name().toLowerCase())));
            Select select = new Select(comboBox.getElement());
            List options = select.getOptions();
            int randomValue1 = (int) (count + Math.random() * (options.size()-count));
            select.selectByIndex(randomValue1);

            values.put(category.name().toLowerCase(),select.getFirstSelectedOption().getText());

        }
    }

        public static void getCar(){

            selectRandomValue();
            btnSearch.click();

    }

    public void clickComparisons(){

        lblComparisons.click();

    }

    public static Map<String, String> getValues() {
        return values;
    }

}
