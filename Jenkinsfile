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
           
          if(gitbranch == “origin/master”) {
           env = 'staging'
           repo = 'phoenix-lib-release'

               } else {
            env = 'development'
                repo = 'phoenix-lib-snapshot'
           }
 
           rtUpload (
              serverId: "MyArtifactory",
              spec:
                  """{
                    "files": [
                      {
                        "pattern": "target/*SystemEventsService-1.jar",
                        "target": "example-repo-local/${repo}"
                      }
                   ]
                  }"""
              )
           
          }
         }
        }
 }
}
