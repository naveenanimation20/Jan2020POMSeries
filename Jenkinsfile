pipeline {
  agent any
  stages {
    stage('Build Dev') {
      parallel {
        stage('Build Dev') {
          steps {
            sh 'mvn clean test'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn clean test -Denv=qa'
          }
        }

        stage('firefox') {
          steps {
            sh 'mvn clean test -Denv=qa'
          }
        }

      }
    }

    stage('Build QA') {
      parallel {
        stage('Build QA') {
          steps {
            sh 'mvn clean test -Denv=qa'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn clean test -Denv=qa'
          }
        }

        stage('firefox') {
          steps {
            sh 'mvn clean test -Denv=qa'
          }
        }

      }
    }

    stage('Build Stage') {
      parallel {
        stage('Build Stage') {
          steps {
            sh 'mvn clean test -Denv=stg'
          }
        }

        stage('firefox') {
          steps {
            sh 'mvn clean test -Denv=qa'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn clean test -Denv=qa'
          }
        }

      }
    }

  }
  tools {
    maven 'M3'
  }
}