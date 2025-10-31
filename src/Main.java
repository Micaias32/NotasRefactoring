import ruim.GerenciadorDeNotas;

void main() {
    IO.println("Bem-vindo ao programa que verifica sua nota!");
    float notaMinima = Float.parseFloat(IO.readln("Digite a menor nota possível: "));
    float notaMaxima = Float.parseFloat(IO.readln("Digite o maior valor possível: "));
    float notaDeCorte = Float.parseFloat(IO.readln("Digite a nota de corte: "));

    var gerenciador = GerenciadorDeNotas.novo(notaMinima, notaMaxima, notaDeCorte);

    if (gerenciador == null) {
        IO.println("Valores Inválidos");
        return;
    }



    float nota = Float.parseFloat(IO.readln("Digite a nota a ser avaliada: "));
    if (gerenciador.verificarNota(nota)) {
        IO.println("Aprovado");
    } else {
        IO.println("Reprovado");
    }
}

