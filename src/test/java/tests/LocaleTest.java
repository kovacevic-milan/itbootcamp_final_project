package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AuthRoutesPage;
import pages.LocalePage;

public class LocaleTest extends BaseTest {

    private LocalePage localePage;;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        localePage = new LocalePage(driver, driverWait);
    }

    @Test
    public void spanishTest() {
        localePage.changeLanguageToSpanish();
        String actualResultESP = localePage.isLanguageChangedToSpanish();
        System.out.println(actualResultESP);
        String expectedResultESP = "Página de aterrizaje";
        Assert.assertEquals(actualResultESP, expectedResultESP);
    }

    @Test
    public void englishTest() {
        localePage.changeLanguageToEnglish();
        String actualResultENG = localePage.isLanguageChangedToEnglish();
        System.out.println(actualResultENG);
        String expectedResultENG = "Landing";
        Assert.assertEquals(actualResultENG, expectedResultENG);
    }

    @Test
    public void frenchTest() {
        localePage.changeLanguageToFrench();
        String actualResultFR = localePage.isLanguageChangedToFrench();
        System.out.println(actualResultFR);
        String expectedResultENG = "Page d'atterrissage";
        Assert.assertEquals(actualResultFR, expectedResultENG);
    }

}
