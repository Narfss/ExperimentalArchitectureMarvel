package com.fmsirvent.experimentalarchitecturemarvel.view.comic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.fmsirvent.experimentalarchitecturemarvel.R;
import com.fmsirvent.experimentalarchitecturemarvel.view.base.BaseActivity;
import com.fmsirvent.experimentalarchitecturemarvel.view.comics.MarvelComicMVO;

import butterknife.ButterKnife;

public class ComicActivity extends BaseActivity {

    public static final String EXTRA_COMIC_ID = "EXTRA_COMIC_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic);
        Bundle extras = getIntent().getExtras();
        if (extras == null
            || !extras.containsKey(EXTRA_COMIC_ID)) {
            finish();
        }
        setupComicFragment();
        ButterKnife.bind(this);
    }

    private void setupComicFragment() {
        Bundle extras = getIntent().getExtras();
        long comicId = extras.getLong(EXTRA_COMIC_ID);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, ComicFragment.newInstance(comicId));
        ft.commit();
    }

    public static Intent newIntent(Context context, MarvelComicMVO comic) {
        Intent intent = new Intent(context, ComicActivity.class);
        intent.putExtra(EXTRA_COMIC_ID, comic.getId());
        return intent;
    }
}
