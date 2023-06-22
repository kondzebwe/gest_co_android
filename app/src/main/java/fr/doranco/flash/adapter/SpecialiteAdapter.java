package fr.doranco.flash.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.doranco.flash.R;
import fr.doranco.flash.entity.Specialite;

/**
 * 1 - creer la classe SpecialiteViewHolder qui extends RecycleView.ViewHolder. Elle permet d'initialiser les composants de la vue
 * 2-  Faire que la classe SpecialiteAdapter extends RecycleView.Adapter<SpecialiteViewHolder>
 */


public class SpecialiteAdapter extends RecyclerView.Adapter<SpecialiteAdapter.SpecialiteViewHolder>{
    private List<Specialite> specialiteList;

    /**
     * Initialisation des donnees
     * @param specialiteList est la liste des objets a afficher par le recycleView
     */
    public SpecialiteAdapter(List<Specialite> specialiteList) {
        this.specialiteList = specialiteList;
    }

    /**
     * Cette methode permet de creer une vue a partir du fichier xml (dans notre cas recycle_view_item_specialite).
     * Elle est utilisee pour creer une instance de notre classe SpecialiteViewHolder.
     * Elle est appelee a chaque fois que le recycleView a besoin de creer une nouvelle vue.
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */

    @NonNull
    @Override
    public SpecialiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // generer un objet de type view a partir de notre fichier recycle_view_item_specialite.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item_specialite, parent, false);
        return new SpecialiteViewHolder(view);
    }

    /**
     * Cette methode permet d'associer les donnees a la vue nouvellement creer
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull SpecialiteViewHolder holder, int position) {
        // recuperer l'objet a afficher
        Specialite specialite = specialiteList.get(position);
        // update de la vue
        holder.nomSpecialite.setText(specialite.getNom());
    }

    @Override
    public int getItemCount() {
        return specialiteList.size();
    }

    public class SpecialiteViewHolder extends RecyclerView.ViewHolder{
        public TextView nomSpecialite;

        public SpecialiteViewHolder(@NonNull View itemView) {
            super(itemView);
            nomSpecialite = itemView.findViewById(R.id.textViewRecycleViewSpecialite);
        }
    }
}
