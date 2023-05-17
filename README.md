# DaaS-With-Java
Build API to expose the data from MongoDB

**Problem statement**

A financial firm, aarkay-credit-union that offers credit cards. We want to expose the documents present in the collection using a DaaS service that can be searched for by either **ApplicationId** or **CustomerId**.

## Tech Stack

**Spring Boot**, ****Spring Data MongoDB**, **openjdk:17**, **Docker**, **Querydsl**, **AWS ECS, AWS Fargate, AWS API Gateway****

**Querydsl**: Querydsl is a framework which enables the construction of statically typed SQL-like queries.It maintains the benefits of type safety and portability. http://querydsl.com/

**Prerequisites**

- Java 17
- Maven
- Docker
- MongoDB
- AWS Account

**Endpoints:**
- http://localhost:8080/loan/application/{{applicationId}}
- http://localhost:8080/loan/customer/{{customerId}}/application

**MongoDB Setup:**

- Create a free account on MongoDB ATLAS (https://cloud.mongodb.com/)
- Create a cluster and the database inside the cluster followed by a Collection
  - Cluster Name: _loancatalog_
  - Database Name: _customerloandb_
  - Document Name: _newloanrequest_
- Go to Network Access and add your current IP address. This will allow your local springboot app to access MongoDB


**Build and Run the application in local (MAC):**

Build the project: _mvn clean install_
Build docker image: _docker build -t loanapi-daas ._  
Run the Docker image: _docker run -p 8080:8080 loanapi-daas _


**Deploy the app to AWS Fargate**

- Create ECR and push the docker image using AWS cli. ECR will provide the push commands with repository name
 
 - Create ECS cluster and run the task. Select the launch type **Fargate**

- Create a security group to allow port 8080 to access the application

- Access the loan application endpoint using ECS ip address

**API Gateway**

- Select REST API followed by "Create Method" and Request Mapping
- Provide ECS Task URL in the Endpoint URL 
- Enable throttling based the requirements
- Repeat the steps to set up customer API endpoint.

MongoDB:

![Screenshot 2023-05-16 at 6 42 35 PM](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/d9707434-9f51-46a2-ace3-3d2ce247a449)

Localhost:

<img width="1238" alt="image" src="https://github.com/aarkatta/DaaS-With-Java/assets/6164192/161427da-82f5-4501-bd7b-f50a61344e9f">

AWS ECR:

![Screenshot 2023-05-12 at 6 54 58 PM](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/ab19f11f-468e-41ef-a5a6-72b9e4571c1f)

AWS ECS Cluster:

![Screenshot 2023-05-12 at 6 59 23 PM](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/f1555b7f-7fce-4f5b-a62f-ea7c92e9c474)

AWS ECS task:

![Screenshot 2023-05-12 at 7 00 52 PM](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/df634590-cb65-4223-902b-2c6d05703ae5)


![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/59d898b3-0fdb-4b32-9fa4-5354b07fe2a8)


![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/ba09e5d1-931c-4060-878f-b8224b57d9cd)


![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/e3b26d76-c0fb-4e75-aa33-3d71d7e3bc8d)


![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/4b415d9b-8fe0-4a7e-ba56-0092508ffb18)

ECS Cluster URL:

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/f04ab8cf-d81a-44b3-a358-3a226f00aaed)

AWS API Gateway:

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/1be26129-85a4-44e3-8780-656a68b8ce1e)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/a18ccc45-5b56-499f-bcd5-ab1fef977e44)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/3909d239-f695-42ae-b253-d047e437b2da)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/e1be26a1-5d3f-43df-84a3-64debeefd1df)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/ba3a422c-375f-4182-a92d-55e9a5a89380)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/04ef0c22-6824-4b65-847a-4145961efc35)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/ba3a422c-375f-4182-a92d-55e9a5a89380)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/7f58fe44-2467-44ad-bd54-1a66188dc912)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/1e0d562c-d6bc-4ce7-b604-fb296fcf8bb4)


![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/cdbbd5fe-f195-4a5b-8169-f9f1da994eb1)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/b30753af-fe9d-47e4-83d0-e5f2ac0cb4c3)



















