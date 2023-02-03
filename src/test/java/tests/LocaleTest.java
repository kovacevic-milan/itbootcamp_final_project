package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest{

    @Test
    public void spanishTest(){
        localePage.changeLanguageToSpanish();
        String actualResultESP = localePage.isLanguageChangedToSpanish();
        System.out.println(actualResultESP);
        String expectedResultESP = "Página de aterrizaje";
        Assert.assertEquals(actualResultESP, expectedResultESP);
    }

    @Test
    public void englishTest(){
        localePage.changeLanguageToEnglish();
        String actualResultENG = localePage.isLanguageChangedToEnglish();
        System.out.println(actualResultENG);
        String expectedResultENG = "Landing";
        Assert.assertEquals(actualResultENG, expectedResultENG);
    }
    @Test
    public void frenchTest(){
        localePage.changeLanguageToFrench();
        String actualResultFR = localePage.isLanguageChangedToFrench();
        System.out.println(actualResultFR);
        String expectedResultENG = "Page d'atterrissage";
        Assert.assertEquals(actualResultFR, expectedResultENG);
    }

}
