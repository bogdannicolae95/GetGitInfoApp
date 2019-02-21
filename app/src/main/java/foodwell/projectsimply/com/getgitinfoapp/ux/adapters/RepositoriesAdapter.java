package foodwell.projectsimply.com.getgitinfoapp.ux.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import foodwell.projectsimply.com.getgitinfoapp.R;
import foodwell.projectsimply.com.getgitinfoapp.common.Repository;
import foodwell.projectsimply.com.getgitinfoapp.ux.i.OnBottomReachedListener;
import foodwell.projectsimply.com.getgitinfoapp.ux.i.OnRecyclerItemClicked;

public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.RecyclerViewHolder> {

    List<Repository> listOfRepositories;
    OnBottomReachedListener onBottomReachedListener;
    OnRecyclerItemClicked onRecyclerItemClicked;

    public void setOnRecyclerItemClicked(OnRecyclerItemClicked onRecyclerItemClicked) {
        this.onRecyclerItemClicked = onRecyclerItemClicked;
    }

    public RepositoriesAdapter(OnBottomReachedListener onBottomReachedListener) {
        this.onBottomReachedListener = onBottomReachedListener;
    }

    public void setListOfRepositories(List<Repository> listOfRepositories) {
        this.listOfRepositories = listOfRepositories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepositoriesAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repository_row_layout,viewGroup,false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoriesAdapter.RecyclerViewHolder viewHolder, int position) {
        Repository currentRepository = listOfRepositories.get(position);

        viewHolder.repoId.setText(String.valueOf(currentRepository.getFullName()));
        viewHolder.repoOwnerName.setText(String.valueOf(currentRepository.getStars()));

        if(position == listOfRepositories.size() - 1){
            onBottomReachedListener.onBottomReached();
        }

        viewHolder.itemView.setOnClickListener(v -> {
            onRecyclerItemClicked.onItemClick(currentRepository);
        });
    }

    @Override
    public int getItemCount() {
        return listOfRepositories != null ? listOfRepositories.size() : 0;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView repoId,repoOwnerName;

        public RecyclerViewHolder(@NonNull View view) {
            super(view);

            repoId = view.findViewById(R.id.repo_row_id);
            repoOwnerName = view.findViewById(R.id.repo_row_login_name);
        }
    }
}
