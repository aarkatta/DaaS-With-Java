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

**MongoDB Setup:**

- Create a free account on MongoDB ATLAS (https://cloud.mongodb.com/)
- Create a cluster and the database inside the cluster followed by a Collection
  - Cluster Name: _loancatalog_
  - Database Name: _customerloandb_
  - Document Name: _newloanrequest_
- Go to Network Access and add your current IP address

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/c3028a6d-6d3c-45e4-87ca-006bfa536d86)


![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/8433bbda-9283-4b2e-8bb3-855c2b66744b)


**Build and Run the application in local (MAC):**

Build the project: _mvn clean install_
Build docker image: _docker build -t loanapi-daas ._  
Run the Docker image: _docker run -p 8080:8080 loanapi-daas _

<img width="1211" alt="image" src="https://github.com/aarkatta/DaaS-With-Java/assets/6164192/72464b65-ce98-4698-8ed8-e80d032d7616">


**Deploy the app to AWS Fargate**

- Create ECR and push the docker image using AWS cli. ECR will provide the push commands with repository name

 ![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/4638ead0-aae9-4ddf-ba75-5cacc40b395d)
 
 - Create ECS cluster and run the task. Select the launch type **Fargate**

![Screenshot 2023-05-12 at 7 01 26 PM](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/415fb31e-1584-4a48-bd23-e39b7a22b582)

- Create a security group to allow port 8080 to access the application

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/2b6f5b8a-2b61-49b3-8009-d57c60cbd2b7)

![Screenshot 2023-05-12 at 7 07 50 PM](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/a8f78b0f-b454-492f-a16c-33cd153d9bf2)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/8754dad9-4105-43db-83f3-2134e0974a31)

- Access the loan application endpoint using ECS ip address

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/a2b29cf2-209c-40ec-af65-de3f64ef6063)

**API Gateway**

- Select REST API followed by "Create Method" and Request Mapping
- Provide ECS Task URL in the Endpoint URL 
- Enable throttling based the requirements

![Screenshot 2023-05-12 at 11 26 10 PM](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/6d57fcc3-3e16-4a0d-84bb-e323e068dae8)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/7dd51220-96d8-4dd3-95c6-ecf3cf6400d4)

Repeat the steps to set up customer API endpoint.

![Screenshot 2023-05-12 at 11 49 28 PM](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/5d525327-27e7-4603-bcc5-602a44fa9121)


![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/ce1b8caf-a95c-4ad1-8650-40277d6ca04e)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/5bebdcec-7191-4210-80de-dd1f655bb7e0)

![image](https://github.com/aarkatta/DaaS-With-Java/assets/6164192/8b36fb7e-fe74-405a-8566-a818969fc311)












 
 













