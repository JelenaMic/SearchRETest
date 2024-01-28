import org.example.Helper;
import org.example.models.House;
import org.example.models.Plot;
import org.example.models.SearchRE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PlotTests {
    static WebDriver driver;
    static WebDriverWait wait;

    @Test
    public void positiveRegistrationTestPlot() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"Ieškau vieno kambario buto nuomai.", "Hello. I am looking for a one-room apartment for rent.", "ищу в аренду однокомнатную квартиру"}, new String[]{"/Users/denismichaliov/Documents/cat.jpg", "/Users/denismichaliov/Documents/Leksikk 3.jpg", "/Users/denismichaliov/Documents/Leks.jpeg"}, "https://www.youtube.com/watch?v=pkWCQAC_mwU", "www.tour3d.com", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotNumberWithDot() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "8.0", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotNumberWithLetter() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "45A", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotNumberWithLetterAndDash() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "45A-20", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotNumberWithDash() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "4-20", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestPlotAddressNumberEmptyWhenTickBoxIsClicked() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[2]")).getText();
        Assert.assertEquals(actual, "Neteisingas numeris");
    }

    @Test
    public void negativeRegistrationTestPlotAddressNumberEmptyWhenTickBoxNotClicked() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "", true, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestPlotAddressNumberWhenTickBoxNotClicked() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", true, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestPlotUniqueItemNumberWithLetter() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "12341234123A", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[11]/span"));
        String actual = errorElement.getText();
        System.out.println("Actual Error Message: " + actual);
        Assert.assertEquals("Neteisingas numerio formatas", actual);
    }

    @Test
    public void negativeRegistrationTestPlotUniqueItemNumberEmptyWhenTickBoxIsClicked() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[11]/span")).getText();
        Assert.assertEquals(actual, "Neteisingas numerio formatas");
    }

    @Test
    public void negativeRegistrationTestPlotUniqueItemNumberEmptyWhenTickBoxNotClicked() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "", true, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestPlotUniqueItemNumberWhenTickBoxNotClicked() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", true, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotAreaOverAllWithDot() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100.9", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotAreaOverEmpty() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "", new String[]{"Namų valda", "Daugiabučių statyba", "Komercinė"});
        p.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Įveskite bendrą plotą");
    }

    @Test
    public void positiveRegistrationTestPlotPurposesClickAll() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Žemės ūkio", "Sklypas soduose", "Miškų ūkio", "Pramonės", "Sandėliavimo", "Komercinė", "Rekreacinė", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTest2PlotPurposesClickOne() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotPurposesClickNone() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"", "", ""});
        p.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/label/span[2]")));
        String actual = element.getText();
        System.out.println("Actual Text: " + actual);
        Assert.assertEquals(actual, "Pasirinkite paskirtį", actual);
    }

    @Test
    public void positiveRegistrationTestPlotNoDescription() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestPlotOnlySpecialCharactersDescription() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{",;:{}()[]&!?#%^*=~`|/<>|/", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[26]/label/span[2]")).getText(), "Netinkamas teksto formatas");
    }

    @Test
    public void negativeRegistrationTestPlotWrongYoutubeLink() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "www.youtube.com", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[30]/span[3]"))).getText();
        Assert.assertEquals(actual, "Blogas embed kodas");
    }

    @Test
    public void negativeRegistrationTestPlotWrong3DLink() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "www.tour3dcom", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[31]/span[3]")).getText();
        Assert.assertEquals(actual, "Bloga nuoroda");
    }

    @Test
    public void positiveRegistrationTestPlotPriceWithDot() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "199.99", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.id("priceField")).getAttribute("value");
        Assert.assertEquals(actual, "199.99");
    }

    @Test
    public void positiveRegistrationTestPLotPriceWithComma() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "199,99", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.id("priceField")).getAttribute("value");
        Assert.assertEquals(actual, "199,99");
    }

    @Test
    public void negativeRegistrationTestPlotNoPrice() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.field-interval-row.required-form-field.input-style-text-unit-with-priceperfield.has-error > span.error-arrow")));
        String actual = element.getText();
        System.out.println("Actual Text: " + actual);
        Assert.assertEquals(actual, "Neteisinga kaina", actual);
    }

    @Test
    public void negativeRegistrationTestPlotPriceZero() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "0", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.field-interval-row.required-form-field.input-style-text-unit-with-priceperfield.has-error > span.error-arrow")));
        String actual = element.getText();
        System.out.println("Actual Text: " + actual);
        Assert.assertEquals(actual, "Neteisinga kaina", actual);
    }

    @Test
    public void negativeRegistrationTestPlotToLowPrice() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "1", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.field-interval-row.required-form-field.input-style-text-unit-with-priceperfield.has-error > span.error-arrow")));
        String actual = element.getText();
        System.out.println("Actual Text: " + actual);
        Assert.assertEquals(actual, "Kaina per maža", actual);
    }

    @Test
    public void positiveRegistrationTestPlotWiredPhoneNumberFormatting() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37046123456", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotPhoneNumberFormatting1() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "867889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotPhoneNumberFormatting2() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "0037067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotPhoneNumberFormatting3() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotPhoneNumberFormatting4() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+370678 89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotPhoneNumberFormatting5() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+370678-89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotPhoneNumberFormatting6() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+370(678)89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotPhoneNumberFormatting7() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+370-678-89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotPhoneNumberFormatting8() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "8678 89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotPhoneNumberWithLetterFormatting() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+370A67889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestPlotNoPhoneNumber() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")));
        String actual = element.getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void negativeRegistrationTestPlotTooShortPhoneNumber() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "678", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void negativeRegistrationTestPlotTooLongPhoneNumber() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "6788990012345", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void positiveRegistrationTestPlotEmailMinLength() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "A@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotEmailMaxLength() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(64) + "@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String text = driver.findElement(By.name("email")).getAttribute("value");
        System.out.println(text.length());
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestPlotNoEmail() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")));
        String actual = element.getText();
        Assert.assertEquals(actual, "Nurodykite el. pašto adresą, kad vėliau galėtumėte redaguoti arba pašalinti skelbimą");
    }

    @Test
    public void negativeRegistrationTestPlotEmailNoDot() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "kodėlAruodas@mailcom", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Neteisingas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestPlotEmailNoAt() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "kodėlAruodasmail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[35]/span[2]"))).getText();
        Assert.assertEquals(actual, "El.pašto adresas nebus rodomas viešai.");
    }

    @Test
    public void negativeRegistrationTestPlotEmailNoSecondLevelDomain() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "kodėlAruodas@.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Neteisingas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestPlotEmailNoCom() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "kodėlAruodas@mail", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Neteisingas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestPlotEmailOnlySpecCharacters() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", ",;:{}()[]&!?#%^*=~`|/<>|/@mail.@mail", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Blogas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestPlotEmailNoUsername() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "@mail.com", new boolean[]{true, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Neteisingas el. pašto adresas");
    }

    @Test
    public void positiveRegistrationTestPlotCheckBoxesTickAgreeToRulesOnly() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "@mail.com", new boolean[]{false, false, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotCheckBoxesTickAgreeToRulesAndFirstTick() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "@mail.com", new boolean[]{true, false, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPlotCheckBoxesTickAgreeToRulesAndSecondTick() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "@mail.com", new boolean[]{false, true, true}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestPlotCheckBoxesTickFirstAndSecond() {
        Plot p = new Plot("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "@mail.com", new boolean[]{true, true, false}, "75", false, "123412341234", false, "100", new String[]{"Namų valda", "Daugiabučių statyba", "Kita"});
        p.fill();
        String actual = driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(38) > span.error-arrow")).getText();
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
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");


    }


    @AfterClass
    public void afterClass() {
//        driver.quit();
    }


}
