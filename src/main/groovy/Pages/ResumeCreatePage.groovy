package Pages

import geb.Page
import geb.navigator.Navigator
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class ResumeCreatePage extends Page{
    static url = "/my-resume/create/#"

    static at = { $("h1").text() == "Создание резюме" }

    static content = {
        resumePosition  { $("input[data-bind='value: position']") }
        salary          { $("input[name='salary']") }
        surname         { $("input[data-bind='value: surname']") }
        name            { $("input[data-bind='value: name']") }
        secondName      { $("input[data-bind='value: secondName']") }
        mobile          { $("input[data-bind='value: phone, maskPhone: false']") }
        email           { $("input[data-bind='value: email']") }
        day             { $("input[data-bind='value: birthDay']") }
        month           { $("input[placeholder='месяц']") }
        year            { $("input[data-bind='value: birthYear']") }
        education       { $("div", class:'item') }
        selectElement   { $("div", class:'option') }
        sex             { $(By.xpath("(//label[@class='radio'])[1]")) }
        createResume    { $("button", text:'Продолжить') }

    }

    def selectMonth(String value)
    {
     println($("div[data-value='"+value+"']",0).text())
        $("div[data-value='"+value+"']",0).click()
    }

    def selectEducation(String value)
    {
        $(By.xpath("(//div[contains(@class, 'selectize-input')])[2]")).click()
        $("div", text: value).click()
    }

    def selectCity(String cityName)
    {
        $(By.xpath("(//div[contains(@class, 'selectize-input')])[3]")).click()

        Navigator region = selectElement.find{ c->
                c.text().contains(cityName)
        }
        region.click()
    }

    def selectMetro(String metroName)
    {
        $(By.xpath("(//div[contains(@class, 'selectize-input')])[4]")).click()

        Navigator region = selectElement.find{ c->
            c.text().contains(metroName)
        }
        region.click()
    }

    def selectNationality(String schedule)
    {
        $(By.xpath("(//div[contains(@class, 'selectize-input')])[5]")).click()
        Thread.sleep(5000)
        Navigator region = selectElement.find{ c->
            c.text().contains(schedule)
        }
        println(region)
        println(region.text())
        region.click()
    }

    def selectSchedule(String schedule)
    {
        $(By.xpath("(//div[contains(@class, 'selectize-input')])[6]")).click()
        Thread.sleep(5000)
        Navigator region = selectElement.find{ c->
            c.text().contains(schedule)
        }
        println(region)
        println(region.text())
        region.click()
    }


    def selectExpirience(String ex)
    {

       println( $(By.xpath("(//div[contains(@class, 'selectize-input')])[8]")).text())
        $(By.xpath("(//div[contains(@class, 'selectize-input')])[8]")).click()
        Thread.sleep(5000)
        Navigator region = selectElement.find{ c->
            c.text().contains(ex)
        }
        println(region)
        println(region.text())
        region.click()
    }

    def scrollTo()
    {
        WebElement el = $("span", text:'Уровень образования').firstElement()
        Actions actions = new Actions(driver)
        actions.sendKeys(Keys.PAGE_DOWN)
        actions.perform()
    }

}
