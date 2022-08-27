package exemplos;

import beans.Pessoa;
import mockdata.MockData;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StremGrouping {

    @Test
    public void agrupamentoSimples() throws Exception {

        Map<String, List<Pessoa>> map = MockData.getPessoas()
                .stream()
                .collect(Collectors.groupingBy(Pessoa::getGender));

        map.forEach((s, pessoas) -> {
            System.out.println("Conteúdo: " + s);
            pessoas.forEach(System.out::println);
            System.out.println("------" + s);
        });
    }

    @Test
    public void agrupandoNomesEcontandoAsOcorrencias() throws Exception {

        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        Map<String, Long> map = names.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println(map);
    }
}
