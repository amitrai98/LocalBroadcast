package com.evontech.demo.testtest;


import android.app.Dialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.evontech.demo.testtest.databinding.FragmentBlankBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends DialogFragment {

    private Button send_broadcast = null;
    FragmentBlankBinding binding = null;
    public BlankFragmentModel blankFragmentModel = null;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false);
        binding.setViewModel(blankFragmentModel);
        return  binding.getRoot();
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            Display mDisplay = getActivity().getWindowManager().getDefaultDisplay();
            final int width  = mDisplay.getWidth();
            final int height = mDisplay.getHeight();


            dialog.getWindow().setLayout(width/2, height/2);
        }
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        blankFragmentModel = new BlankFragmentModel(getContext());
    }
}
