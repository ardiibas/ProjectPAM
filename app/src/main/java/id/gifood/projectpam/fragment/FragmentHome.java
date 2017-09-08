package id.gifood.projectpam.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.gifood.projectpam.R;

/**
 * Created by Ibas on 08/09/2017.
 */

public class FragmentHome extends Fragment{

    public static FragmentHome newInstance(){
        return new FragmentHome();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    public interface OnFragmentInteractionListener{

    }

}
