package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result;

import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.BaseRequest;

import java.util.Map;

public class OffsetRequest {
    private static final String OFFSET = "offset";

    public static Map<String,String> getMap(int offset) {
        Map<String, String> map = BaseRequest.getMap();
        map.put(OFFSET, String.valueOf(offset));
        return map;
    }
}
