pipeline {
    agent any 
    tools {
        jdk 'Java17'      // must match your Jenkins tool name
        maven 'Maven3'    // must match your Jenkins tool name
    }
    stages {
        stage("Cleanup Workspace") {
            steps {
                cleanWs()
            }
        }

stage("Checkout from SCM") {
    steps {
        git branch: 'master', 
            credentialsId: 'github', 
            url: 'https://github.com/Wasim10/SeleniumAutoFrame.git'
    }
}


        stage("Build Application") {
            steps {
                sh "mvn clean package"
            }
        }

        stage("Test Application") {
            steps {
                sh "mvn test"
            }
        }
    }
}
