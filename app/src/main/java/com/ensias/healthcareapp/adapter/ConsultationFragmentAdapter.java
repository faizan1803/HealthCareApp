package com.ensias.healthcareapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ensias.healthcareapp.ConsultationFragmentPage;
import com.ensias.healthcareapp.Hospitalisation;

public class ConsultationFragmentAdapter extends FragmentPagerAdapter {

    private int[] colors;


    public ConsultationFragmentAdapter(FragmentManager mgr) {
        super(mgr);
    }

    @Override
    public int getCount() {
        return(2); // 3 - Number of page to show
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return ConsultationFragmentPage.newInstance();
            case 1:
                return Hospitalisation.newInstance();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Consultation";
            case 1:
                return "Hospitalisation";
            default:
                return null;
        }
    }
}
