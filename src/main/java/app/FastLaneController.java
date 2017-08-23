package app;

import logic.DataCollector;
import logic.DataFollower;
import logic.SchemaConvertor;
import model.FastLaneModel;
import model.ModelCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@PropertySource("classpath:data.properties")
public class FastLaneController {

    @Autowired
    private DataCollector dataCollector;

    @Autowired
    private ModelCreator<FastLaneModel> modelCreator;

    @Autowired
    private SchemaConvertor<FastLaneModel> jsonConvertor;

    @Value("${fastLaneUrl}")
    private String fastLaneUrl;

    @Autowired
    private DataFollower dataFollower;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public FastLaneController() {

    }

    @RequestMapping("/fastLanePing")
    public String index() {
        System.out.println("Greetings from Fast lane service!");

        executorService.execute( () -> {
            System.out.println("Start proccesing");
            String data = dataCollector.collect(fastLaneUrl);
            FastLaneModel model = modelCreator.create(data);
            String jsonModel = jsonConvertor.convertToSchemaString(model);
            dataFollower.follow(jsonModel);
        });
        return "request processing";
    }

}