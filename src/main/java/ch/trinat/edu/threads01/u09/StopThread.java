package ch.trinat.edu.threads01.u09;

public class StopThread extends Thread{
    // Stopping von Threads mittels Polling
        private boolean stopped = false;

        public StopThread() {
            start();
        }

        public synchronized void stopThread() {
            stopped = true;
        }

        public synchronized boolean isStopped() {
            return stopped;
        }

        public void run() {
            int i = 0;
            try {
                while (!isStopped()) {
                    sleep(30);
                    i++;
                    System.out.println("Hallo Welt (" + i + ")");
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

            System.out.println("Thread endet jetzt ...");
        }
        public static void main(String[] args) {
            StopThread st = new StopThread();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            st.interrupt();
            try {
                st.join();
            } catch (InterruptedException e) {

            }
            System.out.println("main terminating");

        }

    }

