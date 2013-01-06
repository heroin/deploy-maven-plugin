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

import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;

/**
 *
 * @goal upload
 * @requiresDependencyResolution test
 * @execute phase="package"
 */
public class DeployMojo extends AbstractDeployMojo {

    /**
     * Location of the file.
     *
     * @parameter expression="${project.build.directory}"
     */
    private File outputDirectory;

    /**
     * The location of the war file.
     * @parameter expression="${project.build.directory}/${project.build.finalName}.${project.packaging}"
     */
    private File outputFile;


    public void execute() throws MojoExecutionException {
        getLog().info(outputFile.toString());
        getLog().info(outputDirectory.toString());
    }
}
