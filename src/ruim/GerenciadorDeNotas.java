package ruim;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * @author Micaias
 * <p>
 * Verifica se uma nota passa na matéria
 * </p>
 * <p>
 * O objeto tem uma invariância que deve ser sequida
 * </p>
 * notaMinima ≤ notaDeCorte ≤ notaMaxima
 */
public class GerenciadorDeNotas {

    /**
     * <p>
     * O menor valor que a nota a ser verificada pode ser.
     * </p>
     * <h1>Invariância:</h1>
     * notaMinima ≤ notaDeCorte ≤ notaMaxima
     */
    private final float notaMinima;

    /**
     * <p>
     * O maior valor que a nota a ser verificada pode ser.
     * </p>
     * <h1>Invariância:</h1>
     * notaMinima ≤ notaDeCorte ≤ notaMaxima
     */
    private final float notaMaxima;

    /**
     * <p>
     * A nota a ser verificada deve ser igual ou maior
     * que essa para que verificarNota() retorne verdadeiro.
     * </p>
     * <h1>Invariância:</h1>
     * notaMinima ≤ notaDeCorte ≤ notaMaxima
     */
    private final float notaDeCorte;

    private GerenciadorDeNotas(float notaMinima, float notaMaxima, float notaDeCorte) {
        this.notaMinima = notaMinima;
        this.notaMaxima = notaMaxima;
        this.notaDeCorte = notaDeCorte;
    }

    @Nullable
    @Contract(pure = true)
    public static GerenciadorDeNotas novo(float notaMinima, float notaMaxima, float notaDeCorte) {
        boolean invarianciaMantida = notaMinima <= notaDeCorte &&
                notaMinima <= notaMaxima &&
                notaDeCorte <= notaMaxima;
        if (!invarianciaMantida) {
            return null;
        }
        return new GerenciadorDeNotas(notaMinima, notaMaxima, notaDeCorte);
    }

    /**
     * Verifica se uma nota é válida e passa a nota de corte.
     * @param nota                  A nota a ser verificada.
     * @return                      Se a nota for maior ou igual que this.notaDeCorte,
     * retorna true, caso o contrário, retorna false.
     * @throws RuntimeException     Se a nota for menor que this.notaMinima ou
     * maior que this.notaMaxima.
     */
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
