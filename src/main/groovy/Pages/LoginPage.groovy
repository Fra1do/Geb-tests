package groovy.Pages

import geb.Page

class LoginPage extends Page{
    static url = "/login"

    static at = { $("a",  id : "js-login-tab-registration").text() == "РЕГИСТРАЦИЯ" }

    static content = {

        selectRegister     { $("a",  id : "js-login-tab-registration") }
        buttonFindJob      { $("a",  id : "js-login-tab-registration-worker") }
    }
}
