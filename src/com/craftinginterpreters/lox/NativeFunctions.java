package com.craftinginterpreters.lox;

import java.util.List;

final class NativeFunctions {
  static LoxCallable ClockFunction = new LoxCallable() {
    @Override
    public int arity() { return 0; }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
      return (double)System.currentTimeMillis();
    }

    @Override
    public String toString() { return "<native fn>"; }
  };

  static LoxCallable StringFunction = new LoxCallable() {
    @Override
    public int arity() { return 1; }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
      return interpreter.stringify(arguments.get(0));
    }

    @Override
    public String toString() { return "<native fn>"; }
  };

  static LoxCallable PrintFunction = new LoxCallable() {
    @Override
    public int arity() { return 1; }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
      String message = interpreter.stringify(arguments.get(0));
      System.out.println(message);
      return message;
    }

    @Override
    public String toString() { return "<native fn>"; }
  };
}
