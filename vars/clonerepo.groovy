def call(){

                    try {
                        echo "Cloning the Repository"
                        git url: "https://gitlab.webelight.co.in/webelight/devops/training.git", branch: "yatharth-monorepo", credentialsId: "gitup"
                    } catch(Exception e) {
                        echo "FAILED ${e}"
                        currentBuild.result = 'FAILURE'
                        throw e
                    }
                
                    }