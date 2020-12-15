package ch.trinat.edu.threads01.u03;

public class ThreadTestLauf {
    public static void main(String[] args) {
        Runnable threadJob = new MeinRunnable();
        Thread meinThread = new Thread(threadJob);
        meinThread.start();
        try {
            Thread.sleep(1);//uebung 3 Zeit ändern entsprechend der andere funktion je nach dem was man zu erst haben will
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("zurück in main");
    }
}
