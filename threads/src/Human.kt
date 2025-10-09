import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random
open class Human : Movable  //добавил интерфейс
{
    var name: String = ""
    var surname: String = ""
    var second_name: String = ""
    //вот свойства взятые с интерфейса
    override var x = 0
    override var y = 0
    override var speed: Int = 1
    constructor(_name: String, _surname: String, _second: String,){
        name = _name
        surname = _surname
        second_name = _second
        println("Сделали новый обьект: $name")
    }
    override fun move(){  //метод из интерфейса
        Thread{
            x = (1..10).random()
            y = (1..10).random()
            println("Человек движется: $x,$y (скорость: $speed)")
            println("Человек прошел")
            Thread.sleep(1500)
        }.start()
    }
    fun moveTo(_toX: Int, _toY: Int){
        x = _toX
        y = _toY
        println("Человек движется по: $x,$y Стандарт")
    }
    fun randomMove(){
        val randomX = (1..100).random()
        val randomY = (1..100).random()
        println("Человек движется по: $randomX,$randomY Рандом")
    }
}