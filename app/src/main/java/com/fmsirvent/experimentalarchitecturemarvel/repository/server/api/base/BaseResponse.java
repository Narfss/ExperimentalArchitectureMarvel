package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base;

public class BaseResponse<T> {
    String code;    //200
    String status;    //"Ok"
    String copyright;    //"© 2016 MARVEL"
    String attributionText;     //"Data provided by Marvel. © 2016 MARVEL"
    String attributionHTML;     //"<a href=\"http://marvel.com\">Data provided by Marvel. © 2016 MARVEL</a>"
    String etag;    //"832ee47a73b87eb78f3b4123b9e1961b96a6af4c"
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
