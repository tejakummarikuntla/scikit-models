
/*
 * Copyright (c) Crio.Do 2019. All rights reserved
 */

//import static java.awt.SystemColor.info;
//import static javax.jws.WebParam.Mode.IN;
//import com.fasterxml.jackson.core.JsonParseException;
import static javax.print.attribute.standard.MediaPrintableArea.MM;

//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.util.JSONPObject;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import org.springframework.format.annotation.DateTimeFormat;
//import main.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sun.text.resources.cldr.es.FormatData_es_419;
//import jdk.nashorn.internal.parser.JSONParser;
public class WeatherAdvisorApplication {


    // TODO: CRIO_TASK_MODULE_WEATHER_PARSING - Implement Weather Parser.
    // If you run the following from command line, expected output is 'Yes'.
    // ./gradlew bootrun -q -Pargs=weather_bangalore.json,"2019-05-23 08:15","2019-05-24 09:15"
    // If you run the following from command line, expected outputs is 'No'.
    // ./gradlew -q bootrun -Pargs=weather_bangalore.json,"2019-05-22 08:15","2019-05-22 09:15"
    /**
     * For a given period, answer whether rain is expected or not.
     * - If rain is expected, print 'Yes' on the console without quotes.
     * - Else print 'No' without quotes.
     * Steps:
     * 1. Parse the given weather report json file.
     * 2. Answer if rain is expected during the given trip time.
     * @param args command line arguments
     *     args[0] - Filename containing the weather report in json format.
     *     args[1] - Trip start time
     *     args[2] - Trip end time
     */

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date1 = format.parse(args[1]);
            Date date2 = format.parse(args[2]);


            byte[] jsonString = Files.readAllBytes(Paths.get(args[0]));
            JsonNode rootNode = mapper.readTree(jsonString);
            System.out.println("JSON parsed :"+rootNode);
            System.out.println("DAta !: "+date1);
            System.out.println("DATE2 : "+ date2);


            JsonNode root=mapper.readTree(new File("weather_bangalore.json"));

            for( int i=0; i< root.asText().length();i++) {
                for (int j = 0; j < 40; j++) {
                    System.out.println(root.get("list").get(i).get("dt_txt").asText());
                    System.out.println(root.get("list").get(j).get("weather").get(0).get("description").asText());
                }
            }

            for (int i = 0; i < root.asText().length(); i++) {



            }



/*  JsonNode root=mapper.readTree("weather_bangalore.json");
  JsonNode listNode = root.path("list");

  if (listNode.isArray()){
    for (JsonNode itNode : listNode){
      String timeNode = itNode.path("dt_txt").asText();
      DateTimeFormat formattter = new DateTimeFormat.ofPattern("yyyy-MM-dd HH:mm:ss");
      LocalDateTime checkTime = LocalDateTime.parse(timeNode,formattter);

    }
  }*/
        }
        catch (IOException e){ e.printStackTrace(); }
/*catch (JsonMappingException e){ e.printStackTrace(); }
catch (JsonParseException e){ e.printStackTrace(); }*/
        catch (ParseException e) { e.printStackTrace(); }

    }
}
