package framework;

import framework.elements.BaseElement;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class BaseForm extends BaseEntity{

    private BaseElement baseElement;
    private By locator;

    protected BaseForm(By locator) {

        this.locator = locator;
        assertTrue(isOpen());

    }

    private Boolean isOpen(){

        baseElement = new BaseElement(locator);
        return baseElement.isPresent();

    }

}
