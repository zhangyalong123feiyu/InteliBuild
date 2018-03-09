package com.bibinet.intelibuild.project.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bibinet.intelibuild.R;
import com.bibinet.intelibuild.project.adapter.ProductInfoShowAdapter;
import com.bibinet.intelibuild.project.application.Constants;
import com.bibinet.intelibuild.project.bean.ProductInfoBean;
import com.bibinet.intelibuild.project.ui.baseui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bibinet on 2018-1-12.
 */

public class ProductInfoShowActivity extends BaseActivity {
    @BindView(R.id.proFileNumber)
    TextView proFileNumber;
    @BindView(R.id.productFile)
    TextView productFile;
    @BindView(R.id.productName)
    TextView productName;
    @BindView(R.id.productNumb)
    TextView productNumb;
    @BindView(R.id.productRecycler)
    RecyclerView productRecycler;
    private List<ProductInfoBean> productInfoList=new ArrayList<>();
    @Override
    protected int getChildlayout() {
        return R.layout.activity_productinfoshow;
    }

    @Override
    protected void initView() {
        title.setText("产品信息展示");
        //将扫描结果赋值到界面上
        productRecycler.setLayoutManager(new GridLayoutManager(this,4));
        productInfoList.add(new ProductInfoBean("张亚龙"));
        productInfoList.add(new ProductInfoBean("张亚龙"));
        productInfoList.add(new ProductInfoBean("张亚龙"));
        productInfoList.add(new ProductInfoBean("张亚龙"));
        productInfoList.add(new ProductInfoBean("张亚龙"));
        productInfoList.add(new ProductInfoBean("张亚龙"));
        productInfoList.add(new ProductInfoBean("张亚龙"));
        ProductInfoShowAdapter adapter=new ProductInfoShowAdapter(productInfoList,this);
        productRecycler.setAdapter(adapter);
        titleBackImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Constants.isProductInfoShow=false;
    }
}
