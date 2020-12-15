package ch.trinat.edu.threads01.u05;

public class ThreadNaming {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        t1.setName("Eins");
        t2.setName("Zwei");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName());

        // alles in einer Zeile
        new Thread(new MyThread(), "Drei").start();


        Thread t3 = new Thread(new MyThread());
        Thread t4 = new Thread(new MyThread());
        t3.setName("Eins");
        t4.setName("Zwei");
        t3.start();
        t4.start();
        System.out.println(Thread.currentThread().getName());

        // alles in einer Zeile
        new Thread(new MyThread(), "Drei").start();


        // Instanz Runnable
        Runnable runner = () -> System.out.println("Hallo Welt");
        new Thread(runner, "runner-x").start();
        new Thread(runner, "runner y").start();
        new Thread(() -> System.out.println("Hallo Welt"), "test").start();




        // Lambda
        new Thread(() -> {
            System.out.println("Lambda");
            for (int i = 0; i < 50; i++) {
                String name = Thread.currentThread().getName();
                System.out.println("Thread " + name + " hat Nummer " + i + " verarbeitet");
            }

        }, "Lambda").start();
    }

}

