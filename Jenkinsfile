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
                echo '🔨 Building all microservices using parent POM'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Images') {
            steps {
                echo '🐳 Building Docker images'
                sh 'docker compose build'
            }
        }

        stage('Run Containers') {
            steps {
                echo '🚀 Starting containers'
                sh 'docker compose up -d'
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
