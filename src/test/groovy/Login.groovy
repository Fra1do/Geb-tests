import Pages.MainPage
import Pages.LoginPage
import Tools.Helper
import Tools.Randoms
import geb.Browser

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
                to MainPage

                when: "I click on button 'Личный кабинет'"
                personalCabinet.click()

                then: "I see LoginPage"
                to LoginPage

                when: "I select register new employee"
                selectRegister.click()
                buttonFindJob.click()

                then: "I see register form for employee"
                fieldCustomPosition.isDisplayed()

                when: "I complete a form and click button 'Зарегистрироваться'"
                fieldName << names
                fieldSurname << surnames
                selectSex.click()
                fieldPassword << "123456"
                fieldEmailOrMobile << mail
                fieldCity << "Москва"
                println(selectCity.text())
                selectCity.click()
                clickNewRegister.click()

                then: "I see MainPage"
                to MainPage

        browser.quit()
}