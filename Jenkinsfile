
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
                sh 'mvn -B clean package'
                }
            }
        }
        stage("Running"){
            parallel{
                    stage("With Chrome"){
                        steps{
                            sh(script: "mvn test -DisRemote=true -DbrowserType=Chrome")
                        }
                    }
                    stage("With Firefox"){
                        steps{
                            sh(script: "mvn test -DisRemote=true -DbrowserType=Firefox")
                        }
                    }
                }

            post {
                always {
                    junit testResults: '**/target/surefire-reports/TEST-*.xml', skipPublishingChecks: true
                    cleanWs()
                }
            }
        }
    }
}