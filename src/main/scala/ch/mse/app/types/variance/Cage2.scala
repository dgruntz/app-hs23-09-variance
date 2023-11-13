package ch.mse.app.types.variance

abstract class Cage2[T] {
  def get: T
  def put(animal: T): Unit
  def replace(animal: T): T
}

class CageTest {
  def readAnimal[T <: Animal](cage: Cage2[T]): Unit = {
    val a: Animal = cage.get
    // cage.put(a)
  }
  
  def readAnimal2(cage: Cage2[_ <: Animal]): Unit = {
    val a: Animal = cage.get
    // cage.put(a)
  }
  
  def storeBird[T >: Bird](b: Bird, cage: Cage2[T]): Unit = {
    // val a: Animal = cage.get
    cage.put(b)
  }

  def storeBird2(b: Bird, cage: Cage2[_ >: Bird]): Unit = {
    // val a: Animal = cage.get
    cage.put(b)
    val res = cage.get  // type of res is Any
  }
}

