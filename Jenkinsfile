pipeline {
    agent any

    stages {
        stage('Testing') {
            steps {
                dir('Cucumber2025') {     // 👈 path where your pom.xml exists
                    bat 'mvn clean test'
                }
            }
        }
    }

    post {
        always {
            publishHTML(target: [
                reportDir: 'Cucumber2025/target',
                reportFiles: 'report.html',
                reportName: 'Cucumber HTML Report'
            ])
        }
    }
}
