fun main(){
    val chels = arrayOf(
        Human("John", "Smith", "Michael", 444),
        Human("Emily", "Johnson", "Rose", 444),
        Human("Michael", "Williams", "James", 444),
        Human("Sarah", "Brown", "Elizabeth", 444),
        Human("David", "Jones", "Robert", 444),
        Human("Jessica", "Miller", "Marie", 444),
        Human("Christopher", "Davis", "Thomas", 444),
        Human("Amanda", "Garcia", "Louise", 444),
        Human("Matthew", "Rodriguez", "Joseph", 444),)
    val Kir: Driver = Driver("Kirill", "Krakhmalnyy", "Vyacheslavovich","B")
    for (human in chels) {
        human.move()
    }
    Kir.move()
    Thread.sleep(2000)
}
