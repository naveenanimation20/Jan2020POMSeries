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

        stage('firefox') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=firefox'
          }
        }

        stage('safari') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=safari'
          }
        }

      }
    }

    stage('Build QA') {
      parallel {
        stage('Build QA') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

        stage('firefox') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=firefox'
          }
        }

        stage('safari') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=safari'
          }
        }

      }
    }

    stage('Build Stage') {
      parallel {
        stage('Build Stage') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('firefox') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=firefox'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

        stage('safari') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=safari'
          }
        }

      }
    }

  }
  tools {
    maven 'M3'
  }
}