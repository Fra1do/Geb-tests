package Tests


import Pages.MainPage
import Pages.ResumeCreatePage
import Pages.VacanciesPage
import Tools.Helper
import geb.Browser
import geb.navigator.Navigator
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities

File texst = new File("family4.txt")

        Browser.drive {

                driver.manage().window().maximize();

                when: "I go to rabota.ru"

                //browser.go("/russkie-i-sovremennye-imena-dlya-malchika")
                browser.go("/familii/pyatsot-chastykh-familij.shtml")

                $("tbody").$("td", class:'topin1').each {t->
                        println(t.text())
                        texst << '\n'  << t.text()
                }
                then: "I did it"


        browser.quit()
}