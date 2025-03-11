fun main() {
    try {
        val students = Array(3) { Student() }
        for (i in 0 until 1)
        {
            println(i+1)
            students[i].Input()
            if (students[i].budget) {
                students[i] = Budget()
                students[i].Input()
            }
            else
            {
                students[i] = Extrabudget()
                students[i].Input()
            }
        }
        while (true)
            {
                println("1. Вывести информацию")
                println("2. Вычислить возраст студента")
                println("3. Вычислить индекс массы тела")
                println("4. Посчитать стипендию студента")
                println("5. Посчитать полную оплату обучения студента")
                println("6. Проверить необходимость оплаты обучения")
                println("7. Закончить")
                print("Команда: ")
                val act = readln().toInt()
                print("Номер студента: ")
                val st = readln().toInt()
                if (act in 1..7 && st in 1..3)
                {
                    when (act) {
                        1 -> println(students[st-1].Info())
                        2 -> println(students[st-1].Age())
                        3 -> println(students[st-1].IMT())
                        4 -> {

                        }
                        5 -> {

                        }
                        6 -> {

                        }
                        7 -> break
                    }
                }
                else
                    println("Неизвестная команда или студент")
            }
    }
    catch (e:Exception)
    {
        println("Неверный формат данных")
    }
}
