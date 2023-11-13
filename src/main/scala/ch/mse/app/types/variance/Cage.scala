package ch.mse.app.types.variance

abstract class Cage [A] {
  def get: A				         // +  covariant position
  def put(animal: A): Unit 	 // -  contravariant position
  val animal: A			      	 // +  covariant position
  var animal2: A			       // +- covariant & contravariant position
  def replace(animal: A): A // +- covariant & contravariant position
}
