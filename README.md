# jumia-phone-directory-task

To run the project please use the command

mvn clean install package

then run the next command

docker-compose up --build

you can access the front end from your local docker machine ip and port 3001 and the back end is on port 8080


to get your local docker machine use the command 

docker-machine ip


if you want to run the application without docker, run the following command to run the backend server


java -jar target/phone.directory-0.0.1-SNAPSHOT.jar


and run the following command at the frontend src folder

npm start


NOTE: if you face issues from accessing the backend from the frontend, adjust the url in the App.js file located in the frontend src file to match your local docker machine IP or localhost.
