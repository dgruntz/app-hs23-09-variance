package ch.mse.app.types.variance

trait ListReader[+T] {
  def get(index: Int): T
  def sort(comparer: Order[T]): Unit
}

trait ListWriter[-T] {
  def add(item: T): Unit
  def addRange(items: Seq[T]): Unit
}

trait Order[-T] {
  def compare(x1: T, x2: T): Int
}

trait Seq[+T] {
  def iterator: Iterator[T] = ???
}

class MyList[T](elem: T) extends ListReader[T] with ListWriter[T] {
  def get(index: Int): T = elem
  def sort(comparer: Order[T]): Unit = { }
  def add(item: T): Unit = { }
  def addRange(items: Seq[T]): Unit = { }
}

class A
class B extends A
class C extends B

object TestList {

  def main(args: Array[String]): Unit = {
    val lista: MyList[A] = new MyList[A](new A)
    val listb: MyList[B] = new MyList[B](new B)
    val listc: MyList[C] = new MyList[C](new C)

    val oa: Order[A] = null
    val ob: Order[B] = null
    val oc: Order[C] = null
    
    val r: ListReader[B] = listc
    r.sort(oa)
    r.sort(ob)
//  r.sort(oc)  // type mismatch
    
    val w: ListWriter[B] = lista
//  w.addRange(new Seq[A]{})
    w.addRange(new Seq[B]{})
    w.addRange(new Seq[C]{})
  }
}