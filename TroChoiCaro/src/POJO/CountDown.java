/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class CountDown {
    int timeLimit , current, tickInterval;
    Timer timer ; 
    ExecutorService executor;

    boolean isPaused = false;
    
    
    public  CountDown(int gioihan){
           timeLimit=gioihan;
           current=gioihan;
           tickInterval= 1 ;
           timer =new Timer();
           executor=Executors.newFixedThreadPool(2);
    }
    
    
    public void pause(){
        isPaused=true;
    }
    public void resume(){
        isPaused=true;
    }
    public void restart(){
        current =timeLimit;
        resume();
    }
    public void cancel(){
        timer.cancel();
        timer.purge();
        executor.shutdownNow();
    }
    
    public void setTimerCallBack(Callable endCallback, Callable tickCallback, int Intervall){
        tickInterval=Intervall;
       timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!isPaused) {
                    current--;

                    // sau tickInterval giây, sẽ gọi 1 lần tick-callback
                    if (tickCallback != null && (timeLimit - current) % tickInterval == 0) {
                        try {
                            executor.submit(tickCallback);
                        } catch (Exception ex) {
//                            Logger.getLogger(Caro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    // khi đếm ngược tới 0 sẽ gọi end-callback
                    if (current <= 0) {
                        try {
                            if (endCallback != null) {
                                executor.submit(endCallback);
                            }
                            executor.shutdown();
                        } catch (Exception ex) {
//                            Logger.getLogger(Caro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        timer.cancel();
                        timer.purge();
                    }
                }
            }
        }, 0, 1000);
    }
     public int getCurrentTick() {
        return current;
    }

    public void setCurrentTick(int currentTick) {
        this.current = currentTick;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getTickInterval() {
        return tickInterval;
    }

    public void setTickInterval(int tickInterval) {
        this.tickInterval = tickInterval;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
