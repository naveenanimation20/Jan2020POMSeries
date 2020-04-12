pipeline {
  agent any
  stages {
    stage('Build Dev') {
      parallel {
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
        }

      }
    }

  }
  tools {
    maven 'M3'
  }
}
