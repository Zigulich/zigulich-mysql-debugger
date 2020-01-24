## zigulich-mysql-debugger
Criado para verificar as querys em que determinado software está executando dentro de uma Thread.

### Como funciona?
Atráves do número da [Thread do banco de dados Mysql](https://dev.mysql.com/doc/refman/8.0/en/mysql-threads.html), o software faz requisições a cada segundo, para verificar se alguma query foi executada, caso a mesma for, mostra para o usuário.

### Instalação
Faça o download do arquivo **dist/MySQLDebugger-1.0.exe** e o execute. O mesmo irá criar um arquivo chamado **Conn.ini**, após isso, edite o arquivo inserindo os seguintes parâmetros `MYSQL_HOST;MYSQL_USER;MYSQL_PASS`, após isso, execute o programa.

> Desenvolvido em 24 de janeiro de 2020.