**********************************************************************
Parallels_Test_Task  README

**********************************************************************

���������:

Windows7 Ultimate 64-bit

Java(TM) SE Runtime Environment (build 1.7.0_25-b15)
Java HotSpot(TM) 64-Bit Server VM (build 23.25-b01, mixed mode)

Eclipse Juno SR2 64-bit with TestNG installed

Selenium Java Client Driver 2.43.1
Internet Explorer Driver Server 32-bit (IEDriverServer.exe)
chromedriver 2.10 win32   (chromedriver.exe)


����������:

�������� ���� � ����� � IEDriverServer.exe, chromedriver.exe (��������, C:\drivers) � Windows System Variable $PATH. ������������� Eclipse, ���� �������.
����������� ����� � ����������� Parallels_Test_Task � Eclipse workspace.
� Eclipse ������� new JavaProject � ������ Parallels_Test_Task.
� Project Properties > Java Build Path  > Add Library �������� TestNG.
� Project Properties > Java Build Path > Add External JARs �������� Selenium JARs (Selenium Java Client Driver 2.43.1 �� �������� ����� � �� libs).
��������� Main.java : Run > as Java Application (����� ���������� ���������� ����� ����� �������).

���������� � Eclipse: 
File > Export > Java > Runnable JAR > 
������� Launch Configuration: Main-Parallels_Test_Task;
������ Export Destination (��������, C:\Parallels_Test_Task\test.jar); 
������� Library handling: Copy required libraries into a sub-folder next to the generated JAR;

����������� ����� data � config �� ���������� � ����� Export Destination.
� ����� data\global_config.properties ������ ������� (ff, gc, ie).
����������� ���� run.bat � ����� Export Destination.
� ����� run.bat ���������� ���������� ���� � ����������������� JAR.

������:
������� ������ �� run.bat. 
�� Eclipse: ������ - Run as TestNG test. 

���������: 
��� �������� ����� ���� ����� �������� (20 ���).

Enjoy!