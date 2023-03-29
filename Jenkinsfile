
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
        stage("Login Tests"){
            parallel{
                    stage("With Chrome"){
                        steps{
                            dir('Week3'){
                            sh 'mvn test -Dtest="LoginPageTest" -Dusername=$username -Dpassword=$password -DbrowserType=Chrome -DisRemote=$isRemote'
                            }
                        }
                    }
                    stage("With Firefox"){
                        steps{
                            dir('Week3'){
                            sh 'mvn test -Dtest="LoginPageTest" -Dusername=$username -Dpassword=$password -DbrowserType=Firefox -DisRemote=$isRemote'
                            }
                        }
                    }
                }
        stage("BrowseIssue Tests"){
            parallel{
                    stage("With Chrome"){
                        steps{
                            dir('Week3'){
                            sh 'mvn test -Dtest="BrowseIssueTest" -Dusername=$username -Dpassword=$password -DbrowserType=Chrome -DisRemote=$isRemote'
                            }
                        }
                    }
                    stage("With Firefox"){
                        steps{
                            dir('Week3'){
                            sh 'mvn test -Dtest="BrowseIssueTest" -Dusername=$username -Dpassword=$password -DbrowserType=Firefox -DisRemote=$isRemote'
                            }
                        }
                    }
                }
        stage("CreateIssue Tests"){
            parallel{
                    stage("With Chrome"){
                        steps{
                            dir('Week3'){
                            sh 'mvn test -Dtest="CreateIssueTest" -Dusername=$username -Dpassword=$password -DbrowserType=Chrome -DisRemote=$isRemote'
                            }
                        }
                    }
                    stage("With Firefox"){
                        steps{
                            dir('Week3'){
                            sh 'mvn test -Dtest="CreateIssueTest" -Dusername=$username -Dpassword=$password -DbrowserType=Firefox -DisRemote=$isRemote'
                            }
                        }
                    }
                }
        stage("EditIssue Tests"){
            parallel{
                    stage("With Chrome"){
                        steps{
                            dir('Week3'){
                            sh 'mvn test -Dtest="EditIssueTest" -Dusername=$username -Dpassword=$password -DbrowserType=Chrome -DisRemote=$isRemote'
                            }
                        }
                    }
                    stage("With Firefox"){
                        steps{
                            dir('Week3'){
                            sh 'mvn test -Dtest="EditIssueTest" -Dusername=$username -Dpassword=$password -DbrowserType=Firefox -DisRemote=$isRemote'
                            }
                        }
                    }
                }
        stage("BrowseProject Tests"){
            parallel{
                    stage("With Chrome"){
                        steps{
                            dir('Week3'){
                            sh 'mvn test -Dtest="BrowseProjectTest" -Dusername=$username -Dpassword=$password -DbrowserType=Chrome -DisRemote=$isRemote'
                            }
                        }
                    }
                    stage("With Firefox"){
                        steps{
                            dir('Week3'){
                            sh 'mvn test -Dtest="BrowseProjectTest" -Dusername=$username -Dpassword=$password -DbrowserType=Firefox -DisRemote=$isRemote'
                            }
                        }
                    }
                }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    cleanWs()
                    echo 'Workspace is cleaned'
                }
            }
        }
    }
}