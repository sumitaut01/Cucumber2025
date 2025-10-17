pipeline {
    agent any

    stages {
        stage('Testing') {
            steps {
                echo '🧪 Running Maven tests...'
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            echo '📊 Publishing Cucumber Report...'
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target',    // ✅ where your report is
                reportFiles: 'report.html',     // ✅ your actual report file name
                reportName: 'Cucumber HTML Report'
            ])
        }
    }
}
