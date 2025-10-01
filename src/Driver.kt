class Driver(name: String, surname: String, second_name: String):
    Human(name, surname,  second_name) {

    override fun move() {
        Thread {
            x += 15
            y += 10
            speed = 5
            println("Водитель $name едет прямо по: $x,$y (скорость: $speed)")
            Thread.sleep(1000)
        }.start()
    }
}