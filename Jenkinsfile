pipeline {
    environment {
    registry = "kalikidhar/bank_app"
        registryCredentials = "dockerhub_id"
        dockerImage = ""
    }
    
    agent any
    tools {
        maven "M3"
    }
    stages {
        stage('Checkout'){
            steps{
                git branch: 'main', url: 'https://github.com/kalkashi/bank.git'
            }
        }
        stage('Compile'){
            steps{
                sh 'mvn clean compile'
            }
        }
        stage('Test'){
            steps{
                sh 'mvn test'
            }
        }
        stage('Package'){
            steps{
                sh 'mvn -Dmaven.test.skip -Dmaven.compile.skip package'
            }
        }

        stage ('Build Docker Image'){
                steps{
                    script {
                        dockerImage = docker.build(registry)
                    }
                }
            }

            stage ("Push to Docker Hub"){
                steps {
                    script {
                        docker.withRegistry('', registryCredentials) {
                            dockerImage.push("${env.BUILD_NUMBER}")
                            dockerImage.push("latest")
                        }
                    }
                }
            }

            stage ("Clean up"){
                steps {
                    script {
                        sh 'docker image prune --all --force --filter "until=48h"'
                           }
                }
            }
        
        
    }
    
}


