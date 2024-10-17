# Manual de Usuário - Sistema de Gestão de Manutenções

Este manual fornece uma visão geral de como usar o **Sistema de Gestão de Manutenções**, detalhando as funcionalidades dos painéis de **Máquinas**, **Técnicos**, **Histórico de Manutenção** e **Falhas**. Siga os passos para realizar as operações corretamente.

## Índice

1. [Painel de Máquinas](#painel-de-máquinas)
2. [Painel de Histórico de Manutenção](#painel-de-histórico-de-manutenção)
3. [Painel de Técnicos](#painel-de-técnicos)
4. [Painel de Falhas](#painel-de-falhas)
5. [Exportação de Relatórios](#exportação-de-relatórios)

---

## Painel de Máquinas

O painel de máquinas permite visualizar, adicionar, alterar e remover máquinas do sistema.

### Funcionalidades

- **Visualizar Máquinas**: Ao acessar o painel, você verá uma tabela listando todas as máquinas cadastradas, com detalhes como ID, Nome, Localização, Status e Observações.
- **Adicionar Máquina**: Clique no botão `Criar` localizado no rodapé da página para abrir o formulário de cadastro.
  - Preencha os campos obrigatórios: `ID`, `Nome`, `Localização`, `Status` e qualquer observação relevante.
  - Após preencher, clique em `Salvar` para adicionar a máquina ao sistema.
- **Alterar Máquina**: Selecione uma máquina da tabela e clique em `Alterar` para modificar as informações.
- **Remover Máquina**: Selecione uma máquina e clique no botão `Remover` para excluí-la do sistema. Uma confirmação será solicitada antes da exclusão.

### Exemplo de Tabela de Máquinas

| ID   | Nome       | Localização | Status  | Observações     |
|------|------------|-------------|---------|-----------------|
| 001  | Máquina 1  | Fábrica A   | Ativa   | Sem observações |
| 002  | Máquina 2  | Fábrica B   | Inativa | Manutenção em andamento |

---

## Painel de Histórico de Manutenção

O painel de **Histórico de Manutenção** permite gerenciar os registros de manutenção das máquinas.

### Funcionalidades

- **Visualizar Histórico**: Uma tabela exibe todas as manutenções realizadas, com detalhes como ID, Máquina ID, Data, Tipo de Manutenção, Peças Trocadas, Tempo de Parada, Técnico e Observações.
- **Criar Manutenção**: Clique em `Criar` para adicionar um novo registro de manutenção.
  - Preencha o formulário com informações como ID da máquina, data da manutenção (no formato `dd-mm-yyyy`), tipo, peças trocadas e tempo de parada.
  - Após preencher, clique em `Salvar`.
- **Alterar Manutenção**: Selecione um registro e clique em `Alterar` para modificar as informações.
- **Remover Manutenção**: Selecione uma manutenção e clique em `Remover` para excluí-la.

### Exemplo de Tabela de Manutenções

| ID   | Máquina ID | Data       | Tipo       | Peças Trocadas | Tempo de Parada | Técnico ID | Observações     |
|------|------------|------------|------------|----------------|-----------------|------------|-----------------|
| 101  | 001        | 12-01-2024 | Corretiva  | Correias       | 2 horas         | TEC001     | Manutenção geral|
| 102  | 002        | 22-02-2024 | Preventiva | Rolamentos     | 3 horas         | TEC002     | Troca preventiva|

---

## Painel de Técnicos

O painel de técnicos permite gerenciar os técnicos responsáveis pelas manutenções das máquinas.

### Funcionalidades

- **Visualizar Técnicos**: A tabela exibe os técnicos cadastrados com informações como ID, Nome, Departamento e Observações.
- **Adicionar Técnico**: Clique em `Criar` para cadastrar um novo técnico.
  - Preencha os campos obrigatórios, como ID do técnico, Nome e Departamento.
  - Clique em `Salvar` para registrar o técnico.
- **Alterar Técnico**: Selecione um técnico da tabela e clique em `Alterar` para modificar os dados.
- **Remover Técnico**: Selecione um técnico e clique em `Remover` para excluí-lo.

### Exemplo de Tabela de Técnicos

| ID     | Nome         | Departamento  | Observações          |
|--------|--------------|---------------|----------------------|
| TEC001 | João Santos  | Mecânica      | Responsável geral    |
| TEC002 | Maria Silva  | Elétrica      | Especialista em PLCs |

---

## Painel de Falhas

O painel de falhas exibe as falhas registradas nas máquinas, permitindo identificar padrões e tomar ações preventivas ou corretivas.

### Funcionalidades

- **Visualizar Falhas**: A tabela exibe as falhas registradas, com detalhes como ID da falha, Máquina, Data, Descrição e Status.
- **Adicionar Falha**: Clique em `Criar` para registrar uma nova falha.
  - Informe os dados da falha, como o ID da máquina, descrição da falha e o status (Resolvida ou Pendente).
  - Após preencher, clique em `Salvar`.
- **Alterar Falha**: Selecione uma falha e clique em `Alterar` para modificar os dados.
- **Remover Falha**: Selecione uma falha e clique em `Remover` para excluí-la do sistema.

### Exemplo de Tabela de Falhas

| ID    | Máquina      | Data       | Descrição               | Status     |
|-------|--------------|------------|-------------------------|------------|
| F001  | Máquina 1     | 15-01-2024 | Falha no motor principal | Resolvida  |
| F002  | Máquina 2     | 20-02-2024 | Vazamento de óleo        | Pendente   |

---

## Exportação de Relatórios

Você pode exportar relatórios detalhados de manutenções diretamente no formato **TXT**.

### Como Exportar

1. Navegue até o **Painel de Histórico de Manutenção**.
2. Clique no botão `Exportar Relatório`.
3. Um arquivo de texto será gerado com todos os registros de manutenção, prontos para impressão ou análise.

O arquivo gerado terá o nome `relatorio_manutencao.txt` e será salvo no diretório local onde o sistema está instalado.

### Exemplo de Relatório Exportado

```txt
Relatório de Manutenção
=======================
ID      Máquina ID      Data        Tipo         Peças Trocadas    Tempo de Parada    Técnico ID    Observações
101     001             12-01-2024  Corretiva    Correias          2 horas            TEC001        Manutenção geral
102     002             22-02-2024  Preventiva   Rolamentos        3 horas            TEC002        Troca preventiva
