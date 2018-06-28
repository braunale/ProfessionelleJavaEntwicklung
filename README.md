README

This simple weatherApplication is the final task of the subject "Professionelle Java Entwicklung" at University of Albstadt-Sigmaringen. 
The Web Application was created with Maven. 
The code and all ressource files are checked with mvn checkstyle, mvn findbugs and mvn pmd. 
The functionality of the app was tested with unittests and mockito-tests which can be run with "mvn test".

USAGE OF THE APP
Open a terminal in the project root directory and start the jetty server with "mvn jetty:run"
Type "http://localhos:8080/WeatherApplication/WeatherServlet?town=[your_town]" in your browser
The weather forcast for the next days for the given town is showed in a xml format. 

