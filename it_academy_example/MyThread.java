package it_academy_example;

import static java.lang.Thread.sleep;

public class MyThread extends Thread {
    public boolean decrement;
    public boolean active;

   public MyThread(boolean decrement){
        this.decrement=decrement;
        this.active=true;
    }
    public void stopThread(){
       this.active=false;
    }
    @Override
    public void run() {

        int i = -1;
        if(this.decrement){
            i=10;
        }
        while (active){
           if(this.decrement){
               if(i<1){
                   break;
               }
               i--;
           }else {
               if(i>8){
                   break;
               }
               i++;
           }
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
