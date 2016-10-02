package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result;

import java.util.List;

public class Data<T> {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<T> result;

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

    public List<T> getResult() {
        return result;
    }

    public boolean isUniqueResult() {
        return getResult().size() == 1;
    }

    public T getFirstResult() {
        return result.get(0);
    }

    public static class Builder<T> {
        int offset;
        int limit;
        int total;
        int count;
        List<T> result;

        public Builder setOffset(int offset) {
            this.offset = offset;
            return this;
        }

        public Builder setLimit(int limit) {
            this.limit = limit;
            return this;
        }

        public Builder setTotal(int total) {
            this.total = total;
            return this;
        }

        public Builder setCount(int count) {
            this.count = count;
            return this;
        }

        public Builder setResult(List<T> result) {
            this.result = result;
            return this;
        }

        public Data<T> build() {
            Data data = new Data<>();
            data.offset = offset;
            data.limit = limit;
            data.total = total;
            data.count = count;
            data.result = result;
            return data;
        }
    }
}
