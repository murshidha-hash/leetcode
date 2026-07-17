class ZeroEvenOdd {
    private int n;
    private Semaphore sem1=new Semaphore(1);
    private Semaphore sem2=new Semaphore(0);
    private Semaphore sem3=new Semaphore(0);

    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n;i++){
            sem1.acquire();
            printNumber.accept(0);
            if(i%2!=0){
                sem2.release();
            }else{
                sem3.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++){
            if(i%2==0){
                sem3.acquire();
                printNumber.accept(i);
                sem1.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++){
            if(i%2!=0){
                sem2.acquire();
                printNumber.accept(i);
                sem1.release();
            }
        }
    }
}