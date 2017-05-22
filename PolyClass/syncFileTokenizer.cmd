SET myFileName=FileTokenizer.java
SET myCurrentDir=src\com\zalgebar
SET myTargetDir=..\..\FileCreator\src\com\zalgebar
SET myCurrentFile=%myCurrentDir%\%myFileName%
SET myTargetFile=%myTargetDir%\%myFileName%

IF NOT EXIST %myCurrentFile% GOTO logCurrent
FOR %%f IN (%myCurrentFile%) DO SET currentDate=%%~tf

IF NOT EXIST %myTargetFile% GOTO logTarget
FOR %%f IN (%myTargetFile%) DO SET targetDate=%%~tf

For /F "Delims=" %%I In ('xcopy /DHYL %myCurrentFile% %myTargetFile% ^|Findstr /I "File"') Do set /a _Newer=%%I 2>Nul

IF %_Newer%==1 GOTO currentIsNewer
GOTO currentIsOlder
exit

:logCurrent
ECHO File doesn't exist in current directory.
GOTO currentIsOlder

:logTarget
ECHO File doesn't exist in target directory.
GOTO currentIsNewer

:currentIsNewer
ECHO Current is newer than target.
xcopy /y /s "%myCurrentFile%" "%myTargetDir%"
pause
exit

:currentIsOlder
ECHO Current equal or older than target.
xcopy /y /s "%myTargetFile%" "%myCurrentDir%"
pause
exit
