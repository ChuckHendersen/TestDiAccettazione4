package main;

public class Starter {
	
	public static void main(String[] args) throws Throwable {
		//Controlla cosa è presente nel classpath
		
//		ClassLoader cl = ClassLoader.getSystemClassLoader();
//        URL[] urls = ((URLClassLoader)cl).getURLs();
//        for(URL url: urls){
//        	System.out.println(url.getFile());
//        }
		System.out.println("Test preliminari in avvio...");
		Controllore c = new Controllore();
		if(c.controlliPrimaDellaConsegna()){
			System.out.println("Test preliminari passati con successo!");
			System.out.println("Test di accettazione in avvio...");
			Thread threadCucumber = new Thread(new RunnableCucumber());
			threadCucumber.start();
			threadCucumber.join();
			if(!threadCucumber.isAlive()) {
				System.out.println("Test di Accettazione arrestati");
			}else {
				System.out.println("Errore nel thread del test di accettazione");
			}
		}else{
			System.out.println("ATTENZIONE! uno o piu' dei controlli prima della consegna "
					+ "non e' andato a buon fine,\nsistemare gli errori prima di poter avviare "
					+ "i test di accettazione. Buon lavoro!");
		}
		System.out.println("Chiusura programma.");
	} 
}
