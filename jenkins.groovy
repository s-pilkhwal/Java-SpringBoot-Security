pipeline {
   agent any
    
    options {
        disableConcurrentBuilds() //Stops two builds from occurring at the same time
    }
	
	tools {
        maven 'Maven_3.8.6'
    }
	
    stages {
		stage('Build') {
			steps {
				script {
					sh '''
					mvn clean verify install
					'''						
				}				
			}
		}
	stage('Clean up') {
		steps {
				cleanWs()
			}
		}
	}
}
