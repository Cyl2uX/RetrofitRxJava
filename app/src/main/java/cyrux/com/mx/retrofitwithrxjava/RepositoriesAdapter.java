package cyrux.com.mx.retrofitwithrxjava;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.ViewHolder> {

    private List<Repository> repositoryList;

    public RepositoriesAdapter(List<Repository> repositoryList) {
        this.repositoryList = repositoryList;
    }

    @NonNull
    @Override
    public RepositoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View repositoriesView = layoutInflater.inflate(R.layout.item_repository, viewGroup, false);

        return new ViewHolder(repositoriesView);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoriesAdapter.ViewHolder viewHolder, int i) {
        Repository repository = repositoryList.get(i);
        viewHolder.tvName.setText(repository.getName());
        viewHolder.tvDescription.setText(repository.getDescription());
    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
