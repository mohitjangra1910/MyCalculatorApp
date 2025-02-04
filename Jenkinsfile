pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                // Create output directory if not exists and compile the main source code
                sh 'mkdir -p out'
                sh 'javac -d out src/main/java/com/example/Calculator.java'
            }
        }
        stage('Test') {
            steps {
                // Compile the test code and run tests
                sh 'javac -d out -cp out src/test/java/com/example/CalculatorTest.java'
                sh 'java -cp out com.example.CalculatorTest'
            }
        }
        stage('Package') {
            steps {
                // Create an executable JAR file of the application
                sh 'cd out && jar cfe CalculatorApp.jar com.example.Calculator com/example/Calculator.class'
            }
        }
        stage('Deploy') {
            steps {
                // Copy the JAR file to the deployment directory
                sh 'sudo cp out/CalculatorApp.jar /opt/apps/'
            }
        }
        stage('Run Application') {
            steps {
                // Optionally stop any existing instance before starting a new one, then run the application in background
                // (If you need to stop the existing instance, add a command here.)
                sh 'nohup java -jar /opt/apps/CalculatorApp.jar > /opt/apps/app.log 2>&1 &'
            }
        }
    }

    post {
        success {
            echo 'Build, deployment, and application run succeeded!'
        }
        failure {
            echo 'Build, deployment, or application run failed.'
        }
    }
}
