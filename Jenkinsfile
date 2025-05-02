pipeline {
    agent any
    tools {
        jdk 'Java' // Name from Global Tool Configuration
    }
    stages {
        stage('run backend') {
            steps {
                sh 'java -version'
                // your Java build commands
            }
        }
    }
  
  stages {
    stage ("run frontend") {
      steps {
        echo 'executing yarn...'
        nodejs('Node-23.11.0') {
          sh 'yarn install'
        }
      }
    }
       
    stage ("build") {
      steps {
        echo 'building the application...'
        echo 'Application built'
  
      }
    }
    stage ("test") {
      steps {
        echo 'testing the application...'
      }
    }
    stage ("deploy") {
      steps {
        echo 'deploying the application...'
      }
    }    
  }
}
