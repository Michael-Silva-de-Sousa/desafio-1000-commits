package mockdata;

import beans.Carro;
import beans.Pessoa;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<Pessoa> getPessoas() throws IOException {
        InputStream inputStream = Resources.getResource("pessoas.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Pessoa>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    public static List<Carro> getCarros() throws IOException {
        InputStream inputStream = Resources.getResource("carros.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Carro>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }
}
