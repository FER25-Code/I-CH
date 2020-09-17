package com.test.ich;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    /**
     * Generate dummy data shopping product
     *
     * @param ctx android context
     * @return list of object
     */
    public static List<ShopProduct> getShoppingProduct(Context ctx) {
        List<ShopProduct> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.shop_product_image);
        String title_arr[] = ctx.getResources().getStringArray(R.array.shop_product_title);
        String price_arr[] = ctx.getResources().getStringArray(R.array.shop_product_price);
        for (int i = 0; i < drw_arr.length(); i++) {
            ShopProduct obj = new ShopProduct();
            obj.image = drw_arr.getResourceId(i, -1);
            obj.title = title_arr[i];
            obj.price = price_arr[i];
            obj.imageDrw = ctx.getResources().getDrawable(obj.image);
            items.add(obj);
        }
        return items;
    }
}
