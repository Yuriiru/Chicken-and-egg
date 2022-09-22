package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Chicken chicken = new Chicken();
        Egg egg = new Egg();
        chicken.start();
        egg.start();
        egg.join();
        if (chicken.isAlive()) {
            chicken.join();
            System.out.println("Спор окончен. Победила курица");
            return;
        }
        System.out.println("Спор окончен. Победило яйцо");
    }

}

 class Chicken extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Курица");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException a) {
                throw new RuntimeException(a);
            }
        }
    }
 }

 class Egg extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Яйцо");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException a) {
                throw new RuntimeException(a);
            }
        }
    }
 }
