FROM node:14-alpine

WORKDIR /app

COPY package.json yarn.lock ./

RUN npm install -g @vue/cli

RUN npm install

COPY . .

EXPOSE 8081

CMD ["npm", "run", "serve"]
