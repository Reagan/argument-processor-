This directory contains the %VERSION% release of arguments-processor. 

h1. Documentation 

arguments-processor is a java library that allows an application to extract start-up instructions. These instructions may be passed to the application as command-line arguments, properties in a properties file, XML tags and attribtes in an XML file or YAML code in a YAML file. These are all supported by the arguments-processor. 

In addition, a user may implement their own arguments processor by overriding the DefaultArgumentProcessor and implementing their own methods to read and extract the application start up arguments. 

h1. Downloading 

arguments-processor may be downloaded by cloning this git repo and making a build of the code to generate a jar file that may then be used in an application. This is the best way to get the nightly-build of the code. However a jar file of stable releases is also available in this git repo 


h1. Development 

arguments-processor is developed in java using IntelliJ-idea. The code is built using maven. You can obtain more information on the maven build tool at: 

http://maven.apache.org

h1. Installation 

Please read the file called INSTALL. Platform specific notes can be found in the README files.

h1. Licensing 

Please see a file called LICENSE 

h1. Contacts 

Reagan Mbitiru <reaganmbitiru@gmail.com> 

h1. Running the code 

One can use the arguments-processor using a combination of the factory and Builder design patterns i.e. 


