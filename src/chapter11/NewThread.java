package chapter11;

//Применить метод join(), чтобы ожидать завершения
//потоков исполнения

public class NewThread implements Runnable{

    String name;   // имя потока исполнения
    Thread t;

    NewThread(String threadName){
        name = threadName;
        t = new Thread(this,name);
        System.out.println("Hoвый поток: " + t);
        t.start();  //  запустить поток исполнения
    }

    //  Точка входа в поток исполнения
    @Override
    public void run() {
        try {
        for (int i = 5; i >0; i--) {
            System.out.println(name + " : " + i);

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " рерван");;
            }
        System.out.println(name + " завершен");
        }
    }

    class DemoJoin{
        public static void main(String[] args) {
            NewThread ob1 = new NewThread("One");
            NewThread ob2 = new NewThread("Two");
            NewThread ob3 = new NewThread("Three");

            System.out.println("Пoтoк Один запущен: " + ob1.t.isAlive());
            System.out.println("Пoтoк Два запущен: " + ob2.t.isAlive());
            System.out.println("Пoтoк Три запущен: " + ob3.t.isAlive());

            // ожидать завершения потоков исполнения
            try {
                System.out.println("Oжидaниe завершения потоков ");
                ob1.t.join();
                ob2.t.join();
                ob3.t.join();
        }catch (InterruptedException e){
                System.out.println("Глaвный поток прерван ");
            }
            System.out.println("Пoтoк Один запущен: " + ob1.t.isAlive());
            System.out.println("Пoтoк Два запущен: " + ob2.t.isAlive());
            System.out.println("Пoтoк Три запущен: " + ob3.t.isAlive());
    }
}
