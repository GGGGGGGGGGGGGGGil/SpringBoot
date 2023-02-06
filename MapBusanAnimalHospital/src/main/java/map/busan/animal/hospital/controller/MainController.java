package map.busan.animal.hospital.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import map.busan.animal.hospital.vo.ItemVO;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import map.busan.animal.hospital.vo.ResultVO;

import java.net.URI;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model){

        // API 정보
        String apiURL = "http://apis.data.go.kr/6260000/BusanAnimalHospService/getTblAnimalHospital";
        String serviceKey = "jdhOacqz0YfoPy4giP7Ur%2BdZuSeJxm1wm%2F1Txp34d%2BvXcxmbKhsdOtpg%2BBuhGiKdEsA9ZPl1ZPPQDr3jW6nunw%3D%3D";
        String resultType = "json";
        String pageNo = "1";
        String numOfRows = "1000"; // 부산시 전체 동물병원 279

        URI uri = UriComponentsBuilder
                        .fromUriString(apiURL)
                        .queryParam("serviceKey", serviceKey)
                        .queryParam("resultType", resultType)
                        .queryParam("pageNo", pageNo)
                        .queryParam("numOfRows", numOfRows)
                        .encode()
                        .build(true)
                        .toUri();

        RequestEntity<Void> req = RequestEntity.get(uri).build();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(req, String.class);

        // JSON 문자열
        String jsonData = result.getBody();

        // JSON 파싱(Deserialization)
        ObjectMapper om = new ObjectMapper();
        try {
            ResultVO resultVO = om.readValue(jsonData, ResultVO.class);
            ItemVO[] items = resultVO.getGetTblAnimalHospital().getBody().getItems().getItem();
            // System.out.println(item);
            model.addAttribute("items", items);
        } catch (JsonMappingException e) {
                e.printStackTrace();
        } catch (JsonProcessingException e) {
                e.printStackTrace();
        }

        return "index";
    }
}
