package pucminas.br.nutriplus;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SelecaoAlimentosAdapter extends RecyclerView.Adapter<SelecaoAlimentosAdapter.MyViewHolder>{
    private final List<Alimento> mDataset;

    public SelecaoAlimentosAdapter() {
        mDataset = new ArrayList<>();
    }

    public void setList(List<Alimento> alimentos) {
        mDataset.addAll(alimentos);
        notifyItemRangeInserted(getItemCount(), alimentos.size());
    }

    public List<Alimento> getSelectedAliments(){
        return mDataset.stream().filter(Alimento::isSelecionado).collect(Collectors.toList());
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
        holder.checkBox.setOnCheckedChangeListener(null);

        holder.checkBox.setChecked(alimento.isSelecionado());
        holder.checkBox.setText(alimento.getNome());
        holder.checkBox.setOnCheckedChangeListener((compoundButton, b) -> {
            mDataset.get(holder.getAdapterPosition()).setSelecionado(b);
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