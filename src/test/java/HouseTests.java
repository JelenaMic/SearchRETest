import org.example.Helper;
import org.example.models.House;
import org.example.models.Plot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HouseTests {

    static WebDriver driver;
    static WebDriverWait wait;


    @Test
    public void positiveRegistrationTestHouse() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"Ieškau vieno kambario buto nuomai.", "Hello. I am looking for a one-room apartment for rent.", "ищу в аренду однокомнатную квартиру"}, new String[]{"/Users/denismichaliov/Documents/cat.jpg", "/Users/denismichaliov/Documents/Leksikk 3.jpg", "/Users/denismichaliov/Documents/Leks.jpeg"}, "https://www.youtube.com/watch?v=pkWCQAC_mwU", "www.tour3d.com", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHouseNumberWithDot() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "8.0", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHouseNumberWithLetter() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "45A", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHouseNumberWithLetterAndDash() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "45A-20", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHouseNumberWithDash() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "4-20", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseAddressNumberEmptyWhenTickBoxIsClicked() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[2]")).getText();
        Assert.assertEquals(actual, "Neteisingas numeris");
    }

    @Test
    public void negativeRegistrationTestHouseAddressNumberEmptyWhenTickBoxNotClicked() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "", true, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseAddressNumberWhenTickBoxNotClicked() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", true, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseUniqueItemNumberWithLetter() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "12341234123A", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[11]/span")));
        String actual = element.getText();
        System.out.println("Actual Text: " + actual);
        Assert.assertEquals(actual, "Neteisingas numerio formatas", actual);
    }

    @Test
    public void negativeRegistrationTestHouseUniqueItemNumberEmptyWhenTickBoxIsClicked() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[11]/span")).getText();
        Assert.assertEquals(actual, "Neteisingas numerio formatas");
    }

    @Test
    public void negativeRegistrationTestHouseUniqueItemNumberEmptyWhenTickBoxNotClicked() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "", true, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseUniqueItemNumberWhenTickBoxNotClicked() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", true, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHouseAreaOverAllWithDot() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100.9", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHouseAreaOverEmpty() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li:nth-child(13) > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Įveskite bendrą plotą");
    }

    @Test
    public void positiveRegistrationTestHouseHeightOneFloor() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "1", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHouseHeightTwoFloors() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "2", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseHeightEmpty() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li:nth-child(14) > span"))).getText();
        Assert.assertEquals(actual, "Įveskite aukštų sk.");
    }

    @Test
    public void negativeRegistrationTestHouseHeightLetters() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "ABC", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li:nth-child(14) > span"))).getText();
        Assert.assertEquals(actual, "Įveskite aukštų sk.");
    }

    @Test
    public void negativeRegistrationTestHouseHeightZero() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "0", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[14]/span"))).getText();
        Assert.assertEquals(actual, "Neteisingai įvesta reikšmė");
    }

    @Test
    public void negativeRegistrationTestHouseHeight10000() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "10000", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[14]/span")).getText();
        Assert.assertEquals(actual, "Neteisingai įvesta reikšmė");
    }

    @Test
    public void positiveRegistrationTestHouseAreaLotWithDot() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100.9", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseAreaLotEmptyWhenTickBoxNotClicked() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Įveskite sklypo plotą");
    }

    @Test
    public void positiveRegistrationTestHouseAreaLotEmptyWhenTickBoxIsClicked() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "", true, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHouseBuildYearAndRenovatedYear() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", true, "2020", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseBuildYearAndEmptyRenovatedYear() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", true, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div[2]/span[2]"))).getText();
        Assert.assertEquals(actual, "Klaida. Netinkami metai");
    }

    @Test
    public void negativeRegistrationTestHouseBuildYearEmpty() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div[1]/span[2]"))).getText();
        Assert.assertEquals(actual, "Įveskite statybos metus");
    }

    @Test
    public void negativeRegistrationTestHouseBuildYearZero() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "0", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div[1]/span[2]"))).getText();
        Assert.assertEquals(actual, "Klaida. Netinkami metai");
    }

    @Test
    public void negativeRegistrationTestHouseWarmSystemOneTick() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Kita"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseWarmSystemTickAll() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Skystu kuru", "Centrinis kolektorinis", "Geoterminis", "Aeroterminis", "Dujinis", "Kietu kuru", "Saulės energija", "Kita"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseWarmSystemTickNone() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{""});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[21]/label/span[2]"))).getText();
        Assert.assertEquals(actual, "Privalomas");
    }

    @Test
    public void positiveRegistrationTestHouseNoDescription() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseOnlySpecialCharactersDescription() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{",;:{}()[]&!?#%^*=~`|/<>|/", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[44]/label/span[2]")).getText(), "Netinkamas teksto formatas");
    }

    @Test
    public void negativeRegistrationTestHouseWrongYoutubeLink() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "www.youtube.com", "", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[48]/span[3]"))).getText();
        Assert.assertEquals(actual, "Blogas embed kodas");
    }

    @Test
    public void negativeRegistrationTestHouseWrong3DLink() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "www.tour3dcom", "500", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[49]/span[3]")).getText();
        Assert.assertEquals(actual, "Bloga nuoroda");
    }

    @Test
    public void positiveRegistrationTestHousePriceWithDot() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "199.99", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.id("priceField")).getAttribute("value");
        Assert.assertEquals(actual, "199.99");
    }

    @Test
    public void positiveRegistrationTestHousePriceWithComma() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "199,99", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.id("priceField")).getAttribute("value");
        Assert.assertEquals(actual, "199,99");
    }

    @Test
    public void negativeRegistrationTestHouseNoPrice() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[51]/span[3]")));
        String actual = element.getText();
        System.out.println("Actual Text: " + actual);
        Assert.assertEquals(actual, "Neteisinga kaina", actual);
    }

    @Test
    public void negativeRegistrationTestHousePriceZero() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "0", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[51]/span[3]")));
        String actual = element.getText();
        System.out.println("Actual Text: " + actual);
        Assert.assertEquals(actual, "Neteisinga kaina", actual);
    }

    @Test
    public void negativeRegistrationTestHouseToLowPrice() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[51]/span[3]")));
        String actual = element.getText();
        System.out.println("Actual Text: " + actual);
        Assert.assertEquals(actual, "Kaina per maža", actual);
    }

    @Test
    public void positiveRegistrationTestHouseWiredPhoneNumberFormatting() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37046123456", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHousePhoneNumberFormatting1() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "867889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHousePhoneNumberFormatting2() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "0037067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHousePhoneNumberFormatting3() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHousePhoneNumberFormatting4() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+370678 89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHousePhoneNumberFormatting5() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+370678-89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHousePhoneNumberFormatting6() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+370(678)89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHousePhoneNumberFormatting7() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+370-678-89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHousePhoneNumberFormatting8() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "8678 89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHouseNumberWithLetterFormatting() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+370A67889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseNoPhoneNumber() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")));
        String actual = element.getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void negativeRegistrationTestHouseTooShortPhoneNumber() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "678", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void negativeRegistrationTestHouseTooLongPhoneNumber() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "6788990012345", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void positiveRegistrationTestHouseEmailMinLength() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", "A@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHouseEmailMaxLength() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(64) + "@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String text = driver.findElement(By.name("email")).getAttribute("value");
        System.out.println(text.length());
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseNoEmail() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", "", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")));
        String actual = element.getText();
        Assert.assertEquals(actual, "Nurodykite el. pašto adresą, kad vėliau galėtumėte redaguoti arba pašalinti skelbimą");
    }

    @Test
    public void negativeRegistrationTestHouseEmailNoDot() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", "kodėlAruodas@mailcom", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Neteisingas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestHouseEmailNoAt() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", "kodėlAruodasmail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Blogas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestHouseEmailNoSecondLevelDomain() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", "kodėlAruodas@.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Neteisingas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestHouseEmailNoCom() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", "kodėlAruodas@mail", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Neteisingas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestHouseEmailOnlySpecCharacters() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", ",;:{}()[]&!?#%^*=~`|/<>|/@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Blogas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestHouseEmailNoUsername() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", "@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Neteisingas el. pašto adresas");
    }

    @Test
    public void positiveRegistrationTestHouseCheckBoxesTickAgreeToRulesOnly() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "@mail.com", new boolean[]{false, false, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHouseCheckBoxesTickAgreeToRulesAndFirstTick() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "@mail.com", new boolean[]{true, false, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestHouseCheckBoxesTickAgreeToRulesAndSecondTick() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "@mail.com", new boolean[]{false, true, true}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestHouseCheckBoxesTickFirstAndSecond() {
        House h = new House("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "500", "+37067889900", generateRndStr(10) + "@mail.com", new boolean[]{true, true, false}, "75", false, "123412341234", false, "100", "4", "100", false, "2000", false, "", "Namas (gyvenamasis)", "Blokinis", "Neįrengtas", new String[]{"Centrinis", "Elektra", "Dujinis"});
        h.fill();
        String actual = driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(56) > span.error-arrow")).getText();
        Assert.assertEquals(actual, "Prašome sutikti su portalo taisyklėmis");
    }

    @BeforeClass
    public void beforeClass() {
        Helper.setUp();
        driver = Helper.driver;
        wait = Helper.wait;
    }

    public static String generateRndStr(int length) {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz12345678901234567890";
        String text = "";
        for (int i = 0; i < length; i++) {
            text += symbols.charAt((int) (Math.random() * symbols.length()));
        }
        return text;
    }

    public void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    @BeforeMethod
    public void getWebsite() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=2");


    }


    @AfterClass
    public void afterClass() {
//        driver.quit();
    }


}
