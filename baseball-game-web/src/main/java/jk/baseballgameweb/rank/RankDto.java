package jk.baseballgameweb.rank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RankDto {

    private String memberName;
    private String gameDisplayName;
    private int point;
}
