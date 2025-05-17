package com.lld.lowleveldesign.pubsub;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Publisher {
    private long id;
    private String name;
}
