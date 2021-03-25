public class MyThread extends Thread {
    float[] arr;

    public MyThread(float[] arr) { ;
        this.arr = arr;
    }

    @Override
    public void run() {
        long a = System.currentTimeMillis();
        System.out.println("Запущен поток " + MyThread.currentThread().getName());
        CalculateArray.calculate(arr);
        System.out.println(MyThread.currentThread().getName() + " закончил вычисления за " + (System.currentTimeMillis() - a) + " мс");
    }
}
