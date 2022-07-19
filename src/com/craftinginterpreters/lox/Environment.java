package com.craftinginterpreters.lox;

import java.util.HashMap;
import java.util.Map;

class Environment {
  final Environment enclosing;
  private final Map<String, Object> values = new HashMap<>();

  Environment() {
    enclosing = null;
  }

  Environment(Environment enclosing) {
    this.enclosing = enclosing;
  }

  void assign(Token name, Object value) {
    if (values.containsKey(name.lexeme)) {
      values.put(name.lexeme, value);
      return;
    }

    if (enclosing != null) {
      enclosing.assign(name, value);
      return;
    }

    throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
  }

  void assignByName(String name, Object value) {
    if (values.containsKey(name)) {
      values.put(name, value);
      return;
    }

    if (enclosing != null) {
      enclosing.assignByName(name, value);
      return;
    }
  }

  void define(String name, Object value) {
    values.put(name, value);
  }

  Object get(Token name) {
    if (values.containsKey(name.lexeme)) {
      return values.get(name.lexeme);
    }

    if (enclosing != null) return enclosing.get(name);

    throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
  }

  Object getByName(String name) {
    if (values.containsKey(name)) {
      return values.get(name);
    }

    if (enclosing != null) return enclosing.getByName(name);

    return null;
  }
}
