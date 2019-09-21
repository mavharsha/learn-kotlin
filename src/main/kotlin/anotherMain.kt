import com.mavharsha.JavaMoney
import java.math.BigDecimal

/* Code from a talk Introduction to Kotlin by Hadi Hariri */

data class Money (val amount: BigDecimal, val currency: String)

fun main(args: Array<String>) {
    val tickets = Money(BigDecimal(100), "$")
    val popcorn = tickets.copy()

    val anotherCopy = tickets.copy(BigDecimal(200), "EUR")

    if(tickets != popcorn) {
        println("They are different")
    }

    /* == checks the equality (between propertis) */
    /* === checks the pointers */

    val javaMoney = JavaMoney(100, "$")
    println("com.mavharsha.JavaMoney ${javaMoney.amount} ${javaMoney.currency}")

    var Bd1 = BigDecimal(100)
    println("percentage 20 percent of $Bd1 using extension function is ${Bd1.percentage(20)}")
    /* Extension functions are available to all the classes in the package  */
    val fourteen: Int = 14
    var Bd2 = BigDecimal(100)
    println("percentage 20 percent of 100 using extension function is ${fourteen.percentOf(Bd2)}")

    println("Is 24 even? ${24.isEven()}")
    println("Is 24 odd? ${24.isOdd()}")

    println("Is tickets dollar currency: ${javaMoney.isDollar()}")



}

fun JavaMoney.isDollar(): Boolean = this.currency.equals("$", true)

fun Int.isEven(): Boolean = this % 2 == 0

fun Int.isOdd(): Boolean = this %2 != 0


fun Int.percentOf(total: BigDecimal): BigDecimal = total.multiply(BigDecimal(this)).divide(BigDecimal(100))

fun BigDecimal.percentage(percent: Int): BigDecimal = this.multiply(BigDecimal(percent)).divide(BigDecimal(100))