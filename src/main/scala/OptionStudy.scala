object OptionStudy {

  trait Option[+A] {
    def map[B](f: A => B): Option[B] = {
        Option.this match {
        case Some(x: A) => Some(f(x))
        case _ => None
      }
    }

    def getOrElse[B >: A](default: => B): B = {
      Option.this match {
        case Some(x: A) => x
        case _ => default
      }
    }

    def flatMap[B](f: A => Option[B]): Option[B] = {
      Option.this match {
        case Some(x: A) => f(x)
        case _ => None
      }
    }
  }

  case class Some[+A](get: A) extends Option[A]

  case object None extends Option[Nothing]

}
