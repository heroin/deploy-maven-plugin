deploy-maven-plugin
===================

maven deploy to linux plugin

##config pom.xml

    <build>
        <plugins>
            <plugin>
                <groupId>so.heroin.maven.plugins</groupId>
                <artifactId>deploy-maven-plugin</artifactId>
                <version>1.0.0.0</version>
                <configuration>
                    <hostname>192.168.12.111</hostname>
                    <username>root</username>
                    <password>root</password>
                    <port>22</port>
                    <remotePath>/tmp/</remotePath>
                </configuration>
            </plugin>
        </plugins>
    </build>