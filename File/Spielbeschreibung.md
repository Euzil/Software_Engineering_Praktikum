# Anforderungen

Im diesjährigen Software-Engineering Praktikum soll das PC-Spiel **Terror Nightmare Towers (TNT)** entwickelt werden.

Entwickelt werden soll ein PC-Spiel basierend auf dem Regelwerk des Brettspiels "**Santorini**" mit einem Zombie/Horror Thema. Das Regelwerk des Brettspiels ist im Moodle zu finden.

Bei dem Spiel soll es möglich sein, gegeneinander als auch gegen den Computer zu spielen.

Das Spiel soll dafür über eine grafische Benutzerschnittstelle verfügen. 

Dafür müssen eine Reihe von **Pflicht-**, **Wahl-** und **Zusatzfeatures** implementiert werden (genaue Beschreibung weiter unten). Das Spiel soll in englischer Sprache umgesetzt werden. Die Entwicklung soll sich dabei in drei Releases gliedern.

Ab Release 2 muss ein auslieferbares Produkt existieren. Dies umfasst neben einem lauffähigen Programm auch eine vollständige Dokumentation von Programm und Code, als auch hinreichende Abdeckung der Programmfunktionalität durch Tests.

Im Folgenden werden die Pflicht und Wahlfeatures näher erläutert.


# Pflichtfeatures

## Grundlegende Spielfunktionalitäten

Das Spiel kann von 2 menschlichen und/oder Computer-Spielern gespielt werden.

Das Spielfeld wird dargestellt.

Figuren können ausgewählt und den Spielregeln entsprechend bewegt werden. Anschließend kann ein Gebäude(teil) den  Regeln entsprechend errichtet werden. 

Das Spiel endet den Regeln entsprechend. 

Am Ende des Spiels wird der Sieger ermittelt und den Spielern angezeigt.


## GUI-basiertes Frontend

 1. Die GUI passt Thematisch zu dem Zombie/Horror-Theme des Spiels.
 2. Zu Programmstart kann gewählt werden, wie viele Spieler am Spiel teilnehmen (wenn als Wahlfeature implementiert) und welcher Spieler von dem Computer oder einem Menschen gespielt wird.
 3. Die GUI zeigt das Spielfeld in der Draufsicht (Thema des Spiels beachten). Die Figuren und Bauwerke sind durch sinnvolle Symbole oder Grafiken dargestellt.
 4. Das Spiel ist mit der Maus spielbar.
 5. Das Spiel zeigt den aktiven Spieler an bzw. highlightet die eigenen Figuren 
 6. Ungültige Zugversuche werden ignoriert. 
 7. Das Programm endet, wenn ein Spieler gewinnt, bzw. alle anderen verlieren.
 8. Am Ende des Spielt wird der Gewinner hervorgehoben.
 9. Es kann jederzeit zum Auswahlbildschirm des Spiels zurückgekehrt werden und von dort aus ein neues Spiel begonnen werden.

## Spiel gegen den Computer

Für das Spiel gegen den Computer, soll der Computer aus allen Zügen, die er aktuell ausführen kann, den wählen, der aktuell am sinnvollsten erscheint (Greedy Strategie o.Ä.). 

## Spiel gegen Menschliche Spieler

Die menschlichen Spieler wechseln sich Reihum an einem PC ab (Hot-Seat). Nach dem Zug eines Spielers zeigt das Programm an, wer als Nächstes an der Reihe ist.

# Wahlfeatures

### 3 Spieler Variante (5P.)

Zum Start des Spiels kann neben der Auswahl für menschliche und Computerspieler auch die Anzahl der Spieler eingestellt werden. Die 3 Spieler spielen ansonsten analog zu der 2 Spieler Variante.
(anders als in den offiziellen Regeln sind die Götterkarten hierfür keine Voraussetzung)

### 4 Spieler Variante (5P.)

