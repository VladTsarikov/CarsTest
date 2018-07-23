package framework.elements;

import framework.BaseEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertTrue;

public class BaseElement extends BaseEntity {

    private List<String> strings = new ArrayList<>();
    private By xpath;

    public BaseElement(By xpath) {
        this.xpath = xpath;
    }


    public WebElement getElement() {
        return driver.findElement(xpath);

    }

    public List<WebElement> getElements(){
        return driver.findElements(getLocator());
    }

    public  void clickAndWait(){
        click();
        WebDriverWait wait1 = new WebDriverWait(driver, Integer.parseInt(String.valueOf(wait)));
        wait1.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public List<String> getTextElements(){
        for(WebElement element: getElements()){
            String string = element.getText();
            strings.add(string);
        }
        return strings;
    }

    public By getLocator(){
        return xpath;
    }

    public void click(){
        assertTrue(isPresent());
        getElement().click();
    }

    public boolean isPresent() {
        return driver.findElement(this.xpath).isDisplayed();

    }

    public WebElement explicitWait(WebElement waitElement){
        WebDriverWait dynamicElement = (new WebDriverWait(driver, timeOut));
        return dynamicElement.until(ExpectedConditions.visibilityOf(waitElement));
    }

}
