Feature: user wants to check  city crud operation 

  @postTest
  Scenario Outline: user wants to Add city record
    When user sends POST HTTP request
    Then  user adds  id <id>, name <name>, pincode <pincode> and state <state>
    
  
  Examples:
  |  id   |   name   			|    pincode       |      state           |
  |  3    |  Kolkata	    |     700071       |   West Bengal        |
  |  4    |  Hyderabad    |     500003       |   Telangana          |
  
  
  @deleteTest
  Scenario Outline: user wants to check delete operation
  Given user launches the application and sends a delete request
  When  user gives id <id> to delete a record
  Then recevies HttpStatus as OK
  
  Examples:
  |  id  |
  |   5  |
  
  
  @geyByIdTest
  Scenario Outline: user checks for GET By ID operation
  Given user launches the application and send getById request
  When  user gives id <id> to see a particular record
  Then  user recevies the id <id>,name <name>,pincode <pincode>,state <state>
  
  Examples:
  | id  | name 			| pincode      |  state        |
  |  1  | Mumbai  	| 400001 			 |  Maharastra   |
  |  2  | Chennai   | 600002       |  Tamilnadu    |