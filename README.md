# AspectJ proxy in Spring boot #

This is an example for using AspectJ proxy under Spring Boot.

It user Spring Boot 2.2.2 version.

For compile you need com.sun:tools dependency.
Unfortunately JDK9+ don't have it.

## com.sun:tools ##

For compiling aspectJ you need com.sun:tools which is in the JDK until JDK8.

### JDK8 ###

If you use JDK8, you have it.

Use for compile that command: `mvn clean install -P JDK8`

### JDK9+ ###

If you use JDK 9+, you don't have it by default.

You have two options for compile it, but you need an JDK8 install too.

For both you need an tools.jar, which is in a JDK8. You can find it at the following path: `[JDK8_HOME]/lib/tools.jar`

Options:

- upload com.sun:tools to your repository (etc: nexus, artifactory)
- use it locally

You can find the JDK8 1.8.0_221 tools jar in the project `lib` folder.

#### upload com.sun:tools to your repository ####

If you choose this option, you have to upload you repository server the `[JDK8_HOME]/lib/tools.jar` with following data:

- group id: com.sun
- artifact id: tools
- version: your JDK8 version. Etc: `jdk1.8.0_221` 

After upload you need to change `tools.version` property in the `pom.xml` to your JDK8 version (etc: jdk1.8.0_221).

Example: `<tools.version>jdk1.8.0_221</tools.version>`

Use for compile that command: `mvn clean install -P FROM_REPOSITORY_JDK9+`

`FROM_REPOSITORY_JDK9+` profile is the default profile.

#### use it locally ####

If you use it locally, you need to change `jdk8.tools.jar.path` property

Example if your JDK8 install in `/opt/jdk/jdk1.8.0_221` change property: `<jdk8.tools.jar.path>/opt/jdk/jdk1.8.0_221</jdk8.tools.jar.path>` 

Use for compile that command: `mvn clean install -P LOCAL_JDK9+`

# Check working #

After run application you need to see in the log (the system out) the following lines:

`Allowed execution for execution(String hu.zsoltii.springboot.aspectj.example.data.Dao1.apple())`
`Allowed execution for execution(String hu.zsoltii.springboot.aspectj.example.data.Dao1.appleStatic())`

If you don't see these lines, aspectJ proxy isn't working

# Thank you #

for the original code to Zsolt Kepler