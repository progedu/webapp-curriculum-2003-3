object OptionStudy {

  trait Option[+A] {
    def map[B](f: A => B): Option[B] =
      if (this == None) {
        None
      } else {
        val Some(e) = this
        Some(f(e))
      }

    def getOrElse[B >: A](default: => B): B =
      if (this == None) {
        default
      } else {
        val Some(e) = this
        e
      }

    def flatMap[B](f: A => Option[B]): Option[B] =
      if (this == None) {
        None
      } else {
        val Some(e) = this
        f(e)
      }
  }

  case class Some[+A](get: A) extends Option[A]

  case object None extends Option[Nothing]

}
