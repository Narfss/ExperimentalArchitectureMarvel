package com.fmsirvent.experimentalarchitecturemarvel.utils;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedrogomez.renderers.Renderer;

import butterknife.ButterKnife;

public abstract class RendererButterKnife<T> extends Renderer<T> {
    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View inflatedView = inflater.inflate(onLayoutRequest(), parent, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @LayoutRes
    protected abstract int onLayoutRequest();

    @Override
    protected void setUpView(View rootView) { }

    @Override
    protected void hookListeners(View rootView) { }
}
