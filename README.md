# fuse-openjpa-persistence
OSGi Sample Projects
This is the sample OSGi implementation project using JBoss Fuse.

Build the project using the following maven command.

<code>
$ mvn clean install
</code>
Start the Fuse Container using the following command.

$ ./fuse.sh

In the windows environment, use fuse.bat alternately.

Add the Features URL as given below.

$ features:addurl mvn:com.scb.rdm/rdm-features/1.0.0/xml/features

Install the rdm-features using the following command.

$ features:install rdm-features

Verify if the rdm-rest bundle is installed, resolved, started and activated.

To view the deployed CXF services, launch the following URL:

http://localhost:8181/cxf
