class Extrabudget: Student() {
    var qCourses: UInt = 0u //количество курсов
    var currentCourse: UInt = 0u //текущий курс
    var paymentForYear: Double = 0.0 //плата за год
    var payed: Double = 0.0 //уже оплачено

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