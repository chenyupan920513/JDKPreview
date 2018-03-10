package jvm.gc;

/**
 * @Author pierre 18-2-27
 */
public class JavaVmStackOOM {

	private void dontStop() {
		while (true) {

		}
	}


	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String[] args) {
		JavaVmStackOOM oom = new JavaVmStackOOM();
		oom.stackLeakByThread();
	}
}
