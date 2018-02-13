package forcomp

object Combination {

  def combinations(in: List[Int]): Seq[List[Int]] = {


    def c(in: List[Int]): Seq[List[Int]] = {
      in match {
        case Nil => List(Nil)
        case h::tail =>

          val o1: Seq[List[Int]] = tail map { t =>
            List(h,t)
          }

          val o2 = c(tail)

          val o: Seq[List[Int]] = o2 map { x =>
            h :: x
          }

          (o ++ o1 ++ o2).toSet.toList
      }
    }

    c(in).sortWith(_.length<_.length)
  }

}
