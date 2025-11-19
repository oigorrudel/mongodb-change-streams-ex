# mongodb-change-streams-ex

Exemplo de aplicação para demonstrar o uso de **MongoDB Change Streams** em Java / Spring.

---

## Visão Geral

Este projeto ilustra como usar **Change Streams** do MongoDB para ficar atento a mudanças em uma coleção ou base de dados em tempo real. Isso é útil para cenários de:

- Captura de dados de mudança (CDC)  
- Reações a inserções, atualizações ou deleções  
- Propagação de eventos para outros sistemas (ex: microserviços, filas, serviços de notificação)  
- Arquiteturas reativas onde mudanças no banco devem disparar fluxos de dados

---

## Tecnologias

- Java  
- Spring
- MongoDB (em replicaset, já que Change Streams exigem réplica para funcionar)

---
