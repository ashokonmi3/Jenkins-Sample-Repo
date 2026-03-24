pipeline {
    agent any

    stages {
        stage('Checkout Info') {
            steps {
                echo 'Code pulled from GitHub'
            }
        }

        stage('Display File') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'cat app.txt'
                    } else {
                        bat 'type app.txt'
                    }
                }
            }
        }

        stage('Build Step') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'echo "Simulating build process on Linux"'
                    } else {
                        bat 'echo Simulating build process on Windows'
                    }
                }
            }
        }
    }
}
