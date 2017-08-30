pipeline {
    agent {
        docker {
            image 'maven:3.3.3-jdk-8'
            label 'swarm'
            args '-v /root/.m2:/root/.m2 -v /tmp:/tmp'
        }
    }

    stages {
        stage('CHECKOUT') {
            steps {
                checkout scm
            }
        }
        stage('BUILD') {
            steps {
                sh 'mvn clean'
                sh 'mvn package'
            }
        }
    }
    post {
        always {
            echo 'I will always say Hello again!'
        }
    }
}

