package com.example.logging;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Anotação para marcar métodos que devem ser logados.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {}
