# Logging Component

## Descrição
Este componente fornece funcionalidade de logging para métodos em Java, permitindo interceptar chamadas de métodos anotados com `@Loggable` e registrar essas chamadas usando um logger personalizado.

## Estrutura do Projeto
O componente consiste nas seguintes classes:
- `@Loggable`
- `LoggingHandler`
- `MethodLogger`

## Funcionamento
### @Loggable
`@Loggable` é uma anotação personalizada que você usa para marcar métodos que devem ser interceptados e logados.

### LoggingHandler
`LoggingHandler` é uma classe que implementa a interface `InvocationHandler`. Ele intercepta chamadas de métodos em objetos proxy e registra essas chamadas se os métodos estiverem anotados com `@Loggable`.

### MethodLogger
`MethodLogger` é uma classe utilitária que registra mensagens de log e permite exibir essas mensagens posteriormente. Ele utiliza a API de logging do Java para registrar as mensagens no console e também as armazena em uma lista interna.

### Funcionamento
1. **Marcação de Métodos:** O desenvolvedor marca os métodos que devem ser logados com a anotação `@Loggable`.
2. **Criação de Proxy:** Um proxy é criado para o objeto alvo usando `LoggingHandler` como manipulador de invocação.
3. **Interceptação e Logging:** Quando um método anotado é chamado no proxy, `LoggingHandler` intercepta a chamada, verifica a anotação `@Loggable`, registra a chamada usando `MethodLogger`, e então invoca o método original no objeto alvo.
4. **Exibição de Logs:** O desenvolvedor pode chamar `MethodLogger.showLogs()` para exibir todas as mensagens de log registradas até o momento.
