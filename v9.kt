fun main() {
    try {
        val students = Array(3) { Student() }
        for (i in 0 until 3)
        {
            println(i+1)
            students[i] = Student()
            students[i].Input()
            if (students[i].budget) {
                val budgetStudent = Budget()
                budgetStudent.name = students[i].name
                budgetStudent.surname = students[i].surname
                budgetStudent.patronimic = students[i].patronimic
                budgetStudent.sex = students[i].sex
                budgetStudent.group = students[i].group
                budgetStudent.bday = students[i].bday
                budgetStudent.height = students[i].height
                budgetStudent.weigth = students[i].weigth
                budgetStudent.sport = students[i].sport
                budgetStudent.budget = students[i].budget
                budgetStudent.Input()
                budgetStudent.scholarship = budgetStudent.GetSchlrshp()
                students[i] = budgetStudent
            }
            else
            {
                val extraBudgetStudent = Extrabudget()
                extraBudgetStudent.name = students[i].name
                extraBudgetStudent.surname = students[i].surname
                extraBudgetStudent.patronimic = students[i].patronimic
                extraBudgetStudent.sex = students[i].sex
                extraBudgetStudent.group = students[i].group
                extraBudgetStudent.bday = students[i].bday
                extraBudgetStudent.height = students[i].height
                extraBudgetStudent.weigth = students[i].weigth
                extraBudgetStudent.sport = students[i].sport
                extraBudgetStudent.budget = students[i].budget
                extraBudgetStudent.Input()
                students[i] = extraBudgetStudent
            }
        }
        while (true)
        {
            println("1. Вывести информацию")
            println("2. Вычислить возраст студента")
            println("3. Вычислить индекс массы тела")
            println("4. Посчитать полную оплату обучения студента")
            println("5. Проверить необходимость оплаты обучения")
            println("6. Закончить")
            print("Команда: ")
            val act = readln().toInt()
            if (act == 6)
                break
            print("Номер студента: ")
            val st = readln().toInt()
            if (act in 1..7 && st in 1..3)
            {
                when (act) {
                    1 -> println(students[st-1].Info())
                    2 -> println(students[st-1].Age())
                    3 -> println(students[st-1].IMT())
                    4 -> {
                        val student = students[st-1]
                        if (student is Extrabudget)
                            println(student.TotalPay())
                        else
                            println("Студент находится в бюджетной группе. 0.0")
                    }
                    5 -> {
                        val student = students[st-1]
                        if (student is Extrabudget)
                            println(student.NeedPay())
                        else
                            println(false)
                    }
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
