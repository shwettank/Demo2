package com.shyamanu.merakivendor.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shyamanu.merakivendor.R;
import com.shyamanu.merakivendor.activity.HomeActivity;
import com.shyamanu.merakivendor.activity.PurchaseProductActivity;

/**
 * Created by shwettank.ramteke on 4/5/2018.
 */

public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView> {

    private HomeActivity context;

   /* int[] imgList = {R.drawable.two, R.drawable.one, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
            R.drawable.nine, R.drawable.ten};*/

    int[] imgList = {R.drawable.apple_one, R.drawable.android_two, R.drawable.bajaj_three, R.drawable.ducati_four,
            R.drawable.samsung_five, R.drawable.office_six, R.drawable.office_seven, R.drawable.office_eight,
            R.drawable.nine, R.drawable.ten};

    String[] headerList = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten"};

    String[] contentList = {"Mountain view", "Coriender", "Eat it on daily basis", "View in night", "Mountain list", "Gold coin",
            "Mobile stand", "Cloud evening view", "Cloud day view", "Ocean view"};

    public MasonryAdapter(HomeActivity context) {
        this.context = context;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        MasonryView masonryView = new MasonryView(layoutView);
        return masonryView;
    }

    @Override
    public void onBindViewHolder(MasonryView holder, final int position) {
        holder.imageView.setImageResource(imgList[position]);
        holder.txtHeader.setText(headerList[position]);
        holder.txtFooter.setText(contentList[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Value",""+headerList[position]);

                Intent productDetailIntent = new Intent(context, PurchaseProductActivity.class);
                context.startActivity(productDetailIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return headerList.length;
    }

    class MasonryView extends RecyclerView.ViewHolder {
        LinearLayout mainLayout;
        ImageView imageView;
        TextView txtHeader;
        TextView txtFooter;

        public MasonryView(View itemView) {
            super(itemView);
            mainLayout = (LinearLayout) itemView.findViewById(R.id.mainLayout);
            imageView = (ImageView) itemView.findViewById(R.id.img);
            txtHeader = (TextView) itemView.findViewById(R.id.textViewHeader);
            txtFooter = (TextView) itemView.findViewById(R.id.textViewFooter);
        }
    }
}
