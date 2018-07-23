package cars.pageObject.pages;

import cars.entities.Car;
import cars.pageObject.forms.AddSecondCarForm;
import framework.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;


public class StartComparePage extends BaseForm {

    private static String enginePath = "//cars-compare-compare-info[contains(@header,'Engine')]//div[contains(@class,'info-column')]//span[@index = '%s']//p[1]";
    private static String transmissionPath = "//cars-compare-compare-info[contains(@header,'Transmission')]//div[contains(@class,'info-column')]//span[@index = '%s']//p[1]";
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
        anotherCarEngine = splitCatInformation(lblEngine);
        anotherCarTransmission = splitCatInformation(lblTransmission);
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

    private String splitCatInformation(Label label){

        String someCar;
        if(label.getElement().getText().endsWith(",")){
            someCar = label.getElement().getText().substring(0,label.getElement().getText().length()-count);
        }else {
            someCar = label.getElement().getText();
        }
        return someCar;
    }


}
