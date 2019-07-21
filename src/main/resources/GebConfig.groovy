import org.openqa.selenium.firefox.FirefoxDriver



// default is to use firefox

driver = { new FirefoxDriver() }

baseUrl = "https://www.rabota.ru"
//baseUrl = "https://micrusha.ru/russkie-i-sovremennye-imena-dlya-malchika"
//baseUrl = "http://imja.name"


reportsDir = "target/geb-reports"



enviroments {
        firefox {
            driver = { new FirefoxDriver() }
        }
}
