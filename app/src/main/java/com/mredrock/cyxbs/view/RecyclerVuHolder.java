package com.mredrock.cyxbs.view;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by David on 15/4/27.
 */
public class RecyclerVuHolder extends RecyclerView.ViewHolder {

    public RecyclerVuHolder(View itemView){
        super(itemView);
    }

    public RecyclerVuHolder(ViewGroup parent, int viewType, @LayoutRes int layoutId) {
        super(LayoutInflater.from(parent.getContext()).inflate(layoutId,parent,false));
    }

}
