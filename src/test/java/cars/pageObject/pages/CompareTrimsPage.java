package cars.pageObject.pages;

import cars.entities.Car;
import cars.pageObject.menu.NavigateBarMenu;
import framework.BaseForm;
import framework.RegExFinder;
import framework.elements.Button;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Map;

public class CompareTrimsPage extends BaseForm {

    private Button btnLogo = new Button(By.xpath("//img[@alt='Cars.com']"));
    private String engineRegEx = "<div class=\"cell cell-bg grow-2\">(.*)<\\/div>";
    private String transmitionRegEx = "<div class=\"cell grow-2\">(.*)<\\/div>";
    private Car car;
    private int index = 0;
    public NavigateBarMenu navigateBarMenu = new NavigateBarMenu();

    public CompareTrimsPage() {
        super(By.xpath("//h1[contains(text(),'Compare Trims')]"));
    }

    public Car initializeCar(Map<String, String> values){

        car = new Car();
        car.setNameValues(values, "makes");
        car.setNameValues(values, "models");
        car.setNameValues(values, "years");
        getCarInformation();
        return car;

    }

    private void getCarInformation(){

        car.setEngine(getCharacterValue(RegExFinder.findByRegularExp(engineRegEx)));
        car.setTransmission(getCharacterValue(RegExFinder.findByRegularExp(transmitionRegEx)));

    }

    private String getCharacterValue(List<String> value){
        return value.get(index);

    }

    public void returnToMainPage(){

        btnLogo.click();

    }

}
