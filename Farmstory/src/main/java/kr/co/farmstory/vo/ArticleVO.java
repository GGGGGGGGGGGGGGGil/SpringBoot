package kr.co.farmstory.vo;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleVO {

    private int no;
    private int parent;
    private int comment;
    private String cate;
    private String title;
    private String content;
    private int file;
    private int hit;
    private String uid;
    private String regip;
    private String rdate;

    //날짜, 시간 짜르기
    public String getRdate(){
        return rdate.substring(2, 10);
    }

    // 추가 필드
    private String nick;
    private String fileVO;
}
