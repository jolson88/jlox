package com.craftinginterpreters.lox;

class ReturnCommand extends RuntimeException {
  final Object value;

  ReturnCommand(Object value) {
    super(null, null, false, false);
    this.value = value;
  }
}

class BreakCommand extends RuntimeException {
  final Token keyword;

  BreakCommand(Token keyword) {
    this.keyword = keyword;
  }
}

class ContinueCommand extends RuntimeException {
  final Token keyword;

  ContinueCommand(Token keyword) {
    this.keyword = keyword;
  }
}