Zum Start des Spiels kann neben der Auswahl für menschliche und Computerspieler auch die Anzahl der Spieler eingestellt werden. Die 4 Spieler spielen wie in den Regeln dargestellt in 2er-Teams. Die Teams gewinnen gemeinsam, bzw. verlieren gemeinsam, sobald ein Teammitglied verliert.

### Menüführung (1P.)

Nach dem Starten des Programms öffnet sich ein "Hauptmenü" in dem sich alle Untermenüs, Einstellungsoptionen, Möglichkeit ein spiel zu starten oder das Programm zu beenden befinden. Das Menü kann außerdem jederzeit aus dem laufenden Spiel aufgerufen und wieder geschlossen werden, ohne dass das laufende Spiel dadurch beendet wird. 

### Speichern/Laden (2P.)

Das aktuelle Spielfeld inklusive Kartenreihen, Handkarten, Ablagestapel, aktivem Spieler und Punkten kann in einer Datei gespeichert oder daraus geladen werden. Bezüglich des Speicherformats gibt es keine Vorgaben.

### Mehrsprachigkeit (1P.)

Von jeder Stelle im Spiel aus kann zwischen zwei oder mehr Sprachen gewechselt werden (z.B. über das Menü). 

### Resizeable GUI (2P.)

Das GUI-basierte Frontend lässt sich jederzeit auf eine beliebige Größe ziehen.

### Spielernamen und -farben (1P.)

Jedem Spieler (Mensch und Computer) kann ein Name und eine Farbe gegeben werden, die im Spiel angezeigt werden.

### High Score (2P.)

Die Anzahl benötigter Züge des Gewinners jeder Partie wird mit den aktuellen High Scores verglichen und, wenn ausreichend hoch, in die Bestenliste eingetragen. In der Bestenliste befinden sich die 3 besten Ergebnisse bestehend aus Zuganzahl, Spielernamen, und ob es sich um einen Menschlichen oder Computerspieler handelte. Der High-Score ist persistent über das Beenden des Spiels.

### Wählbares Terror Theme (3P.)

Es gibt wenigstens 2 Unterschiedliche grafische Themen (z.B. Untote, alles Blutig, etc.). Zwischen diesen Themen lässt sich vor und während des Spiels das Aussehen des Spiels verändern (z.B. über das Menü).

### Anzahl der Bausteine wählbar (2P.)

Vor dem Spiel kann ausgewählt werden, wie viele Bausteine (Kuppel und Level 1-3) es gibt. Das Spiel kann demnach früher/später dadurch enden, dass ein Spieler nicht mehr Bauen kann.


### Kompetente KI (3P.)

Bei der Wahl eines Computerspielers kann man dessen Spielstärke einstellen. Ein starker Computerspieler sollte versuchen möglichst schnell zu gewinnen, wenn er der Meinung ist, vor allen anderen Mitspielern gewinnen zu können, und ansonsten versuchen die anderen Spieler zu behindern.


### Anzahl der Arbeiter wählbar (3P.)

Vor Spielstart kann ausgewählt werden, wie viele Arbeiter jeder Spieler zur Verfügung hat.


### Größe des Spielfeldes Wählbar (2P.)

Die Größe des Spielfeldes kann vor Spielbeginn festgelegt werden. 

### Die Welt ist eine "Kugel" (3P.)

Arbeiter können das Spielfeld am Rand verlassen und dafür das entsprechende Feld am gegenüberliegenden Rand betreten.

### Macht der Götter Simple (1P. je 2 Götterkarten, Max 5 Punkte)

Die Spielvariante "Macht der Götter" kann den Regeln entsprechend gewählt werden. Je 2 vollständig und richtig implementierter "Simple Gods" Götter gibt es einen Punkt.

### Macht der Götter Advanced (1P. je 4 Götterkarten, Max 5 Punkte)

Die Spielvariante "Macht der Götter" kann den Regeln entsprechend gewählt werden. Je 4 vollständig und richtig implementierter "Advanced Gods" Götter gibt es einen Punkt.