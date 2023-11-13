package ch.mse.app.types.variance

case class Pair[T](val p1: T, val p2: T) {
    def withFirst[R >: T](newp1: R) = Pair[R](newp1, p2)
}

object Test {

    val p = Pair(new Bird(), new Bird());

    val r1 = p.withFirst(new Bird());

}
