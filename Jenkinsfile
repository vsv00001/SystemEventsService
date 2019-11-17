import java.text.SimpleDateFormat

pipeline {
agent any
 
 environment {
  MAVEN_HOME = 'C:\apache-maven-3.6.2\bin' 
 }
 stages {
       
     stage ('Artifactory configuration') {
       /* agent {
           docker 'maven:3.6.1-jdk-8'
         } */
      
            steps {
              bat 'mvn -version'
             
             /*
                rtServer (
                    id: "MyArtifactory",
                    url: 'http://localhost:8081/artifactory',
                    credentialsId: CREDENTIALS
                ) */

                rtMavenDeployer (
                    id: "MAVEN_DEPLOYER",
                    serverId: "MyArtifactory",
                    releaseRepo: "reactor-libs-release",
                    snapshotRepo: "reactor-libs-snapshot"
                )

                rtMavenResolver (
                    id: "MAVEN_RESOLVER",
                    serverId: "MyArtifactory",
                    releaseRepo: "reactor-libs-release",
                    snapshotRepo: "reactor-libs-snapshot"
                )
             
                  rtMavenRun (
                    tool: 'mymaven', // Tool name from Jenkins configuration
                    pom: 'pom.xml',
                    goals: 'clean install',
                    deployerId: "MAVEN_DEPLOYER",
                    resolverId: "MAVEN_RESOLVER"
                )
             
               rtPublishBuildInfo (
                    serverId: "MyArtifactory"
                )
            }
        }

    

        
   
         /*
        stage('Push to arfifactory') { 
 
         steps {
          script {
          def release_repo = 'reactor-libs-release'
          def snapshot_repo ='reactor-libs-snapshots'
           
          def dirName ='/com/example/SystemEventsService'
           
          def gitbranch = "$GIT_BRANCH"
          echo "${gitbranch}"
          def buildNum = "$BUILD_NUMBER"
           echo "build Number ${buildNum}"
          
           
          // sh 'mvn clean install'
           def env =''
           def image =  readMavenPom().getArtifactId()
          // def version = readMavenPom().getVersion()
           
           def version = sh 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout'
           
           echo "image ${image}"
           echo "version ${version}"
           
           def verName = ''
           def jarName =''
           
           def dt = new Date()
           def dateformat =  new SimpleDateFormat("yyyyMMdd.HHmmss")
           echo "date format ${dateformat.format(dt)}"
           
           if(gitbranch == 'origin/master') {
            env = 'staging'
            repo= "${release_repo}"
            jarName = "${image}"+"-"+"${version}"+"-"+"${dateformat.format(dt)}"+"-"+"${buildNum}"
           } else {
            env = 'development'
            repo ="${snapshot_repo}"     
            verName = version.split("SNAPSHOT")
            jarName = "${image}"+"-"+"${verName[0]}"+"-"+"${dateformat.format(dt)}"+"-"+"${buildNum}"
           }
           
            echo "JAR NAME  ${jarName}"
           
           
           
           // change the jar and pom names
           
         //  def jarName = "${image}"+"-"+"${dateformat.format(dt)}"+"-"+"${buildNum}"
            echo "JAR NAME  ${jarName}"
          sh 'ls -ltr'
          sh 'ls -ltr target'
          
         // sh 'sudo chown -Rv jenkins target' 
         //  sh 'mv target/*SystemEventsService*.jar target/"${jarName}" '
         //  sh "mv target/*SystemEventsService*.jar ${jarName}.jar "
           
           //   "target": "phoenix/${dirName}/${version}/"
           rtUpload (
              serverId: "MyArtifactory",
              spec:
                  """{
                    "files": [
                      {
                        "pattern": "target/*SystemEvents*.jar",
                        "target": "${repo}/${dirName}/${version}/"
                      }
                   ]
                  }""",
               buildNumber: "${buildNum}"
              )
           
           // this will fail as the pom structure does not match the directory structure being created in local artifactory
           rtUpload (
                       serverId: "MyArtifactory",
                       spec:
                               """{
               "files": [
                 {
                   "pattern": "pom.xml",
                   "target": "phoenix/${dirName}/${version}/${jarName}.pom"
                 }
              ]
             }"""
               )
           
          }
         }
        } */
 
}
}
