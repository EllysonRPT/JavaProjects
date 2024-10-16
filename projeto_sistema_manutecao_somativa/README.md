# Documentação Técnica: Sistema de Manutenção Preventiva e Corretiva

## 1. Definição do Tema

O **Sistema de Manutenção Preventiva e Corretiva** é um software destinado ao gerenciamento do ciclo de vida de máquinas e equipamentos industriais. Seu objetivo é minimizar o tempo de inatividade e otimizar a performance operacional. O sistema possibilita:

- Controle de manutenções preventivas (para evitar falhas).
- Controle de manutenções corretivas (após uma falha).
- Registro de falhas, gerenciamento de técnicos e geração de relatórios.
- Acompanhamento de indicadores de desempenho, como:
  - **MTTR**: Mean Time to Repair (Tempo Médio de Reparo).
  - **MTBF**: Mean Time Between Failures (Tempo Médio Entre Falhas).

---

## 2. Análise de Requisitos e Escopo

### Funcionalidades Principais

- **Gerenciamento de Máquinas e Equipamentos:**
  - Cadastro de máquinas com especificações técnicas, data de aquisição e localização.
  - Visualização e edição das informações cadastradas.

- **Registro e Controle de Manutenções:**
  - Registro de manutenções preventivas e corretivas.
  - Histórico completo de manutenções para cada máquina.
  - Registro de peças substituídas e tempo de inatividade.

- **Gerenciamento de Falhas:**
  - Registro de falhas ocorridas, incluindo a severidade e identificação do operador.
  - Controle de falhas por máquina.

- **Gerenciamento de Técnicos:**
  - Cadastro de técnicos, especialidades e disponibilidade.

- **Relatórios e Indicadores:**
  - Geração de relatórios sobre manutenções, falhas, tempo de inatividade e peças trocadas.
  - Cálculo automático de indicadores **MTTR** e **MTBF**.

---

### Requisitos Funcionais

- Cadastro de máquinas com suas especificações.
- Registro de manutenções preventivas e corretivas, associando técnicos e peças trocadas.
- Geração de relatórios e indicadores de performance.
- Interface gráfica intuitiva para o usuário.

### Requisitos Não Funcionais

- O sistema deve ser responsivo e ter tempo de resposta rápido.
- Interface amigável e de fácil navegação.
- Armazenamento e recuperação de dados devem ser seguros e eficientes.

---

## 3. Escopo do Projeto

### Objetivos:

- Desenvolvimento de interface gráfica (Swing) para gerenciamento de máquinas, técnicos e manutenções.
- Implementação de funcionalidades **CRUD** para máquinas, manutenções, falhas e técnicos.
- Geração de relatórios com base nos dados registrados, incluindo indicadores de desempenho.
- Validação e testes para garantir a robustez do sistema.

---

### Ambiente de Desenvolvimento:

- **IDE:** Visual Studio Code.
- **Linguagem:** Java.
- **Frameworks:** 
  - **Swing** para a interface gráfica (desktop).
  - **JSON-Server** para simulação de API (localmente).

### Infraestrutura:

- A aplicação será **desktop Java**, sem interface web.
- O **JSON-Server** simulará o armazenamento e recuperação de dados, sem uso de banco de dados relacional.

---

## 4. Análise de Riscos

1. **Atrasos no Cronograma:**
   - **Mitigação:** Planejamento detalhado e revisão regular.

2. **Falhas na Integração da API:**
   - **Mitigação:** Testes rigorosos e documentação clara da API.

3. **Problemas de Usabilidade:**
   - **Mitigação:** Testes de usabilidade com usuários finais.

4. **Segurança dos Dados:**
   - **Mitigação:** Criptografia e práticas recomendadas de segurança.

5. **Manutenção do Sistema:**
   - **Mitigação:** Documentação completa e treinamento da equipe.

---

## 5. Diagramas e Endpoints

### Diagrama de Classe

![alt text](<img/diagrama 1.png>)
---

### Diagrama de Fluxo

![Diagrama de Fluxo](/img/image.png)

---

### Endpoints de Máquinas

- **GET - Todas as Máquinas:**
  
  ![Get Máquinas](/img/Get_Maquinas.png)

- **POST - Cadastro de Máquina:**
  
  ![Post Máquina](/img/Post_maquinas.png)

- **PUT - Atualizar Máquina:**
  
  ![Put Máquina](/img/Put_Maquinas.png)

- **DELETE - Remover Máquina:**
  
  ![Delete Máquina](/img/Delete_Maquinas.png)

---

### Endpoints de Manutenção

- **GET - Histórico de Manutenções:**
  
  ![Get Histórico de Manutenções](/img/Get_historico_Manutecao.png)

- **POST - Registrar Manutenção:**
  
  ![Post Manutenção](Post_historico_Manutencao.png)

---

### Endpoints de Falhas

- **GET - Falhas Registradas:**
  
  ![Get Falhas](/img/Get_Falha.png)

- **POST - Registrar Falha:**
  
  ![Post Falha](/img/Post_Falha.png)

---

### Endpoints de Técnicos

- **GET - Lista de Técnicos:**
  
  ![Get Técnicos](/img/Get_Tecnicos.png)

- **POST - Cadastro de Técnico:**
  
  ![Post Técnico](/img/Post_tecnicos.png)

- **DELETE - Remover Técnico:**
  
  ![Delete Técnico](/img/Delete_tecnicos.png)

---

Essa versão mantém todas as informações importantes, mas com uma organização clara, incluindo separação por seções e estilo para melhor visualização. As imagens estão distribuídas corretamente, e os endpoints seguem uma sequência lógica dentro do contexto de cada seção.
