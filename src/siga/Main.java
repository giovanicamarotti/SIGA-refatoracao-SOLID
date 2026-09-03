package siga;

import java.util.Arrays;
import java.util.List;

/**
 * Ponto de entrada do SIGA (código INICIAL da atividade da Aula 3).
 *
 * Esta classe demonstra, em execução, os três problemas de design que você
 * deverá corrigir aplicando os princípios SOLID. Rode o programa e observe:
 * ele FUNCIONA — mas o código não resiste bem à mudança, como discutido em aula.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade de Refatoração SOLID (código inicial) ===\n");

        List<Aluno> alunos = Arrays.asList(
            new Aluno("Maria Silva", "2026001", "maria@exemplo.edu", 8.5, true),
            new Aluno("João Souza",  "2026002", "joao@exemplo.edu",  6.0, false),
            new Aluno("Ana Pereira", "2026003", "ana@exemplo.edu",   9.2, false)
        );

        FormatacaoRelatorio formatador = new FormatacaoRelatorio();
        PersistenciaRelatorio persistencia = new PersistenciaRelatorio();
        ComunicacaoRelatorio comunicacao = new ComunicacaoRelatorio();

        String conteudo = formatador.formatar(alunos);
        persistencia.salvarEmArquivo(conteudo, "relatorios/alunos.txt");
        comunicacao.enviarPorEmail(conteudo, "coordenacao@exemplo.edu");

        System.out.println();

        SaveExterno gravador = new GravadorMySQL();

        // PROBLEMA 2 (OCP): o cálculo usa condicionais que crescem a cada desconto.
        Matricula m1 = new Matricula(alunos.get(0), 1000.0, new DescontoBolsista(), gravador);
        Matricula m2 = new Matricula(alunos.get(1), 1000.0, new SemDesconto(), gravador);
        System.out.println("Mensalidade (bolsista): " + m1.calcularMensalidade());
        System.out.println("Mensalidade (sem desconto): " + m2.calcularMensalidade());

        // PROBLEMA 3 (DIP): Matricula depende diretamente de GravadorMySQL.
        m1.salvar();
        m2.salvar();
    }
}
