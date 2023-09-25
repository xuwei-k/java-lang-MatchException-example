package example;

public sealed interface A {
  public record B(int x) implements A{}
  public record C(int x) implements A{}
}
