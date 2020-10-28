package tests.practico11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class spotifyByPlaceHolderTest {
    private String SPOTIFY_REGISTRATION_URL = "https://www.spotify.com/uy/signup/";

    private WebDriver getDriver(String url){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System . setProperty ( "webdriver.chrome.driver" ,
                "D:\\Documentos\\2020\\Automation\\Drivers\\chromedriver.exe" );

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }
    @Test
    public void cssSelectorTest(){
        WebDriver driver = getDriver(SPOTIFY_REGISTRATION_URL);
        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("holamundo123");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("NombrePerfil");
        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("02");
        WebElement mes = driver.findElement(By.id("month"));
        Select comboboxMes = new Select(mes);
        comboboxMes.selectByValue("05");
        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1969");
        driver.findElement(By.xpath("//*[@id='__next']/main/div[2]/form/div[6]/div[2]/label[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Compartir mis datos de registro con los proveedores de contenido de Spotify para fines de marketing.')]")).click();
        driver.findElement(By.xpath("//*[@id='__next']/main/div[2]/form/div[9]/div/button")).click();

    }

}
