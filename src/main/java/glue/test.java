package glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

private ChromeDriver driver;

    @Given("un usuario que se encuentra en la pagina de inicio")
    public void un_usuario_que_se_encuentra_en_la_pagina_de_inicio() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Esteban Ruiz Novoa\\OneDrive\\Documentos\\SELENIUM_2\\src\\main\\java\\resource\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        driver.manage().window().maximize();

        String usuario = "standard_user";
        String contrasena = "secret_sauce";

        WebElement usuarioEntrada = driver.findElement(By.id("user-name"));
        WebElement contrasenaEntrada = driver.findElement(By.id("password"));

        WebElement btnIngresar = driver.findElement(By.xpath("//input[@id='login-button']"));

        usuarioEntrada.sendKeys(usuario);
        contrasenaEntrada.sendKeys(contrasena);
        btnIngresar.click();

        WebElement agregar = driver.findElement(By.xpath("//div[@class='inventory_list']/div[3]//button[@class='btn_primary btn_inventory']\n"));
        agregar.click();

        WebElement carrito = driver.findElement(By.id("shopping_cart_container"));
        carrito.click();

        WebElement comprar = driver.findElement(By.xpath("//a[.='CHECKOUT']"));
        comprar.click();

        String nombres = "Esteban";
        String apellidos = "Ruiz";
        String codigos = "12345";


        WebElement nombre = driver.findElement(By.id("first-name"));
        WebElement apellido = driver.findElement(By.id("last-name"));
        WebElement codigo = driver.findElement(By.id("postal-code"));

        nombre.sendKeys(nombres);
        apellido.sendKeys(apellidos);
        codigo.sendKeys(codigos);

        WebElement continuar = driver.findElement(By.xpath("//input[@class='btn_primary cart_button']"));
        continuar.click();

        JavascriptExecutor abajo = (JavascriptExecutor) driver;

        int scrollDistance = -250; // Valor negativo para desplazamiento hacia arriba
        int scrollIncrement = 10;   // Valor ajustable para el incremento de desplazamiento
        int delayInMillis = 20;     // Valor ajustable para el tiempo de espera entre incrementos

        for (int i = 0; i > scrollDistance; i -= scrollIncrement) {
            String script = String.format("window.scrollBy(0, %d);", scrollIncrement);
            abajo.executeScript(script);
            try {
                Thread.sleep(delayInMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        WebElement finalizar = driver.findElement(By.xpath("//a[.='FINISH']"));
        finalizar.click();

    }
    @When("hace click sobre una opcion")
    public void hace_click_sobre_una_opcion() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("me debe mostrar ventana")
    public void me_debe_mostrar_ventana() {
        // Write code here that turns the phrase above into concrete actions
    }

}
