pipeline {
 agent any
 stages {
        stage('Push to arfifactory') { 
         steps {
          script {
           def jarName = "SystemEventsService.jar"
           echo "JAR NAME  ${jarName}"
           
           sh 'mvn --version'
           
           rtServer (
                 id: 'LocalArtifactory',
                 url: 'http://localhost:8081/artifactory',
                 // If you're using username and password:
                 username: 'admin',
                 password: 'password'
                
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
