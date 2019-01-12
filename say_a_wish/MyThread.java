package say_a_wish;

public class MyThread extends Thread {
    int i = 0;
    public void run(){
        try {
            sleep(5000);
            i++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public void access(){
        if(i!=0){
            System.out.println("Sorry, you've been thinking for a long time\n");
        }else{
            System.out.println("Maybe you get it");

        }
    }
}

