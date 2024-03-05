FROM node:14-alpine

WORKDIR /app

COPY package*.json ./

RUN npm install
RUN npm install react-scripts --save

COPY . .

EXPOSE 3001

CMD ["npm", "start"]
