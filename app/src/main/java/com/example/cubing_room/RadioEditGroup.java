package com.example.cubing_room;

import java.util.ArrayList;
import java.util.List;

public class RadioEditGroup {
    private List<RadioEdit> radioEditItems = new ArrayList<>();

    public void addRadioEdit(RadioEdit radioEditItem){
        radioEditItems.add(radioEditItem);
        radioEditItem.getRadioButton().setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                for (RadioEdit radioEdit: radioEditItems){
                    if (radioEdit != radioEditItem){
                        radioEdit.setChecked(false);
                    }
                }
            }
        });
    }

    public RadioEdit getCheckedRadioEdit(){
        for (RadioEdit radioEdit: radioEditItems){
            if (radioEdit.isChecked()){
                return radioEdit;
            }
        }
        return null;
    }

    public void setChecked(int checkedRadioEditIndex){
        for (int i = 0; i < radioEditItems.size(); i++){
            radioEditItems.get(i).setChecked(i == checkedRadioEditIndex);
        }
    }

    public void clearChecks(){
        setChecked(0);
    }

    public void setText(String text, int radioEditIndex){
        radioEditItems.get(radioEditIndex).setText(text);
    }

    public String getText(int radioEditIndex){
        return radioEditItems.get(radioEditIndex).getText();
    }

    public Integer getGroupSize(){
        return radioEditItems.size();
    }
}
