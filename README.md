# TheCatApi

RESTful API project using [thecatapi.com](https://thecatapi.com/) as external service to implement /breeds.

#### Technical Stack

- **Backend Framework:** Backend Framework: Spring Boot v3.2.3 (Java v17)
- **External Service Integration:** TheCatAPI [thecatapi.com](https://thecatapi.com/)
- **API Documentation:** Swagger/OpenAPI

## Table of Contents

- [Deployment](#deployment)
- [API Reference](#api-reference)
  - [Get all breeds](#get-all-breeds)
  - [Get breed](#get-breed)
  - [Search breeds](#search-breeds)

## Deployment

Clone the project

```bash
  git clone https://github.com/orregoandres96/thecatapi.git
```

Go to the project directory

```bash
  cd thecatapi
```

Install dependencies

```
  ./mvnw clean install
```

To deploy this project run the next commands in the project root directory

```bash
  ./mvnw clean package
  docker build -t thecatapi .
  docker run -p 8080:8080 thecatapi
```

or

```
  sh deploy.sh
```

## API Reference

The server runs on [localhost:8080](http://localhost:8080/). check the [API Documentation](http://localhost:8080/api-doc/index.html)

#### Get all breeds

```http
  GET /api/v1/breeds
```

| Parameter | Type     | Description   | Example  |
| :-------- | :------- | :------------ | :------- |
| `limit`   | `string` | **Optional**. | limit=10 |
| `page`    | `string` | **Optional**. | page=0   |

#### Get breed

```http
  GET /breeds/${breed_id}
```

| Parameter  | Type     | Description                        |
| :--------- | :------- | :--------------------------------- |
| `breed_id` | `string` | **Required**. Id of breed to fetch |

#### Search breeds

```http
  GET /breeds/search?q=${breed_name}&attach_image=${1|0}
```

| Query Parameter | Type     | Description                                                         | Example        |
| :-------------- | :------- | :------------------------------------------------------------------ | :------------- |
| `q`             | `string` | **Required** search term for breed name                             | q=air          |
| `attach_image`  | `string` | **Optional**. whether to attach the reference_image_id image or not | attach_image=1 |
