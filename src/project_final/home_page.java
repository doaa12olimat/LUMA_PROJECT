package project_final;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class home_page extends parameters {
	Random rand = new Random();
	int RandomNumber = rand.nextInt(1000) % 100;

	// ********************this test one for SINGUP with valid
	// password****************************************
	@Test(priority = 1, groups = { "creatacount" })
	public void t_1Signuptestvalidpassword() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

		System.out.println("****this test for SINGUP with valid password*****");
		Thread.sleep(3000);
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.xpath("//header//li[3]//a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("doaa");
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("olimat");
		driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("doaaolimataa982@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("AAbb12_3");
		driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys("AAbb12_3");

		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();

		// assertion that the Test case is passed.
		Thread.sleep(9000);
		// String actualURL =
		// "https://magento.softwaretestingboard.com/customer/account/";
		// String expectedURL = driver.getCurrentUrl();
		String actual = "Thank you for registering with Main Website Store.";
		String expected = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
		System.out.println(expected);
		Thread.sleep(9000);
		myAssertion.assertEquals(actual, expected);
		myAssertion.assertAll();
	}

	// ********************this test Tow for
	// search_bar****************************************
	@Test(priority = 2, invocationCount = 2, groups = { "searchbar" })
	public void t_2searchbar() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(3000);
		System.out.println("****this test for search_bar*****");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		int RandomNumberSearchBar = rand.nextInt(500) % 5;
		String[] SearchBar = { "Jacket", "t-shirt", "jeans for men", "jeans for women", "pants" };
		driver.findElement(By.xpath("//a[@aria-label='store logo']//img")).click();

		WebElement search_box = driver.findElement(By.xpath("//input[@id='search']"));
		search_box.sendKeys(SearchBar[RandomNumberSearchBar] + Keys.ENTER);

		String search_tex = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText();
		System.out.println(search_tex);
		driver.navigate().back();
		Thread.sleep(5000);

	}

	// ********************this test Tow for
	// addeItem****************************************
	@Test(priority = 3, groups = { "addeitem" })
	public void t_3ADDITEM() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		Random rand = new Random();

		System.out.println("****this test for Add Item*****");
		// add Item
		Thread.sleep(3000);
		String[] numberItems = { "3", "2", "4", "1", "5" };// list for number of E items add
		for (int i = 0; i < 5; i++) {
			WebElement DivContaintListProdect = driver.findElement(By.xpath("//div[@class='products-grid grid']"));
			List<WebElement> mydivIteam = DivContaintListProdect.findElements(By.tagName("img"));// list for 5 items

			mydivIteam.get(i).click();
			Thread.sleep(3000);

			// ADD fusion backpack 5 items
			if (i == 5) {
				Thread.sleep(3000);

				System.out.println(driver.findElement(By.xpath("//span[@class='base']")).getText());// print name items
				driver.findElement(By.xpath("//input[@title='Qty']")).clear();
				driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("5");// number items add
				driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();
				Thread.sleep(3000);
				driver.navigate().back();

			} else {

				int RandomNumbersize = rand.nextInt(500) % 5;// choose SIZE
				int RandomNumbercolor = rand.nextInt(500) % 3;// choose COLOR

				System.out.println(driver.findElement(By.xpath("//span[@class='base']")).getText());// print name items
				driver.findElement(By.xpath("//input[@title='Qty']")).clear();
				driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys(numberItems[i]);// number items add from
																								// list
				Thread.sleep(3000);
				WebElement DivContaintSize = driver
						.findElement(By.xpath("//div[@attribute-code='size']//div[@role='listbox']"));

				List<WebElement> mydivSize = DivContaintSize.findElements(By.tagName("div"));// list for size
				mydivSize.get(RandomNumbersize).click();
				WebElement DivContaintColor = driver
						.findElement(By.xpath("//div[@attribute-code='color']//div[@role='listbox']"));

				List<WebElement> mydivColor = DivContaintColor.findElements(By.tagName("div"));// list for color
				if (i == 2) {
					// choose argus all weather tank color
					mydivColor.get(0).click();
				} else {

					mydivColor.get(RandomNumbercolor).click();
					Thread.sleep(3000);
				}
				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
				Thread.sleep(9000);
				driver.navigate().back();

			}
			Thread.sleep(9000);
		} // end forloop

	}
	// ********************this test four for
	// CHECKOUT PAGE****************************************

	// this test for CHECKOUT PAGE
	@Test(priority = 4, groups = { "checkoutpagenew" })
	public void t_4CHECKOUTPAGEnew() throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

		System.out.println("****this test for CHECKOUT PAGE*****");
		Thread.sleep(9000);
		// CHECKOUT PAGE
		WebElement heard = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]"));

		heard.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).click();
		Thread.sleep(9000);
		driver.findElement(By.tagName("form"));
		WebElement forme = driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]"));
		List<WebElement> mydivIteams = forme.findElements(By.tagName("input"));

		String[] listinformation = { "doaa", "olimat", "qa", "st omar", "", "", "Amman", "18", "13110", "0928273368",
				"JO" };// list for get my information
		Thread.sleep(9000);
		mydivIteams.get(0).clear();
		mydivIteams.get(0).sendKeys(listinformation[0]);// first name
		mydivIteams.get(1).clear();
		mydivIteams.get(1).sendKeys(listinformation[1]);// last name
		mydivIteams.get(2).sendKeys(listinformation[2]);// company

		mydivIteams.get(3).sendKeys(listinformation[3]);// Street Address
		mydivIteams.get(6).sendKeys(listinformation[6]);// City

		driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[5]/div"));

		List<WebElement> mydivselect = forme.findElements(By.tagName("select"));

		WebElement drop = mydivselect.get(0);
		Select select = new Select(drop);

		select.selectByValue(listinformation[7]);// State/Province

		mydivIteams.get(8).sendKeys(listinformation[8]);// Zip/Postal Code

		driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[8]/div"));

		List<WebElement> mydivselect2 = forme.findElements(By.tagName("select"));

		Thread.sleep(9000);
		WebElement drop2 = mydivselect2.get(1);
		Select select2 = new Select(drop2);
		select2.selectByValue("JO");

		mydivIteams.get(9).sendKeys(listinformation[9]);
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]"));
		driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span")).click();// click
																												// next
		Thread.sleep(9000);

	}

	// ********************this test five for
	// placeorder****************************************

	@Test(priority = 5, groups = { "placeorder" })
	public void t_5placeorder() throws InterruptedException {
		System.out.println("****this test for Place order*****");
		Thread.sleep(9000);
		driver.findElement(
				By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();// click
																														// place
																														// order
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a/strong")).click();// click number
																											// order
		Thread.sleep(9000);

		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[2]/div[2]")); // find price every item
		WebElement table1 = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]"));
		Thread.sleep(9000);
//expected price
		List<WebElement> mydivstable = table1.findElements(By.tagName("tbody"));
		int price = 0;
		for (int i = 0; i < mydivstable.size(); i++) {
			Thread.sleep(9000);
			WebElement tdd = mydivstable.get(i);
			String RadiantTeeprice = tdd.findElement(By.className("subtotal")).getText();// name items
			String Actual1 = RadiantTeeprice.replaceAll("\\$", "");// replace $ to convert to decimal
			BigDecimal number = new BigDecimal(Actual1);
			int intprice = number.intValue(); // convert to int
			price = price + intprice;
			System.out.println("RadiantTeeprice     =   " + number);
			Thread.sleep(9000);
		}

		System.out.println("expected total price=   " + price);

		// actual price
		String actualtotal1 = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tfoot/tr[1]/td/span"))
				.getText();

		String numberstring = actualtotal1.replaceAll("\\$", "");
		BigDecimal number11 = new BigDecimal(numberstring);
		int actual = number11.intValue();
		System.out.println("actual price=      " + actual);
		myAssertion.assertEquals(actual, price, "this test for price");
		myAssertion.assertAll();

		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click();
		Thread.sleep(5000);

	}

	// ********************this test six for
	// Reordersignin****************************************

	@Test(priority = 6, groups = { "reordersignin" })
	public void t_6CHECKOUTPAGE() throws InterruptedException {
		System.out.println("****this test for ReOrder sign in*****");
		Thread.sleep(5000);
		Random rand = new Random();
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("doaaolimataa982@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("AAbb12_3");
		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div"));
		driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]"));
		driver.findElement(By.xpath("//a[normalize-space()='My Orders']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr/td[6]/a[1]/span")).click();
		Thread.sleep(9000);

		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/div[2]/div/a[1]/span")).click();
			Thread.sleep(9000);
			driver.navigate().back();

		}

	}
	// ********************this test seven for
	// reordersignin price****************************************

	@Test(priority = 7, groups = { "reordersignin price" })
	public void t_7PriceREorder() throws InterruptedException {
		System.out.println("****this test for price reorder*****");

		Thread.sleep(9000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a/span[2]/span[1]")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a/span")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[1]"));

		WebElement table2 = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]"));
		Thread.sleep(9000);

		List<WebElement> mydivstable = table2.findElements(By.tagName("tbody"));
