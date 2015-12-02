
class Accumulate {
  def accumulate[SOURCE_TYPE, TARGET_TYPE](transform: SOURCE_TYPE => TARGET_TYPE, list: List[SOURCE_TYPE]): List[TARGET_TYPE] = {
    list.map((listElement: SOURCE_TYPE) => transform(listElement))
  }
}