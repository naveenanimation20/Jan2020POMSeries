pipeline {
  agent any
  tools {
    maven 'M3'
  }
  stages {
    stage('Build Dev') {
      steps {
        sh 'mvn clean test'
      }
    }
    
    stage('Build QA') {
      steps {
        sh 'mvn clean test -Denv=qa'
      }
    }
    
    stage('Build Stage') {
      steps {
        sh 'mvn clean test -Denv=stg'
      }
    }
  
  
stage('reports') {
    steps {
    script {
    
    
    
            allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: '/allure-results']]
            ])
           
            
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

}
