Feature: partita completa HW4
#simula una partita completa
  @testBuilder
  Scenario: Labirinto completo
  	Given carico un labirinto completo per testare una partita HW4
  	And carico il comando "prendi torcia"
  	And carico il comando "vai est"
  	And carico il comando "saluta mago"
  	And carico il comando "interagisci"
  	And carico il comando "prendi ottocsib"
  	And carico il comando "vai est"
  	And carico il comando "posa ottocsib"
  	And carico il comando "guarda"
  	And carico il comando "prendi ottocsib"
  	And carico il comando "posa ottocsib"
  	And carico il comando "prendi ottocsib"
  	And carico il comando "posa ottocsib"
  	And carico il comando "prendi biscotto"
  	And carico il comando "vai est"
  	And carico il comando "regala biscotto"
  	And carico il comando "vai est"
  	And carico il comando "posa torcia"
  	And carico il comando "vai est"
  	And carico il comando "interagisci"
  	And carico il comando "vai est"
  	And carico il comando "posa chiave"
  	And carico il comando "vai est"
  	And il gioco e stato avviato
   	Then hai vinto la partita