package com.example.do_an_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.do_an_android.R;
import com.example.do_an_android.ultils.Server;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {
    Context context;
    int layout;
    ArrayList<String> listImage;

    public SliderAdapter(Context context, int layout, ArrayList<String> listImage) {
        this.context = context;
        this.layout = layout;
        this.listImage = listImage;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(layout, container, false);
        ImageView image = view.findViewById(R.id.slider_image);
        Picasso.get().load(Server.urlImage + listImage.get(position)).into(image);
        container.addView(view);
        return view;
    }


    @Override
    public int getCount() {
        return listImage.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
//PagerAdapter cung cấp các phương thức cần thiết để định nghĩa cách hiển thị các mục hoặc trang trong ViewPager, bao gồm:
//
//getCount(): Trả về số lượng mục hoặc trang có trong ViewPager.
//isViewFromObject(View view, Object object): Xác định xem một View có thuộc về một Object cụ thể không.
//instantiateItem(ViewGroup container, int position): Tạo và trả về một View đại diện cho mục hoặc trang ở vị trí cụ thể trong ViewPager.
//destroyItem(ViewGroup container, int position, Object object): Loại bỏ View tại vị trí cụ thể trong ViewPager.
//PagerAdapter được sử dụng bởi ViewPager để lấy các View tương ứng từ Adapter và hiển thị chúng cho người dùng
// khi vuốt qua các mục hoặc trang khác nhau. Nó cung cấp khả năng tùy chỉnh và quản lý dữ liệu hiển thị trong ViewPager
// một cách dễ dàng và linh hoạt.