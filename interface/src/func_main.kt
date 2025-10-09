fun main(){
    val chels = arrayOf(
        Human("John", "Smith", "Michael", ),
        Human("Emily", "Johnson", "Rose", ),
        Human("Michael", "Williams", "James", ),
        Human("Sarah", "Brown", "Elizabeth", ),)
    val Kir: Driver = Driver("Kirill", "Krakhmalnyy", "Vyacheslavovich",)
    for (human in chels) {
        human.move()
        Thread.sleep(1000)
    }
    Kir.move()
    Thread.sleep(2000)
}