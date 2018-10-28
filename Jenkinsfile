def server = Artifactory.server 'paradyme-artifactory'
def rtMaven = Artifactory.newMavenBuild()
def buildInfo
pipeline{
    agent any
    tools{
        maven 'mvn-3.5.2'

    }

    environment {
            SPRING_APPLICATION_NAME = 'ms-account-service'
            SPRING_CLOUD_CONFIG_URI    = 'http://mc-config-service.development.svc.cluster.local:8888'
            SPRING_PROFILES_ACTIVE = 'dev'
        }
    stages{


        stage('Build'){
            steps {
                withMaven(maven: 'mvn-3.5.2'){
                    sh 'mvn clean package'
                }


            }
            post {
                success{
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }



        stage('Build and Push Docker Image to Paradyme Artifactory'){
            steps {
                script {
                    def customImage = docker.build("registry-vpc.cn-beijing.aliyuncs.com/megacoffee/mc-account-service:${params.buildNum}", ".")
                    docker.withRegistry("https://registry-vpc.cn-beijing.aliyuncs.com/megacoffee"){
                        customImage.push()
                        customImage.push('latest')
                    }
                }
            }
        }

        stage('Deploy to MegaCoffee K8S'){

            steps{
                sh "kubectl apply -f kubernetes-deployment/"

            }
        }



    }
}