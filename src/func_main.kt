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
        Human("Matthew", "Rodriguez", "Joseph", 444),
        Human("Ashley", "Wilson", "Ann", 444),
        Human("James", "Martinez", "William", 444),
        Human("Stephanie", "Anderson", "Grace", 444),
        Human("Daniel", "Taylor", "Charles", 444),
        Human("Elizabeth", "Thomas", "Jane", 444),)
    val Kir: Driver = Driver("Kirill", "Krakhmalnyy", "Vyacheslavovich","C")
    for (human in chels) {
        human.move()
    }
    Kir.move()
    Thread.sleep(2000)
}