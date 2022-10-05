package chapter2;

public class Main2 {
    public static int counter = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            counter++;
        });

        new Thread(() -> {
            counter++;
        });

//      Получаем вывод 0
        System.out.println(counter);

    }
}
