# 📦 Person API

> Uma API RESTful simples construída com Spring Boot, seguindo boas práticas e novas releases lançadas de linguagens e dependências. <br>
> O projeto inclui funcionalidades como CRUD de pessoas, enriquecimento automático de endereço via CEP, e utiliza MongoDB como banco de dados.

---

## 🚀 Tecnologias

- ✅ Java 25+
- ✅ Spring Boot 3.5.6
- ✅ Spring Web
- ✅ Spring Data MongoDB
- ✅ Maven
- ✅ Docker

---

### 💡 Questões interessantes implementadas neste projeto

* **🔄 Enriquecimento automático de endereço via CEP**: Integração com API externa para buscar e preencher dados de endereço a partir do CEP informado.
* **🧵 Suporte a Virtual Threads (Java 21+)**: Utilização de recursos modernos da JVM para maior escalabilidade e performance.
* **♻️ Estrutura limpa e desacoplada**: Separação clara entre camadas (domínio, aplicação, infraestrutura) seguindo princípios do Clean Architecture.
* **🌐 Versionamento de API**: Implementação de versionamento via URI para facilitar evolução sem breaking changes.
* **🔗 Integração HTTP moderna com RestClient**: Utilização do `RestClient` (substituto do `RestTemplate`) para chamadas HTTP externas, aproveitando recursos mais modernos, fluentes e seguros da stack Spring.

---

## 🔧 Instalação

### Pré-requisitos:
- Java 25 ou superior
- Maven
- Docker

### Clonar o projeto:
```bash
git https://github.com/guiareze/persons.git
cd persons
````

### Rodar localmente:

```bash
./mvnw spring-boot:run
```

> A aplicação estará disponível em:
> 📍 `http://localhost:8080`

---

## 🧪 Exemplos de Endpoints

### 🔍 Buscar pessoa por ID

```http
GET /persons/{personId}
```

### 📦 Criar pessoa

```http
POST /persons
Content-Type: application/json
```

```json
{
  "name": "Guilherme Rezende",
  "age": 30,
  "cep": "06140010"
}
```

---

## 🗂️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/br/com/guiareze/persons/
│   │   ├── application/
│   │   ├── domain/
│   │   ├── gateway/
│   │   ├── infrastructure/
│   │   ├── main/
│   │   └── PersonsApplication.java
│   └── resources/
│       ├── application.properties
```

---

## 🐳 Docker

### Build da imagem:

```bash
cd docker
docker-compose up
```

---

## 🧰 Variáveis de Ambiente (exemplo)

| Nome                    | Padrão               | Descrição                    |
| ----------------------- | -------------------- | ---------------------------- |
| `SERVER_PORT`           | `8080`               | Porta em que a API irá rodar |

---

## 📘 Documentação

Acesse a documentação Swagger (se habilitada) em:

```
http://localhost:8080/swagger-ui.html
```

---
