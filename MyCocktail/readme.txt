==================
== Installation ==
==================

1) Requirements
================
MyCocktail requires:
  * Servlet container (Apache Tomcat, Glassfish, JBoss, etc.)
  * Compatible Web browser: Mozilla Firefox, Opera, Chrome, or Safari. Internet Explorer (not fully compatible).
      * Flash plug-in installed in the web browser.

2) Deploy the WAR
==================
The MyCocktail distribution contains the WAR MyCocktail.war, it should be deployed in a Servlet Container.

3) Database
============
Enter in the "database" folder (in MyCocktail distribution) and launch this command:
./start-db.sh (Linux or MAC) start-db.bat (Windows)
To stop the database enter in the "database" folder and launch this command:
./stop-db.sh (Linux or MAC) stop-db.bat (Windows)

4) Run MyCocktail
==================
MyCocktail is published by the servlet container where you have made the deploy usually you can access to it these URLs:
  * MyCocktail Mashup Builder: http://<DOMAIN>/MyCocktail
  * MyCocktail Page Editor: http://<DOMAIN>/MyCocktail/editor.html
