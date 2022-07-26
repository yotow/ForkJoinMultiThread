import java.util.Random;

public class ArrayCalcService {

    private int[] array;

    private int[] genArray(int count) {
        int[] array = new int[count];

        for (int i = 0; i < count; i++) {
            Random random = new Random();
            array[i] = random.nextInt(5);
        }
        return array;
    }

    public int[] getArray(int count) {
        if (array != null && array.length == count) {
            return array;
        }
        return genArray(count);
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public long calcSum(int[] array) {
        long start = System.currentTimeMillis();

        var res = 0;
        for (int i :
                array) {
            res = res + i;
        }

        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, 1 thread мс: " + elapsed);

        return res;
    }

    public double average(int[] array){
        var sum = calcSum(array);
        return sum/(double)array.length;
    }

    public long extCalcSum(int[] array){
        int res;

        long start = System.currentTimeMillis();
        res = new ArraySumTask(0, array.length, array).compute();
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, 1 thread мс: " + elapsed);

        return res;
    }

    public double extAverage(int[] array){
        var sum = new ArraySumTask(0, array.length, array).compute();
        return sum/(double)array.length;
    }
}
