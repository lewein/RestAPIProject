package packageRest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class FileLoad {
//    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public RestResponse restMethod(String name) {
//        RestResponse result = new RestResponse();
//        result.setParam1("Hello");
//        result.setParam2(name);
//        return result;
//    }
//
    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "application/json",produces = "application/json")
    public @ResponseBody
    String fileUpload(@RequestParam("name") String name,
                            @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                String res = new String();
                for (byte b:bytes) {
                    res += (char)b;
                }
                stream.write(bytes);
                stream.close();
                return res;
            } catch(Exception e) {
                return "Вам не удалось загрузить файл! Ошибка "+ e.getMessage();
            }
        } else {
            return "Загрузка не удалась! Файл " + name + " пустой!";
        }
    }
}
