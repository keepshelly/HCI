class Driver(name: String, surname: String, second_name: String, val Prava: String):
    Human(name, surname,  second_name, -1) {


    override fun move() {
        Thread {
            x += 20
            y += 20
            println("Водитель $name едет прямо по: $x,$y")
        }.start()
    }

}
