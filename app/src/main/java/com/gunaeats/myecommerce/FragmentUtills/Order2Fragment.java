package com.gunaeats.myecommerce.FragmentUtills;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.gunaeats.myecommerce.R;

public class Order2Fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public static Order2Fragment newInstance(String param1) {
        Order2Fragment fragment = new Order2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order2, container, false);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addTab(tabLayout.newTab().setText("Confirmed"));
//        tabLayout.addTab(tabLayout.newTab().setText("Allotted"));
//        tabLayout.addTab(tabLayout.newTab().setText("Quotation"));
//        // tabLayout.addTab(tabLayout.newTab().setText("Pending"));
//        tabLayout.addTab(tabLayout.newTab().setText("Completed"));
//        tabLayout.addTab(tabLayout.newTab().setText("Canceled"));

        LinearLayout linearLayout = (LinearLayout)tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.GRAY);
        drawable.setSize(1, 1);
        linearLayout.setDividerPadding(10);
        linearLayout.setDividerDrawable(drawable);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        // mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        //mRecyclerView.setLayoutManager(mLayoutManager);
        viewPager.setAdapter(new PagerAdapter(getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }
    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;
        private String[] tabTitles = new String[]{"All","Confirmed"};

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        // overriding getPageTitle()
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }


        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new OrderHistoryFragment();
                case 1:
                    return new ONGoingOrderFragment();
//                case 2:
//                    return new OrderAllottedFragment();
//                case 3:
//                    return new OrderAwaitingFragment();
//                case 4:
//                    return new OrderCompletedFragment();
//                case 5:
//                    return new OrderCanceledFragment();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
}
