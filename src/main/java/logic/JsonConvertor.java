package logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvertor<T> implements SchemaConvertor<T> {

    private ObjectMapper mapper;

    public JsonConvertor() {
        mapper = new ObjectMapper();
    }

    @Override
    public String convertToSchemaString(T model) {
        String jsonInString = null;

        try {
            jsonInString = mapper.writeValueAsString(model);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonInString;
    }

    @Override
    public T convertToModel(String schema) {


        return null;
    }
}
