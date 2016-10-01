package com.fmsirvent.experimentalarchitecturemarvel.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;
import com.pedrogomez.renderers.RendererViewHolder;

public class ClickableRVRendererAdapter<T> extends RVRendererAdapter<T> {
    private OnItemClick onItemClick;

    public ClickableRVRendererAdapter(RendererBuilder rendererBuilder) {
        super(rendererBuilder);
    }

    public ClickableRVRendererAdapter(RendererBuilder rendererBuilder, AdapteeCollection collection) {
        super(rendererBuilder, collection);
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @Override
    public RendererViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final RendererViewHolder rendererViewHolder = super.onCreateViewHolder(viewGroup, viewType);
        if (onItemClick != null) {
            rendererViewHolder.getRenderer().getRootView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = rendererViewHolder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION
                            && position < getItemCount() ) {
                        onItemClick.onItemClick(position);
                    }
                }
            });
        }
        return rendererViewHolder;
    }

    public interface OnItemClick {
        void onItemClick(int position);
    }
}
