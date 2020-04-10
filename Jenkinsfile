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
  
  


}

}
