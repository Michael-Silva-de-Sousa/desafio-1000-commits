package exemplos;

import beans.Pessoa;
import mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
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

    @Test
    void testeFiltrosEmFasePrecosCarros() throws Exception {

        /**
         * Exemplo de como usar stream para realizar o
         * filtro faseado. nesse exemplo primeiro é filtrado os carros
         * com preço menor de 10.000, em seguida é extraído somente os preços
         * e depois os preços são multiplicado por .14.
         * */

        MockData.getCarros()
                .stream()
                .filter(car -> { //Filtra todos os carros com preço menor que 10.000
                    //System.out.println("carros filtrados: " + car);
                    return car.getPrice() < 10000;
                })
                .map(car -> { //Pega somente a propriedade precos
                    //System.out.println("Carros filtrados: " + car);
                    return car.getPrice();
                })
                .map(price -> { // realiza o calculo dos preços
                    return price + (price * .14);
                })
                .forEach(System.out::println);


    }

    @Test
    void filtrarPorFasesPessoas() throws Exception {
        MockData.getPessoas()
                .stream()
                .filter(p -> { //filtra Pessoas maiores de 17 anos e com idade menor que 31.
                    return p.getAge() >= 18 && p.getAge() <= 30 ;
                })
                .filter(p -> { //Pega o resultado e filtra por genero male
                    return p.getGender().equalsIgnoreCase("male");
                }).filter(p -> {
                    return p.getFirstName().toUpperCase().startsWith("A");
                }).sorted(Comparator.comparing(Pessoa::getAge))//Ordenando por idade
                /*
                .map(p -> {
                    return p.getFirstName().toUpperCase();
                })*/
                .forEach(System.out::println);
    }

}
