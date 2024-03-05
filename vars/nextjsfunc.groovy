def call(){

                        dir('nextjs-app') {
                            sh 'docker build -t nextjs .'
                            withCredentials([usernamePassword(credentialsId: "dockerhub", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
                                sh "docker tag nextjs ${env.dockerHubUser}/nextjs"
                                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                                sh "docker push ${env.dockerHubUser}/nextjs"
                                sh "docker compose up -d"
                            }
                        }
                    } 

