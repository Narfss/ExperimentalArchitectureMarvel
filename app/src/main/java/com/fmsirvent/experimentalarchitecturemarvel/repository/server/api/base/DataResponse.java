package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base;

import java.util.List;

public class DataResponse<T> {
    int offset; // 0,
    int limit; // 20,
    int total; // 1494,
    int count; // 20,
    List<T> results;

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public List<T> getResults() {
        return results;
    }
}
