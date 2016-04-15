package com.creativejones.andre.longitodo.handlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.app.NewEditActivity;

public class MainViewHandler extends BaseHandler {

    MainViewInteraction Listener;

    public MainViewHandler(Context context, MainViewInteraction listener) {
        super(context);
        Listener = listener;
    }

    public void onClickNew(View view){
        startActivity(new Intent(_Context, NewEditActivity.class));
    }

    public void onClickCompleted(View view){
        Button btn = (Button)view;
        String label = btn.getText().toString();

        if(label.equalsIgnoreCase(_Context.getString(R.string.completed))) {
            Listener.showCompleted();

            setText(btn, R.string.pending);

        } else {
            Listener.showPending();

            setText(btn, R.string.completed);
        }
    }

    private void setText(Button button, int stringResource){
        button.setText(_Context.getString(stringResource));
    }

    public interface MainViewInteraction {
        void showCompleted();

        void showPending();
    }
}
