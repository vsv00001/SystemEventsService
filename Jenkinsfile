pipeline {
 agent {
  docker {
            image 'maven:3-alpine'
        }
 }
 
 stages {
        stage('Push to arfifactory') { 
         
         
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
