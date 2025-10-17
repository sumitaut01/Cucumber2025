// pipeline {
//     agent any
//     stages {
//         stage('Run Parallel Browsers') {
//             parallel {
//                 stage('Chrome') {
//                     steps {
//                         sh 'mvn clean test -Pchrome'
//                     }
//                 }
//                 stage('Firefox') {
//                     steps {
//                         sh 'mvn clean test -Pfirefox'
//                     }
//                 }
//                 stage('Edge') {
//                     steps {
//                         sh 'mvn clean test -Pedge'
//                     }
//                 }
//             }
//         }
//     }
// }




pipeline {
    agent any

    stages {
        stage('Testing') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}
