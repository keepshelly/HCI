import kotlin.random.Random
import kotlin.math.*

open class Human
{
    var name: String = ""
    var surname: String = ""
    var second_name: String = ""
    var group_number: Int = -1

    var x = 0
    var y = 0

    constructor(_name: String, _surname: String, _second: String, _gn: Int){
        name = _name
        surname = _surname
        second_name = _second
        group_number = _gn
        println("Сделали новый обьект: $name")
    }

    open fun move(){
        Thread{
            val x = (1..10).random()
            val y = (1..10).random()
            println("Человек движется: $x,$y")
            println("Человек прошел")
        }.start()

    }

    fun moveTo(_toX: Int, _toY: Int){
        x = _toX
        y = _toY
        println("Человек движется по: $x,$y Стандарт")
    }
    fun randomMove(){
        val x = (1..100).random()
        val y = (1..100).random()
        println("Человек движется по: $x,$y Рандом")
    }
    fun gaussmarkov(){
        var speed = (1..20).random().toDouble()
        var direction = (0..360).random().toDouble()
        speed = 0.8 * speed + 0.2 * (1.0 + Random.nextDouble() * 5.0)
        val directionRad = direction * PI / 180.0
        val newX = x + (speed * cos(directionRad)).toInt()
        val newY = y + (speed * sin(directionRad)).toInt()
        x = newX.coerceIn(0..1000)
        y = newY.coerceIn(0..1000)
        println("$name движется: $x,$y по Гауссу-Маркова")
    }
}
class Driver(name: String, surname: String, second_name: String, val licenseCategory: String):
    Human(name, surname,  second_name, -1) {


    override fun move() {
        Thread {
            x += 15
            y += 10
            println("Водитель $name едет прямо по: $x,$y")
        }.start()
    }
}

fun main(){
    val humans = arrayOf(

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

    for (human in humans) {
        human.move()
    }
    Kir.move()
    Thread.sleep(2000)
}