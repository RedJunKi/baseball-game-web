package jk.baseballgameweb.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class BoardDto {

    private String username;
    private String title;
    private String content;

}
