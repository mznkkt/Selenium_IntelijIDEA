public class Calculator {
  
  public Calculator () {
    
    System.out.println("Calling constructor");
  }
  
  public void add() {

    System.out.println("Adding some numbers");
  }

  public void sub() {

    System.out.println("Sub some numbers");
  }

  public void div() {

    System.out.println("Div some numbers");
  }

  public void mult() {

    System.out.println("Mult some numbers");
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Calculator calc = new Calculator();
    
    calc.add();
    calc.div();
    calc.sub();
    calc.mult();
  }

}