package cars.pageObject.forms;

import cars.entities.Car;
import framework.Characteristic;
import framework.elements.Button;
import framework.elements.ComboBox;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.List;


public class AddSecondCarForm {

    private String path = "//select[@id='%s-dropdown']";
    private ComboBox comboBox;
    private Button btnAddCar = new Button( By.xpath("//button[@class='modal-button']"));
    private int iterator = 0;
    private int firsIndex = 0;
    private int count = 1;

    public void chooseSecondCar(Car car){

        for(Characteristic category: Characteristic.values()){
            String name = category.name().toLowerCase();
            comboBox = new ComboBox(By.xpath((String.format(path,name.substring(firsIndex,name.length()-count)))));
            Select select = new Select(comboBox.getElement());
            List<String> values = car.getValues();
            select.selectByVisibleText(values.get(iterator));
            iterator++;

        }

        btnAddCar.click();

        }
    }



