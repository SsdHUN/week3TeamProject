
pipeline{
  agent any

  stages {
        stage("build"){
            steps{
                sh(script: "mvn -f Week3/pom.xml compile")
            }
        }
        stage("run"){
            parallel{
                    stage("With Chrome"){
                        steps{
                            sh(script: "mvn clean test -DisRemote=true -DbrowserType=Chrome")
                        }
                    }
                    stage("With Firefox"){
                        steps{
                            sh(script: "mvn clean test -DisRemote=true -DbrowserType=Firefox")
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