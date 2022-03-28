# java-OpenFeign-example
Projeto simples para dar suporte ao meu artigo sobre clientes http em java.
Artigo: https://medium.com/@andrelcalves/http-rest-cliente-em-java-6af3005a15

### Anotação @FeignClient
* @FeignClient(name=””, url=””) – A URL do serviço Rest(Api) que vamos fazer a requisição HTTP, no nosso exemplo utilizamos a url base https://jsonplaceholder.typicode.com 
* @GetMapping(value=”/todos”,consumes=MediaType.APPLICATION_JSON_VALUE) – Endpoint que vamos consumir, no nosso exemplo será "/todos" que retorno um json. 
* List<TodoModel>getTodos() - Tipo de retorno que nosso metódo vai retornar, no nosso exemplo criamos um Model que representa o retorno do Json retornado pelo endpoint.

