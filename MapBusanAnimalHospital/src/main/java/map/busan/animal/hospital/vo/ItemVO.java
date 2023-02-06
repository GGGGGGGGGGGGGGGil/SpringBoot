package map.busan.animal.hospital.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemVO {
    private String gugun; // 구군명
    private String animal_hospital; // 병원명
    private String approval; // 인허가일자
    private String road_address; // 도로명주소
    private String tal; // 전화번호
    private String lat; // 위도(latitude)
    private String lon; // 경도(longitude)
    private String basic_date; // 데이터기준일자
}