//expected price
		int price = 0;
		for (int i = 0; i < mydivstable.size(); i++) {
			Thread.sleep(9000);
			WebElement tdd = mydivstable.get(i);
			String RadiantTeeprice = tdd.findElement(By.className("subtotal")).getText();// name items
			String Actual1 = RadiantTeeprice.replaceAll("\\$", "");// replace $ to convert to decimal
			BigDecimal number = new BigDecimal(Actual1);
			int intprice = number.intValue(); // convert to int
			price = price + intprice;
			System.out.println("RadiantTeeprice     =   " + number);
			Thread.sleep(9000);
		}

		System.out.println("expected total price=   " + price);// print expected total price

		// actual price
		String actualtotal1 = driver.findElement(By.xpath("//*[@id=\"cart-totals\"]/div/table/tbody/tr[1]/td/span"))
				.getText();

		String numberstring = actualtotal1.replaceAll("\\$", "");
		String Actual16 = numberstring.replaceAll("\\,", "");
		BigDecimal number11 = new BigDecimal(Actual16);
		int actual = number11.intValue();
		Thread.sleep(9000);
		System.out.println("actual total price =    " + actual);
		Thread.sleep(9000);
		myAssertion.assertEquals(actual, price);

		myAssertion.assertAll();

	}

}
