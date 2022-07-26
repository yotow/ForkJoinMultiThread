import java.util.concurrent.RecursiveTask;

public class ArraySumTask extends RecursiveTask<Integer> {

    int start;
    int end;
    int[] array;

    public ArraySumTask(int start, int end, int[] array) {
        this.array = array;
        this.end = end;
        this.start = start;
    }

    @Override
    protected Integer compute() {
        int diff = end - start;
        switch (diff) {
            case 0:
                return 0;
            case 1:
                return array[start];
            case 2:
                return array[start] + array[start + 1];
            default:
                return forkTasksAndGetResult();
        }
    }

    private int forkTasksAndGetResult() {
        int middle = (end - start) / 2 + start;
        // Создаем задачу для левой части диапазона
        ArraySumTask task1 = new ArraySumTask(start, middle, array);
        // Создаем задачу для правой части диапазона
        ArraySumTask task2 = new ArraySumTask(middle, end, array);
        // Запускаем обе задачи в пуле
        invokeAll(task1, task2);
        // Суммируем результаты выполнения обоих задач
        return task1.join() + task2.join();
    }
}
