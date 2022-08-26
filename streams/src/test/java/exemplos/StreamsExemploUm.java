package exemplos;

import beans.Pessoa;
import mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;

class StreamsExemploUm {

    @Test
    void listandoEmails() throws Exception {
        List<String> emails = MockData.getPessoas()
                .stream()
                .map(Pessoa::getEmail)
                .toList();

        emails.forEach(System.out::println);
    }


}
