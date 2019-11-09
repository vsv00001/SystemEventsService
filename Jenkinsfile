pipeline {
 agent any
 
 environment {
PROJECT_NAME = 'phoenix-common'
// BUILD_VERSION - can we get this
PROJECT_REPO = 'phoenix-repo-local'
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
           repo = “phoenix-lib-release”

               } else {
            env = “development”
                repo = “phoenix-lib-snapshot”
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
