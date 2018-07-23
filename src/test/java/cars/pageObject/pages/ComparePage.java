package cars.pageObject.pages;

import cars.entities.Car;
import framework.BaseForm;
import framework.Characteristic;
import framework.elements.Button;
import framework.elements.ComboBox;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class ComparePage extends BaseForm {

    private Button btnStartComparing = new Button(By.xpath("//button[@class='done-button']"));
    private ComboBox comboBox;
    private String path = "//select[@id='%s-dropdown']";
    private int iterator = 0;
    private int firsIndex = 0;
    private int count = 1;

    public ComparePage() {
        super(By.xpath("//h2[@class='cui-alpha compare-sub-head-h1']"));
    }


    public void clickStartComparing(Car car){

        for(Characteristic category: Characteristic.values()){

            String name  = category.name().toLowerCase();
            comboBox = new ComboBox(By.xpath(String.format(path,name.substring(firsIndex,name.length()-count))));
            Select select = new Select(comboBox.getElement());
            List<String> values = car.getValues();
            select.selectByVisibleText(values.get(iterator));
            iterator++;

        }

        btnStartComparing.click();
        comboBox.explicitWait(StartComparePage.getLblAddSecondCar().getElement());


    }
}
