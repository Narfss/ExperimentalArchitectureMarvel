package com.fmsirvent.experimentalarchitecturemarvel.view.images;

import com.fmsirvent.experimentalarchitecturemarvel.BaseTest;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MarvelImageMVOTest extends BaseTest {
    private static final String EXTENSION = "jpg";
    private static final String PATH = "http://x.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73";
    private static final String STANDARD_SMALL = PATH + "/standard_small."+ EXTENSION;
    private static final String STANDARD_MEDIUM = PATH + "/standard_medium."+ EXTENSION;
    private static final String STANDARD_XLARGE = PATH + "/standard_xlarge."+ EXTENSION;
    private static final String STANDARD_FANTASTIC = PATH + "/standard_fantastic."+ EXTENSION;
    private static final String STANDARD_UNCANNY = PATH + "/standard_uncanny."+ EXTENSION;
    private static final String STANDARD_INCREDIBLE = PATH + "/standard_incredible."+ EXTENSION;
    private static final String PORTRAIT_SMALL = PATH + "/portrait_small."+ EXTENSION;
    private static final String PORTRAIT_MEDIUM = PATH + "/portrait_medium."+ EXTENSION;
    private static final String PORTRAIT_XLARGE = PATH + "/portrait_xlarge."+ EXTENSION;
    private static final String PORTRAIT_FANTASTIC = PATH + "/portrait_fantastic."+ EXTENSION;
    private static final String PORTRAIT_UNCANNY = PATH + "/portrait_uncanny."+ EXTENSION;
    private static final String PORTRAIT_INCREDIBLE = PATH + "/portrait_incredible."+ EXTENSION;
    private static final String LANDSCAPE_SMALL = PATH + "/landscape_small."+ EXTENSION;
    private static final String LANDSCAPE_MEDIUM = PATH + "/landscape_medium."+ EXTENSION;
    private static final String LANDSCAPE_XLARGE = PATH + "/landscape_xlarge."+ EXTENSION;
    private static final String LANDSCAPE_FANTASTIC = PATH + "/landscape_fantastic."+ EXTENSION;
    private static final String LANDSCAPE_UNCANNY = PATH + "/landscape_uncanny."+ EXTENSION;
    private static final String LANDSCAPE_INCREDIBLE = PATH + "/landscape_incredible."+ EXTENSION;
    private static final String DETAIL = PATH + "/detail."+ EXTENSION;
    private static final String FULL_SIZE = PATH + "."+ EXTENSION;
    private MarvelImageMVO image;

    @Override
    public void setup() {
        image = new MarvelImageMVO.Builder()
                .setPath(PATH)
                .setExtension(EXTENSION)
                .build();
    }

    @Test
    public void shouldReturnUrlDetail(){
        String url = image.getURL(MarvelImageMVO.Original.DETAIL);
        assertEquals(DETAIL, url);
    }

    @Test
    public void shouldReturnFullsize(){
        String url = image.getURL(MarvelImageMVO.Original.FULL_SIZE);
        assertEquals(FULL_SIZE, url);
    }

    @Test
    public void shouldReturnUrlSMALLStandard(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.STANDARD, MarvelImageMVO.AspectSize.SMALL);
        assertEquals(STANDARD_SMALL, url);
    }

    @Test
    public void shouldReturnUrlMEDIUMStandard(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.STANDARD, MarvelImageMVO.AspectSize.MEDIUM);
        assertEquals(STANDARD_MEDIUM, url);
    }

    @Test
    public void shouldReturnUrlXLARGEStandard(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.STANDARD, MarvelImageMVO.AspectSize.XLARGE);
        assertEquals(STANDARD_XLARGE, url);
    }

    @Test
    public void shouldReturnUrlFANTASTICStandard(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.STANDARD, MarvelImageMVO.AspectSize.FANTASTIC);
        assertEquals(STANDARD_FANTASTIC, url);
    }

    @Test
    public void shouldReturnUrlUNCANNYStandard(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.STANDARD, MarvelImageMVO.AspectSize.UNCANNY);
        assertEquals(STANDARD_UNCANNY, url);
    }

    @Test
    public void shouldReturnUrlINCREDIBLEStandard(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.STANDARD, MarvelImageMVO.AspectSize.INCREDIBLE);
        assertEquals(STANDARD_INCREDIBLE, url);
    }

    @Test
    public void shouldReturnUrlSMALLPortrait(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.PORTRAIT, MarvelImageMVO.AspectSize.SMALL);
        assertEquals(PORTRAIT_SMALL, url);
    }

    @Test
    public void shouldReturnUrlMEDIUMPortrait(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.PORTRAIT, MarvelImageMVO.AspectSize.MEDIUM);
        assertEquals(PORTRAIT_MEDIUM, url);
    }

    @Test
    public void shouldReturnUrlXLARGEPortrait(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.PORTRAIT, MarvelImageMVO.AspectSize.XLARGE);
        assertEquals(PORTRAIT_XLARGE, url);
    }

    @Test
    public void shouldReturnUrlFANTASTICPortrait(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.PORTRAIT, MarvelImageMVO.AspectSize.FANTASTIC);
        assertEquals(PORTRAIT_FANTASTIC, url);
    }

    @Test
    public void shouldReturnUrlUNCANNYPortrait(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.PORTRAIT, MarvelImageMVO.AspectSize.UNCANNY);
        assertEquals(PORTRAIT_UNCANNY, url);
    }

    @Test
    public void shouldReturnUrlINCREDIBLEPortrait(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.PORTRAIT, MarvelImageMVO.AspectSize.INCREDIBLE);
        assertEquals(PORTRAIT_INCREDIBLE, url);
    }

    @Test
    public void shouldReturnUrlSMALLLandscape(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.LANDSCAPE, MarvelImageMVO.AspectSize.SMALL);
        assertEquals(LANDSCAPE_SMALL, url);
    }

    @Test
    public void shouldReturnUrlMEDIUMLandscape(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.LANDSCAPE, MarvelImageMVO.AspectSize.MEDIUM);
        assertEquals(LANDSCAPE_MEDIUM, url);
    }

    @Test
    public void shouldReturnUrlXLARGELandscape(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.LANDSCAPE, MarvelImageMVO.AspectSize.XLARGE);
        assertEquals(LANDSCAPE_XLARGE, url);
    }

    @Test
    public void shouldReturnUrlFANTASTICLandscape(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.LANDSCAPE, MarvelImageMVO.AspectSize.FANTASTIC);
        assertEquals(LANDSCAPE_FANTASTIC, url);
    }

    @Test
    public void shouldReturnUrlUNCANNYLandscape(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.LANDSCAPE, MarvelImageMVO.AspectSize.UNCANNY);
        assertEquals(LANDSCAPE_UNCANNY, url);
    }

    @Test
    public void shouldReturnUrlINCREDIBLELandscape(){
        String url = image.getURL(MarvelImageMVO.AspectRatio.LANDSCAPE, MarvelImageMVO.AspectSize.INCREDIBLE);
        assertEquals(LANDSCAPE_INCREDIBLE, url);
    }
}