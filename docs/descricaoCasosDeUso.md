Caso de uso 1
=============

Nome
-------------------------
Pesquisar voo e conexões.

Descrição sucinta
-------------------
Qualquer usuário do sistema pode pesquisar um voo existente. 

Atores
-----------------
* Cliente 
* Empresa (vendedora)
*(Usuários não cadastrados)

Pré-Condições
------------
**Não há**

Fluxo básico
--------
1. O usuário do sistema deve selecionar a opção pesquisar voos.
2. O sistema deve requisitar ao usuário um formulário para ser preenchido com datas, locais de origem e destino, etc.
3. O usuário deve preencher e enviar o formulário.
4. O sistema deverá fazer uma consulta no banco e retornar as conexões existententes com as informações requisitadas.

Fluxo alternativo
----------------
**Não há**

Caso de uso 2
=============

Nome
----
CRUD passagens 

Descrição sucinta
-----------------
A Empresa (Vendedor) irá cadastrar voos e conexoes que gerarão passagens.

Atores
------
* Empresa (Vendedora)

Pré-Condições
-------------
1. O usuário deve estar logado como vendedor
Fluxo básico
------------
1. O sistema terá a opção Cadastrar/Modificar/Deletar voos e Cadastrar/Modificar/Deletar conexões (para usuarios do tipo vendedor)
2. O vendedor acessará a opção Cadastrar voos primeiramente.
3. O vendedor irá realizar o cadastro do voo.
4. O sistema adicionará o voo cadastrado pelo usuario no banco de dados.
5. O sistema gerará todas as passagens produzidas por este voo cadastrado automaticamente e as adicionarão no banco.
6. **(Repetir a operação 3 à 5 até que a conexão possa ser cadastrada)** O usuário deve selecionar a opção cadastrar uma conexão.
7. O sistema deve listar todas os voos com checkbox para que o usuário possa selecionar os voos que compoẽm uma conexão.
8. O usuário deve delecionar os voos que realizam a conexão e preencher o formulario de cadastro.
9. O sistema antes de armazenar no banco de dados deve verificar se as conexões são possíveis de serem feitas.
10. Após a verificação e dados OK o sistema adiciona essas informações no banco de dados.

Fluxo Alternarivo
-----------------
** * Caso os voos já tivessem sido adicionados**
1. Continuar a partir do fluxo básico item 6.

** * Caso a verificação do fluxo básico item 9 não tenha sido OK** 
1. O sistema deve exibir o erro que foi dado ao usuário e exigir modificação, porém a opção de continuar com o erro deve ser exibida.
1.1 Caso o usuario pretenda continuar com o erro, o sistema deve requisitar a senha do usuário para efetuar o cadastro com o conflito.

   
