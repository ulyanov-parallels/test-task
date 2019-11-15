**********************************************************************
Parallels_Test_Task  README

**********************************************************************

ДОПУЩЕНИЯ:

Windows7 Ultimate 64-bit

Java(TM) SE Runtime Environment (build 1.7.0_25-b15)
Java HotSpot(TM) 64-Bit Server VM (build 23.25-b01, mixed mode)

Eclipse Juno SR2 64-bit with TestNG installed

Selenium Java Client Driver 2.43.1
Internet Explorer Driver Server 32-bit (IEDriverServer.exe)
chromedriver 2.10 win32   (chromedriver.exe)


ИНСТРУКЦИЯ:

Добавить путь к папке с IEDriverServer.exe, chromedriver.exe (Например, C:\drivers) в Windows System Variable $PATH. Перезапустить Eclipse, если запущен.
Скопировать папку с исходниками Parallels_Test_Task в Eclipse workspace.
В Eclipse создать new JavaProject с именем Parallels_Test_Task.
В Project Properties > Java Build Path  > Add Library добавить TestNG.
В Project Properties > Java Build Path > Add External JARs добавить Selenium JARs (Selenium Java Client Driver 2.43.1 из корневой папки и из libs).
Запустить Main.java : Run > as Java Application (Можно остановить выполнение зразу после запуска).

Компиляция в Eclipse: 
File > Export > Java > Runnable JAR > 
выбрать Launch Configuration: Main-Parallels_Test_Task;
задать Export Destination (Например, C:\Parallels_Test_Task\test.jar); 
выбрать Library handling: Copy required libraries into a sub-folder next to the generated JAR;

Скопировать папки data и config из исходников в папку Export Destination.
В файле data\global_config.properties задать браузер (ff, gc, ie).
Скопировать файл run.bat в папку Export Destination.
В файле run.bat установить актуальный путь к скомпилированному JAR.

Запуск:
Двойным кликом на run.bat. 
Из Eclipse: проект - Run as TestNG test. 

Замечание: 
При ассертах могут быть паузы ожидания (20 сек).

Enjoy!
