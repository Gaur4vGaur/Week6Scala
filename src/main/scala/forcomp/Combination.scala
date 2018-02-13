package forcomp

object Combination {

  def combinations(in: List[Int]): Seq[List[Int]] = {


    def c(in: List[Int]): Seq[List[Int]] = {
      in match {
        case Nil => List(Nil)
        case h :: tail =>

          val o1: Seq[List[Int]] = tail map { t =>
            List(h, t)
          }

          val o2 = c(tail)

          val o: Seq[List[Int]] = o2 map { x =>
            h :: x
          }

          (o ++ o1 ++ o2).toSet.toList
      }
    }

    c(in).sortWith(_.length < _.length)
  }

  def c1(in: List[(Char, Int)]): Seq[(Char, Int)] = in flatMap { l => (1 to l._2) map ((l._1, _)) }

  type CI = (Char, Int)

  def combGen(in: List[CI]): List[List[CI]] = {


    def c(in: List[CI]): List[List[CI]] = {
      in match {
        case Nil => List(Nil)
        case h :: tail =>

          val o1: Seq[List[CI]] = tail map { t =>
            if (h._1 != t._1) List(h, t) else Nil
          }

          val o2 = c(tail)

          val o: Seq[List[CI]] = o2 map { x =>
            if (x.unzip._1.contains(h._1))
              x
            else
              h :: x
          }

          (o ++ o1 ++ o2).toSet.toList
      }
    }

    c(in)
  }

}
