package com.example.cubing_room;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
public class RadioEdit extends LinearLayout {
    private RadioButton radioButton;
    private EditText editText;

    public RadioEdit(Context context){
        super(context);
        init(context);
    }

    public RadioEdit(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init(context);
    }

    public RadioEdit(Context context, AttributeSet attributeSet, int defStyleAttr){
        super(context, attributeSet, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        setOrientation(HORIZONTAL);
        setWeightSum(10);
        LayoutInflater.from(context).inflate(R.layout.radio_edit, this, true);

        radioButton = findViewById(R.id.radio_button);
        editText = findViewById(R.id.edit_text);

        editText.setOnClickListener(v -> radioButton.setChecked(true));
        editText.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                radioButton.setChecked(true);
            }
        });
    }

    public RadioButton getRadioButton(){
        return radioButton;
    }

    public EditText getEditText(){
        return editText;
    }

    public void setHint(String hint){
        editText.setHint(hint);
    }

    public String getText(){
        return editText.getText().toString();
    }

    public void setText(String text){
        editText.setText(text);
    }

    public boolean isChecked(){
        return radioButton.isChecked();
    }

    public void setChecked(boolean checked){
        radioButton.setChecked(checked);
    }
}
