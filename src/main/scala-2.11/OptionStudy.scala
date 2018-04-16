object OptionStudy {

  sealed trait Option[+A] {
    final def map[B](f: A => B): Option[B] = this match {
      case None => None
      case Some(a) => Some(f(a))
      case _ => None
    }

    final def getOrElse[B >: A](default: => B): B = this match {
      case None => default
      case Some(a) => a
      case _ => default
    }

    final def flatMap[B](f: A => Option[B]): Option[B] =
      this.map(f).getOrElse(None)
  }

  case class Some[+A](get: A) extends Option[A]

  case object None extends Option[Nothing]
}
