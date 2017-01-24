package sorting

object Sorting {

  def mergeSort(list: List[Int]): List[Int] = {
    if (list.size <= 1) list

    def merge(left: List[Int], right: List[Int]): List[Int] =
      (left, right) match {
        case (List(), rightList) => rightList
        case (leftList, List()) => leftList
        case (l :: ls, r :: rs) => if (l > r) r :: merge(l :: ls, rs) else l :: merge(ls, r :: rs)
      }

    list.splitAt(list.length / 2) match {
      case (List(), r) => r
      case (l, List()) => l
      case (l, r) => merge(mergeSort(l), mergeSort(r))
    }
  }

}