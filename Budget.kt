class Budget: Student() {
    var scholarship: Double = 0.0 //стипендия
    var count5 : UInt = 0u //количество 5
    var count4 : UInt = 0u //количество 4
    var count3 : UInt = 0u //количество 3

    //Перегрузка функции ввода информации
    override fun Input() {
        try {
            print("Введите количество 5:")
            count5 = readln().toUInt()
            print("Введите количество 4:")
            count4 = readln().toUInt()
            print("Введите количество 3:")
            count3 = readln().toUInt()
        }
        catch (e: Exception)
        {
            println("Неверный формат данных")
        }
    }
    //Подсчет стипендии
    fun GetSchlrshp():Double{
        if (count3 == 0u && count4 == 0u && count5 != 0u)
            scholarship == 1598.5
        else if (count3 == 0u && count4>0u && count5>0u)
            scholarship == 1066.05
        else
            scholarship == 0.0
        return scholarship
    }
}