package chapter3;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();

        Thread thread1 = new Thread(null, () -> account.transfer(500), "Клиент1");
        Thread thread2 = new Thread(null, () -> account.transfer(200), "Клиент2");
        Thread thread3 = new Thread(null, () -> account.transfer(300), "Клиент3");

        thread1.start();
        thread2.start();
        thread3.start();

        //если убрать join(), то баланс в основной потоке выведется 0
        thread3.join();
        thread2.join();
        thread1.join();

        System.out.printf("Баланс после всех переводов составил: %d рублей.\n", account.getMoney());
    }
}
