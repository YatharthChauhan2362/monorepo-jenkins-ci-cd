def call(){

                        dir('reactjs-app') {
                            sh 'docker build -t yc-app-jenkins:react-docker-img .'
                            withCredentials([usernamePassword(credentialsId: "dockerhub", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
                                sh "docker tag yc-app-jenkins:react-docker-img ${env.dockerHubUser}/yc-app-jenkins:react-docker-img"
                                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                                sh "docker push ${env.dockerHubUser}/yc-app-jenkins:react-docker-img"
                                sh "docker compose up -d"
                            }
                        }
                    }
