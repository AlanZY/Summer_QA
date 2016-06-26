
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.google.common.collect.Iterables;

@SuppressWarnings("unused")
public class RubyBDDTest {

	static WebDriver driver = new HtmlUnitDriver();

	// Start at the home page for RubyBBD for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com/");

	}

	//-------------------------- story 1st -------------------------
	// As a developer
	// I want tokenization which can go through can seperate my code
	// So that I can do further processing towards that.
	//--------------------------------------------------------------

	// Given that I am on the main page, and write a line of code,
	// that is "a = 1 + 2"
	// When I click Tokenize
	// Then I should see "on_sp" in the new page.
	@Test
	public void testSpace()
	{
		// type code
		driver.findElement(By.id("code_code")).sendKeys("a = 1 + 2");

		// click button "Tokenize"
		try{
			    WebElement token = driver.findElement(By.xpath("//form/p[2]/input[1]"));
          token.click();
          WebElement result = driver.findElement(By.xpath("//body/p[1]/code[1]"));
          assertTrue(result.getText().contains("on_sp"));
		}catch(NoSuchElementException nseex){
			    fail();
		}

	}

	// Given that I am on the main page, and write one line of code,
	// that is "puts 'test puts'"
	// When I click Tokenize
	// Then I should see "on_ident" in the new page.
	@Test
	public void testPuts()
	{
		// type code
		driver.findElement(By.id("code_code")).sendKeys("puts 'test puts'");

		// click button "Tokenize"
		try{
	   		  WebElement token = driver.findElement(By.xpath("//form/p[2]/input[1]"));
	        token.click();
	        WebElement result = driver.findElement(By.xpath("//body/p[1]/code[1]"));
	        assertTrue(result.getText().contains("on_ident"));
	    }catch(NoSuchElementException nseex){
			    fail();
		}
	}


	// Given that I am on the main page, and write code,
	// that is "a = 1 + 3\nb = 3"
	// When I click Tokenize
	// Then I should see "on_nl" in the new page.
	@Test
	public void testEnter()
	{
		// type code
		//driver.findElement(By.id("code_code")).sendKeys("a = 1 + 3 \r\n b = 3");
		driver.findElement(By.id("code_code")).sendKeys("a = 1 + 3\nb = 3" );

		// click button "Tokenize"
		try{
			    WebElement token = driver.findElement(By.xpath("//form/p[2]/input[1]"));
	        token.click();
	        WebElement result = driver.findElement(By.xpath("//body/p[1]/code[1]"));
	        assertTrue(result.getText().contains("on_nl"));
	    }catch(NoSuchElementException nseex){
			    fail();
		}
	}



	//----------------------- story 2nd ------------------------
	// As a developer
	// I want parse which puts tokens into an abstract syntax tree
	// So that I can understand the structure of the code
	//-----------------------------------------------------------

	// Given that I am on the main page, and write code,
	// that is "a = 1 + 3 - 2\nputs a"
	// When I click Parse
	// Then I should see "+", "-" or "puts" in the new page.
	@Test
	public void testNonWhitespace()
	{
		// type code
		driver.findElement(By.id("code_code")).sendKeys("a = 1 + 3 - 2\nputs a");

		// click button "Parse"
		try{
			    WebElement parse = driver.findElement(By.xpath("//form/p[2]/input[2]"));
	        parse.click();
	        WebElement result = driver.findElement(By.xpath("//body/p[1]/code[1]"));
	        assertTrue(result.getText().contains("+") && result.getText().contains("-")&& result.getText().contains("puts"));
	    }catch(NoSuchElementException nseex){
			    fail();
		}
	}

	// Given that I am on the main page, and write code,
	// that is "a = 1 + 3\nputs a"
	// When I click Parse
	// Then I can not see "\" \"" or "on_sp"in the new page.
	@Test
	public void testWhitespace()
	{
		// type code
		driver.findElement(By.id("code_code")).sendKeys("a = 1 + 3\nputs a");

		// click button "Parse"
		try{
			  WebElement parse = driver.findElement(By.xpath("//form/p[2]/input[2]"));
		    parse.click();
		    WebElement result = driver.findElement(By.xpath("//body/p[1]/code[1]"));
		    assertFalse(result.getText().contains("\" \"") || result.getText().contains("on_sp") );
		}catch(NoSuchElementException nseex){
			  fail();
		}
	}


	//---------------------------------- story 3rd -------------------------
	// As a developer
	// I want compiler which writes machine-level instructions
	// So that machine can understand my code and do what I want.
	//----------------------------------------------------------------------

	// Given that I am on the main page, and write code,
	// that is "type = \"Noogie Cat\"\nputs \"The is a: \" + type"
	// When I click Compile
	// Then I can see "putstring" in the new page.
	@Test
	public void testString()
	{
		// type code
		driver.findElement(By.id("code_code")).sendKeys("type = \"Noogie Cat\"\nputs \"The is a: \" + type");

		// click button "Compile"
		try{
			  WebElement compile = driver.findElement(By.xpath("//form/p[2]/input[3]"));
		    compile.click();
		    WebElement result = driver.findElement(By.xpath("//body/p[1]/code[1]"));
		    assertTrue(result.getText().contains("putstring"));
		}catch(NoSuchElementException nseex){
			  fail();
		}
	}

	// Given that I am on the main page, and write code,
	// that is "a = 1 + 3"
	// When I click Compile
	// Then I can see "opt_plus" in the new page.
	@Test
	public void testPlus()
	{
		// type code
		driver.findElement(By.id("code_code")).sendKeys("a = 1 + 3");

		// click button "Compile"
		try{
			  WebElement compile = driver.findElement(By.xpath("//form/p[2]/input[3]"));
		    compile.click();
		    WebElement result = driver.findElement(By.xpath("//body/p[1]/code[1]"));
		    assertFalse(!result.getText().contains("opt_plus"));
		}catch(NoSuchElementException nseex){
			  fail();
		}
	}

	// Given that I am on the main page, and write code,
	// that is "a = 45-12"
	// When I click Compile
	// Then I can see "opt_minus" in the new page.
	@Test
	public void testMinus()
	{
		// type code
		driver.findElement(By.id("code_code")).sendKeys("a = 45-12");

		// click button "Compile"
		try{
			  WebElement compile = driver.findElement(By.xpath("//form/p[2]/input[3]"));
		    compile.click();
		    WebElement result = driver.findElement(By.xpath("//body/p[1]/code[1]"));
		    assertFalse(!result.getText().contains("opt_minus"));
		}catch(NoSuchElementException nseex){
			  fail();
		}
  }

	// Given that I am on the main page, and write code,
	// that is "a = 45/12"
	// When I click Compile
	// Then I can see "opt_div" in the new page.
	@Test
	public void testDiv()
	{
		// type code
		driver.findElement(By.id("code_code")).sendKeys("a = 45/12");

		// click button "Compile"
		try{
			  WebElement compile = driver.findElement(By.xpath("//form/p[2]/input[3]"));
		    compile.click();
		    WebElement result = driver.findElement(By.xpath("//body/p[1]/code[1]"));
		    assertFalse(!result.getText().contains("opt_div"));
		}catch(NoSuchElementException nseex){
			  fail();
		}
  }

	// Given that I am on the main page, and write code,
	// that is "a = 3*5"
	// When I click Compile
	// Then I can see "opt_mult" in the new page.
	@Test
	public void testMult()
	{
		// type code
		driver.findElement(By.id("code_code")).sendKeys("a = 3*5");

		// click button "Compile"
		try{
			  WebElement compile = driver.findElement(By.xpath("//form/p[2]/input[3]"));
		    compile.click();
		    WebElement result = driver.findElement(By.xpath("//body/p[1]/code[1]"));
		    assertTrue(result.getText().contains("opt_mult"));
		}catch(NoSuchElementException nseex){
			  fail();
		}
  }


	// Given that I am on the main page, and write code,
	// that is "a = 3*5+2"
	// When I click Compile
	// Then I can see "putobject" in the new page.
	@Test
	public void testObject()
	{
		// type code
		driver.findElement(By.id("code_code")).sendKeys("a = 3*5+2");

		// click button "Compile"
		try{
			  WebElement compile = driver.findElement(By.xpath("//form/p[2]/input[3]"));
		    compile.click();
		    WebElement result = driver.findElement(By.xpath("//body/p[1]/code[1]"));
		    assertTrue(result.getText().contains("putobject"));
		}catch(NoSuchElementException nseex){
			  fail();
		}
  }



}
