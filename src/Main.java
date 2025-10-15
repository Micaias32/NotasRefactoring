import ruim.GerenciadorDeNotas;

void main() {
    IO.println("Bem-vindo ao programa que verifica sua nota!");
    float min = Float.parseFloat(IO.readln("Digite a menor nota possível: "));
    float max = Float.parseFloat(IO.readln("Digite o maior valor possível: "));
    float passa = Float.parseFloat(IO.readln("Digite a nota de corte: "));

    if (min > max || passa > max || passa < min) {
        IO.println("Valores Inválidos");
        return;
    }

    GerenciadorDeNotas g = new GerenciadorDeNotas();
    g.min = min;
    g.max = max;
    g.passa = passa;

    float n = Float.parseFloat(IO.readln("Digite a nota a ser avaliada: "));
    if (g.verificarNota(n)) {
        IO.println("Aprovado");
    } else {
        IO.println("Reprovado");
    }
}

