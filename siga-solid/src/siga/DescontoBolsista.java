package siga;

public class DescontoBolsista implements Desconto {
    public double aplicar(double valorBase) {
        return valorBase * 0.5;
    }
}