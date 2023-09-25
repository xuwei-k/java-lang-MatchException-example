package example;

public class F {
  public static int f(A a) {
    return switch(a) {
      case A.B b -> b.x();
      case A.C c -> c.x();
    };
  }
}
