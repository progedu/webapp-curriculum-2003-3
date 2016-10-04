object OptionStudy {

  trait Option[+A] {
    def map[B](f: A => B): Option[B] = ???

    def getOrElse[B >: A](default: => B): B = ???

    def flatMap[B](f: A => Option[B]): Option[B] = ???
  }

  case class Some[+A](get: A) extends Option[A]

  case object None extends Option[Nothing]

}
