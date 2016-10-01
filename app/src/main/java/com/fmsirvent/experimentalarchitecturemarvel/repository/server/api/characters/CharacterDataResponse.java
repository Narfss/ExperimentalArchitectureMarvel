package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters;

import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.ImageResponse;

public class CharacterDataResponse {
    int id; //1011334,
    String name; // "3-D Man",
    String description; // "",
    String modified; //"2014-04-29T14:18:17-0400",
    ImageResponse thumbnail;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public ImageResponse getThumbnail() {
        return thumbnail;
    }

    //"resourceURI": "http://gateway.marvel.com/v1/public/characters/1011334",

    /*"comics": {
        "available": 11,
        "collectionURI": "http://gateway.marvel.com/v1/public/characters/1011334/comics",
        "items": [
            {
                "resourceURI": "http://gateway.marvel.com/v1/public/comics/21366",
                    "name": "Avengers: The Initiative (2007) #14"
            },
            ...
        ],
        "returned": 11
        },*/

    /*"series": {
        "available": 2,
        "collectionURI": "http://gateway.marvel.com/v1/public/characters/1011334/series",
        "items": [
            {
                "resourceURI": "http://gateway.marvel.com/v1/public/series/1945",
                    "name": "Avengers: The Initiative (2007 - 2010)"
            },
            ...
        ],
        "returned": 2
    },
    */

    /*"stories": {
        "available": 17,
        "collectionURI": "http://gateway.marvel.com/v1/public/characters/1011334/stories",
        "items": [
            {
                "resourceURI": "http://gateway.marvel.com/v1/public/stories/19947",
                    "name": "Cover #19947",
                    "type": "cover"
            },
            ...
        ],
        "returned": 17
    },*/

    /*"events": {
        "available": 1,
                "collectionURI": "http://gateway.marvel.com/v1/public/characters/1011334/events",
                "items": [
        {
            "resourceURI": "http://gateway.marvel.com/v1/public/events/269",
                "name": "Secret Invasion"
        }
        ],
        "returned": 1
    },
    */

    /*"urls": [
        {
            "type": "detail",
                "url": "http://marvel.com/characters/74/3-d_man?utm_campaign=apiRef&utm_source=6a7ed890b4b941a925202a5630d5b162"
        },
        {
            "type": "wiki",
                "url": "http://marvel.com/universe/3-D_Man_(Chandler)?utm_campaign=apiRef&utm_source=6a7ed890b4b941a925202a5630d5b162"
        },
        {
            "type": "comiclink",
                "url": "http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=6a7ed890b4b941a925202a5630d5b162"
        }
    ]*/
}
