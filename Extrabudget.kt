class Extrabudget: Student() {
    var qCourses: UInt = 0u //количество курсов
    var currentCourse: UInt = 0u //текущий курс
    var paymentForYear: Double = 70000.0 //плата за год
    var payed: Double = 0.0 //уже оплачено

    override fun Input() {
        try {
            print("Введите количество курсов:")
            qCourses = readln().toUInt()
            print("Введите текущий курс:")
            currentCourse = readln().toUInt()
            print("Введите сколько уже оплачено:")
            payed = readln().toDouble()
            if (payed < 0.0)
                println("Неверный ввод")
        }
        catch (e: Exception)
        {
            println("Неверный формат данных")
        }
    }
    //Расчет полной оплаты обучения
    fun TotalPay(): Double{
        val total = qCourses.toDouble() * paymentForYear
        return total
    }
    //Проверка необходимости оплаты обучения
    fun NeedPay(): Boolean{
        if (payed == TotalPay() || payed == paymentForYear*currentCourse.toDouble())
            return false
        else
            return true
    }
}