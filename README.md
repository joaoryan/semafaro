# semafaro

Para fixar os conceitos fundamentais de Semáforos, crie um exemplo simples de aplicação Java que seja capaz de demonstrar:
O uso de uma Seção Crítica SEM controle;
O uso de uma Seção Crítica COM controle

Nome: João Ryan dos Santos
Matricula: 239

Logica usada para projeto foi utilizar um contador compartilhado por varias threads em que o contador e incrementado varias vezes,

sem controle ocorrer uma condição de corrida (race condition), onde duas ou mais threads tentam acessar e modificar o contador ao mesmo tempo. 
Isso pode levar a resultados inconsistentes.

com controle usamos semáforo (Semaphore) para controlar o acesso à seção crítica, que é a operação de incrementar o contador. O semáforo é inicializado com uma permissão (1), 
o que permite que apenas uma thread acesse a seção crítica por vez. As outras threads aguardam a liberação do semáforo.