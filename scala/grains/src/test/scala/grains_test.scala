import org.scalatest._

class GrainsTest extends FunSuite with Matchers {
  test ("square 1") {
    Grains.square(1) should be (1)
  }

  test ("square 2") {
  
    Grains.square(2) should be (2)
  }

  test ("square 3") {
    
    Grains.square(3) should be (4)
  }

  test ("square 4") {
    
    Grains.square(4) should be (8)
  }

  test ("square 16") {
    
    Grains.square(16) should be (32768)
  }

  test ("square 32") {
    
    Grains.square(32) should be (2147483648L)
  }

  test ("square 64") {
    
    Grains.square(64) should be (BigInt("9223372036854775808"))
  }

  test ("total grains") {
    
    Grains.total should be (BigInt("18446744073709551615"))
  }
}
