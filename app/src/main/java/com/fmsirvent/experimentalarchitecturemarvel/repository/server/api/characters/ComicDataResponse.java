package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters;

import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.base.ImageResponse;

import java.util.List;

public class ComicDataResponse {
    long id; //57870,
    int digitalId; //0,
    String title; //"Captain America: Steve Rogers (2016) #5",
    int issueNumber; //5,
    //String variantDescription; //"",
    String description; //"CIVIL WAR II TIE-IN! As heroes choose sides and tragedy strikes, Steve takes steps to end the war. Guest-starring the Invincible Iron Man!",
    String modified; //"2016-09-22T10:39:34-0400",
    String isbn; //"",
    //String upc; //"75960608457900511",
    //String diamondCode; //"JUN160784",
    //String ean; //"",
    //String issn; //"",
    //String format; //"Comic",
    int pageCount; //32,
    ImageResponse thumbnail;
    List<ImageResponse> images;

    public long getId() {
        return id;
    }

    public int getDigitalId() {
        return digitalId;
    }

    public String getTitle() {
        return title;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPageCount() {
        return pageCount;
    }

    public ImageResponse getThumbnail() {
        return thumbnail;
    }

    public List<ImageResponse> getImages() {
        return images;
    }

    /*"textObjects": [
        {
            "type": "issue_solicit_text",
            "language": "en-us",
            "text": "CIVIL WAR II TIE-IN! As heroes choose sides and tragedy strikes, Steve takes steps to end the war. Guest-starring the Invincible Iron Man!"
        }
    ],*/

    //"resourceURI": "http://gateway.marvel.com/v1/public/comics/57870",

    /*"urls": [
        {
            "type": "detail",
                "url": "http://marvel.com/comics/issue/57870/captain_america_steve_rogers_2016_5?utm_campaign=apiRef&utm_source=6a7ed890b4b941a925202a5630d5b162"
        },
        {
            "type": "purchase",
                "url": "http://comicstore.marvel.com/Captain-America-Steve-Rogers-5/digital-comic/42313?utm_campaign=apiRef&utm_source=6a7ed890b4b941a925202a5630d5b162"
        }
        ],
                "series": {
            "resourceURI": "http://gateway.marvel.com/v1/public/series/21098",
                    "name": "Captain America: Steve Rogers (2016 - Present)"
        },
                "variants": [
        {
            "resourceURI": "http://gateway.marvel.com/v1/public/comics/60203",
                "name": "Captain America: Steve Rogers (2016) #5 (Chen Marvel Tsum Tsum Takeover Variant)"
        }
    ],
    */

    //"collections": [],

    //"collectedIssues": [],

    /*"dates": [
    {
        "type": "onsaleDate",
            "date": "2016-09-28T00:00:00-0400"
    },
    {
        "type": "focDate",
            "date": "2016-09-13T00:00:00-0400"
    }
    ],
    */

    /*"prices": [
    {
        "type": "printPrice",
            "price": 3.99
    }
    ],
    */


    /*"creators": {
        "available": 4,
                "collectionURI": "http://gateway.marvel.com/v1/public/comics/57870/creators",
                "items": [
        {
            "resourceURI": "http://gateway.marvel.com/v1/public/creators/2133",
                "name": "Tom Brevoort",
                "role": "editor"
        },
        ...
        ],
        "returned": 4
    },
    */

    /*"fragment_characters": {
        "available": 1,
                "collectionURI": "http://gateway.marvel.com/v1/public/comics/57870/characters",
                "items": [
        {
            "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009220",
                "name": "Captain America"
        }
        ],
        "returned": 1
    },
    */


    /*"stories": {
        "available": 2,
                "collectionURI": "http://gateway.marvel.com/v1/public/comics/57870/stories",
                "items": [
        {
            "resourceURI": "http://gateway.marvel.com/v1/public/stories/126442",
                "name": "cover from Captain America: Steve Rogers (2016) #5",
                "type": "cover"
        },
        {
            "resourceURI": "http://gateway.marvel.com/v1/public/stories/126443",
                "name": "story from Captain America: Steve Rogers (2016) #5",
                "type": "interiorStory"
        }
        ],
        "returned": 2
    },
    */

    /*"events": {
        "available": 0,
                "collectionURI": "http://gateway.marvel.com/v1/public/comics/57870/events",
                "items": [],
        "returned": 0
    }
    */
}
