pipeline {
    agent any 
    stages {
        stage('Setup') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew clean test || true'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew bootJar'
            }
        }
        stage('Deploy') {
            steps {
                sh 'java -jar build/libs/jenkins-test-0.0.1-SNAPSHOT.jar'
                sh 'curl localhost:8181'
            }
        }
    }
    post {
        always {
            sh 'tree build'
            junit 'build/reports/**/*.xml'
        }
    }
}