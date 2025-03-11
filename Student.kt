import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

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
    var budget: Boolean = false //бюджет-внебюджет


    //Заполнение информации о студенте
    open fun Input(){
        try {
            val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

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

            print("Введите дату рождения (гггг-мм-дд): ")
            val bdate = readln()
            bday = LocalDate.parse(bdate, formatter)

            print("Введите рост: ")
            height = readln().toDouble()

            print("Введите вес: ")
            weigth = readln().toDouble()

            print("Введите вид спорта: ")
            sport = readln()

            print("Введите вид обучения (бюджет/внебюджет): ")
            val bgt = readln()
            when (bgt) {
                "бюджет" -> budget = true
                "внебюджет" -> budget = false
                else -> {
                    println("Некорректная запись")
                    return
                }
            }

            if (!CheckCorrect())
                println("Некорректная запись")
        }
        catch (e:Exception)
        {
            println("Неверный формат данных")
        }
    }

    //Проверка корректности ввода
    fun CheckCorrect ():Boolean{

            if (name != "" && surname != "" && patronimic != "" && (sex == 'м' || sex == 'ж') && group != ""
                && bday != LocalDate.now() && height > 140.0 && weigth > 40.0 && sport != "")
                return true
            else
                return false
    }

    //Вывод информации о студенте
    fun Info(): String {
            return "Студент $surname $name $patronimic, рожден $bday, обучается в группе $group, занимается $sport. Рост: $height, вес: $weigth."
                // else -> return "Студентка $surname $name $patronimic, рождена $bday, обучается в группе $group, занимается $sport. Рост: $height, вес: $weigth."

    }

    //Вычисление возраста студента
    fun Age(): Int{
        val currentDate = LocalDate.now()
        val age = Period.between(bday, currentDate)
        return age.years
    }

    //Вычисление индекса массы тела
    fun IMT ():Double {
        var imt: Double = 0.0
        if (height < 2.5)
            imt = weigth/height
        else
            imt = weigth/(height/100)
        return imt
    }


}