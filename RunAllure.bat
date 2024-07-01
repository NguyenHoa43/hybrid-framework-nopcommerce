set ProjectPath=%~dp0
cd %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.9.8.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libAllure\*;%ProjectPath%libExtentV5\*;%ProjectPath%libraryLog4J\*;%ProjectPath%libraries\*;%ProjectPath%libraryReportNG\*;%ProjectPath%librarybWebDriverManager\*" org.testng.TestNG "%ProjectPath%bin\runJQueryUpload.xml"
pause