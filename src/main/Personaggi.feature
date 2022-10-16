#Controllo delle funzioni dei personaggi
Feature: Verifica funzionalita personaggi
	
	@TestMago
	Scenario: Test funzionalita mago
		Given un monolocale con personaggio "Mago" e con un attrezzo "spada" di peso "4"
		And carico il comando "regala spada"
		And il gioco e stato avviato
		Then verifico che il personaggio "Mago" dia al giocatore "spada" di peso "2"