/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package so.heroin.maven.plugins.deploy;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.IOException;

/**
 *
 * @goal upload
 * @requiresDependencyResolution test
 * @execute phase="package"
 */
public class DeployMojo extends AbstractDeployMojo {

    public void execute() throws MojoExecutionException {
        if (null != outputFile) {
            if (checkConfig()) {
                Connection connection = new Connection(hostname, port);
                try {
                    connection.connect();
                    boolean isAuth = connection.authenticateWithPassword(username, password);
                    getLog().info("auth hostname: " + hostname + " username: " + username + " password: " + password);
                    if (isAuth) {
                        SCPClient scp = connection.createSCPClient();
                        scp.put(outputFile.getAbsolutePath(), remotePath);
                        connection.close();
                        getLog().info("UPLOAD SUCCESSFUL");
                    } else {
                        getLog().error("auth error, hostname: " + hostname);
                        getLog().error("UPLOAD ERROR");
                    }
                } catch (IOException e) {
                    getLog().error("connection to server error, hostname: " + hostname + ", " + e);
                    getLog().error("UPLOAD ERROR");
                }
            }
        } else {
            getLog().error("not found build file.");
            getLog().error("UPLOAD ERROR");
        }
    }
}
