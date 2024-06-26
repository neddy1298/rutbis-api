# API SPECIFICATION

## Authentication

All API must use this header for authentication

- Request:
  - Headers:
    - X-Api-Key: "api_key"


[//]: # (Start of Bus API)

## Create Bus
Request:
- Method: POST
- Endpoint: '/api/bus'
- Headers:
  - Content-Type: application/json
  - Accept: application/json
  - X-Api-Key: "api_key"
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "busId": "string",
    "busLicense": "string",
    "busName": "string",
    "busIcon": "int",
    "busImage": "string",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Get Bus

Request:
- Method: GET
- Endpoint: '/api/bus/{bus_id}'
- Headers:
  - Accept: application/json
  - X-Api-Key: "api_key"
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "busId": "string",
    "busLicense": "string",
    "busName": "string",
    "busIcon": "int",
    "busImage": "string",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```


## List Bus

Request:
- Method: GET
- Endpoint: '/api/buses'
- Headers:
  - Accept: application/json
  - X-Api-Key: "api_key"
- Query Params:
  - page: int
  - size: int
  - sort: string
  - order: string
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": [
    {
      "busId": "string",
      "busLicense": "string",
      "busName": "string",
      "busIcon": "int",
      "busImage": "string",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "busId": "string",
      "busLicense": "string",
      "busName": "string",
      "busIcon": "int",
      "busImage": "string",
      "createdAt": "date",
      "updatedAt": "date"
    }
  ]
}
```

## Update Bus
Request:
- Method: PUT
- Endpoint: '/api/bus/{bus_id}'
- Headers:
  - Content-Type: application/json
  - Accept: application/json
  - X-Api-Key: "api_key"
- Body:
```json
{
  "busLicense": "string",
  "busName": "string",
  "busIcon": "int",
  "busImage": "string"
}
```
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "busLicense": "string",
    "busName": "string",
    "busIcon": "int",
    "busImage": "string",
    "updatedAt": "date"
  }
}
```

## Delete Bus
Request:
- Method: DELETE
- Endpoint: '/api/bus/{bus_id}'
- Headers:
  - Accept: application/json
  - X-Api-Key: "api_key"

- Response:
```json
{
    "code": "int",
    "status": "string"
}

```

[//]: # (End of Bus API)

[//]: # (Start of Terminal API)

## Create Terminal
Request:
- Method: POST
- Endpoint: '/api/terminal'
- Headers:
  - Content-Type: application/json
  - Accept: application/json
  - X-Api-Key: "api_key"
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "terminalId": "string",
    "terminalName": "string",
    "terminalLocation": "string",
    "terminalIcon": "int",
    "terminalImage": "string",
    "serviceTime": "time",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Get Terminal

Request:
- Method: GET
- Endpoint: '/api/terminal/{terminal_id}'
- Headers:
  - Accept: application/json
  - X-Api-Key: "api_key"
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "terminalId": "string",
    "terminalName": "string",
    "terminalLocation": "string",
    "terminalIcon": "int",
    "terminalImage": "string",
    "serviceTime": "time",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## List Terminal

Request:
- Method: GET
- Endpoint: '/api/terminals'
- Headers:
  - Accept: application/json
  - X-Api-Key: "api_key"
- Query Params:
  - page: int
  - size: int
  - sort: string
  - order: string
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": [
    {
      "terminalId": "string",
      "terminalName": "string",
      "terminalLocation": "string",
      "terminalIcon": "int",
      "terminalImage": "string",
      "serviceTime": "time",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "terminalId": "string",
      "terminalName": "string",
      "terminalLocation": "string",
      "terminalIcon": "int",
      "terminalImage": "string",
      "serviceTime": "time",
      "createdAt": "date",
      "updatedAt": "date"
    }
  ]
}


```

## Update Terminal
Request:
- Method: PUT
- Endpoint: '/api/terminal/{terminal_id}'
- Headers:
  - Content-Type: application/json
  - Accept: application/json
  - X-Api-Key: "api_key"
