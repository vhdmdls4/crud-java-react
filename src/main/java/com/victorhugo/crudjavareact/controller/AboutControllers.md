package com.victorhugo.crudjavareact.controller;

## HTTP protocol (8 methods) - GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD, TRACE
------------
* The HTTP protocol is a request-response protocol. A client sends a request to the server in the form of a request method, URI, and protocol version, followed by a MIME-like message containing request modifiers, client information, and possible body content over a connection with a server.

* The server responds to the client in the form of a status line, including the message's protocol version and a success or error code, followed by a MIME-like message containing server information, entity meta information, and possible entity-body content.

* HTTP methods are the standard way to send requests to a server. The methods are typically used to indicate the desired action to be performed for a given resource. The methods are defined in RFC 2616, Section 9. The methods are:

#### GET
- The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.

#### POST
- The POST method submits an entity to the specified resource, often causing a change in state or side effects on the server.

#### PUT
- The PUT method replaces all current representations of the target resource with the request payload.

#### PATCH
- The PATCH method applies partial modifications to a resource.

#### DELETE
- The DELETE method deletes the specified resource.

#### OPTIONS
- The OPTIONS method describes the communication options for the target resource.

#### HEAD
- The HEAD method asks for a response identical to a GET request, but without the response body.

#### TRACE
- The TRACE method performs a message loop-back test along the path to the target resource.

### Quando usar @PathVariable ou @RequestParams
- @RequestParams: filtros de pesquisa mais complexos, configuração do resultado como ordem e afins
- @PathVariable: busca de recursos específicos, id de entidades ou afins