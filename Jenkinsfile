pipeline {
    agent any
    
    stages {
        stage("Checkout") {
            steps {
                git "https://github.com/automation-craftsman/devops-on-the-go.git"
            }
        }
        
        stage("Build") {
            steps {
                echo "Building the project..."
                sh "mvn clean package -DskipTests"
            }
        }
        
        stage("Test") {
            steps {
                echo "Testing the project..."
                sh "mvn test"
            }
        }
        
        stage("Deploy") {
            steps {
                echo "Starting application in background..."
                sh '''
                  nohup java -jar $WORKSPACE/target/app.jar > app.log 2>&1 &
                  echo $! > app.pid
                  sleep 10
                '''
            }
        }
        
        stage("Test Application") {
            steps {
                echo "Testing application runtime..."
                sh 'curl -f http://localhost:8081 || (echo "Applicationm is not responding" && exit 1)'
            }
        }
    }
    
    post {
        always {
            sh '''
                if [ -f app.pid ]; then
                  echo "Stopping application..."
                  kill $(cat app.pid) || echo "Application already stopped!!!"
                  rm app.pid
                fi
              '''
        }
        success {
            echo "Pipeline executed successfully!!!"
        }
        failure {
            echo "Pipeline failed to execute!!!"
        }
    }
}
