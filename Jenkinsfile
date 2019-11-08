pipeline {
 agent any
 stages {
        stage('Push to arfifactory') { 
         steps {
          script {
           def jarName = "SystemEventsService.jar"
           echo 'JAR NAME  ${jarName}"
           
           rtServer (
                 id: 'LocalArtifactory',
                 url: 'http://localhost:8081/artifactory',
                 // If you're using username and password:
                 username: 'admin',
                 password: 'password'
                 // Configure the connection timeout (in seconds).
                 // The default value (if not configured) is 300 seconds:
                 timeout = 300
             )
           
           rtUpload (
              serverId: "LocalArtifactory",
              spec:
                  """{
                    "files": [
                      {
                        "pattern": "build/*myapp*.jar",
                        "target": "phoenix-local-repo/"
                      }
                   ]
                  }"""
              )
           
          }
         }
        }
 }
}
