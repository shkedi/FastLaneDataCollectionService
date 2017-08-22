package app;

import logic.DataCollector;
import logic.SchemaConvertor;
import model.FastLaneModel;
import model.ModelCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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

    public FastLaneController() {

    }

    @RequestMapping("/fastLanePing")
    public String index() {
        System.out.println("Greetings from Fast lane service!");
        String data = dataCollector.collect(fastLaneUrl);
        FastLaneModel model = modelCreator.create(data);
        String jsonModel = jsonConvertor.convertToSchemaString(model);

        return "request processing";
    }

}