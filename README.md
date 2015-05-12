# fuse-openjpa-persistence
OSGi Sample Projects
This is the sample OSGi implementation project using JBoss Fuse.

Build the project using the following maven command.

<code>
$ mvn clean install
</code>

Start the Fuse Container using the following command.

<code>
$ ./fuse.sh
</code>

In the windows environment, use fuse.bat alternately.

Add the Features URL as given below.

<code>
$ features:addurl mvn:com.scb.rdm/rdm-features/1.0.0/xml/features
</code>

Install the rdm-features using the following command.

<code>
$ features:install rdm-features
</code>

Verify if the rdm-rest bundle is installed, resolved, started and activated.

To view the deployed CXF services, launch the following URL:

<code>
http://localhost:8181/cxf
</code>
