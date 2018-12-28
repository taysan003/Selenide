package com.gsmserver.pages;
import com.gsmserver.testbase.TestBase;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends TestBase {

    public void searchFor(String query){
        $(By.name("q")).setValue(query).pressEnter();
    }
}
