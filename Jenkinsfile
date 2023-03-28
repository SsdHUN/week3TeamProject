
pipeline{
  agent any

  stages {
        stage('Workspace setup') {
            steps {
                cleanWs()
                echo 'Workspace is cleaned'
                checkout scm
            }
        }
        stage("Build"){
            steps{
                dir('Week3'){
                sh 'mvn compile'
                }
            }
        }
        stage("Running"){
            parallel{
                    stage("With Chrome"){
                        steps{
                            sh 'mvn test -DbrowserType=Chrome'
                        }
                    }
                    stage("With Firefox"){
                        steps{
                            sh 'mvn test -DbrowserType=Firefox'
                        }
                    }
                }

            post {
                always {
                    junit testResults: '**/target/surefire-reports/TEST-*.xml', skipPublishingChecks: true
                    cleanWs()
                    echo 'Workspace is cleaned'
                }
            }
        }
    }
}