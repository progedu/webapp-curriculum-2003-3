object OptionStudy {

  trait Option[+A] {
    def map[B](f: A => B): Option[B] = {
      this match {
        case a: Some[A] => Some(f(a.get))
        case None => None
      }
    }

    def getOrElse[B >: A](default: => B): B = {
      this match {
        case a: Some[B] => a.get
        case None => default
      }
    }

    def flatMap[B](f: A => Option[B]): Option[B] = {
      this match {
        case a: Some[A] => f(a.get)
        case None => None
      }
    }
  }

  case class Some[+A](get: A) extends Option[A]

  case object None extends Option[Nothing]

}
