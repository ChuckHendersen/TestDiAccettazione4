#Controllo delle funzioni dei personaggi
Feature: Verifica funzionalita personaggi
	
	@TestMago
	Scenario: Test funzionalita mago
		Given un monolocale con "Mago"
		And carico il comando "saluta"
		And il gioco e stato avviato
		Then verifico che 