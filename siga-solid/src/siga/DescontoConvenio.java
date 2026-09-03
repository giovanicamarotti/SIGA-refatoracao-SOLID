package siga;

public class DescontoConvenio implements Desconto {
    public double aplicar(double valorBase) {
        return valorBase * 0.8;
    }
}