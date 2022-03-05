pipeline {
    agent any
    tools {
        maven "mavenproject" 
    }

    stages {
        stage('clone') {
            steps {
             git 'https://github.com/sanjai1979/mvnproj.git'   
            }
        }
        stage('build') {
            steps {
            sh "mvn clean package"   
            }
        }
        stage('deploy') {
            steps {
            sh "sudo cp /var/lib/jenkins/workspace/maven2/target/myproj.war /opt/tomcat/webapps/"   
            }
        }
    }

}
