# SupportSystem

## Integrantes
Bruno Cavalheiro Sahlberg  
Gabriel Furlan Fogaça  
João Vitor Morais Ribas  

## Tema
### **Sistema de venda de produtos eletrônicos**  

O sistema desenvolvido tem como objetivo simular a realização de uma venda de um eletrônico no ramo da informática, com intuito de aplicar os conhecimentos adquiridos em sala de aula. Para ser realizada, a venda deve conter um cliente, um funcionário, um produto e sua respectiva quantidade.  

Essas informações, com exceção da quantidade, são trazidas para a interface a partir de uma consulta no banco de dados. Ao selecionar os devidos campos e clicar no botão para concluir a venda, o sistema irá realizar um insert no banco com as informações desta nova venda e, ao mesmo tempo, diminuir a quantidade do determinado produto disponível em estoque.  

### Aplicativos utilizados:
- NetBeans  
- XAMPP
- MySQL Workbench

### Configurar a aplicação para testes: 
#### Criação do Banco de Dados  
1. Abrir o XAMPP e inicializar o MySQL  
2. Criar o Banco no MySQL Workbench  
    2.1 Abrir o MySQL Workbench e criar uma nova conexão localhost  
    2.2 Configurar a conexão com login "root", sem senha e com a porta inicializada pelo MySQL (3306)  
3. Abrir a nova conexão criada, inserir e executar a syntaxe que consta no arquivo infomilDB.sql  

#### Testar a aplicação
1. Abrir o NetBeans e o projeto SupportSystem  
2. Abrir a Interface e executar o arquivo (Shift + F6)  
3. Selecionar os dados desejados nos campos de preenchimento
4. Clicar em "Concluir Venda" para inserir a venda na tabela      

## GitHub  
Para realizar o download do repositório, basta acessar o link abaixo:  
https://github.com/BrunoSahlberg/SupportSystem
