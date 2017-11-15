package jcp.com.exiyou.ui.shoppingmall.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.base.base.BaseActivity;
import jcp.com.exiyou.ui.shoppingmall.adapter.ShopSpecialListAdapter;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSpecialBean;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSpecialListBean;
import jcp.com.exiyou.ui.shoppingmall.contract.ShopContract;
import jcp.com.exiyou.ui.shoppingmall.model.ShopSpecialModel;
import jcp.com.exiyou.ui.shoppingmall.presenter.ShopSpecialPresenter;

public class ShopSpecialActivity extends BaseActivity <ShopSpecialPresenter,ShopSpecialModel> implements ShopContract.ShopSpecialView {

    private static final String TAG = ShopSpecialActivity.class.getSimpleName();

    @BindView(R2.id.shoppage_special_details_title1)
    TextView mTitle1;
    @BindView(R2.id.shoppage_special_details_title2)
    TextView mTitle2;

    @BindView(R2.id.shoppage_special_details_text1)
    TextView mText1;
    @BindView(R2.id.shoppage_special_details_text2)
    TextView mText2;
    @BindView(R2.id.shoppage_special_details_text3)
    TextView mText3;
    @BindView(R2.id.shoppage_special_details_text4)
    TextView mText4;
    @BindView(R2.id.shoppage_special_details_text5)
    TextView mText5;
    @BindView(R2.id.shoppage_special_details_text6)
    TextView mText6;
    @BindView(R2.id.shoppage_special_details_text7)
    TextView mText7;
    @BindView(R2.id.shoppage_special_details_text8)
    TextView mText8;

    @BindView(R2.id.shoppage_special_details_text9)
    TextView mText9;
    @BindView(R2.id.shoppage_special_details_text10)
    TextView mText10;
    @BindView(R2.id.shoppage_special_details_text11)
    TextView mText11;
    @BindView(R2.id.shoppage_special_details_text12)
    TextView mText12;
    @BindView(R2.id.shoppage_special_details_text13)
    TextView mText13;
    @BindView(R2.id.shoppage_special_details_text14)
    TextView mText14;
    @BindView(R2.id.shoppage_special_details_text15)
    TextView mText15;
    @BindView(R2.id.shoppage_special_details_text16)
    TextView mText16;

    @BindView(R2.id.shoppage_special_details_list1)
    ListView mListView1;
    @BindView(R2.id.shoppage_special_details_list2)
    ListView mListView2;

    @OnClick(R2.id.shoppage_special_details_back)
    public void back(){
        this.finish();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_special;
    }

    @Override
    public void initPresenter() {
        mPresenter.setMV(mModel, this);

    }

    @Override
    public void initView() {
            Intent intent = getIntent();
            String type1= intent.getStringExtra("areaType");
            //detail发送请求 请求数据
            mPresenter.getShopSpecialRes(type1);
    }

    ShopSpecialListBean data = new ShopSpecialListBean();
    @Override
    public void returnShopSpecialData(ShopSpecialListBean data) {
        this.data = data;
        if(data!=null) {
//            Toast.makeText(this, "返回成功,绑定数据", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "returnShopSpecialData: "+data.getData().toString());

            ShopSpecialBean shopSpecialBean = data.getData().get(0);
            mTitle1.setText(shopSpecialBean.getArea());
            mText1.setText(shopSpecialBean.getPoi().get(0));
            mText2.setText(shopSpecialBean.getPoi().get(1));
            mText3.setText(shopSpecialBean.getPoi().get(2));
            mText4.setText(shopSpecialBean.getPoi().get(3));
            mText5.setText(shopSpecialBean.getPoi().get(4));
            mText6.setText(shopSpecialBean.getPoi().get(5));
            mText7.setText(shopSpecialBean.getPoi().get(6));
            mText8.setText(shopSpecialBean.getPoi().get(7));

            final List<ShopSpecialBean.ShopSpecialList> list = data.getData().get(0).getList();
            mListView1.setAdapter(new ShopSpecialListAdapter(this,null, list,R.layout.shoppage_special_list_item));
            mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ShopSpecialActivity.this, ShopWebViewIdDetails.class);
                    intent.putExtra("id", list.get(position).getId());
                    intent.putExtra("type", "1");
                    ShopSpecialActivity.this.startActivity(intent);
                }
            });


            ShopSpecialBean shopSpecialBean1 = data.getData().get(1);
            mTitle2.setText(shopSpecialBean1.getArea());
            mText9.setText(shopSpecialBean1.getPoi().get(0));
            mText10.setText(shopSpecialBean1.getPoi().get(1));
            mText11.setText(shopSpecialBean1.getPoi().get(2));
            mText12.setText(shopSpecialBean1.getPoi().get(3));
            mText13.setText(shopSpecialBean1.getPoi().get(4));
            mText14.setText(shopSpecialBean1.getPoi().get(5));
            mText15.setText(shopSpecialBean1.getPoi().get(6));
            mText16.setText(shopSpecialBean1.getPoi().get(7));

            final List<ShopSpecialBean.ShopSpecialList> list1 = data.getData().get(1).getList();
            mListView2.setAdapter(new ShopSpecialListAdapter(this,null, list1,R.layout.shoppage_special_list_item));
            mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ShopSpecialActivity.this, ShopWebViewIdDetails.class);
                    intent.putExtra("id", list1.get(position).getId());
                    intent.putExtra("type", "1");
                    ShopSpecialActivity.this.startActivity(intent);
                }
            });
        }
    }

    @Override
    public void OnStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }

}
