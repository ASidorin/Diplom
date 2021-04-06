FROM node:8.16.2-alpine
WORKDIR /opt/app
COPY . .
ENV TZ Europe/Moscow
RUN npm install
CMD ["npm", "start"]
EXPOSE 9999
