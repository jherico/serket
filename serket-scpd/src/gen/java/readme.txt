This source folder is only used to generate the java classes from the scpd 
description files.  it is not used for ordinary builds or at runtime.  It
depends on the Sun CodeModel project to execute and should not be included in 
your classpath unless you plan to manually place CodeModel on your classpath 
in your IDE.

Using these classes may cause some of the files in src/main/java to be 
overwritten.  You have been warned. 