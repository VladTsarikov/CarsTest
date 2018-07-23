package cars.steps;

import cars.entities.Car;
import cars.pageObject.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.List;
import static cars.pageObject.menu.NavigateBarMenu.LabelName.RESEARCH;


public class CarsTest {

    private MainPage mainPage;
    private ResearchPage researchPage;
    private RandomCarPage randomCarPage;
    private CompareTrimsPage compareTrimsPage;
    private ComparePage comparePage;
    private StartComparePage startComparePage;
    private List<Car> cars = new ArrayList<>();
    static SoftAssert softAssert;
    private int firstIndex = 0;
    private int secondIndex = 1;
    private int iterationsCount = 3;

    @Given("open website cars")
    public void openWebSite() {
        mainPage = new MainPage();
        softAssert = new SoftAssert();
    }

    @When("we click tab Research")
    public void clickLabelResearch() {
        mainPage.navigateBarMenu.navigateMenu(RESEARCH);
    }

    @Then("we get ResearchPage")
    public void getResearchPage(){
        researchPage = new ResearchPage();
    }

    @When("we choose random car")
    public void chooseRandomCar() {
        ResearchPage.getCar();
    }

    @Then("we get RandomCarPage")
    public void getRandomCarPage(){
        randomCarPage = new RandomCarPage();
    }

    @When("we click compare trims button")
    public void clickCompareTripButton() {
        randomCarPage.clickCompareTrimButton(iterationsCount);
    }

    @Then("we go to CompareTrimsPage")
    public void getCompareTrimPagePage(){
        compareTrimsPage = new CompareTrimsPage();
    }

    @When("we initialize car")
    public void createNewCar() {
        cars.add(compareTrimsPage.initializeCar(ResearchPage.getValues()));
    }

    @Then("return to main page")
    public void clickLogoButton(){
        compareTrimsPage.returnToMainPage();
    }


    @Then("back to research page")
    public void clickResearchButton() {
        compareTrimsPage.navigateBarMenu.navigateMenu(RESEARCH);
    }

    @When("click side by side comparisons")
    public void clickComparisonsLabel() {
        researchPage.clickComparisons();
    }

    @Then("we go to ComparePage")
    public void getComparePage() {
        comparePage = new ComparePage();
    }

    @When("we choose first car")
    public void chooseFirstCar() {
        comparePage.clickStartComparing(cars.get(firstIndex));
    }

    @Then("we go to StartComparePage")
    public void getStartComparePage() {
        startComparePage = new StartComparePage();
    }

    @When("we click add second car")
    public void clickAddSecondCar() {
        startComparePage.clickAddSecondCar();
    }

    @And("choose second car")
    public void chooseSecondCar() {
        startComparePage.addSecondCarForm.chooseSecondCar(cars.get(secondIndex));
    }

    @Then("we get result of comparing")
    public void compareCars() {
        softAssert.assertTrue(startComparePage.getCatInformation(cars.get(firstIndex),firstIndex));
        softAssert.assertTrue(startComparePage.getCatInformation(cars.get(secondIndex),secondIndex));
    }

}
