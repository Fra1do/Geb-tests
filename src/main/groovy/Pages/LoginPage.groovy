package Pages

import geb.Page

class LoginPage extends Page{
    static url = "/login"

    static at = { $("a",  id : "js-login-tab-registration").text() == "РЕГИСТРАЦИЯ" }

    static content = {

        selectRegister      { $("a",  id : "js-login-tab-registration") }
        buttonFindJob       { $("a",  id : "js-login-tab-registration-worker") }
        fieldName           { $("input", placeholder : "Имя") }
        fieldSurname        { $("input", placeholder : "Фамилия") }
        selectSex           { $("span", text: 'Мужчина').parent() }
        fieldCity           { $("input", placeholder : 'Город') }
        selectCity          { $("div",0, class : 'autocomplete-suggestion') }
        fieldCustomPosition { $("input", placeholder : "Должность") }
        fieldEmailOrMobile  { $("input", name : "login") }
        fieldPassword       { $("input", name : "password") }
        clickNewRegister    { $("button", id : "registration-btn-button") }
    }
}
