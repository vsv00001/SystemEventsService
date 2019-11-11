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
          def buildNum = "$BUILD_NUMBER"
           echo "${buildNum}"
           def buildID = "$BUILD_ID"
           echo "${buildID}"
           def wkspace = "$WORKSPACE"
           echo "${wkspace}"
           def buildTag = "$BUILD_TAG"
           echo "${buildTag}"
           
           sh 'mvn clean install'
           
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
