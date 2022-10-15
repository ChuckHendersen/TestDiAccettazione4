package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Controllore {
	public boolean controlloMetodiBorsa() {
		String nomeAtteso = "it.uniroma3.diadia.giocatore.Borsa";
		System.out.println("daje");
		try {
			Class<?> classeDaControllare = Class.forName(nomeAtteso);
			Method[] metodiDaControllare = classeDaControllare.getDeclaredMethods();
			Boolean trovatoGetContenutoOrdinatoPerPeso= false;
			Boolean trovatoGetContenutoOrdinatoPerNome= false;
			Boolean trovatoGetContenutoRaggruppatoPerPeso= false;
			Boolean trovatoSortedSetOrdinatoPerPeso = false;
			for(Method method : metodiDaControllare) {
				if(method.getName().equals("getContenutoOrdinatoPerPeso")) {
					trovatoGetContenutoOrdinatoPerPeso= true;
				}
				if(method.getName().equals("getContenutoOrdinatoPerNome")) {
					trovatoGetContenutoOrdinatoPerNome= true;
				}
				if(method.getName().equals("getContenutoRaggruppatoPerPeso")) { 
					trovatoGetContenutoRaggruppatoPerPeso= true;
				}
				if(method.getName().equals("getSortedSetOrdinatoPerPeso")) {
					trovatoSortedSetOrdinatoPerPeso= true;
				}
			}
			if(trovatoGetContenutoOrdinatoPerPeso) {
				System.out.println("Ok! Esiste getContenutoOrdinatoPerPeso");
			}
			else { 
				System.out.println("Attenzione! Non esiste  il metodo getContenutoOrdinatoPerPeso");
			}
			if(trovatoGetContenutoOrdinatoPerNome) {
				System.out.println("Ok! Esiste getContenutoOrdinatoPerNome");
			}
			else { 
				System.out.println("Attenzione! Non esiste  il metodo getContenutoOrdinatoPerNome");
			}
			if(trovatoGetContenutoRaggruppatoPerPeso) {
				System.out.println("Ok! Esiste getContenutoRaggruppatoPerPeso");
			}
			else { 
				System.out.println("Attenzione! Non esiste  il metodo getContenutoRaggruppatoPerPeso");
			}
			if(trovatoSortedSetOrdinatoPerPeso) {
				System.out.println("Ok! Esiste getSortedSetOrdinatoPerPeso");
			}
			else { 
				System.out.println("Attenzione! Non esiste  il metodo getSortedSetOrdinatoPerPeso");
			}
			return trovatoGetContenutoOrdinatoPerNome&&trovatoGetContenutoOrdinatoPerPeso&&trovatoGetContenutoRaggruppatoPerPeso&&trovatoSortedSetOrdinatoPerPeso;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Borsa non esiste, e' stata chiamata diversamente o e' nel package sbagliato.\n");
			return false;
		}


	}

	public boolean esisteLabirintoBuilder() {
		String nomeAtteso = "it.uniroma3.diadia.ambienti.Labirinto$LabirintoBuilder";
		try {
			@SuppressWarnings("unused")
			Class<?> classeDaControllare = Class.forName(nomeAtteso);
			System.out.println("OK! Esiste la classe LabirintoBuilder");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione, la classe LabirintoBuilder non e' implementata, ha un nome diverso o e' nel paclage sbagliato!");
			return false;
		}	
	}


	//NON IMPLEMENTABILE CON RIFLESSIONE ???
	@SuppressWarnings("unused")
	public boolean testDiUnitaLabirintoBuilder() {
		Class<?> labBuilderClass = null;
		try {
			labBuilderClass=Class.forName("it.uniroma3.diadia.ambienti.Labirinto$LabirintoBuilder");
			Constructor<?> costruttoreLabBuilder = null;
			costruttoreLabBuilder = labBuilderClass.getConstructor();
			//Utilizziamo questa mappa per facilitare l'accesso ai metodi nei test
			Method addStanzaIniziale = labBuilderClass.getMethod("addStanzaIniziale",String.class);
			Method addStanzaVincente = labBuilderClass.getMethod("addStanzaVincente",String.class);
			Method addStanza = labBuilderClass.getMethod("addStanza",String.class);
			Method addStanzaMagica = labBuilderClass.getMethod("addStanzaMagica", String.class,int.class);
			Method addStanzaBloccata = labBuilderClass.getMethod("addStanzaBloccata", String.class, String.class, String.class);
			Method addStanzaBuia = labBuilderClass.getMethod("addStanzaBuia", String.class, String.class);
			Method addAdiacenza = labBuilderClass.getMethod("addAdiacenza",String.class,String.class,String.class);
			Method addAttrezzo = labBuilderClass.getMethod("addAttrezzo",String.class,int.class);
			Method getLabirinto = labBuilderClass.getMethod("getLabirinto");
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Test di esistenza metodi di LabirintoBuilder non superati con successo.");
			System.out.println("Assicurarsi dell'esistenza della classe LabirintoBuilder e che i suoi metodi siano chiamati appropriatamente.");
			return false;
		}
		System.out.println("Ok! I metodi di LabirintoBuilder sono chiamati correttamente");
		return true;
	}

	public boolean esistenzaInterfaceIo(){
		String nomeAtteso = "it.uniroma3.diadia.IO";
		try {
			Class<?> classeIo= Class.forName(nomeAtteso);
			if(classeIo.isInterface()) {
				System.out.println("OK! Esiste l'interface IO.");
				classeIo.getMethod("leggiRiga");
				classeIo.getMethod("mostraMessaggio", String.class);
				return true;
			}else{
				throw new ClassNotFoundException();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! L'interface IO non esiste, o è stata chiamata diversamente oppure è nel package sbagliato. Assicurarsi che IO sia una interface e non una classe.");
		} catch (NoSuchMethodException e) {
			System.out.println("Attenzione! Non esiste il metodo leggiRiga() e/o mostraMessaggio(String msg) nell'interface.");
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean esistenzaBuilderDiadia() {
		Class<?> classeDiaDia;
		boolean risultato=false;
		try {
			classeDiaDia = Class.forName("it.uniroma3.diadia.DiaDia");
			for(Constructor<?> constructor : classeDiaDia.getDeclaredConstructors()) {
				if(constructor.getParameterCount()==1 && constructor.getParameterTypes()[0]== Class.forName("it.uniroma3.diadia.IO")) {
					risultato=true;
				}
			}
			if(risultato)
				System.out.println("OK! Esiste il costruttore di diadia richiesto.");
			else
				System.out.println("Attenzione! Non esiste il costruttore di DiaDia al quale si puo' passare l'IO.");
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! Non e' stata individuata nessuna classe DiaDia. Assicurarsi di aver esportato\nil proprio DiaDia in formato jar e di averlo posizionato nella cartella esatta.");
		}
		return risultato;
	}

	public boolean esisteLabirinto() {
		String nomeAtteso = "it.uniroma3.diadia.ambienti.Labirinto";
		try {
			@SuppressWarnings("unused")
			Class<?> classeLab= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Labirinto ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Labirinto non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean esisteStanza() {
		String nomeAtteso = "it.uniroma3.diadia.ambienti.Stanza";
		try {
			@SuppressWarnings("unused")
			Class<?> classeStanza= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Stanza ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Stanza non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean esisteAttrezzo() {
		String nomeAtteso = "it.uniroma3.diadia.attrezzi.Attrezzo";
		try {
			@SuppressWarnings("unused")
			Class<?> classeAttrezzo= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Attrezzo ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Attrezzo non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean esisteGiocatore() {
		String nomeAtteso = "it.uniroma3.diadia.giocatore.Giocatore";
		try {
			@SuppressWarnings("unused")
			Class<?> classeGiocatore= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Giocatore ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Giocatore non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean esisteBorsa() {
		String nomeAtteso = "it.uniroma3.diadia.giocatore.Borsa";
		try {
			@SuppressWarnings("unused")
			Class<?> classeBorsa= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Borsa ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Borsa non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean esisteComando() {
		String nomeAtteso = "it.uniroma3.diadia.comandi.AbstractComando";
		try {
			@SuppressWarnings("unused")
			Class<?> classeComando= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Comando ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Comando non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean esisteDiaDia() {
		String nomeAtteso = "it.uniroma3.diadia.DiaDia";
		try {
			@SuppressWarnings("unused")
			Class<?> classeDiadia= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste DiaDia ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe DiaDia non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}


	public boolean esistePartita() {
		String nomeAtteso = "it.uniroma3.diadia.Partita";
		try {
			@SuppressWarnings("unused")
			Class<?> classePartita= Class.forName(nomeAtteso);
			System.out.println("OK! Esiste Partita ed e' nel package corretto.");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Partita non esiste, e' stata chiamata diversamente o e' nel package sbagliato");
			return false;
		}
	}

	public boolean controlliPrimaDellaConsegna() {
		return this.esisteDiaDia()&&this.esistePartita()&&this.esisteLabirinto()&&
				this.esisteStanza()&&this.esisteGiocatore()&&this.esisteComando()&&
				this.esisteBorsa()&&this.esisteAttrezzo()&&this.esistenzaInterfaceIo()&&
				this.esistenzaBuilderDiadia()&&this.testDiUnitaLabirintoBuilder()&&
				this.esisteLabirintoBuilder()&&this.controlloMetodiBorsa();
	}
}

