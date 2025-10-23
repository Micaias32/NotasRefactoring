package ruim;

// Verifica se uma nota passa na matéria
// O usuário deve informar a nota mínima, máxima, e a nota de corte
public class GerenciadorDeNotas {
    // Menor nota possível, se a nota a testar
    // for menor que essa, um erro deve se informado.
    // O valor não deve ser maior que max
    public float notaMinima;

    // Maior nota possível, se a nota a testar
    // for maior que essa, um erro deve se informado.
    // O valor não deve ser maior que min
    public float notaMaxima;

    // Nota de corte, não deve ser menor que min
    // ou maior que max
    public float notaDeCorte;

    // Verifica se uma nota está acima da nota de corte.
    // Espera-se que os valores de min, max e passa estejam atribuídos
    // e que sejam válidos
    public boolean verificarNota(float nota) {
        // a nota não pode ser menor que a mínima
        if (nota >= notaMinima) {
            // a nota não pode ser maior que a máxima:
            if (nota <= notaMaxima) {
                // se a nota for maior ou igual à nota de corte:
                if (nota >= notaDeCorte) {
                    // retornamos verdadeiro (true)
                    return true;
                // Senão:
                } else {
                    // retornamos falso (false)
                    return false;
                }
            } else {
                // Erro para se a nota for maior que o máximo
                throw new RuntimeException("nota maior que o máximo");
            }
        } else {
            // Erro para se a nota for menor que o mínimo
            throw new RuntimeException("nota menor que o mínimo");
        }
    }
}
