package jcp.com.exiyou.ui.shoppingmall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jcp.com.exiyou.R;
import jcp.com.exiyou.R2;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchSecondBean;
import jcp.com.exiyou.ui.shoppingmall.bean.ShopSearchSecondListBean;


public class ShopSearchSecondHeaderFragment extends Fragment {

    private static final String TAG = ShopSearchSecondHeaderFragment.class.getSimpleName();
    @BindView(R2.id.shoppage_search_second_header_image5)
    ImageView mImage5;
    @BindView(R2.id.shoppage_search_second_header_image4)
    ImageView mImage4;
    @BindView(R2.id.shoppage_search_second_header_image3)
    ImageView mImage3;
    @BindView(R2.id.shoppage_search_second_header_image2)
    ImageView mImage2;
    @BindView(R2.id.shoppage_search_second_header_image1)
    ImageView mImage1;
    @BindView(R2.id.shoppage_search_second_header_image0)
    ImageView mImage0;
    @BindView(R2.id.shoppage_search_second_header_1_image)
    ImageView headerImage1;
    @BindView(R2.id.shoppage_search_second_header_2_image)
    ImageView headerImage2;
    @BindView(R2.id.shoppage_search_second_header_3_image)
    ImageView headerImage3;
    @BindView(R2.id.shoppage_search_second_header_4_image)
    ImageView headerImage4;
    @BindView(R2.id.shoppage_search_second_header_5_image)
    ImageView headerImage5;


    @BindView(R2.id.shoppage_search_second_header_1_title)
    TextView headerText1;
    @BindView(R2.id.shoppage_search_second_header_2_title)
    TextView headerText2;
    @BindView(R2.id.shoppage_search_second_header_3_title)
    TextView headerText3;
    @BindView(R2.id.shoppage_search_second_header_4_title)
    TextView headerText4;
    @BindView(R2.id.shoppage_search_second_header_5_title)
    TextView headerText5;
    @BindView(R2.id.shoppage_search_second_header_text5)
    TextView mText5;
    @BindView(R2.id.shoppage_search_second_header_text4)
    TextView mText4;
    @BindView(R2.id.shoppage_search_second_header_text3)
    TextView mText3;
    @BindView(R2.id.shoppage_search_second_header_text2)
    TextView mText2;
    @BindView(R2.id.shoppage_search_second_header_text1)
    TextView mText1;
    @BindView(R2.id.shoppage_search_second_header_text0)
    TextView mText0;
    @BindView(R2.id.shoppage_search_second_header1_5)
    LinearLayout mLinearLayout1_5;
    @BindView(R2.id.shoppage_search_second_header6_11)
    LinearLayout mLinearLayout6_11;

    private List<View> headerView1_5;
    private List<View> headerView6_11;

    private ShopSearchSecondListBean data;

    public void setData(ShopSearchSecondListBean data) {
        this.data = data;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shoppage_search_second_headerrecycler, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public void initView() {

        List<ShopSearchSecondBean.ShopSearchSecondIconList> icon_list = data.getData().getIcon_list();
        Picasso.with(getActivity()).load(icon_list.get(0).getIcon_pic()).into(headerImage1);
        Picasso.with(getActivity()).load(icon_list.get(1).getIcon_pic()).into(headerImage2);
        Picasso.with(getActivity()).load(icon_list.get(2).getIcon_pic()).into(headerImage3);
        Picasso.with(getActivity()).load(icon_list.get(3).getIcon_pic()).into(headerImage4);
        Picasso.with(getActivity()).load(icon_list.get(4).getIcon_pic()).into(headerImage5);
        headerText1.setText(icon_list.get(0).getIcon());
        headerText2.setText(icon_list.get(1).getIcon());
        headerText3.setText(icon_list.get(2).getIcon());
        headerText4.setText(icon_list.get(3).getIcon());
        headerText5.setText(icon_list.get(4).getIcon());


        List<ShopSearchSecondBean.ShopSearchSecondSubIconList> sub_icon_list = data.getData().getSub_icon_list();
        Picasso.with(getActivity()).load(sub_icon_list.get(0).getIcon_pic()).into(mImage0);
        Picasso.with(getActivity()).load(sub_icon_list.get(1).getIcon_pic()).into(mImage1);
        Picasso.with(getActivity()).load(sub_icon_list.get(2).getIcon_pic()).into(mImage2);
        Picasso.with(getActivity()).load(sub_icon_list.get(3).getIcon_pic()).into(mImage3);
        Picasso.with(getActivity()).load(sub_icon_list.get(4).getIcon_pic()).into(mImage4);
        Picasso.with(getActivity()).load(sub_icon_list.get(5).getIcon_pic()).into(mImage5);

        mText0.setText(sub_icon_list.get(0).getIcon());
        mText1.setText(sub_icon_list.get(1).getIcon());
        mText2.setText(sub_icon_list.get(2).getIcon());
        mText3.setText(sub_icon_list.get(3).getIcon());
        mText4.setText(sub_icon_list.get(4).getIcon());
        mText5.setText(sub_icon_list.get(5).getIcon());

    }

//    @Override
//    public void onClick(View v) {
//
//        Toast.makeText(getActivity(), "点击了", Toast.LENGTH_SHORT).show();
////        Intent intent = new Intent(context, ShopWebViewIdDetails.class);
//////            Intent intent2 = new Intent(context, ShopSearchSecondActicity.class);
//////            Intent intent3 = new Intent(context, ShopSpecialActivity.class);
////        Intent intent4 = new Intent(context, ShopSearchListActivity.class);
////
////        switch (v.getId()) {
////            case R.id.shoppage_search_second_header_1:
////            case R.id.shoppage_search_second_header_2:
////            case R.id.shoppage_search_second_header_3:
////            case R.id.shoppage_search_second_header_4:
////            case R.id.shoppage_search_second_header_5:
////                int size = headerView1_5.size();
////                for (int i = 0; i < size; i++) {
////                    if (headerView1_5.get(i) == v) {
////                        if (data.getData().getIcon_list().get(i).getLink_url().equals("")) {
////                            intent4.putExtra("stg_id", data.getData().getIcon_list().get(i).getStg_id());
////                            intent4.putExtra("title", data.getData().getIcon_list().get(i).getIcon());
////                            context.startActivity(intent4);
////                        } else {
////                            intent.putExtra("url", data.getData().getIcon_list().get(i).getLink_url());
////                            intent.putExtra("title", data.getData().getIcon_list().get(i).getIcon());
////                            intent.putExtra("type", "2");
////                            context.startActivity(intent);
////                        }
////                        break;
////                    }
////                }
////                break;
////
////        }
//    }
//    }
}
