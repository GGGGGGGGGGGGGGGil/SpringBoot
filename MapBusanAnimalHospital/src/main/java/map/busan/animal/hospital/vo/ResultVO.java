package map.busan.animal.hospital.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultVO {
    private GetTblAnimalHospital getTblAnimalHospital;

    @Getter
    @Setter
    public class GetTblAnimalHospital {
        private Header header;
        private Body body;

        @Getter
        @Setter
        public class Header {
            private String resultCode; // 결과 코드
            private String resultMsg; // 결과 메세지
        }

        @Getter
        @Setter
        public class Body {
            private Items items;
            private int numOfRows; // 한 페이지 결과 수
            private int pageNo; // 페이지번호
            private int totalCount; // 전체 결과 수

            @Getter
            @Setter
            public class Items {
                private String item;
            }
        }
    }
}
