import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

open class Student(var name: String = "",
                   var surname: String = "",
                   var patronimic: String = "",
                   var sex: Char = '?',
                   var group: String = "",
                   var bday: LocalDate = LocalDate.now(),
                   var height: Double = 0.0,
                   var weigth: Double = 0.0,
                   var sport: String = "",
                   var budget: Boolean = false) {
    var correct = true
   open fun Input(){
        try {
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

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
            else
                correct = false
            print("Введите группу: ")
            group = readln()
            print("Введите дату рождения (дд.мм.гггг): ")
            val bdate = readln()
            bday = try {
                LocalDate.parse(bdate, formatter)
            }
            catch (e: DateTimeParseException)
            {
                correct = false
                println("Неверный формат даты")
                LocalDate.now()
            }
            print("Введите рост: ")
            height = readln().toDouble()
            print("Введите вес: ")
            weigth = readln().toDouble()
            print("Введите вид спорта: ")
            sport = readln()
            CheckCorrect(name, surname, patronimic, sex, group, bday, height, weigth, sport)
            print("Введите бюджет или внебюджет: ")
            val bdgt = readln()
            when (bdgt) {
                "бюджет" -> budget = true
                "внебюджет" -> budget = false
                else -> {
                    correct = false
                    println("Неверный ввод")
                    return
                }
            }
        }
        catch (e:Exception)
        {
            println("Неверный формат данных")
            correct = false
        }
    }

    //Проверка корректности ввода
    fun CheckCorrect (name: String, surname: String, patronimic: String,
                      sex: Char, group: String, bday: LocalDate, height: Double, weigth: Double, sport: String):String{
        try {
            if (name != "" && surname != "" && patronimic != "" && (sex == 'м' || sex == 'ж') && group != ""
                && bday != LocalDate.now() && height > 140.0 && height < 210.0 && weigth > 40.0 && sport != "") {
                correct = false
                return "Некорректная запись данных"
            }
            else
                return "Корректная запись данных"
        }
        catch (e:Exception)
        {
            return "Неверный формат данных"
        }
    }

    //Вывод информации о студенте
    open fun Info(): String {
        if (correct) {
            when (sex) {
                'м' -> return "Студент $surname $name $patronimic, рожден $bday, обучается в группе $group, занимается $sport. Рост: $height, вес: $weigth."
                'ж' -> return "Студентка $surname $name $patronimic, рождена $bday, обучается в группе $group, занимается $sport. Рост: $height, вес: $weigth."
                else -> return "Некорректная запись"
            }
        }
        else return "Информация внесена некорректно"
    }

    //Вычисление возраста студента
    fun Age(): Int{
        val currentDate = LocalDate.now()
        val age = Period.between(bday, currentDate)
        return age.years
    }

    //Вычисление индекса массы тела
    fun IMT ():Double {
        val imt = weigth/(Math.pow(height/100, 2.0))
        return imt
    }
}
