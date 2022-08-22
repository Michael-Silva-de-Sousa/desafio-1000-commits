package exemplos;

import lombok.extern.slf4j.Slf4j;
import mockdata.MockData;

import java.io.IOException;

@Slf4j
public class Streams {

    public static void main(String[] args) throws IOException {
        MockData.getPessoas().forEach(i -> log.info(i.getEmail()));
    }
}
