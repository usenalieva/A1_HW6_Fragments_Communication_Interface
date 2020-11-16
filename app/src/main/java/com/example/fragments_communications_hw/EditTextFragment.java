package com.example.fragments_communications_hw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments_communications.R;


public class EditTextFragment extends Fragment {

    private EditText editText;
    private Button btnSend;


    public EditTextFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.edit_text_fragment, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        editText = view.findViewById(R.id.et_text);
        btnSend = view.findViewById(R.id.btn_send);

        btnSend.setOnClickListener(v -> {
            String msg = editText.getText().toString();
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.msgConductor(msg);
            editText.setText("");
        });
    }
}
