pipeline {
    agent any
    environment {
    }
    stages {
        stage('Verificar Repositorio') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']],
                          userRemoteConfigs: [
                                [
                                    url: 'https://github.com/GuilhermeLBonomo/GuilhermeBonomoEmissorMicroservicoApplication.git',
                                    credentialsId: 'guilhermelbonomo']]])
            }
        }

        stage('Construir Imagem Docker') {
            steps {
                script {
                    def appName = 'av1'
                    def imageTag = "${appName}:${env.BUILD_ID}"
                    bat "docker build --build-arg SPRING_PROFILES_ACTIVE=${DEPLOY_PROFILE} -t ${imageTag} ."
                }
            }
        }

        stage('Fazer Deploy') {
            steps {
                script {
                    def appName = 'av1'
                    def imageTag = "${appName}:${env.BUILD_ID}"
                    bat "docker-compose up -d --build"
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
