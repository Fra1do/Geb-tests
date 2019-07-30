package Pages

import geb.Page

class MainPage extends Page{
    static url = "/"

    static at = { $("div", class : "main-header__slogan").text() == "устраивает всех" }

    static content = {
        searchButton        (to:VacanciesPage) { $("input[value='Найти']") }
        setCustomPosition   { $("input[placeholder='Должность или компания']") }
        personalCabinet     ( to:LoginPage) {$("span", text:'Личный кабинет')  }
    }
}
