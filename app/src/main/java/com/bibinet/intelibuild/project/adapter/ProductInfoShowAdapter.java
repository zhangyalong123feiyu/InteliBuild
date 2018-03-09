package com.bibinet.intelibuild.project.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.project.bean.ProductInfoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bibinet on 2018-1-12.
 */

public class ProductInfoShowAdapter extends RecyclerView.Adapter<ProductInfoShowAdapter.ProductInfoShowViewHolder> {
    private List<ProductInfoBean> productInfoList = new ArrayList();
    private Context context;

    public ProductInfoShowAdapter(List<ProductInfoBean> productInfoList, Context context) {
        this.productInfoList = productInfoList;
        this.context = context;
    }

    @Override
    public ProductInfoShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductInfoShowViewHolder(LayoutInflater.from(context).inflate(R.layout.item_productinfoshow_adapter,null));
    }

    @Override
    public void onBindViewHolder(ProductInfoShowViewHolder holder, int position) {
        holder.projectName.setText(productInfoList.get(position).getProductName());
        holder.projectImage.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return productInfoList.size() > 0 ? productInfoList.size() : 0;
    }

    class ProductInfoShowViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.projectImage)
        ImageView projectImage;
        @BindView(R.id.projectName)
        TextView projectName;
        public ProductInfoShowViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
