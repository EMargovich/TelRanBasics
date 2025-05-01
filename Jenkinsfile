pipeline {
  agent any
  stages {
    stage ("run frontend")
      steps {
        echo 'executing yarn...'
        nodejs('Node-23.11.0') {
          sh 'yarn install'
        }
      }
    stage ("run backeng")
      steps {
        echo 'executing gradle...'
        withGradle() {
          sh './gradlew -v'
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
