package cars.pageObject.pages;

import cars.pageObject.menu.NavigateBarMenu;
import framework.BaseForm;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

    public  NavigateBarMenu navigateBarMenu = new NavigateBarMenu();

    public MainPage() {
        super(By.xpath("//h1[contains(text(),'Find your')]"));
    }



}


