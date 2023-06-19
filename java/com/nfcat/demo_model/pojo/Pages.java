package com.nfcat.demo_model.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pages {
    private List<Paper> papers;
    private Integer total;
}
