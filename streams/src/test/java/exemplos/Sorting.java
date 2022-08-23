package exemplos;

import beans.Carro;
import beans.Pessoa;
import mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Collectors;

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
    void ordenarPorNomeReverso() throws Exception {

        var pessoas = MockData.getPessoas();

        var ordenadoRerverso = pessoas.stream()
                .map(Pessoa::getFirstName)
                .sorted(Comparator.reverseOrder())
                .toList();

        ordenadoRerverso.forEach(System.out::println);
    }

    @Test
    void ordenarOsDezCarrosAzuisMaisCaro() throws Exception {

        var carros = MockData.getCarros();

        var topDez = carros.stream()
                .filter(car -> "blue".equalsIgnoreCase(car.getColor()))
                .sorted(Comparator.comparing(Carro::getPrice).reversed())
                .limit(10)
                .toList();

        topDez.forEach(i -> System.out.println(i.toString()));
    }
}
