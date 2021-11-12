package pucminas.br.nutriplus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SelecaoAlimentosAdapter extends RecyclerView.Adapter<SelecaoAlimentosAdapter.MyViewHolder>{
    private List<Alimento> mDataset;
    OnClickListener<Alimento> onClickListener;

    public SelecaoAlimentosAdapter(OnClickListener<Alimento> clickListener) {
        mDataset = new ArrayList<>();
        onClickListener = clickListener;
    }

    public void setList(List<Alimento> alimentos) {
        mDataset.addAll(alimentos);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder((CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_alimento, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Alimento alimento = mDataset.get(position);
        holder.checkBox.setChecked(alimento.isSelecionado());
        holder.checkBox.setText(alimento.getNome());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                alimento.setSelecionado(!alimento.isSelecionado());
                onClickListener.onClick(alimento);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CheckBox checkBox;


        public MyViewHolder(CardView v) {
            super(v);
            checkBox = v.findViewById(R.id.checkBox);
        }
    }
}

interface OnClickListener<T> {
    void onClick(T T);
}
