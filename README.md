# Projeto Consulta de Veículos

Este projeto foi desenvolvido para realizar consultas de informações sobre veículos diretamente pelo terminal. Ele permite que o usuário selecione a marca, o modelo e o ano de um veículo, retornando dados como o valor e outras informações relevantes.

## 🚀 Funcionalidades

- Listagem de marcas de veículos.
- Seleção de modelos de veículos.
- Consulta de anos disponíveis para o modelo escolhido.
- Exibição de informações detalhadas, como o valor do veículo e especificações.

## 🛠️ Tecnologias Utilizadas

- **Java 17 ou superior**
- **Gson** versão `2.11.0` para manipulação de JSON.

## 📦 Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:

- **Java 17 ou superior**: [Instalar Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Biblioteca Gson**: Faça o download do arquivo JAR da versão `2.11.0` no [repositório oficial do Gson](https://github.com/google/gson).

## 🚀 Como executar o projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   
2. Navegue até a pasta do projeto:
```
  cd seu-repositorio
```

3. Certifique-se de que o arquivo gson-2.11.0.jar está disponível no classpath do seu projeto.

4. Compile os arquivos Java:
```
   javac -cp gson-2.11.0.jar src/*.java
```

5. Execute o projeto:
```
   java -cp .:gson-2.11.0.jar src.NomeDaClassePrincipal
```

## 📚 Arquitetura

Este projeto não implementa completamente a Arquitetura Limpa ou o DDD (Domain-Driven Design), mas segue algumas boas práticas de desenvolvimento e organização de código.
O foco principal é fornecer uma aplicação funcional e bem desenvolvida para consultas de veículos.

## 🌟 Exemplos de Uso

Passo a passo no terminal:
O sistema apresenta uma lista de marcas de veículos.
O usuário seleciona uma marca.
O sistema lista os modelos disponíveis para a marca escolhida.
O usuário seleciona um modelo e um ano.
O sistema exibe os detalhes do veículo, incluindo o valor.

# Exemplo de saída no terminal:

Selecione uma marca:
1. Ford
2. Chevrolet
3. Toyota
...

Digite o número da marca desejada: 1

Modelos disponíveis para Ford:
1. Fiesta
2. Focus
...

Digite o número do modelo desejado: 2

Anos disponíveis para Focus:
1. 2020
2. 2021
...

Digite o número do ano desejado: 1

Detalhes do veículo:
Marca: Ford
Modelo: Focus
Ano: 2020
Valor: R$ 75.000,00
...

## 🖋️ Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para enviar issues ou pull requests.

1. Faça um fork do projeto.
2. Crie um branch para sua feature (git checkout -b feature/nome-da-feature).
3. Faça as alterações necessárias e commit (git commit -m 'Adicionei uma nova feature').
4. Envie seu branch (git push origin feature/nome-da-feature).
5. Abra um Pull Request.

## 💻 Desenvolvido com ❤️ por Erick.







