# Desenvolvendo uma Aplicação de E-commerce com Spring Boot em Java

## Introdução:
 Vamos explorar o processo de desenvolvimento de uma aplicação de e-commerce utilizando o framework Spring Boot em Java.

## 1. Visão Geral do Projeto:
A aplicação de e-commerce que vamos desenvolver permitirá aos usuários calcular o valor total de um pedido, considerando uma porcentagem de desconto e o custo de frete. A aplicação seguirá as seguintes regras para o cálculo do frete:

| Faixa de Preço       | Frete   |
|----------------------|---------|
| Abaixo de R$ 100.00  | R$ 20.00|
| De R$ 100.00 até R$ 200.00 | R$ 12.00 |
| R$ 200.00 ou mais    | Grátis  |

## 2. Tecnologias Utilizadas:
- Java: Linguagem de programação amplamente utilizada para desenvolvimento de aplicativos corporativos.
- Spring Boot: Framework Java que simplifica o desenvolvimento de aplicativos baseados em Spring.
- Maven: Ferramenta de gerenciamento de dependências para projetos Java.
- Git: Sistema de controle de versão distribuído para gerenciamento do código-fonte.
- GitHub: Plataforma de hospedagem de código-fonte baseada em Git.

## 3. Estrutura do Projeto:
O projeto será estruturado em diferentes pacotes e classes para manter a organização e a modularidade do código. Teremos os seguintes componentes principais:
```mermaid

flowchart TD
    subgraph "Pacotes"
        A[com.ecommerce.mhsecommerce] --> B[entities]
        A[com.ecommerce.mhsecommerce] --> C[services]
        A[com.ecommerce.mhsecommerce] --> D[MhsEcommerceApplication]
    end

    subgraph "Pacote: entities"
        B[entities] --> E[Order]
    end

    subgraph "Pacote: services"
        C[services] --> F[OrderService]
        C[services] --> G[ShippingService]
    end
  ```

## 4. Funcionalidades da Aplicação:
- **Cálculo do Valor Total do Pedido**: Os usuários podem inserir o código do pedido, o valor básico e a porcentagem de desconto. A aplicação calculará o valor total do pedido de acordo com as regras especificadas.
- **Tratamento de Exceções**: A aplicação realiza o tratamento de exceções para garantir que o sistema seja robusto e capaz de lidar com diferentes cenários, como entrada inválida ou números negativos.

## 5. Diagrma de classes:
```mermaid
classDiagram
    class MhsEcommerceApplication {
        +run(String...)
    }
    class ExceptionUtil {
        +handleInputMismatchException(InputMismatchException)
        +handleNegativeNumberException()
    }
    class Order {
        -code: Integer
        -basic: Double
        -discount: Double
        +Order()
        +Order(Integer, Double, Double)
        +getCode(): Integer
        +setCode(Integer)
        +getBasic(): Double
        +setBasic(Double)
        +getDiscuont(): Double
        +setDiscuont(Double)
    }
    class OrderService {
        -shippingService: ShippingService
        +total(Order): double
    }
    class ShippingService {
        +shipment(Order): double
    }
    MhsEcommerceApplication "1" -- "1" OrderService : uses
    OrderService "1" -- "1" ShippingService : uses
    MhsEcommerceApplication "1" -- "1" ExceptionUtil : uses
    OrderService "1" -- "1" Order : uses
    ShippingService "1" -- "1" Order : uses
```


## Conclusão:
Com as tecnologias e práticas adequadas, é possível desenvolver soluções de e-commerce poderosas e escaláveis para atender às necessidades do mercado atual.

