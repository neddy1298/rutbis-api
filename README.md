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
  "arrivalTime": "time"
}
```
