
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.*;
import java.util.Scanner;
public class number {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        ForkJoinTask<Long> task = new SumTask(x,1,1000000000);
        Long result = ForkJoinPool.commonPool().invoke(task);
        /*for (long i = 1; i < 1000000000; i++) {
            if (contain(i, x)) ans += i;
        }*/
        System.out.println(result);
    }
}

class SumTask extends RecursiveTask<Long> {
    static final int THRESHOLD = 50;
    int start;
    int end;
    int x;
    SumTask(int x,int start, int end) {
        this.x = x;
        this.start = start;
        this.end = end;
    }
    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // 如果任务足够小,直接计算:
            long sum = 0;
            for (int i = start; i < end; i++) {
                if (contain(i, x)) sum += i;
            }
            return sum;
        }
        // 任务太大,一分为二:
        int middle = (end + start) / 2;
        SumTask subtask1 = new SumTask(x,start,middle);
        SumTask subtask2 = new SumTask(x, middle, end);
        invokeAll(subtask1, subtask2);
        Long subresult1 = subtask1.join();
        Long subresult2 = subtask2.join();
        return subresult1 + subresult2;
    }
}

