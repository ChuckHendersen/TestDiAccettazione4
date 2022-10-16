#Controllo delle funzioni dei personaggi
Feature: Verifica funzionalita personaggi
	
	#Il mago dovrebbe ridare l'attrezzo regalato al giocatore e dimezzarne il peso
	@TestMago
	Scenario: Test funzionalita mago
		Given un monolocale con personaggio "Mago" e con un attrezzo "spada" di peso "4"
		And carico il comando "guarda"
		And carico il comando "prendi spada"
		And carico il comando "regala spada"
		And carico il comando "guarda"
		And il gioco e stato avviato
		Then verifico che il personaggio "Mago" posi nella stanza "spada" di peso "2"