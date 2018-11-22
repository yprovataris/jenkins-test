pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                withGradle()
                sh './gradlew build'
            }
        }
        stage('Test') { 
            steps {
                sh './gradlew test'
            }
        }
        stage('Deploy') { 
            steps {
                sh 'echo executing deploy...'
            }
        }
    }
}