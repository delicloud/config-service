#!/usr/bin/env groovy


pipeline {
    agent { label 'docker' }

    stages {
        stage('CHECKOUT') {
            steps {
                checkout scm
            }
        }
        stage('BUILD') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
    post {
        always {
            echo 'I will always say Hello again!'
        }
    }
}

