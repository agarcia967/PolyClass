RD /s /q docs\
call "C:\Program Files\Java\jdk1.8.0_121\bin\javadoc.exe" -tag pre:cm:"Precondition:" -tag post:cm:"Postcondition:" -verbose -d ..\JavaDocs\ -sourcepath src\ -subpackages com.zalgebar
pause
