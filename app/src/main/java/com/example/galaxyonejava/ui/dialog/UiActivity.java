package com.example.galaxyonejava.ui.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.galaxyonejava.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class UiActivity extends AppCompatActivity {

    private ConstraintLayout layoutBottomSheet;
    private AppCompatButton btnShowPersistanceBottomSheet;
    private AppCompatButton btnShowDialogBottomSheet;
    private BottomSheetBehavior bottomSheetBehavior;
    private AppCompatButton btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        //findID
        layoutBottomSheet = findViewById(R.id.layoutBottomSheet);
        btnShowPersistanceBottomSheet = findViewById(R.id.btnShowPersistanceBottomSheet);
        btnShowDialogBottomSheet = findViewById(R.id.btnShowDialogBottomSheet);
        btnShowDialog = findViewById(R.id.btnShowDialog);
        bottomSheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);


        btnShowPersistanceBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });


        btnShowDialogBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialog = getLayoutInflater().inflate(R.layout.demo_persistant_bottom_sheet, null);
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(UiActivity.this);
                bottomSheetDialog.setContentView(dialog);
                bottomSheetDialog.show();

            }
        });

        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(UiActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.demo_dialog_bottom_sheet);
                Window window = dialog.getWindow();
                if (window == null) {
                    return;
                }
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                WindowManager.LayoutParams windowAttributes = window.getAttributes();
                windowAttributes.gravity = Gravity.CENTER;
                window.setAttributes(windowAttributes);
                dialog.show();
            }
        });
    }
}