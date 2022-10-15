package main;

public class RunnableCucumber implements Runnable{

	@Override
	public void run() {
		io.cucumber.core.cli.Main.main(new String[]{"-g", "classpath:"});
	}

}
