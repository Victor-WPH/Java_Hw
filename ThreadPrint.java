import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPrint {
	

	public static void main(String[] args) throws ExecutionException, InterruptedException {

	    ExecutorService service = Executors.newFixedThreadPool(3);
	    int x = 0;
	    while (x < 100) {
	        service.submit(() -> {
	            System.out.print("A ");
	            return "A";
	        }).get();

	        service.submit(() -> {
	            System.out.print("B ");
	            return "B";
	        }).get();

	        service.submit(() -> {
	            System.out.print("C ");
	            return "C";
	        }).get();

	        x++;
	    }

	    service.shutdown();
	}
}