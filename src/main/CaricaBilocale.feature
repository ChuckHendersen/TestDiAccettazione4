Feature: Iniezioni di labirinto
#Da utilizzare a partire dall'homework 3 in poi (Deve esistere la classe LabirintoBuilder)
  @testBuilder
  Scenario: Labirinto bilocale
  	Given carico un bilocale composto da "Stanza Iniziale" collegata a "nord" alla "Stanza Vincente"
  	Given carico il comando "guarda"
   	And carico il comando "vai nord"
   	And carico il comando "guarda"
   	And il gioco e stato avviato
   	Then verifico lo spostamento da "Stanza Iniziale" a "Stanza Vincente" verso "nord"
  	Then il gioco si chiude