
# SolidarizAção

**"SolidarizAção: conectando quem quer ajudar com quem precisa de apoio."**

## 🧩 Tema e Objetivo do Projeto

O **SolidarizAção** é uma plataforma web inspirada no site [Exército de Doações](https://www.exercitodoacoes.org.br/), com o diferencial de **promover um elo direto entre doadores e campanhas solidárias**.

O objetivo é facilitar a logística de arrecadações, permitindo:

- Cadastro de campanhas solidárias
- Solicitação de caixas de coleta
- Registro de doações
- Gerenciamento de perfis de usuários

---

## 💻 Tecnologias Utilizadas

### Front-end
- HTML5
- CSS3
- JavaScript (ES6)
- Bootstrap

### Back-end
- Java (Servlets)
- JDBC

### Banco de Dados
- MySQL

### Servidor Web
- Apache Tomcat 10

### Ferramentas de Apoio
- MySQL Workbench
- VS Code / Apache NetBeans IDE 20

---

## 🏗️ Estrutura do Sistema

### Módulos principais:

1. **Autenticação de Usuários**
   - Cadastro e login
   - Validação de sessões

2. **Perfil do Usuário**
   - Dados pessoais
   - Campanhas organizadas ou solicitadas
   - Doações agrupadas por tipo

3. **Campanhas**
   - Cadastro de campanhas
   - Visualização de pontos de coleta

4. **Solicitação de Caixas**
   - Formulário completo com endereço, itens e datas
   - Criação ou associação com campanhas

5. **Registro de Doações**
   - Itens variados (roupas, alimentos, brinquedos etc.)

---

## 🖼️ Capturas de Tela e Interface

### 📌 Tela Inicial
Acesso rápido às principais páginas do sistema.

### 🔐 Tela de Login
Formulário simples com verificação de sessão ativa.

### 👤 Perfil do Usuário
Exibe:
- Nome, email, cidade e telefone
- Campanhas organizadas (com datas)
- Doações realizadas (agrupadas por item)

### 📦 Solicitação de Caixa
Formulário dividido por:
- Endereço e dados de contato
- Itens coletados
- Campanha (nova ou existente)
- Datas de início e fim

### 🗺️ Pontos de Coleta
Lista pública com:
- Nome da campanha
- Itens coletados
- Endereço do ponto
- Período da campanha

---

## 🚀 Como Executar Localmente

1. **Clone o repositório**

Via GitHub:

```bash
git clone -b main https://github.com/LetMineiro/SolidarizAcao.git
```

Ou baixe o ZIP em: [github.com/LetMineiro/SolidarizAcao](https://github.com/LetMineiro/SolidarizAcao)

---

2. **Importe no NetBeans ou Eclipse**

- No NetBeans: `File > Open Project`
- Configure o Apache Tomcat na aba *Services*

---

3. **Configure o Banco de Dados**

- Crie o banco MySQL `solidarizacao`
- Execute o script `bdSQL.sql` (tabelas e inserts)

No arquivo `Conexao.java`, atualize:

```java
String url = "jdbc:mysql://localhost:3306/solidarizacao";
String usuario = "root";
String senha = "sua_senha";
```

---

4. **Execute o projeto**

- Inicie o servidor Tomcat
- Acesse: [http://localhost:8080/solidarizacao/login.html](http://localhost:8080/solidarizacao/login.html)

---

## 📎 Autoria

- **Aluna:** Ana Letícia Mineiro Leandro  
- **Aluno:** Francisco Janylson de Sousa Silva  
- **Curso:** Sistemas de Informação – UECE – Campus Mombaça  
- **Disciplina:** Desenvolvimento de Software para a Web  
- **Professor:** Leonardo Ferreira Da Costa
