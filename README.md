# API SPECIFICATION

## Authentication

All API must use this header for authentication

- Request:
  - Headers:
    - X-Api-Key: "your secret api key"



[//]: # (Start of Bus API)

## Get Bus

Request:
- Method: GET
- Endpoint: '/api/bus/{busId}'
- Headers:
  - Accept: application/json
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
    "price": "long",
    "journeyList": [
      {
        "terminalId": "string1"
      },
      {
        "terminalId": "string2"
      }
    ],
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```


## List Bus

Request:
- Method: GET
- Endpoint: '/api/bus'
- Headers:
  - Accept: application/json
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
      "price": "long",
      "journeyList": [
        {
          "terminalId": "string",
          "terminalName": "string"
        }
      ],
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "busId": "string",
      "BusLicence": "string",
      "busName": "string",
      "busIcon": "string",
      "busImage": "string",
      "price": "long",
      "journeyList": [
        {
          "terminalId": "string",
          "terminalName": "string"
        }
      ],
      "createdAt": "date",
      "updatedAt": "date"
    }
  ]
}

```

[//]: # (End of Bus API)

[//]: # (Start of Terminal API)

## Get Terminal

Request:
- Method: GET
- Endpoint: '/api/terminal/{terminal_id}'
- Headers:
  - Accept: application/json
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
- Endpoint: '/api/terminal'
- Headers:
  - Accept: application/json
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

[//]: # (End of Terminal API)