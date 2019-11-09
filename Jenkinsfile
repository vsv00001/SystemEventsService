pipeline {
 agent any
 stages {
        stage('Push to arfifactory') { 
         
         
         steps {
          script {
           def jarName = "SystemEventsService.jar"
           echo "JAR NAME  ${jarName}"
           
          def gitbranch = "$GIT_BRANCH"
          echo "${gitbranch}"
           
          sh 'pwd'
          sh 'ls -lrt'
           
           
           rtUpload (
              serverId: "MyArtifactory",
              spec:
                  """{
                    "files": [
                      {
                        "pattern": "targets/*SystemEventsService-1.jar",
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
