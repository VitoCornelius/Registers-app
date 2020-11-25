# Instructions

This is an application for registry management. It exposes the following API:

GET /registers/

PUT /registers/{registerId}?amount={amount}

POST /registers/transfer {
                           "amount": 1000,
                           "fromRegisterId": 2,
                           "toRegisterId": 4
                         }

For verification, you can use a swagger-ui api where you can test the API. Just call [http://localhost:8081/swagger-ui.html]

##Architecture

The architecture is designed to follow the domain driven approach. The com.rafal.in4mo.register.domain package is loosely coupled 
and can easily be extracted into a separate maven artifact or java module. It exposes only the following plugs :
 1. com.rafal.in4mo.register.domain.service.RegisterService
 2. com.rafal.in4mo.register.domain.repository.RegisterRepository
  
This way, in the future, it can be connected with different adapter.
For now, the com.rafal.in4mo.register.infrastructure extends the domain with Jpa Repository adapter and a REST interface


##Running the demo from Intellij Idea

Please follow the following steps to run the demo application:
1. Open the solution in Intellij Idea
2. Execute the application via com.rafal.in4mo.register.RegisterApplication


##Places for further development
The domain object can be extended in the future to hold not only the current balance but also a list of domain events that would indicate
the recharge / deduction actions. Such events could form an event store in the DB.