package Tools

import java.time.LocalDate
import java.util.Random

class Helper {
    def getRandomEmail()
    {
        LocalDate currentDate = LocalDate.now();
        Random rnd = new Random()
        ArrayList<String> domain = new ArrayList()
        domain.add("mail.ru")
        domain.add("yandex.ru")
        domain.add("rambler.ru")
        domain.add("gmail.com")
        domain.add("rdw.ru")
        String mail = currentDate.toString().md5()+"@"+domain.get(rnd.nextInt(domain.size()))
    }
}
