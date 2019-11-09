pipeline {
 agent any
 
 environment {
  RELEASE_REPO = “phoenix-lib-release"
 SNAPSHOT_REPO = “phoenix-lib-snapshot”
 PROJECT_NAME = “phoenix-common”	  
 // BUILD_VERSION - can we get this
 PROJECT_REPO = “phoenix-repo-local” 
 }
 
 stages {
        stage('Push to arfifactory') { 
         
         
         steps {
          script {
           def jarName = "SystemEventsService.jar"
           echo "JAR NAME  ${jarName}"
           
          def gitbranch = "$GIT_BRANCH"
          echo "${gitbranch}"
           
          if(gitbranch == “origin/master”) {
           env = “staging”
           repo = “${RELEASE_REPO}”

               } else {
            env = “development”
                repo = “${SNAPSHOT_REPO}”
           }
 
           rtUpload (
              serverId: "MyArtifactory",
              spec:
                  """{
                    "files": [
                      {
                        "pattern": "target/*SystemEventsService-1.jar",
                        "target": "${repo}/${PROJECT_REPO}"
                      }
                   ]
                  }"""
              )
           
          }
         }
        }
 }
}
