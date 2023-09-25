package example;

public sealed interface A {
  public record B(int x) implements A{}
}
