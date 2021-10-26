package com.example.lesson4.logic;

public enum Operation {

    ADD("+"),
    SUB("-"),
    MULT("*"),
    DIV("/"),
    EXPON("^2"),
    SQRT("√"),
    MODUL("%"),
    SUMM("=");

    private String name;

    Operation(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
