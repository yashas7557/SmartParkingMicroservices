pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/yashas7557/SmartParkingMicroservices.git'
            }
        }

        stage('Build Microservices') {
            steps {
                sh '''
                  chmod +x mvnw
                  ./mvnw clean package -DskipTests
                '''
            }
        }

        stage('Deploy with Docker Compose') {
            steps {
                sh '''
                  docker compose down || true
                  docker compose up -d --build
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Deployment Successful'
        }
        failure {
            echo '❌ Deployment Failed'
        }
    }
}
