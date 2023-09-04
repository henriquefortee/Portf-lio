import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {  //Inicia classe

	@Test //Indica para o sistema que se trata de um teste
	public void testeTextField() { //Inicia método
		WebDriver driver = new ChromeDriver();  //Chama o webdriver e abre Chrome  
		driver.manage().window().setSize(new Dimension(100, 600)); //Define tamanho da janela
		driver.get("file:///" + System.getProperty("user.dir") //Busca html no computador
			+ "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")) //Encontra o elemento "formulário nome"
			.sendKeys("Texto"); //Escreve o texto no formulário
		Assert.assertEquals("Texto",driver.
				findElement(By.id("elementosForm:nome"))
				.getAttribute("value") ); //Busca o valor inserido no campo e compara com o texto que está buscando

		driver.quit(); //Fecha o driver
		
	}
	
	@Test //Indica para o sistema que se trata de um teste
	 public void deveInteragirComTextArea() { //Inicia método
		WebDriver driver = new ChromeDriver(); //Chama o webdriver e abre Chrome 
		driver.manage().window().setSize(new Dimension(100, 600)); //Define tamanho da janela
		driver.get("file:///" + System.getProperty("user.dir") //Busca html no computador
			+ "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")) //Encontra o elemento "formulário sugestões"
		.sendKeys("Texto"); //Escreve o texto no formulário
		Assert.assertEquals("Texto",driver
			 .findElement(By.id("elementosForm:sugestoes"))
			 .getAttribute("value") ); //Busca o valor inserido no campo e compara com o texto que está buscando
		
		driver.quit(); //Fecha o driver
	}
	
	@Test //Indica para o sistema que se trata de um teste
	 public void deveInteragirComRadioButton() { //Inicia método
		WebDriver driver = new ChromeDriver(); //Chama o webdriver e abre Chrome 
		driver.manage().window().setSize(new Dimension(100, 600)); //Define tamanho da janela
		driver.get("file:///" + System.getProperty("user.dir") //Busca html no computador
			+ "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")) //Encontra o elemento radio "sexo"
		.click(); //clica no elemento
		
		assertTrue(driver.findElement(By.id("elementosForm:sexo:0"))
				.isSelected()); //busca novamente o elemento e confere se ele foi selecionado
		driver.quit(); //Fecha o driver
		
	}
	
	@Test //Indica para o sistema que se trata de um teste
	 public void deveInteragirComCheckBox() { //Inicia método
		WebDriver driver = new ChromeDriver(); //Chama o webdriver e abre Chrome 
		driver.manage().window().setSize(new Dimension(100, 600)); //Define tamanho da janela
		driver.get("file:///" + System.getProperty("user.dir") //Busca html no computador
			+ "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2"))//Encontra o elemento checkbox
		.click(); //clica no elemento
		
		assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2"))
				.isSelected()); //busca novamente o elemento e confere se ele foi selecionado
		driver.quit(); //Fecha o driver
		
	}
	
	@Test //Indica para o sistema que se trata de um teste
	 public void deveInteragirComCombo() { //Inicia método
		WebDriver driver = new ChromeDriver(); //Chama o webdriver e abre Chrome 
		driver.manage().window().setSize(new Dimension(100, 600)); //Define tamanho da janela
		driver.get("file:///" + System.getProperty("user.dir") //Busca html no computador
			+ "/src/main/resources/componentes.html");
		
		//Encontra um elemento HTML e coloca em um objeto webElement chamado "element"
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade")); 
		
		/*Cria objeto Select chamado "combo" que permite interagir com um elemento HTML 
		do tipo <select> que recebe a variável "element"*/
		Select combo = new Select(element);  
	
//		combo.selectByIndex(3); //Seleciona valor por index
//		combo.selectByValue("superior"); //Seleciona valor por "value"
		combo.selectByVisibleText("2o grau completo"); // Seleciona valor por texto
		assertEquals("2o grau completo",combo
				.getFirstSelectedOption()
				.getText()); //Busca a opção selecionada confere com o texto desejado
		driver.quit(); //Fecha o driver
		
	}
	
	@Test //Indica para o sistema que se trata de um teste
	 public void deveVerificarValoresCombo() { //Inicia método
		WebDriver driver = new ChromeDriver(); //Chama o webdriver e abre Chrome
		driver.manage().window().setSize(new Dimension(100, 600)); //Define tamanho da janela
		driver.get("file:///" + System.getProperty("user.dir") //Busca html no computador
			+ "/src/main/resources/componentes.html");
		
		//Encontra um elemento HTML e coloca em um objeto webElement chamado "element"
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		
		/*Cria objeto Select chamado "combo" que permite interagir com um elemento HTML 
		do tipo <select> que recebe a variável "element"*/
		Select combo = new Select(element);
		
		/*O resultado do método combo.getOptions() (a lista de elementos <option>) 
		é armazenado na variável options. Esta variável é declarada como uma lista 
		de objetos WebElement, ou seja, é uma lista que contém os elementos HTML 
		representados por objetos WebElement.*/
		List<WebElement> options = combo.getOptions();
		
		//verifica se o número de opções no menu suspenso é igual a 8
		Assert.assertEquals(8, options.size()); 
		
		boolean encontrou = false;
		
		/*cria loop "for-each" que percorre cada item da List<WebElement> options 
		armazenando cada um deles individualmente em "option" para realizar operações em seguida*/
		for(WebElement option: options) { 
			if(option.getText().equals("Mestrado")) { // Verifica se o texto do elemento atual é igual a "Mestrado"
				encontrou = true; // Se encontrou a opção "Mestrado", define 'encontrou' como 'true'
				break; //Sai do loop assim que a condição é atendida
			}
		}
		assertTrue(encontrou); //verifica se "encontrou" é verdadeiro
		driver.quit(); //Fecha o driver
		
	}

}
