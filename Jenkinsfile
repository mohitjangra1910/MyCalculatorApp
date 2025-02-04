pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                // Create output directory if not exists
                sh 'mkdir -p out'
                // Compile the source code
                sh 'javac -d out src/main/java/com/example/Calculator.java'
            }
        }
        stage('Test') {
            steps {
                // Compile the test code and run tests
                sh 'javac -d out -cp out src/test/java/com/example/CalculatorTest.java'
                // Run the tests; if tests fail, exit code will be non-zero and fail the build.
                sh 'java -cp out com.example.CalculatorTest'
            }
        }
        stage('Package') {
            steps {
                // Create a JAR file of the application
                sh 'cd out && jar cfe CalculatorApp.jar com.example.Calculator com/example/Calculator.class'
            }
        }
        stage('Deploy') {
            steps {
                // Deployment can be as simple as copying the jar to a deployment directory,
                // or you can add further steps such as restarting a service.
                // For demonstration, we copy the JAR file to /opt/apps (ensure that directory exists and is writable)
                sh 'sudo mkdir -p /opt/apps'
                sh 'sudo cp out/CalculatorApp.jar /opt/apps/'
                // Optionally, run the jar file in background:
                // sh 'nohup java -jar /opt/apps/CalculatorApp.jar &'
            }
        }
    }
    
    post {
        success {
            echo 'Build and deployment succeeded!'
        }
        failure {
            echo 'Build or deployment failed.'
        }
    }
}
