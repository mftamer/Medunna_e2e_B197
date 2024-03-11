package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
    //In this class, we are going create a reusable method which will convert json to any java object (map, or pojo)
    // In this class, we learn how to use a generic method
    // <T> T -> this syntax stands for 'any data type'


    public static <T> T convertJsonToJava (String str, Class <T> responseJava ){

        try {
            return new ObjectMapper().readValue(str, responseJava);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}