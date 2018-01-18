#!/usr/bin/env groovy

node {
    stage('checkout') {
        checkout scm
    }

    docker.image('maven:3.3.3-jdk-8').inside('-v /root/.m2:/root/.m2 -v /tmp:/tmp') {
        stage('BUILD') {
            sh "mvn clean"
            sh "mvn package"
        }
    }

    def dockerImage
    stage('PACKAGE') {
        sh "cp -R src/main/docker build/"
        sh "cp target/*.war build/docker/"
        dockerImage = docker.build('deliflow/config-service', 'build/docker')
    }

    stage('PUBLISH') {
        docker.withRegistry('http://thoughtworks.io:5001', 'registry-login') {
            dockerImage.push 'latest'
        }
    }
}
