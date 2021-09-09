import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

	
	//Teste de abertura do navegador Google
	@Test
	public void teste() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().setPosition(new Point(100,100)); Google alinhado a esquerda
		//driver.manage().window().setSize(new Dimension(1200, 765)); Google nas posições
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
		driver.close();              //Fecha a janela aberta atualmente
		//driver.quit();               //Mata o processo
	}

}
