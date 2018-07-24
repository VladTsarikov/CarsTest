package cars.pageObject.pages;

import cars.entities.Car;
import cars.pageObject.forms.AddSecondCarForm;
import framework.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class StartComparePage extends BaseForm {

    private static String enginePath = "//cars-compare-compare-info[contains(@header,'Engine')]//div[contains(@class,'info-column')]//span[@index = '%s']//p";
    private static String transmissionPath = "//cars-compare-compare-info[contains(@header,'Transmission')]//div[contains(@class,'info-column')]//span[@index = '%s']//p";
    private static String textName = "//cars-compare-compare-info[contains(@format,'research-car-mmyt')]//span[@index = '%s']";
    private Label lblName;
    private Label lblEngine;
    private Label lblTransmission;
    private static Label lblAddSecondCar = new Label( By.xpath("//div[@id='icon-div']"));
    public AddSecondCarForm addSecondCarForm = new AddSecondCarForm();
    private Boolean bool;
    private int count = 1;
    private String compareCarName;
    private String compareCarEngine;
    private String compareCarTransm;
    private String anotherCarName;
    private String anotherCarEngine;
    private String anotherCarTransmission;



    public StartComparePage() {
        super(By.xpath("//h1[contains(text(),'Compare Cars Side-by-Side')]"));
    }

    public static Label getLblAddSecondCar() {
        return lblAddSecondCar;
    }

    public void clickAddSecondCar(){

        lblAddSecondCar.click();

    }

    public Boolean getCatInformation(Car compareCar, int i){

        initializeLabel(i);
        readCarInformation(compareCar);
        anotherCarName = lblName.getElement().getText();
        anotherCarEngine = checkInf(lblEngine,compareCarEngine);
        anotherCarTransmission = checkInf(lblTransmission,compareCarTransm);
        return compareCars();

    }

    private void initializeLabel(int i){
        lblName = new Label(By.xpath(String.format(textName, i)));
        lblEngine = new Label(By.xpath(String.format(enginePath, i)));
        lblTransmission = new Label(By.xpath(String.format(transmissionPath, i)));
    }

    private Boolean compareCars(){

        if(compareCarName.equals(anotherCarName) && compareCarEngine.equals(anotherCarEngine) && compareCarTransm.equals(anotherCarTransmission)){
            bool = Boolean.TRUE;
        }else{
            bool = Boolean.FALSE;
        }
        return bool;
    }

    private void readCarInformation(Car compareCar){
        compareCarName  = new StringBuilder().append(compareCar.getYear()).append(" "+compareCar.getMake()).append(" "+ compareCar.getModel()).toString();
        compareCarEngine = compareCar.getEngine();
        compareCarTransm = compareCar.getTransmission();
    }

    private String splitCatInformation(String str){

        String someCar;
        if(str.endsWith(",")){
            someCar = str.substring(0,str.length()-count);
        }else {
            someCar = str;
        }
        return someCar;
    }














    public String checkInf(Label label,String comp){
        List<WebElement> lab = label.getElements();
        String a = null;
        for(WebElement element: lab){
            if(splitCatInformation(element.getText()).equals(comp)){
                a = element.getText();
            }
        }
        return a;
    }


}
