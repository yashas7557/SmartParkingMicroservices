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
                sh '''
                    docker build -t eureka-server ./eureka-server
                    docker build -t api-gateway ./api-gateway
                    docker build -t vehicle-service ./vehicle-service
                    docker build -t parking-slot-service ./parking-slot-service
                    docker build -t ticket-service ./ticket-service
                    docker build -t payment-service ./payment-service
                '''
            }
        }

        stage('Run Containers') {
            steps {
                echo '♻️ Restarting containers safely'
                sh '''
                    docker rm -f eureka-server api-gateway vehicle-service parking-slot-service ticket-service payment-service || true

                    docker run -d --name eureka-server -p 8761:8761 eureka-server
                    docker run -d --name api-gateway -p 8181:8181 api-gateway
                    docker run -d --name vehicle-service vehicle-service
                    docker run -d --name parking-slot-service parking-slot-service
                    docker run -d --name ticket-service ticket-service
                    docker run -d --name payment-service payment-service
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
