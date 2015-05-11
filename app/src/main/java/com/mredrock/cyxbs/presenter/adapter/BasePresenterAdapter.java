package com.mredrock.cyxbs.presenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mredrock.cyxbs.view.impl.AbsItemVuHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 高度抽象的Adapter，当然是用于ListView的，包含了数据的增删改功能，已经将getView()方法简单化
 * Created by David on 15/4/24.
 */
public abstract class BasePresenterAdapter<T, V extends AbsItemVuHolder> extends BaseAdapter {
    protected V vu;
    private Context mContext;//万一要用呢
    private int          page   = 0;
    private ArrayList<T> mDatas = new ArrayList<>();

    public BasePresenterAdapter(Context mContext, ArrayList<T> datas) {
        this.mContext = mContext;
        this.mDatas = datas;
    }

    public void add(T elem) {
        mDatas.add(elem);
        notifyDataSetChanged();
    }

    public void addAll(List<T> elements) {
        mDatas.addAll(elements);
        notifyDataSetChanged();
    }

    public void set(T oldElem, T newElem) {
        set(mDatas.indexOf(oldElem), newElem);
    }

    public void set(int index, T elem) {
        mDatas.set(index, elem);
        notifyDataSetChanged();
    }

    public void remove(T elem) {
        mDatas.remove(elem);
        notifyDataSetChanged();
    }

    public void remove(int index) {
        mDatas.remove(index);
        notifyDataSetChanged();
    }

    public void refresh(ArrayList<T> datas) {
        if (datas == null) {
            datas = new ArrayList<T>(0);
        }
        this.mDatas = datas;
        notifyDataSetChanged();
    }

    public void replaceAll(ArrayList<T> elements) {
        mDatas.clear();
        mDatas.addAll(elements);
        notifyDataSetChanged();
    }

    public boolean contains(T elem) {
        return mDatas.contains(elem);
    }

    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    public int getPage() {
        return page;
    }

    public void addPage() {
        this.page += 1;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void resetPage() {
        this.page = 0;
    }

    @Override
    public final View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            try {
                vu = getVuClass().newInstance();
                vu.init(inflater, parent, position);//这一步是必须的，为了初始化
                convertView = vu.getView();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            //noinspection unchecked
            vu = (V) convertView.getTag();
        }
        if (convertView != null) {
            onBindListItemVu(position, convertView, parent);
        }
        return convertView;
    }

    protected abstract void onBindListItemVu(int position, View convertView, ViewGroup parent);

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected abstract Class<V> getVuClass();
}
