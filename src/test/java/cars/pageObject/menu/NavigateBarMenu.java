package cars.pageObject.menu;

import framework.elements.Label;
import org.openqa.selenium.By;

public class NavigateBarMenu {

    private static String menuLabel = "//header/nav/ul/li[a[contains(text(), '%s')]]";
    private  Label lblMenu;
    private String path;

    public enum LabelName {

        RESEARCH("Research"), CARS_FOR_SALE("Cars for Sale"), SELL_YOUR_CAR("Sell Your Car");

        private String category;

        LabelName(String category) {
            this.category = category;
        }

    }
    public void navigateMenu(LabelName labelName) {

        path = String.format(menuLabel, labelName.category);
        lblMenu = new Label(By.xpath(path));
        lblMenu.click();

    }
}
