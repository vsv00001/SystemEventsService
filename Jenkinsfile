pipeline {
agent any
 
 stages {
        stage('Push to arfifactory') { 
 
         steps {
          script {
          def jarName = "SystemEventsService.jar"
          echo "JAR NAME  ${jarName}"
          def release_repo = 'phoenix-libs-release'
          def snapshot_repo ='phoenix-snapshot-release'
           
          def dirName ='/com/comcast/phoenix/mongo-index-builder'
           
          def gitbranch = "$GIT_BRANCH"
          echo "${gitbranch}"
          def buildNum = "$BUILD_NUMBER"
           echo "build Number ${buildNum}"
           def buildID = "$BUILD_ID"
           echo "buildId ${buildID}"
           def wkspace = "$WORKSPACE"
           echo "workspace ${wkspace}"
           
          // sh 'mvn clean install'
           def env =''
           
           if(gitbranch == 'origin/master') {
            env = 'staging'
            repo= "${release_repo}"
            
           } else {
            env = 'development'
            repo ="${snapshot_repo}"           
           }
           
           def image =  readMavenPom().getArtifactId()
           def version = readMavenPom().getVersion()
           
           echo "image ${image}"
           echo "version ${version}"
           
           // change the jar and pom names
           
           
           
           rtUpload (
              serverId: "MyArtifactory",
              spec:
                  """{
                    "files": [
                      {
                        "pattern": "target/*SystemEventsService-1.jar",
                        "target": "phoenix/${repo}/${dirName}/"
                      }
                   ]
                  }"""
              )
           
          }
         }
        }
 }
}
