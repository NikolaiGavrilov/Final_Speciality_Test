package Java;

public class Counter implements AutoCloseable {
    static int count = 0;

    public static void add() {
        Counter.count += 1;
    }

    public static void animalCounter() {
        System.out.println("Текущий счётчик ваших животных: " + Counter.count);
    }

    public Counter() {
        this.count = count;
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
    }
}
