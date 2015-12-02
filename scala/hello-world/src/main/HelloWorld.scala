object HelloWorld {
       def main(args: Array[String]) {
         println("Hello, World!")
       }
	   def mail(name: String="World"): String = {
		return ("Hello, "+name+"!")
	   }
     }