package forcomp

import forcomp.Combination._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CombinationSuite extends FunSuite  {

  /*test("1") {
    assert(combinations(List(1,2)) == List(List(1,2)))
  }
*/
  test("2") {
    assert(combinations(List(1,2,3)) == List(List(), List(1), List(3), List(2), List(1, 2), List(2, 3), List(1, 3), List(1, 2, 3)))
  }

  test("3") {
    assert(c1(List(('a', 2))) == List[(Char, Int)](('a', 1),('a', 2)))
  }

  test("4") {
    assert(c1(List(('a', 2), ('b', 2))) == List[(Char, Int)](('a', 1),('a', 2), ('b', 1), ('b', 2)))
  }

  test("combinations: abba") {
    val abba = List(('a', 2), ('b', 2))
    val abbacomb = List(
      List(),
      List(('a', 1)),
      List(('a', 2)),
      List(('b', 1)),
      List(('a', 1), ('b', 1)),
      List(('a', 2), ('b', 1)),
      List(('b', 2)),
      List(('a', 1), ('b', 2)),
      List(('a', 2), ('b', 2))
    )
    val abbaC1: List[(Char, Int)] = c1(abba).toList
    val result = combGen(abbaC1).sortWith(_.length < _.length)
    println(result.length)
    assert(result.toSet === abbacomb.toSet)
  }

}
