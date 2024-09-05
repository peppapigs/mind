package com.xg.service.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class DstTimeMount extends TimeMount {

    //分销商
    private long distributor;
}
