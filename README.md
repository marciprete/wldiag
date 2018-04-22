# WLDiag - WebLogic Diagnostic Images Analyzer

## WARNING 
This project is a work-in-progress and is in alpha version. 

### Purpose
WLDIag is an Angular 5 - Spring web application, whose purpose is to aggregate WLS diagnostic images files information 
and present it with tables and charts.

Informamtion about weblogic diagnostic framework (wldf) and diagnostic images are available on the Oracle website.
https://docs.oracle.com/cd/E13222_01/wls/docs100/wldf_configuring/config_diag_images.htm

### Prerequisites
MySQL v5.6+ is required to store diagnostic images data

### Note
Currently, the application analyzes only a subset of the diagnostic image files contained within the Zip file, that is:
* JTA.xml
* JVM.xml
* JDBC.txt
* WORK_MANAGER.txt
