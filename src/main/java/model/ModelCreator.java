package model;

public interface ModelCreator<T> {

    boolean isValid(String data);

    T create(String data);

}
