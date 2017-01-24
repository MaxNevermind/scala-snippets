package sorting

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import scala.collection.immutable.::

@RunWith(classOf[JUnitRunner])
class SortingTest extends FunSuite {

  test("merge sort works correctly") {
    assert(isOrdered(Sorting.mergeSort(List(3, 6, 1, 3, 4, 2))))
    assert(isOrdered(Sorting.mergeSort(List(1))))
    assert(isOrdered(Sorting.mergeSort(List(3, 1))))
    assert(isOrdered(Sorting.mergeSort(List(- 1, 5, 2, 4))))
  }

  def isOrdered(list: List[Int]): Boolean =
    list match {
      case List() => true
      case x :: List() => true
      case l :: r :: xs => l <= r && isOrdered(r :: xs)
    }


}
