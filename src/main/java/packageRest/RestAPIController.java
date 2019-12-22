package packageRest;

import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

@RestController
public class RestAPIController {
    public static class RestResponse {
        private String param1;
        private String param2;

        public String getParam1(){
            return param1;
        }

        public void setParam1(String param1) {
            this.param1 = param1;
        }

        public String getParam2() {
            return param2;
        }

        public void setParam2(String param2) {
            this.param2 = param2;
        }
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse restMethod(String name) {
        RestResponse result = new RestResponse();
        result.setParam1("Hello");
        result.setParam2(name);
        return result;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "application/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
                                                 @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
//                String res = new String();
//                for (byte b:bytes) {
//                    res += (char)b;
//                }
                JsonParser parser = new JsonParser() {
                    @Override
                    public Map<String, Object> parseMap(String json) throws JsonParseException {
                        return null;
                    }

                    @Override
                    public List<Object> parseList(String json) throws JsonParseException {
                        return null;
                    }
                }
                stream.write(bytes);
                stream.close();
                return "Вы удачно загрузили ";
            } catch(Exception e) {
                return "Вам не удалось загрузить файл! Ошибка "+ e.getMessage();
            }
        } else {
            return "Загрузка не удалась! Файл " + name + " пустой!";
        }
    }
}
