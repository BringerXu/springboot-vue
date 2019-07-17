# springvue-frontend
This project is a web project demo which is separating frontend and backend with springboot and vue-cli.
springvue-backend folder under the project root is a simple springboot backend.
the rest of code in the folder is a simpler vue-cli project.

P.S. I started to learn these two frameworks at July 11th 2019, so if you have any advice about what kinds of 
function this project should have or which new technology I should learn for imporving it, please teach me with
your knowledge.
[Advice](bringerXu@protonmail.com)

## backend
port: 8080
Need a simple database
default setting:
    provider: mysql
    database: IE
    port: 3306
    table: user{char(255) name, char(255) password}
    user: root
    password: root

## frontend
port: 8081
### Project setup
```
npm install
```

#### Compiles and hot-reloads for development
```
npm run serve
```

#### Compiles and minifies for production
```
npm run build
```

#### Run your tests
```
npm run test
```

#### Lints and fixes files
```
npm run lint
```

#### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
