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

import org.apache.commons.lang.StringUtils;
import org.apache.maven.plugin.AbstractMojo;

import java.io.File;

public abstract class AbstractDeployMojo extends AbstractMojo {

    /**
     * @parameter
     */
    protected String hostname;

    /**
     * @parameter
     */
    protected int port = 22;

    /**
     * @parameter
     */
    protected String username;

    /**
     * @parameter
     */
    protected String password;

    /**
     * @parameter
     */
    protected File cert;

    /**
     * @parameter
     */
    protected String remotePath = "/tmp";

    /**
     * Location of the file.
     *
     * @parameter expression="${project.build.directory}"
     */
    protected File outputDirectory;

    /**
     * The location of the war file.
     * @parameter expression="${project.build.directory}/${project.build.finalName}.${project.packaging}"
     */
    protected File outputFile;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public File getCert() {
        return cert;
    }

    public void setCert(File cert) {
        this.cert = cert;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public File getOutputDirectory() {
        return outputDirectory;
    }

    public void setOutputDirectory(File outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public boolean checkConfig() {
        boolean check = true;
        if (StringUtils.isBlank(hostname)) {
            getLog().error("hostname is null");
            check = false;
        }
        if (StringUtils.isBlank(username)) {
            getLog().error("username is null");
            check = false;
        }
        if (StringUtils.isBlank(password)) {
            getLog().error("password is null");
            check = false;
        }
        if (StringUtils.isBlank(remotePath)) {
            getLog().error("remotePath is null");
            check = false;
        }
        return check;
    }
}
