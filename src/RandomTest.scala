import scala.util.Random

/**
 * Created by Real on 2015-06-27.
 */
object RandomTest extends App{
  val rnd = new Random();
  val highNumberListCount = rnd.nextInt(3) + 2

  for(i <- 1 to 1000000) {
    val highNumberListCount = rnd.nextInt(3) + 2
    if(highNumberListCount >= 5) println("OK")
  }
}
