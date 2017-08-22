package logic;

public interface DataCollector {

    String collect(String path);

    void sendData(String url, String data);

}
