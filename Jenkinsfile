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
                echo '🔨 Building using Maven Wrapper'
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Images') {
            steps {
                echo '🐳 Building Docker images'
                sh 'docker compose build'
            }
        }

        stage('Deploy Containers') {
            steps {
                echo '♻️ Restarting containers safely'
                sh '''
                  docker compose down
                  docker compose up -d
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Smart Parking CI/CD Pipeline Successful'
        }
        failure {
            echo '❌ Pipeline Failed'
        }
    }
}
