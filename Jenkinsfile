// pipeline {
//     agent any
//
//     environment {
//         GITHUB_REPO = 'https://github.com/RitikGarg7/Springboot-docker.git'
//         DOCKER_REGISTRY = 'docker.io'
//         DOCKER_IMAGE_NAME = 'ritik7garg/springboot-app'
//         DOCKER_TAG = "latest"
//         MYSQL_CONTAINER_NAME = 'mysql-container'
//     }
//
//     stages {
//         stage('Checkout Code') {
//             steps {
//                 git url: "$GITHUB_REPO", branch: 'main'
//             }
//         }
//
//         stage('Build Application') {
//             steps {
//                 script {
//                     sh './gradlew clean build -x test'
//                 }
//             }
//         }
//
// //         stage('Build Docker Image') {
// //             steps {
// //                 script {
// //                     sh "docker build -t ${DOCKER_IMAGE_NAME}:${DOCKER_TAG} ."
// //                 }
// //             }
// //         }
// //
// //         stage('Login to DockerHub') {
// //             steps {
// //                 script {
// //                     withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
// //                         sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
// //                     }
// //                 }
// //             }
// //         }
// //
// //         stage('Push Docker Image to DockerHub') {
// //             steps {
// //                 script {
// //                     sh "docker push ${DOCKER_IMAGE_NAME}:${DOCKER_TAG}"
// //                 }
// //             }
// //         }
// //
// //         stage('Deploy to Docker') {
// //             steps {
// //                 script {
// //                     sh "docker pull ${DOCKER_IMAGE_NAME}:${DOCKER_TAG}"
// //                     sh "docker run -d --name ${MYSQL_CONTAINER_NAME} --link mysql-container:mysql ${DOCKER_IMAGE_NAME}:${DOCKER_TAG}"
// //                 }
// //             }
// //         }
//     }
//
//     post {
//         success {
//             echo 'Pipeline executed successfully!'
//         }
//         failure {
//             echo 'Pipeline failed!'
//         }
//     }
// }


pipeline {
    agent any
    environment {
        SPRINGBOOT_IMAGE = 'ritik7garg/spring-rest-application:latest'
        FRONTEND_IMAGE = 'ritik7garg/frontend-application:latest'
    }
    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/RitikGarg7/Springboot-docker.git'
            }
        }
        stage('Build Application') {
            steps {
                script {
                    sh './gradlew clean build -x test'
                }
            }
        }
        stage('Build Spring Boot Docker Image') {
            steps {
                script {
                    sh 'docker build -t ${SPRINGBOOT_IMAGE} -f ./Dockerfile .'
                }
            }
        }
        stage('Build Frontend Docker Image') {
            steps {
                script {
                    sh 'docker build -t ${FRONTEND_IMAGE} -f ./frontend/Dockerfile .'
                }
            }
        }
//         stage('Login to Docker Hub') {
//             steps {
//                 script {
//                     withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
//                         sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} --password-stdin"
//                     }
//                 }
//             }
//         }
//         stage('Push Images to Docker Hub') {
//             steps {
//                 script {
//                     // Push both Spring Boot and Frontend images to Docker Hub
//                     sh 'docker push ${SPRINGBOOT_IMAGE}'
//                     sh 'docker push ${FRONTEND_IMAGE}'
//                 }
//             }
//         }
    }
    post {
//         always {
//             sh "docker logout"
//         }
        success {
            echo 'Build and push to Docker Hub was successful!'
        }
        failure {
            echo 'Build or push to Docker Hub failed.'
        }
    }
}
