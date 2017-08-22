package logic;

public interface SchemaConvertor<T> {

    String convertToSchemaString(T model);

    T convertToModel(String schema);

}
