import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;
    static final int RALF = SIZE / 4;


    public static void main(String[] args) {

        computationInOneThread();

        try {
            MyThread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        computationInTwoThread();
    }

    public static void computationInOneThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        System.out.println("Начало вычисления в однопоточном режиме");

        long a = System.currentTimeMillis();
        CalculateArray.calculate(arr);

        System.out.println("Время вычисления в однопоточном режиме: " + (System.currentTimeMillis() - a) + " мс");
        resultCalculate(arr,10);
        System.out.println();
    }

    private static void computationInTwoThread() {
        float[] arr = new float[SIZE];
        float[] tempArr1 = new float[HALF];
        float[] tempArr2 = new float[HALF];

        Arrays.fill(arr, 1);

        System.out.println("Начало вычисления в многопоточном режиме");
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, tempArr1, 0, HALF);
        System.arraycopy(arr, HALF, tempArr2, 0, HALF);

        MyThread myThread = new MyThread(tempArr1);
        MyThread myThread1 = new MyThread(tempArr2);
        myThread.setName("Поток №1");
        myThread1.setName("Поток №2");
        myThread.start();
        myThread1.start();
        try {
            myThread.join();
            myThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(tempArr1, 0, arr, 0, HALF);
        System.arraycopy(tempArr2, 0, arr, HALF, HALF);

        System.out.println("Время вычисления в многопоточном режиме: " + (System.currentTimeMillis() - a) + " мс");
        resultCalculate(arr,10);
    }

    private static void resultCalculate(float[] arr, int i) {
        System.out.println("Результат вычисления первых " + i + " элементов: ");
        System.out.print("[");
        for (int j = 0; j < i; j++) {
            System.out.print(arr[j]);
            if(j != i - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }
}
