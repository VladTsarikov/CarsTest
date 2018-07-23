package cars.pageObject.pages;

import cars.pageObject.menu.NavigateBarMenu;
import framework.BaseForm;
import framework.elements.Button;
import org.openqa.selenium.By;
import java.util.NoSuchElementException;
import static cars.pageObject.menu.NavigateBarMenu.LabelName.RESEARCH;

public class RandomCarPage extends BaseForm {

    private Button btnCompareTrim = new Button(By.xpath("//a[@name='&lid=trim-compare']"));
    private NavigateBarMenu navigateBarMenu = new NavigateBarMenu();
    private int minValue = 0;

    public RandomCarPage() {
        super(By.xpath("//div[@class='mmy-hero__buttons']//a[contains(text(),'View Local Inventory')]"));
    }

    public void clickCompareTrimButton(int iteration) {

        for(int i = iteration; i>=minValue ; i--){
            if(i!=minValue) {
                    try {
                        btnCompareTrim.click();
                    }catch(Throwable e){
                        System.out.println("CompareTrim button has not found");
                        navigateBarMenu.navigateMenu(RESEARCH);
                        ResearchPage.getCar();
                        clickCompareTrimButton(iteration--);
                    }
                break;
            }else{
                    throw new NoSuchElementException();

            }
        }
    }

}
