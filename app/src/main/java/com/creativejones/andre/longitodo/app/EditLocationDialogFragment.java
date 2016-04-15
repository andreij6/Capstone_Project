package com.creativejones.andre.longitodo.app;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.creativejones.andre.longitodo.R;

public class EditLocationDialogFragment extends DialogFragment {

    private EditLocationInteraction Listener;
    private String Name;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_edit_location, null);
        final TextView locationName = (TextView)view.findViewById(R.id.dialog_location_name);
        locationName.setText(Name);

        builder.setMessage(R.string.addlocation)
                .setView(view)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the positive button event back to the host activity
                        Name = locationName.getText().toString();

                        Listener.onPositiveClick(Name);
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the negative button event back to the host activity
                        Listener.onNegativeClick();
                    }
                });
        return builder.create();
    }

    public static EditLocationDialogFragment newInstance(EditLocationInteraction listener, String name) {
        EditLocationDialogFragment frag = new EditLocationDialogFragment();
        frag.Listener = listener;
        frag.Name = name;
        return frag;
    }

    public interface EditLocationInteraction {
        void onPositiveClick(String name);

        void onNegativeClick();
    }
}
