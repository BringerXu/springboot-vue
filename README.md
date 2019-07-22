# springvue-frontend
This project is a web project demo which is separating frontend and backend with springboot and vue-cli.
springvue-backend folder under the project root is a simple springboot backend.
the rest of code in the folder is a simpler vue-cli project.

P.S. I started to learn these two frameworks at July 11th 2019, so if you have any advice about what kinds of 
function this project should have or which new technology I should learn for imporving it, please teach me with
your knowledge.
[Advice](mailto:bringerXu@protonmail.com)

## backend
port: 8080  

Need a simple database  

IE:  

​	{  

​		port:3306,  

​		user:root,  

​		password:root,  

​		table:  

​			{  

​				user{char(255) name, char(255) password}  

​				tableInfo{char(255) tablename, int tablerows}

​			}  

​	}  

```properties
useAffectedRows=true
```

## frontend
port: 8081
### Project setup
```
1. Run backend:  
	/root_of_project/springvue-backend/
	IDE(IDEA, Eclipse...) run SpringvueApplication.class
2. Run frontend:
	/root_of_project  
	npm run serve
3. browse localhost:8081
```
