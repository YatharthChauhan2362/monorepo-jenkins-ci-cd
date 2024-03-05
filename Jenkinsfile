pipeline {
    agent any
    
    parameters {
        choice(name: 'Server', choices: ['React', 'Node', 'Node API', 'Vue', 'Python'])
    }

    stages {
        stage('Cloning the Project') {
            steps {
                script {
                    try {
                        echo "Cloning the code"
                        git url: "https://gitlab.webelight.co.in/webelight/devops/training.git", branch: "yatharth-monorepo", credentialsId: "gitup"
                    } catch(Exception e) {
                        echo "FAILED ${e}"
                        currentBuild.result = 'FAILURE'
                        throw e
                    }
                }
            }
        }

        stage('Build and Deploy') {
            when {
                expression {
                    params.Server in ['React', 'Node', 'Node API', 'Vue', 'Python']
                }
            }
            steps {
                script {
                    if (params.Server == 'React') {
                        dir('reactjs-app') {
                            sh 'docker build -t yc-app-jenkins:react-docker-img .'
                            withCredentials([usernamePassword(credentialsId: "dockerhub", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
                                sh "docker tag yc-app-jenkins:react-docker-img ${env.dockerHubUser}/yc-app-jenkins:react-docker-img"
                                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                                sh "docker push ${env.dockerHubUser}/yc-app-jenkins:react-docker-img"
                                sh "docker compose up -d"
                            }
                        }
                    } else if (params.Server == 'Node') {
                        dir('nextjs-app') {
                            sh 'docker build -t nextjs .'
                            withCredentials([usernamePassword(credentialsId: "dockerhub", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
                                sh "docker tag nextjs ${env.dockerHubUser}/nextjs"
                                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                                sh "docker push ${env.dockerHubUser}/nextjs"
                                sh "docker compose up -d"
                            }
                        }
                    } else if (params.Server == 'Node API') {
                        dir('node-api') {
                            sh 'docker build -t node-api .'
                            withCredentials([usernamePassword(credentialsId: "dockerhub", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
                                sh "docker tag node-api ${env.dockerHubUser}/node-api"
                                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                                sh "docker push ${env.dockerHubUser}/node-api"
                                sh "docker compose up -d"
                            }
                        }
                    } else if (params.Server == 'Vue') {
                        dir('vue-app') {
                            sh 'docker build -t vue .'
                            withCredentials([usernamePassword(credentialsId: "dockerhub", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
                                sh "docker tag vue ${env.dockerHubUser}/vue"
                                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                                sh "docker push ${env.dockerHubUser}/vue"
                            }
                            sh "docker compose up -d"
                        }
                    } else if (params.Server == 'Python') {
                        dir('python-app') {
                            sh 'docker build -t python-image:py-docker-img .'
                            withCredentials([usernamePassword(credentialsId: "dockerhub", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
                                sh "docker tag python-image ${env.dockerHubUser}/python-image:py-docker-img"
                                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                                sh "docker push ${env.dockerHubUser}/python-image:py-docker-img"
                                sh "docker compose up -d"
                            }
                        }
                    }
                }
            }
        }
    }
}

