import java.util.List;

import org.apache.bcel.generic.Select;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class TesteCampoTreinamento {

	@SuppressWarnings("deprecation")
	@Test
	// Elementos básicos: Campo de treinamento
	public void testeDeAberturaDoSite() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		// System.getproperty pega o caminho.
		// O projeto esta dentro da pasta resources
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Texto");
		Assert.assertEquals("Texto", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.close();
	}

	@Test
	// Elementos básicos: TextField e TextArea
	public void deveInteragirComTextArea() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Afirmação Positiva\nTexto Completo");
		Assert.assertEquals("Afirmação Positiva",
				driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("Afirmação Positiva"));
		driver.close();
	}

	@Test
	// Elementos básicos: Radio e Check
	public void deveInteragirComRadioButton() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.close();
	}

	@Test
	// Elementos básicos: Radio e Check
	public void deveInteragirComCheckBox() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.close();
	}

	@Test
	// Elementos básicos: Combo
	public void deveInteragirComCombo() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		org.openqa.selenium.support.ui.Select combo = new org.openqa.selenium.support.ui.Select(element);
		// combo.selectByIndex(2);
		combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		driver.close();
	}

	@Test
	// Elementos básicos: Combo - Verificando os valores disponiveis
	public void deveVerificarValoresCombo() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		org.openqa.selenium.support.ui.Select combo = new org.openqa.selenium.support.ui.Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		boolean encontrou = false;
		for (WebElement option : options) {
			if (option.getText().equals("Doutorado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
	}

	@Test
	// Elementos básicos: Combo de multipla escolha
	public void deveVerificaMultiplasEscolhasCombo() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		org.openqa.selenium.support.ui.Select combo = new org.openqa.selenium.support.ui.Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("Karate");
		List<WebElement> allselectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allselectedOptions.size());

		combo.deselectByVisibleText("Corrida"); // Retirando arquivos da marcação
		allselectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allselectedOptions.size());

		driver.close();
	}

	@Test
	// Elementos básicos: Botoes
	public void deveInteragirComBotoes() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado",botao.getAttribute("value"));
		driver.close();
	}
	
	@Test
	@Ignore
	// Elementos básicos: Link
	public void deveInteragirComLinks() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fire\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); // Dimensao do Layout
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.linkText("Voltar")).click();
		//Assert.fail();
	}
}
