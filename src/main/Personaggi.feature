#Controllo delle funzioni dei personaggi
Feature: Verifica funzionalita personaggi
	
	#Il mago dovrebbe ridare l'attrezzo regalato al giocatore e dimezzarne il peso
	@TestMagoRegalo
	Scenario: Test funzionalita regalo mago
		Given un monolocale con personaggio "Mago" e con un attrezzo "spada" di peso "4"
		And carico il comando "guarda"
		And carico il comando "prendi spada"
		And carico il comando "regala spada"
		And carico il comando "guarda"
		And il gioco e stato avviato
		Then verifico che il personaggio "Mago" posi nella stanza "spada" di peso "2"
	
	#Dovrebbe regalare un attrezzo specificato
	@TestMagoRegalo
	Scenario: Test funzionalita interazione mago
		Given un monolocale con personaggio "Mago" che posi nella stanza "chiave" di peso "2" dopo averci interagito
		And carico il comando "interagisci"
		And carico il comando "guarda"
		And il gioco e stato avviato
		Then verifico che il personaggio "Mago" posi nella stanza "chiave" di peso "2"
	
	#La strega se non salutata dovrebbe teletrasportarti nella stanza adiacente con meno oggetti all'interno
	@TestStregaInterazioneNonSalutata
	Scenario: Test funzionalita interazione strega non salutata
		Given un trilocale con personaggio Strega con stanze adiacenti con numeri diversi di attrezzi
		And carico il comando "guarda"
		And carico il comando "interagisci"
		And carico il comando "guarda"
		And il gioco e stato avviato
		Then verifico lo spostamento da "stanza con strega" a "zero attrezzi" verso "nord"
		
	#La strega se non salutata dovrebbe teletrasportarti nella stanza adiacente con piu' oggetti all'interno
	@TestStregaInterazioneSalutata
	Scenario: Test funzionalita interazione strega salutata
		Given un trilocale con personaggio Strega con stanze adiacenti con numeri diversi di attrezzi
		And carico il comando "saluta"
		And carico il comando "guarda"
		And carico il comando "interagisci"
		And carico il comando "guarda"
		And il gioco e stato avviato
		Then verifico lo spostamento da "stanza con strega" a "un attrezzo" verso "est"
		
	#se si interagisce con il cane, dovrebbe levarti CFU e portare alla morte del personaggio
	@TestCaneInterazioneAttacco
	Scenario: Test funzionalita di attacco del cane
		Given un monolocale con personaggio "Cane" 
		And carico il comando "interagisci" per "21" volte
		And il gioco e stato avviato
		Then viene mostrato il messaggio di morte
		And il gioco si chiude
		
	#dando qualcosa al cane, lui in cambio svela un oggetto
	@TestCaneRegalo
	Scenario: Test di funzionalita regalo al cane
		Given un monolocale con personaggio "Cane" a cui piace il "biscotto" e in cambio da una "spada" di peso "2"
		And carico il comando "prendi biscotto"
		And carico il comando "regala biscotto"
		And il gioco e stato avviato 
		Then verifico che il personaggio "Cane" posi nella stanza "spada" di peso "2"