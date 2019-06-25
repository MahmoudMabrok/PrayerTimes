package utitity.mahmoud.prayertimes.feature.display_times;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import utitity.mahmoud.prayertimes.R;

public class TimesAdapter extends RecyclerView.Adapter<TimesAdapter.Holder> {

    List<String> values;
    List<String> titles;

    public void setValues(List<String> titles, List<String> values) {
        this.titles = titles;
        this.values = values;
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.day_prayer_item, viewGroup, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvDayItem)
        TextView tvDayItem;
        @BindView(R.id.tvDayItemValue)
        TextView tvDayItemValue;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}