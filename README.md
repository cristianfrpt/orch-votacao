Olá, agradeço desde já pela oportunidade.




Levando em consideração os desafios, optei por uma arquiterura de orquestração, acredito que esse cenario que foi apresentado, em uma aplicação real, seria apenas um processo de um grande sistema. 
Por isso optei por essa arquitetura, é uma arquitetura mais simples e que nos permite desenvolver muito em cima dela alterar o que for necessario sem grandes complicações.


Vejo que na minha solução ainda há muito a implementar, começando por testes unitarios e integrados, além do próprio teste de carga que foi solicitado.
Eu planejava criar toda a estrutura utilizando o swagger codegen e utilizar a JDBI para manter a performance, em vez da JPA, porém todos esses planos acabaram me custando muito tempo tentando integrar as tecnologias e fazer com que o componente compilasse de fato, o swagger se mostrou meu maior inimigo aqui na minha maquina pessoal hahaha.

Assim tive que realizar o trabalho com o bom e verboso JDBC.

Continuarei trabalhando no projeto, tenho muitas coisas a arrumar e convido-os a revisitarem este projeto.

Falando um pouco das tarefas bonus agora:

●	Tarefa Bônus 1 - Integração com sistemas externos
Realizei a integração desenvolvendo um componente próprio, ele segue as regras citadas na descrição da avaliação tecnica.
Caso queiram testar com o endpoint https://user-info.herokuapp.com/users/{cpf}, isso é facilmente configurado pelo application.properties deste orquestrador.

●	Tarefa Bônus 2 - Performance
Quanto a performance, um dos meus objetivos realizando o desenvolvimento baseado em microserviçoes era utilizar mensageria via filas/kafka para principalmente receber os votos, que na minha visão seria o ponto de maior demanda.

●	Tarefa Bônus 3 - Versionamento da API
Existem algumas formas de versionar a API, eu particularmente gosto de versionar na própria URI como realizei, porém de maneira diferente.
Eu acabo trabalhando bastante com a OpenAPI e por isso vejo que combina bem essas duas ideias.



Diagrama que fiz sem muita pretenção para me situar de tudo que seria desenvolvido, acredito que ajude a compreender a solução.

![Diagrama em branco (2)](https://github.com/cristianfrpt/orch-votacao/assets/44879061/e07d2518-0e4b-47ab-b924-1db8838833c5)






Requisições de exemplo para o orch-votacao:

curl --location 'http://localhost:8080/v1/cadastrarPauta' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "nomePauta"
}'


//Timeout em segundos
curl --location 'http://localhost:8080/v1/abrirVotacao' \
--header 'Content-Type: application/json' \
--data '{
    "idPauta": 9,
    "timeoutPauta": 180 
}'

curl --location 'http://localhost:8080/v1/cadastrarVoto' \
--header 'Content-Type: application/json' \
--data '{
    "idSessao": "51",
    "cpfAssociado": "10101110101",
    "voto": "SIM"
}'

curl --location 'http://localhost:8080/v1/resultadoPauta/51'