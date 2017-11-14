import scala.io.StdIn

/**
  * Created by Kloop on 2017/11/12.
  */
object TestObject {
  def main(args: Array[String]): Unit = {
    println("hello world!");

    //声明变量
    val i=1;//一旦定义不允许修改，相当于final
    var j=1;//变量，可以改变
    var s="hello";
    val str:String = "itcast";
    val x = 0;

    //块表达式
    var result = {
      if(x<0){
        -1;
      }else if(x>=1){
        1;
      }
      else{
        "error"
      }
    }
    println(result);

    //循环
    for(i <- 1 to 3;j <- 1 to 3 if  i!=j){
      print(10*i+j+" ");
    }
    println();

    //每个值*10
    val t = for(i <- 1.to(10)) yield i*10;
    println(t);

    val v = 1.to(10).map(_*10);
    println(v);

    val o = test(10);
    println(o);

    //输入和输出
//    val name = StdIn.readLine("Your name:")
//    println(name);

    val s2 = "Hello";
    var sum = 0;
    for(i <- 0 until s2.length){
      sum += s2(i);
    }
    println(sum);

    var sum2 = 0;
    for(ch <- "Hello") sum2 += ch;
    println(sum2);

    //for推导式
    println(for(c <- "Hello";i<- 0 to 1) yield (c+i).toChar);
    println(for(i<- 0 to 1;c <- "Hello") yield (c+i).toChar);

    //递归调用
    println(fac(10))

    //默认参数和带名参数
    println(decorate("12323"))

    //变长参数
    println(sum1(1,4,9,16,25))
    println(sum1(1 to 5 : _*))

    //调用过程
    box("hello scala")

    //在words被定义时即被赋值
    val words1 = scala.io.Source.fromFile("D:\\Develop Workspaces\\MyFirstProject\\pom.xml").mkString
    //懒值 在words被首次调用时被取值
    lazy val words2 = scala.io.Source.fromFile("D:\\Develop Workspaces\\MyFirstProject\\pom.xml").mkString
    //在每一次words被调用时取值
    def words3 = scala.io.Source.fromFile("D:\\Develop Workspaces\\MyFirstProject\\pom.xml").mkString

    println(words1)
    println(words2)
    println(words3)
  }

  //定义递归函数1
  def test(n:Int) ={
    var r = 1;
     for(i <- 1 to n)  r= r*i;
    r;
  }

  //定义递归函数2
  def fac(n:Int) :Int ={
    if(n <= 0) 1;
    else n* fac(n-1);
  }

  //默认参数和带名参数
  def decorate(str:String,left:String="[",right:String = "]"): String ={
    left + str +right ;
  }

  //变长参数
  def sum1(args:Int *): Int ={
    var result = 0;
    for(arg <- args) result += arg
    result;
  }

  //过程
  def box(s:String):Unit ={
    var border = "-"+s.length +"--\n";
    println(border + "|"+s+"|\n"+border);
  }
}
