package siga;

public class ComunicacaoRelatorio {
    public void enviarPorEmail(String conteudo, String destinatario) {
        System.out.println("[email] Enviando relatório para: " + destinatario);
        System.out.println(conteudo);
    }
}

