package lambda;

@FunctionalInterface
public interface SuperFunction<T, S, U, R> {
  
  R apply(T t, S s, U u);
}
