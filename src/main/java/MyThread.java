public class MyThread extends Thread {
    float[] arr;
    int startingIndex;

    public MyThread(float[] arr, int startingIndex) { ;
        this.arr = arr;
        this.startingIndex = startingIndex;
    }

    @Override
    public void run() {
        long a = System.currentTimeMillis();
        System.out.println("Запущен поток " + MyThread.currentThread().getName());
        CalculateArray.calculate(arr, startingIndex);
        System.out.println(MyThread.currentThread().getName() + " закончил вычисления за " + (System.currentTimeMillis() - a) + " мс");
    }
}
