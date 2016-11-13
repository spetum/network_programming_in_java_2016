public class ThreadFailOver implements Runnable {
	private String greeting ;
	
	public ThreadFailOver(String greeting)
	{
		this.greeting = greeting ;
	}
	public void run() {
//		for (;;) {
			System.out.println(Thread.currentThread().getName() + ": " + greeting);
			try {
				Thread.sleep((long)(Math.random()*100));
			} catch (InterruptedException e ) {} 
//		} // end of for(;;)
	} // end of run
	public static void main(String[] args) {
		new Thread(new ThreadFailOver("Hello")).start();
		new Thread(new ThreadFailOver("Aloha")).start();
		new Thread(new ThreadFailOver("Ciao")).start();
	} // end of main
} // end of class