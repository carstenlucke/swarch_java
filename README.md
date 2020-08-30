# VL SW-Arch
Dieses Projekt enthält den Quellcode für die Java-basierten Übungen in der Veranstaltung "SW-Architektur". Das Projekt wurde in IntelliJ entwickelt.

Das Projekt enthält eine Docker-Konfiguration (`Dockerfile`). Falls Sie auf Ihrem Rechner ein Java-SDK installiert haben, dann benötigen Sie den Container nicht. Sie können Ihn aber trotzdem benutzen.

Die vorhandenen Module sind: 

- swarch-sockets

## Allgemeine Hinweise
Teilweise müssen Sie Quellcode komplett neu schreiben, teilweise gibt es aber auch schon vorhandene Klassen und Interfaces, welche Sie anpassen sollen. Im letzteren Fall sind i.d.R. Stellen im Code mit TODO-Markern versehen. Hier sollen Sie Änderungen vornehmen. Es gibt einen View „TODO“, wo solche zu erledigende Aufgaben angezeigt werden. Sie finden die Ansicht im unteren Bereich von IntelliJ. Sollte diese nicht angezeigt sein, können Sie sie über den Shortcut `ALT + 6` oder über das Menü einblenden.

![](doc/img/todo%20markers.png)


## Übung zur Socket-Programmierung

Ziel der Übung ist die Erstellung eines Echo-Servers und eines dazugehörigen Clients auf Basis von Sockets programmiert mit der Java Socket-API. 

Die grundlegende Funktionsweise ist im Rahmen der Vorlesung besprochen worden. Das Serverprogramm wird an einen TCP-Port des Rechners gebunden (Hostname und Port machen einen „Endpoint“ aus) und wartet auf eingehende Verbindungen. Stellt ein Client eine Verbindungsanfrage wird eine Verbindung aufgebaut – man spricht von einer Endpoint-Connection. Über diese Endpoint-Connection können sodann Daten übertragen werden. Der EchoServer liest jeweils eine Zeile des Clients und sendet die identische Zeichenfolge an diesen zurück – das Echo.

Lesen Sie die Informationen unter [SP.1] und programmieren Sie zunächst den Serverteil des Socket-Servers. Das Vorgehen wird auf der Website beschrieben. 
Wenn Sie den Server programmiert und gestartet haben, dann können Sie diesen testen. Starten Sie ein Terminal und verbinden Sie sich mittels `telnet` mit dem Server-Endpoint (siehe folgende Abbildung). 


![](doc/img/sockets-terminal.png)


**Optional:** Wenn lokal alles funktioniert, stimmen Sie sich mit einem Kommilitonen ab und stellen eine Remote-Verbindung von einem anderen Rechner mit Ihrem Echo-Server her. 
 
### Docker-Kommandos
Voraussetzung ist, dass Sie Docker lokal auf Ihrem Rechner installiert haben.

- Docker-Container bauen: `$ docker build -t swarch_java .`
- Docker-Container starten und auszuführende Java-Klasse (Echo-Server) angeben: `$ docker run -it -p 9999:9999 swarch_java de/thm/swarch/sockets/echoserver/EchoServer 9999`, startet den EchoServer auf Port `9999` und macht den Container-Port auf dem Host verfügbar 
- EchoClient starten: `$ docker run -it swarch_java de/thm/swarch/sockets/echoclient/EchoClient host.docker.internal 9999`. Der Client darf sich nicht zu `localhost`verbinden, da dies der Docker-Container ist. Der Server, wenn wie oben angegeben gestartet, bindet das Socket aber an den Host-Rechner, nicht im Container. Der Hostname, um aus einem Container an den Hostrechner zu verbinden, ist `host.docker.internal`. 
- Terminal im laufenden Docker-Container starten: `$ docker exec -it <CONTAINER-ID> /bin/bash`
- Docker-Prozesse anzeigen: `$ docker ps`, um die Container-ID zu identifizieren
 
 
### Mehrere Clients ...
Wenn Sie sich an das Beispiel der oben genannten URL gehalten haben, werden Sie feststellen, dass Ihr Echo-Server nur jeweils eine Client-Verbindung verarbeiten kann. 
Das ServerSocket ist grundsätzlich in der Lage mehrere EndpointConnections anzunehmen. Die eingehenden Verbindungsanfragen werden nacheinander verarbeitet. Bei zwei oder mehr Verbindungsanfragen, muss die Verbindungsannahme und die Kommunikationsverarbeitung mit dem Client auf Threads übertragen werden. D.h. es gibt einen Serverprozess, welcher auf eingehende Verbindungen horcht und je Client einen Thread, der durch Verbindungsannahme die Referenz auf ein Socket erhält und sich um die Abwicklung der eigentlichen Kommunikation kümmert. Wie dies implementiert wird, ist unter [SP.2] im Abschnitt „Supporting Multiple Clients“ beschrieben. Versuchen Sie Ihr Glück!
Wenn alles korrekt implementiert ist, kann Ihr Echo-Server nun eine Vielzahl von Clients gleichzeitig bedienen. Testen Sie dies erneut mittels telnet.

### Lang-laufende Anfragen
Die Anfragen an den Echo-Server werden synchron bearbeitet. Das bedeutet, dass der Client auf eine Antwort des Servers wartet, auch wenn dies sehr lang dauert. Währenddessen ist der Client blockiert. 

Um dies zu simulieren können Sie mit Thread.sleep(2000) die Abarbeitung im Echo-Server verzögern, sodass der Client etwas auf das Echo warten muss.
Über synchrone und asynchrone Kommunikationsmodelle werden wir im weiteren Verlauf der Vorlesung noch sprechen.

### Zusatzaufgabe
Programmieren Sie optional einen Echo-Client als Java-Applikation für die Kommandozeile.

### Quellen zur Aufgabe 
[SP.1] https://docs.oracle.com/javase/tutorial/networking/sockets/index.html

[SP.2] https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
