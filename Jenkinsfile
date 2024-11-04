pipeline {
    
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
        stage('Packge'){
            steps{
                sh 'mvn -Dmaven.test.skip -Dmaven.compile.skip package'
            }
        }
        
        
    }
    
}
