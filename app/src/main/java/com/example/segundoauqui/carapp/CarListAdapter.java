package com.example.segundoauqui.carapp;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by segundoauqui on 8/12/17.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.ViewHolder> {


    List<Car> carList = new ArrayList<>();

    public CarListAdapter(List<Car> carList) {
        this.carList = carList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvModel, tvType, tvYear;

        public ViewHolder(View itemView) {
            super(itemView);
            tvModel = (TextView) itemView.findViewById(R.id.tvModel);
            tvType = (TextView) itemView.findViewById(R.id.tvType);
            tvYear = (TextView) itemView.findViewById(R.id.tvYear);

        }
    }

    @Override
    public CarListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carlist_item, parent, false);
        return new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(CarListAdapter.ViewHolder holder, int position) {
        final Car car = carList.get(position);
        holder.tvModel.setText("Model: " + car.getModel());
        holder.tvType.setText("Type: " + car.getType());
        holder.tvYear.setText("Year: " + car.getYear());


    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

}
