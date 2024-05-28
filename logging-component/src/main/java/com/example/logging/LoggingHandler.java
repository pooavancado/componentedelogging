package com.example.logging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Manipulador de invocação que loga chamadas de métodos anotados com {@link Loggable}.
 */
public class LoggingHandler implements InvocationHandler {
    private final Object target;

    /**
     * Constrói um novo LoggingHandler para o objeto alvo fornecido.
     *
     * @param target o objeto alvo cujos métodos serão interceptados e logados
     */
    public LoggingHandler(Object target) {
        this.target = target;
    }

    /**
     * Intercepta chamadas de métodos no objeto alvo e as loga se estiverem anotadas com {@link Loggable}.
     *
     * @param proxy  a instância do proxy em que o método foi invocado
     * @param method o método sendo invocado
     * @param args   os argumentos do método
     * @return o resultado da invocação do método no objeto alvo
     * @throws Throwable se a invocação do método falhar
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Loggable.class)) {
            String methodName = method.getName();
            StringBuilder argsBuilder = new StringBuilder("(");
            if (args != null && args.length > 0) {
                argsBuilder.append(args[0]);
                for (int i = 1; i < args.length; i++) {
                    argsBuilder.append(", ").append(args[i]);
                }
            }
            argsBuilder.append(")");
            String argsString = argsBuilder.toString();
            String message = methodName + argsString;
            MethodLogger.log("Chamando: " + message);
        }
        return method.invoke(target, args);
    }
}
