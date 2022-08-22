package exemplos;

import beans.Pessoa;
import mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;

/**
 * Exemplos do uso de Streams para ordernar
 * Listas.
 * */

class Sorting {

    @Test
    void ordernarPorNome() throws Exception {
        try {
            var pessoas = MockData.getPessoas();
            var ordenado = pessoas.stream()
                    .map(Pessoa::getFirstName)
                    .sorted().toList();

            ordenado.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void ordenandoPorNomeReverso() throws Exception {

        var pessoas = MockData.getPessoas();

        var ordenadoRerverso = pessoas.stream()
                .map(Pessoa::getFirstName)
                .sorted(Comparator.reverseOrder())
                .toList();

        ordenadoRerverso.forEach(System.out::println);
    }
}
