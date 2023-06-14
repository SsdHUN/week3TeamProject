
pipeline{
  agent any

  stages {
        stage('Workspace setup') {
            steps {
                cleanWs()
                echo 'Workspace is cleaned'ä
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
                            dir('Week3'){
                            sh 'mvn test -Dusername=$username -Dpassword=$password -DbrowserType=Chrome -DisRemote=$isRemote'
                            }
                        }
                    }
                    stage("With Firefox"){
                        steps{
                            dir('Week3'){
                            sh 'mvn test -Dusername=$username -Dpassword=$password -DbrowserType=Firefox -DisRemote=$isRemote'
                            }
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