package com.tofohack.jianhui_zhu.cardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jianhui zhu on 15-08-27.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {
    private List<Tree> trees;
    private Context context;

    /**
     * Private constructor, force user use builder to construct adapter object
     * @param cardViewAdapterBuilder
     */
    private CardViewAdapter(CardViewAdapterBuilder cardViewAdapterBuilder) {
        trees = cardViewAdapterBuilder.trees;
        context = cardViewAdapterBuilder.context;
    }

    @Override
    public CardViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         * Steps
         * 1. save the context for future usage(Optional)
         *
         * 2. Pass the context to the LayoutInflater
         *
         * 3. inflate a new view with
         *    1. layout file
         *    2. The root view to be attached
         *    3. Attach to the root view or not
         *
         * 4. Create a new ViewHolder which defined as an inner class of CardViewAdapter and return
         */
        this.context = parent.getContext();

        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.card_view, parent, false);


        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CardViewAdapter.ViewHolder holder, int position) {
        /**
         * Get the specific tree from tree list
         */
        Tree tree = trees.get(position);
        /**
         * Set the tree name for the card_view
         */
        holder
                .cardName
                .setText(tree.getName());
        /**
         * Set the image for the card_view
         *
         * Steps:
         * 1. with(context) pass the parent view context here
         *
         * 2. load(tree.getImagePath()) pass the path of tree's image
         *
         * 3. fit() resize the image to fit exactly into the target {@link ImageView}'s bounds --Picasso Square
         *
         * 4. into(holder.imageForCard) load the given image into the specific ImageView(here is holder.imageForCard)
         */
        Picasso
                .with(context)
                .load(tree.getImagePath())
                .fit()
                .centerCrop()
                .into(holder.imageForCard);

    }

    @Override
    public int getItemCount() {
        /**
         * return the number of trees in the trees list
         */
        return trees == null ? 0 : trees.size();
    }

    /**
     * ViewHolder, like normal adapter in list view and spinner view
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.image_for_card)
        ImageView imageForCard;
        @Bind(R.id.card_name)
        TextView cardName;

        /**
         * viewholder constructor
         * @param itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    /**
     * Builder, please reference Effective Java builder pattern
     */
    public static class CardViewAdapterBuilder {
        private Context context;
        private List<Tree> trees;

        /**
         * Setters
         * @param context
         * @return
         */
        public CardViewAdapterBuilder setContext(Context context) {
            this.context = context;
            return this;
        }

        public CardViewAdapterBuilder setTrees(List<Tree> trees) {
            this.trees = trees;
            return this;
        }

        public CardViewAdapter build() {
            return new CardViewAdapter(this);
        }
    }
}
