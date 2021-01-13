

del *.class

javac ^
	-cp C:\temp2\apache-tomcat-9.0.37\lib\servlet-api.jar ^
	HelloServlet*.java
	
	
REM globbing	



:  rm -f *.class

:: javac \
::	-cp C:\temp2\apache-tomcat-9.0.37\lib\servlet-api.jar: \
::	HelloServlet*.java
	
:: # globbing	
