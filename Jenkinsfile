pipeline {
    agent any

    stages {

        stage('Verificar Repositório') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']],
                          userRemoteConfigs: [[url: 'https://github.com/GuilhermeLBonomo/GuilhermeBonomoReceptorMicroservicoApplication.git']]])
            }
        }



        stage('Construir Imagem Docker') {
            steps {
                script {
                    def appName = 'provajhonny2'
                    def imageTag = "${appName}:${env.BUILD_ID}"
                    bat "docker build -t ${imageTag} ."
                }
            }
        }

        stage('Fazer Deploy') {
            steps {
                script {
                    def appName = 'provajhonny2'
                    def imageTag = "${appName}:${env.BUILD_ID}"
                    bat "docker stop ${appName} || exit 0"
                    bat "docker rm ${appName} || exit 0"
                    bat "docker-compose up -d --build"
                }
            }
        }
    }
    stage('Análise SonarQube') {
                steps {
                    script {
                        withSonarQubeEnv('SonarQubeServer') {  // 'SonarQubeServer' é o nome da instância configurada no Jenkins
                            bat 'mvn clean verify sonar:sonar -Dsonar.projectKey=GuilhermeBonomoReceptorMicroservicoApplication -Dsonar.projectName=GuilhermeBonomoReceptorMicroservicoApplication -Dsonar.token=squ_b76b715aabb86953255617b90ab021f3ab23bd7d'
                        }
                    }
                }
            }
    post {
        success {
            echo 'Deploy realizado com sucesso!'
        }
        failure {
            echo 'Houve um erro durante o deploy.'
        }
    }
}
