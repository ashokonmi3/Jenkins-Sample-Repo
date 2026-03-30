// ============================================================
// File: jenkinsfile_tools_maven.groovy
// Topic: Jenkins Declarative Pipeline with tools block
// Purpose: Build a Maven project after checking out code from GitHub
// ============================================================

// ============================================================
// PIPELINE OVERVIEW
// ------------------------------------------------------------
// This pipeline performs the following actions:
//
// 1. Executes on any available Jenkins agent
// 2. Utilizes the Maven tool configured in Jenkins
// 3. Checks out source code from a GitHub repository
// 4. Builds (compiles) the project using Maven
//
// ------------------------------------------------------------
// PREREQUISITES (IMPORTANT)
//
// ✔ Maven must be installed on the Jenkins machine (AWS EC2)
//
// Install Maven using:
// sudo yum install maven -y
//
// Verify installation:
// mvn -version
//
// ------------------------------------------------------------
// JENKINS CONFIGURATION
//
// Maven must also be configured in Jenkins:
//
// Navigate to:
// Manage Jenkins → Global Tool Configuration
//
// Under "Maven installations":
// - Click "Add Maven"
// - Set Name as: Maven (must match pipeline)
// - Enable auto-install OR provide Maven home path
// ============================================================

pipeline {
    
    // agent any means this pipeline can run on any available Jenkins node/agent
    agent any

    // tools block is used to automatically set up tools required in pipeline
    tools {
        // Jenkins must already have Maven configured with the name 'Maven'
        maven 'Maven'
    }

    stages {

        // Stage 1: Checkout source code from GitHub
        stage('Checkout Source Code') {
            steps {

                // checkout scmGit is used to pull code from Git repository
                // branches -> tells which branch to pull
                // userRemoteConfigs -> contains repository URL
                checkout scmGit(
                    branches: [[name: '*/master']],
                    extensions: [],
                    userRemoteConfigs: [[url: 'https://github.com/DevopsWorking/addressbook.git']]
                )
            }
        }

        // Stage 2: Build the project using Maven
        stage('Build Project') {
            steps {

                // sh is used to run shell command on Linux/Unix agents
                // mvn compile compiles the Java project
                sh 'mvn compile'
            }
        }
    }
}