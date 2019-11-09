pipeline {
 agent {
    label 'docker' 
  }
 
 stages {
        stage('Push to arfifactory') { 
         
         agent {
          docker {
            // Set both label and image
            label 'docker'
            image 'node:7-alpine'
            args '--name docker-node' // list any args
          }
        }
         
         steps {
          script {
           def jarName = "SystemEventsService.jar"
           echo "JAR NAME  ${jarName}"
           
          def gitbranch = "$GIT_BRANCH"
          echo "${gitbranch}"
    
           sh 'mvn -version'
           
           rtUpload (
              serverId: "MyArtifactory",
              spec:
                  """{
                    "files": [
                      {
                        "pattern": "target/*SystemEventsService-1.jar",
                        "target": "example-repo-local/"
                      }
                   ]
                  }"""
              )
           
          }
         }
        }
 }
}
