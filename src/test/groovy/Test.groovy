package Tests

import Pages.MainPage
import Pages.ResumeCreatePage
import Pages.VacanciesPage
import Tools.Helper
import Tools.Randoms
import geb.Browser
import geb.navigator.Navigator

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities


//class Tests.Test
//{
      /*  static void main(args) {

                def a = "test"
                println("test "+a)
        }*/

       // def browser = new Browser(driver : new FirefoxDriver())

    //    def browser = new Browser(driver : new ChromeDriver())
        Helper help = new Helper()
        Randoms rand = new Randoms()

        def mail        = help.getRandomEmail()
        def names       = rand.getRandomName()
        def surnames    = rand.getRandomSurname()
        def secondnames = rand.getRandomSecondname()
        def days        = rand.getRandomDay()
        def months      = rand.getRandomMonth()
        def years       = rand.getRandomYear()

        println(mail)
        println(names)
        println(surnames)
        println(secondnames)
        println(days)
        println(months)
        println(years)

        Browser.drive {

                driver.manage().window().maximize();

                when: "I go to rabota.ru"

                browser.go("/")

                then: "I see this page"
                at MainPage

             /*   when: "I click person cabiner"
                personalCabinet.click()

                then: "I see LoginPage"
                at LoginPage

                when: "I create new user"
                selectRegister.click()
                buttonFindJob.click()*/

                then: "I see MainPage"
                Thread.sleep(3000)

                when: "I create new search"
                setCustomPosition << "Тестировщик"
                searchButton.click()

                then: "I go to vacanciesPage"
                at VacanciesPage

                when: "I find vacancy and click 'Откликнуться '"
                Thread.sleep(1000)
                FindVacancyByCompanyAndCreateResponce('Мониторинг')

                then: "I go to ResumeCreatePage"
                at ResumeCreatePage

                when: "I write all the fields"
                name       <<  names
                surname    <<  surnames
                secondName <<  secondnames
                //mobile     << '88005553555'
                email      <<  mail
                day        <<  days
                year       <<  years
                month.click()
                selectMonth(months)
                selectEducation("высшее")
                selectCity("Москва")
                selectMetro("Перово")
                selectNationality('Россия')
                scrollTo()
                sex.click()
                selectExpirience("5 лет и более")
                selectSchedule("свободный график")


                createResume.click()

                then: "I return in VacancyPage"
                Thread.sleep(60000)

        browser.quit()
}