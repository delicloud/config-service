pipeline {
    agent {
        docker {
            image 'maven:3.3.3-jdk-8'
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
        def dockerImage
        stage('PACKAGE') {
            sh "cp -R src/main/docker build/"
            sh "cp build/libs/*.war build/docker/"
            dockerImage = docker.build('config-service', 'build/docker')
        }

        stage('PUBLISH') {
            docker.withRegistry('http://thoughtworks.io:5001', 'registry-login') {
                dockerImage.push 'latest'
            }
        }
    }
    post {
        always {
            echo 'I will always say Hello again!'
        }
    }
}
