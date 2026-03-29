pipeline{
    agent any
    stages{
        stage('checkout stage'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DevopsWorking/11-script.git']])
            }
        }
        stage('script usage'){
            steps{
                sh'''
                chmod +x helloworld.sh
                sh helloworld.sh
                '''
            }
        }
    }
}
