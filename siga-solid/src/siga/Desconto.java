package siga;


/*Interface desconto que será responsável por
definir qual método de desconto será aplicado dentro de Matricula*/
public interface Desconto {
        double aplicar(double valorBase);
}
