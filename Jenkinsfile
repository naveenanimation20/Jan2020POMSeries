pipeline {
  agent any
  stages {
  
  
        stage('Build Dev') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

      
    

    stage('Publish reports') {
      steps {
        script {
         // publish html
        		publishHTML([
        		allowMissing: false, 
        		alwaysLinkToLastBuild: false, 
        		keepAll: false, 
        		reportDir: 'build', 
        		reportFiles: 'TestExecutionReport.html', 
        		reportName: 'Extent HTML Report',
        		 reportTitles: ''
        		 ])
          
          allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: '/allure-results']]
            ])
          
        }

      }
    }

  }
  tools {
    maven 'M3'
  }
}
