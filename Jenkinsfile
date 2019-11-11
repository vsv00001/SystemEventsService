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
           echo "build Number ${buildNum}"
           def buildID = "$BUILD_ID"
           echo "buildId ${buildID}"
           def wkspace = "$WORKSPACE"
           echo "workspace ${wkspace}"
           
           echo " currentBuild $currentBuild.projectName -- $currentBuild.displayName "
          
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
