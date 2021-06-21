import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPrint {
	

	public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);
        int x = 0;
        while (x < 100) {
            service.submit(getTask("A ")).get();
            service.submit(getTask("B ")).get();
            service.submit(getTask("C ")).get();
            x++;
        }

        service.shutdown();
    }

    private static Callable<String> getTask(String task) {
        return () -> {
            System.out.print(task);
            return task;
        };
    }
}
