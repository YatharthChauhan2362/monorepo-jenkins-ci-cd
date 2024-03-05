module.exports = {
  apps : [
    {
      name: "yarn-app",
      script: "npm",
      args: "run serve",
      cwd: "/var/lib/jenkins/workspace/monorepo-cicd/vue-app", 
      instances: 1,
      autorestart: true,
      watch: false,
      max_memory_restart: '1G',
      log_file: 'pm2.log',
      error_file: 'pm2_error.log',
      out_file: 'pm2_out.log',
      merge_logs: true,
      env: {
        NODE_ENV: 'production'
      },
      env_production: {
        NODE_ENV: 'production'
      }
    }
  ]
};
