fun main(args: Array<String>) {
    println("Szép napot , kezdődhet a kviz jaték!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Megkérem adja meg hány kérdésre szeretne válaszolni" )
    var nr :Int=readln().toInt()
    val itemController = ItemController()
    itemController.quiz(nr)


}