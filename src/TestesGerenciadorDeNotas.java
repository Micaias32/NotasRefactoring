import ruim.GerenciadorDeNotas;

// Códigos ANSI para colorir o terminal (funcionam em quase todos os terminais)
private static final String GREEN = "\u001B[32m";
private static final String RED = "\u001B[31m";
private static final String YELLOW = "\u001B[33m";
private static final String RESET = "\u001B[0m";

private static int total = 0;
private static int sucesso = 0;

void main() {
    System.out.println(YELLOW + "Iniciando testes de GerenciadorDeNotas..." + RESET);

    testar("Nota dentro dos limites e aprovada", () -> {
        var g = criar(0, 10, 6);
        return g.verificarNota(8);
    }, true);

    testar("Nota dentro dos limites e reprovada", () -> {
        var g = criar(0, 10, 6);
        return g.verificarNota(5);
    }, false);

    testar("Nota igual à mínima mas insuficiente", () -> {
        var g = criar(0, 10, 6);
        return g.verificarNota(0);
    }, false);

    testar("Nota igual à máxima e aprovada", () -> {
        var g = criar(0, 10, 6);
        return g.verificarNota(10);
    }, true);

    testarErro("Nota abaixo do mínimo deve gerar erro", () -> {
        var g = criar(0, 10, 6);
        g.verificarNota(-1);
    });

    testarErro("Nota acima do máximo deve gerar erro", () -> {
        var g = criar(0, 10, 6);
        g.verificarNota(11);
    });

    // resumo
    System.out.println();
    System.out.println(YELLOW + "Resumo dos testes:" + RESET);
    System.out.printf("  Sucesso: %s%d%s/%d\n", GREEN, sucesso, RESET, total);
    System.out.printf("  Falhas:  %s%d%s\n", RED, (total - sucesso), RESET);
}

private static GerenciadorDeNotas criar(float min, float max, float passa) {
    var g = new GerenciadorDeNotas();
    g.min = min;
    g.max = max;
    g.passa = passa;
    return g;
}

private static void testar(String nome, Teste teste, boolean esperado) {
    total++;
    try {
        boolean resultado = teste.executar();
        if (resultado == esperado) {
            sucesso++;
            System.out.println(GREEN + "✔ " + nome + RESET);
        } else {
            System.out.println(RED + "✘ " + nome + " (resultado incorreto)" + RESET);
        }
    } catch (Throwable e) {
        System.out.println(RED + "✘ " + nome + " (erro inesperado: " + e.getMessage() + ")" + RESET);
    }
}

private static void testarErro(String nome, TesteErro teste) {
    total++;
    try {
        teste.executar();
        System.out.println(RED + "✘ " + nome + " (nenhum erro lançado)" + RESET);
    } catch (RuntimeException e) {
        sucesso++;
        System.out.println(GREEN + "✔ " + nome + RESET);
    } catch (Throwable e) {
        System.out.println(RED + "✘ " + nome + " (erro inesperado: " + e.getMessage() + ")" + RESET);
    }
}

@FunctionalInterface
interface Teste {
    boolean executar();
}

@FunctionalInterface
interface TesteErro {
    void executar();
}

