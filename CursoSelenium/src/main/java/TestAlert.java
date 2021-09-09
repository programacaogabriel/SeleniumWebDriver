import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {

	@Test
	// Elementos básicos: Alert Simple
	public void deveInteragirComAlertSimple() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", alert.getText());
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		driver.quit();
	}

	@Test
	// Elementos básicos: Confirm ok
	public void deveInteragirComAlertConfimOk() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("confirm")).click();
		Alert confirm = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", confirm.getText());
		confirm.accept();
		Assert.assertEquals("Confirmado", confirm.getText());
		confirm.accept();
		driver.close();

	}

	@Test
	// Elementos básicos: Confirm Cancelar
	public void deveInteragirComAlertConfimCancelar() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("confirm")).click();
		Alert confirm = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", confirm.getText());
		confirm.dismiss();
		Assert.assertEquals("Negado", confirm.getText());
		confirm.accept();
		driver.close();
	}
		@Test
		// Elementos básicos: Prompt
		public void deveInteragirComPrompt() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
			driver.findElement(By.id("promt")).click();
			Alert prompt = driver.switchTo().alert();
			Assert.assertEquals("Digite um numero", prompt.getText());
			prompt.sendKeys("1");
			prompt.accept();
			Assert.assertEquals("12", prompt.getText());
			prompt.accept();
			Assert.assertEquals(":D", prompt.getText());
			driver.close();
		
			
		
		
		
	}
}