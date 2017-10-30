# store-meta-data

# Local Build and Run
git clone https://github.com/sreedhar9580/store-meta-data.git
cd store-meta-data
mvn clean install
mvn spring-boot:run

# Sample Request

1. create a Json file with below data
{
  "id": 1212,
  "name": "Sid",
  "age": 30,
  "salary": 200,
  "designation": "Developer"
}
2. open browser with http://localhost:8080/
3. Input the above saved Json file and click Submit button.
4. There will be Employee.txt file created int the main root.
