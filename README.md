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
    "busIcon": "string",
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
    "busIcon": "string",
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
      "busIcon": "string",
      "busImage": "string",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "busId": "string",
      "busLicense": "string",
      "busName": "string",
      "busIcon": "string",
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
  "busIcon": "string",
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
    "busIcon": "string",
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
      "terminalImage": "string",
      "serviceTime": "time",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "terminalId": "string",
      "terminalName": "string",
      "terminalLocation": "string",
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

## Get Bus Terminal

Request:
- Method: GET
- Endpoint: '/api/bus-terminal/{bus_terminal_id}'
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
    "terminalId": "string",
    "price": "long",
    "departureTime": "time",
    "arrivalTime": "time",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## List Bus Terminal

Request:
- Method: GET
- Endpoint: '/api/bus-terminals'
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
      "terminalId": "string",
      "price": "long",
      "departureTime": "time",
      "arrivalTime": "time",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
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

## Update Bus Terminal
Request:
- Method: PUT
- Endpoint: '/api/bus-terminal/{bus_terminal_id}'
- Headers:
  - Content-Type: application/json
  - Accept: application/json
  - X-Api-Key: "api_key"
- Body:
```json
{
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
    "price": "long",
    "departureTime": "time",
    "arrivalTime": "time",
    "updatedAt": "date"
  }
}
```

## Delete Bus Terminal
Request:
- Method: DELETE
- Endpoint: '/api/bus-terminal/{bus_terminal_id}'
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
  "email": "string",
  "password": "string",
  "fullName": "string",
  "avatar": "string"
}
```
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "userId": "string",
    "email": "string",
    "fullName": "string",
    "avatar": "string",
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
    "email": "string",
    "fullName": "string",
    "avatar": "string",
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
  "email": "string",
  "fullName": "string",
  "avatar": "string"
}
```
- Response:
```json
{
  "code": "int",
  "status": "string",
  "data": {
    "email": "string",
    "fullName": "string",
    "avatar": "string",
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