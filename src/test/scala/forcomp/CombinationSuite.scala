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

}
