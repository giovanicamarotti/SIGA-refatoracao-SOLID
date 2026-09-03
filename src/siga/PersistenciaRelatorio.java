package siga;

public class PersistenciaRelatorio {
    public void salvarEmArquivo(String conteudo, String caminho) {
        System.out.println("[disco] Gravando relatório em: " + caminho);
        System.out.println(conteudo);
    }
}