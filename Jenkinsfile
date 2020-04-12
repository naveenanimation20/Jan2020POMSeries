pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn clean install -DskipTests=true'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test -Denv=qa -Dbrowser=chrome'
      }
    }

  }
}