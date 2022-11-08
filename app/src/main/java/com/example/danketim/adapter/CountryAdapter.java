package com.example.danketim.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.danketim.OnItemClickListener;
import com.example.danketim.R;
import com.example.danketim.model.CountryModel;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountriesViewHolder> implements View.OnClickListener {

    private List<CountryModel> listCountries;
    private OnItemClickListener onItemClickListener;

    public CountryAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(List<CountryModel> listCountries) {
        this.listCountries = listCountries;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountriesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.CountriesViewHolder holder, int position) {
        holder.itemView.setOnClickListener(this);
        holder.onBind(listCountries.get(position));
    }

    // метод возврашяюший (отвечаюший за) количество элементов в списке
    @Override
    public int getItemCount() {

        return listCountries.size();
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.onClick((CountryModel) view.getTag());
    }

    // класс который отвечает за упаковку данных view
    public static class CountriesViewHolder extends RecyclerView.ViewHolder {

        private final MaterialCardView mainContainer;
        private final ImageView imageView;
        private final TextView textAmount;
        private final TextView textName;

        // конструктор для viewHolder
        public CountriesViewHolder(@NonNull View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            textAmount = view.findViewById(R.id.textView2);
            textName = view.findViewById(R.id.textView);
            mainContainer = view.findViewById(R.id.mainContainer);

        }

        // метод отвечающий  за привязку данных внутри viewHolder
        public void onBind(CountryModel country ) {
            Glide.with(imageView.getContext()).load(country.getImageUrl()).into(imageView);
            textName.setText(country.getName());
            // что такое valueOf c помощью его мы можем тип данных int можем переобразовать в String
            textAmount.setText(String.valueOf(country.getAmount()));

            ////мы тут меняем цвета в item_task то есть там мы меняется определенный цвет на то что добавили в repasitory
            mainContainer.setCardBackgroundColor(Color.parseColor(country.getColor()));
            itemView.setTag(country); // это означает например у нас есть 10 контейнеров и столько же создается country
            //это означает что item_view обрашается к главным контейнерам
            // itemView.setBackgroundColor(Color.parseColor(country.getColor()));
        }
    }
}
