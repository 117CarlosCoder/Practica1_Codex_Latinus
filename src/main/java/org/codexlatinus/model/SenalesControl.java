package org.codexlatinus.model;

public class SenalesControl {

    public static class SenalReturn extends RuntimeException {
        private final Object valor;

        public SenalReturn(Object valor) {
            this.valor = valor;
        }

        public Object getValor() {
            return valor;
        }
    }

    public static class SenalBreak extends RuntimeException {
        public SenalBreak() {
        }
    }

    public static class SenalContinue extends RuntimeException {
        public SenalContinue() {
        }
    }
}
