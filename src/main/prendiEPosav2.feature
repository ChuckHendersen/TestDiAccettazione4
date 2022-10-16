#scenario di testing che verifica il funzionamento dei comandi "prendi" e "posa"
Feature: test di prendi e posa

	@testPrendiEPosa
	Scenario: Labirinto di default con osso in atrio
		Given carico il comando "guarda"
		And carico il comando "prendi osso"
		And carico il comando "guarda"
		And carico il comando "posa osso"
		And carico il comando "guarda"
		And il gioco e stato avviato 
		Then controllo che "osso" viene preso e posato
