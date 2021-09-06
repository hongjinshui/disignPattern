package com.hjs.pattern.p06.prototype;

public class RacerRunnable implements Runnable {
    public static void main(String[] args) {
        RacerRunnable racerRunnable = new RacerRunnable();
        new Thread(racerRunnable, "tortoise").start();
        new Thread(racerRunnable, "rabbit").start();
    }
    private String winner;// 胜利者
    @Override
    public void run() {
        for (int step = 1; step <= 100; step++){
            // 模拟兔子休息
            if (Thread.currentThread().getName().equals("rabbit") && (step%10==0)){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-->"+step);
            // 比赛是否结束
            boolean b = gameOver(step);
            if (b){
                break;
            }
        }
    }
    public boolean gameOver(int step){
        if (winner!=null){
            return true;
        }else{
            if (step == 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner==>"+ winner);
                return true;
            }
        }
        return false;
    }
}