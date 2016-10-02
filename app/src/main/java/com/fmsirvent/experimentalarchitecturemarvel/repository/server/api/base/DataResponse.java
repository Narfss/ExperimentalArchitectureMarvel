package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base;

import java.util.List;

public class DataResponse<T> {
    int offset;
    int limit;
    int total;
    int count;
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
