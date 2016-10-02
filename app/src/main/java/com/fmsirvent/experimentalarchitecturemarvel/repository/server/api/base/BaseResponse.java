package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base;

public class BaseResponse<T> {
    String code;
    String status;
    String copyright;
    String attributionText;
    String attributionHTML;
    String etag;
    DataResponse<T> data;

    public DataResponse<T> getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public String getEtag() {
        return etag;
    }
}