- Body:
```json
{
  "terminalName": "string",
  "terminalLocation": "string",
  "terminalIcon": "int",
  "terminalImage": "string",
  "serviceTime": "time"
}
```
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "terminalName": "string",
    "terminalLocation": "string",
    "terminalIcon": "int",
    "terminalImage": "string",
    "serviceTime": "time",
    "updatedAt": "date"
  }
}
```

## Delete Terminal
Request:
- Method: DELETE
- Endpoint: '/api/terminal/{terminal_id}'
- Headers:
  - Accept: application/json
  - X-Api-Key: "api_key"
- Response:
```json
  {
      "code": "int",
      "status": "string"
  }
  ```

[//]: # (End of Terminal API)

[//]: # (Start of Bus Terminal API)

## Create Bus Terminal
Request:
- Method: POST
- Endpoint: '/api/bus-terminal'
- Headers:
  - Content-Type: application/json
  - Accept: application/json
  - X-Api-Key: "api_key"
- Body:
```json
{
  "busId": "string",
  "terminalId": "string",
  "price": "long",
  "departureTime": "time",
  "arrivalTime": "time",
  "createdAt": "date",
  "updatedAt": "date"
}
```
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "busId": "string",
    "terminalId": "string",
    "price": "long",
    "departureTime": "time",
    "arrivalTime": "time",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Get Journey

Request:
- Method: GET
- Endpoint: '/api/journey/{journey_id}'
- Headers:
  - Accept: application/json
  - X-Api-Key: "api_key"
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "journeyId": "string",
    "busId": "string",
    "terminalId": "string",
    "price": "long",
    "departureTime": "time",
    "arrivalTime": "time",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## List Journey

Request:
- Method: GET
- Endpoint: '/api/journeys'
- Headers:
  - Accept: application/json
  - X-Api-Key: "api_key"
- Query Params:
  - page: int
  - size: int
  - sort: string
  - order: string
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": [
    {
      "journeyId": "string",
      "busId": "string",
      "terminalId": "string",
      "price": "long",
      "departureTime": "time",
      "arrivalTime": "time",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "journeyId": "string",
      "busId": "string",
      "terminalId": "string",
      "price": "long",
      "departureTime": "time",
      "arrivalTime": "time",
      "createdAt": "date",
      "updatedAt": "date"
    }
  ]
}
```

## Update Journey
Request:
- Method: PUT
- Endpoint: '/api/journey/{journey_id}'
- Headers:
  - Content-Type: application/json
  - Accept: application/json
  - X-Api-Key: "api_key"
- Body:
```json
{
  "busId": "string",
  "terminalId": "string",
  "price": "long",
  "departureTime": "time",
  "arrivalTime": "time"
}
```
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "busId": "string",
    "terminalId": "string",
    "price": "long",
    "departureTime": "time",
    "arrivalTime": "time",
    "updatedAt": "date"
  }
}
```

## Delete Journey
Request:
- Method: DELETE
- Endpoint: '/api/journey/{journey_id}'
- Headers:
  - Accept: application/json
  - X-Api-Key: "api_key"
- Response:
```json
{
    "code": "int",
    "status": "string"
}
```

[//]: # (End of Bus Terminal API)

[//]: # (Start of User API)

## Create User
Request:
- Method: POST
- Endpoint: '/api/user'
- Headers:
  - Content-Type: application/json
  - Accept: application/json
- Body:
```json
{
  "userName": "string",
  "userEmail": "string",
  "userPassword": "string",
  "userAvatar": "int"
}
```
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "userId": "string",
    "userName": "string",
    "userEmail": "string",
    "userPassword": "string",
    "userAvatar": "int",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Get User

Request:
- Method: GET
- Endpoint: '/api/user/{user_id}'
- Headers:
  - Accept: application/json
- Authorization
  - Bearer: "token jwt"
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "userId": "string",
    "userName": "string",
    "userEmail": "string",
    "userPassword": "string",
    "userAvatar": "int",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Update User

Request:
- Method: PUT
- Endpoint: '/api/user/{user_id}'
- Headers:
  - Content-Type: application/json
  - Accept: application/json
- Authorization
  - Bearer: "token jwt"
- Body:
```json
{
  "userName": "string",
  "userEmail": "string",
  "userPassword": "string",
  "userAvatar": "int"
}
```
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "userName": "string",
    "userEmail": "string",
    "userPassword": "string",
    "userAvatar": "int",
    "updatedAt": "date"
  }
}
```

## Delete User

Request:
- Method: DELETE
- Endpoint: '/api/user/{user_id}'
- Headers:
  - Accept: application/json
- Authorization
  - Bearer: "token jwt"
- Response:
```json
{
    "code": "int",
    "status": "string"
}
```

[//]: # (End of User API)