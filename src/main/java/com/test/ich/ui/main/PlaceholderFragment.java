package com.test.ich.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.test.ich.AdapterGridShopProductCard;
import com.test.ich.DataGenerator;
import com.test.ich.R;
import com.test.ich.ShopProduct;
import com.test.ich.SpacingItemDecoration;
import com.test.ich.details.ShoppingProductAdvDetails;

import java.util.Collections;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    public RecyclerView recyclerView;
    View root;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main, container, false);
     //   final TextView textView = root.findViewById(R.id.section_label);
        recyclerView = (RecyclerView) root.findViewById(R.id.m_RecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(getActivity(), 8), true));
        recyclerView.setHasFixedSize(true);
        List<ShopProduct> items = DataGenerator.getShoppingProduct(getActivity());
        Collections.shuffle(items);
        //set data and list adapter
        AdapterGridShopProductCard mAdapter = new AdapterGridShopProductCard(getActivity(), items);
        recyclerView.setAdapter(mAdapter);
        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterGridShopProductCard.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ShopProduct obj, int position) {
                Toast toast = Toast.makeText(getActivity(), "one clike ", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(getActivity(), ShoppingProductAdvDetails.class);
                startActivity(intent);

            }
        });
        mAdapter.setOnMoreButtonClickListener(new AdapterGridShopProductCard.OnMoreButtonClickListener() {
            @Override
            public void onItemClick(View view, ShopProduct obj, MenuItem item) {
                Snackbar.make(root, obj.title + " (" + item.getTitle() + ") clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });
        return root;
    }

}