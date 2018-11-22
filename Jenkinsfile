pipeline {
    agent any 
    stages {
        stage('Test') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew test || true'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew bootJar'
            }
        }
        stage('Deploy') {
            steps {
                sh 'java -jar build/lib/bootJar.jar'
                sh 'curl localhost:8181'
            }
        }
    }
    post {
        always {
            junit 'build/reports/**/*.xml'
        }
    }
}