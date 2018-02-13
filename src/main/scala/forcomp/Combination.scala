package forcomp

object Combination {

  def combinations(in: List[Int]): Seq[List[Int]] = {


    def c(in: List[Int]): Seq[List[Int]] = {
      in match {
        case h::Nil => List(List(h))
        case h::tail =>

          val o1: Seq[List[Int]] = tail map { t =>
            List(h,t)
          }

          val o: Seq[List[Int]] = c(tail) map { x =>
            h :: x
          }

          (o ++ o1).toSet.toList
      }
    }

    c(in)




  }

}
