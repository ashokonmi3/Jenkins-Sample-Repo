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
*/
/*======================================
Pre requisit 
Docker installation 
sudo yum install docker -y
sudo systemctl start docker
sudo usermod -aG docker jenkins
Git installation 
sudo yum update -y
sudo yum install git -y
===========================================*/
 /* pipeline {
    agent any

    environment {
        IMAGE_NAME = "html-app"
        CONTAINER_NAME = "html-container"
    }

    stages {

        stage('Checkout Code') {
            steps {
                        cleanWs()

                git branch: 'main', url: 'https://github.com/ashokonmi3/Jenkins-Sample-Repo.git'
            }
        }

        stage('Verify Environment') {
            steps {
                sh 'which git'
                sh 'git --version'
                sh 'docker --version'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Stop Old Container') {
            steps {
                sh '''
                docker stop $CONTAINER_NAME || true
                docker rm $CONTAINER_NAME || true
                '''
            }
        }

        stage('Run Container (Deploy)') {
            steps {
                sh '''
                docker run -d -p 80:80 --name $CONTAINER_NAME $IMAGE_NAME
                '''
            }
        }
    }

    post {
        success {
            echo '🚀 Deployment Successful!'
        }
        failure {
            echo '❌ Deployment Failed!'
        }
    }
}
*/
