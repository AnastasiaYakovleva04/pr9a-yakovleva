import java.time.LocalDate
import java.time.Period

open class Student() {

    var name: String = "" //имя
    var surname: String = "" //фамилия
    var patronimic: String = "" //отчество
    var sex: Char = '?' //пол
    var group: String = "" //группа
    var bday: LocalDate = LocalDate.now() //дата рождения
    var height: Double = 0.0 //рост
    var weigth: Double = 0.0 //вес
    var sport: String = "" //спорт

    fun Input(){
        try {
            print("Введите фамилию: ")
            surname = readln()
            print("Введите имя: ")
            name = readln()
            print("Введите отчество: ")
            patronimic = readln()
            print("Введите пол: ")
            val ch = readln()
            if (ch.length == 1)
                sex = ch[0]
            print("Введите дату рождения: ")
            //
            print("Введите рост: ")
            height = readln().toDouble()
            print("Введите вес: ")
            weigth = readln().toDouble()
            print("Введите вид спорта: ")
            sport = readln()
            CheckCorrect(name, surname, patronimic, sex, group, bday, height, weigth, sport)
        }
        catch (e:Exception)
        {
            println("Неверный формат данных")
        }
    }

    //Проверка корректности ввода
    fun CheckCorrect (name: String, surname: String, patronimic: String,
                      sex: Char, group: String, bday: LocalDate, height: Double, weigth: Double, sport: String):String{
        try {
            if (name != "" && surname != "" && patronimic != "" && (sex == 'м' || sex == 'ж') && group != ""
                && bday != LocalDate.now() && height > 0.0 && weigth > 0.0 && sport != "")
                return "Некорректная запись данных"
            else
                return "Корректная запись данных"
        }
        catch (e:Exception)
        {
            return "Неверный формат данных"
        }
    }

    //Вывод информации о студенте
    fun Info(): String {
        when(sex){
            'м' -> return "Студент $surname $name $patronimic, рожден $bday, обучается в группе $group, занимается $sport. Рост: $height, вес: $weigth."
            else -> return "Студентка $surname $name $patronimic, рождена $bday, обучается в группе $group, занимается $sport. Рост: $height, вес: $weigth."
        }
    }

    //Вычисление возраста студента
    fun Age(bday: LocalDate): Int{
        val currentDate = LocalDate.now()
        val age = Period.between(bday, currentDate)
        return age.years
    }

    //Вычисление индекса массы тела
    fun IMT (height: Double, weigth: Double):Double {
        var imt: Double = 0.0
        if (height < 2.5)
            imt = weigth/height
        else
            imt = weigth/(height/100)
        return  imt
    }


}