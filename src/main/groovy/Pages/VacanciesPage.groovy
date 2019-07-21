package Pages

import geb.Page
import geb.navigator.Navigator
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class VacanciesPage extends Page{
    static url = "/vacancy"

    static at = { $("i", text: "map").next().text() == "показать на карте" }

    static content = {
        vacancy { $("section[class='list-vacancies__item    ']") }
    }
    def FindVacancyByCompanyAndCreateResponce(String companyName)
    {
        Navigator elem =  vacancy.find {el ->

            el.text().contains(companyName)

        }
        Thread.sleep(3000)
        println(elem.find( "a",0, href:' /my-resume/create/ ').text())
        elem.find( "a", 0, href:' /my-resume/create/ ').click()

    }
}
