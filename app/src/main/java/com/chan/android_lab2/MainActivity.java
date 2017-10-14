package com.chan.android_lab2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String getNumber;
    String getPW;
    TextInputLayout NumberText,PWText;
    EditText NText, PText;
    RadioGroup RGroup;
    @IdRes int ChoiceRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] ChoseItems = {"拍摄","从相册选择"};
        final AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        alertdialog.setTitle("上传图片")
                .setItems(ChoseItems, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplication(),"您选择了["+ChoseItems[which]+"]",Toast.LENGTH_LONG).show();}
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplication(),R.string.cancel,Toast.LENGTH_LONG).show();}
                }).create();
        ImageView Img=(ImageView)findViewById(R.id.ImageView);
        Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertdialog.show();
            }
        });

        RGroup = (RadioGroup)findViewById(R.id.choices);
        RGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                ChoiceRes = checkedId;
                if(checkedId==R.id.choice1)
                {
                    Snackbar.make(group,R.string.choose1,Snackbar.LENGTH_LONG)
                            .setAction(R.string.yes, new View.OnClickListener(){
                                @Override
                                public void onClick(View view){
                                    Toast.makeText(getApplication(),"Snackerbar的确定按钮被点击了",Toast.LENGTH_LONG).show();
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                            .setDuration(5000)
                            .show();
                }
                else
                {
                    Snackbar.make(group,R.string.choose2,Snackbar.LENGTH_LONG)
                            .setAction(R.string.yes, new View.OnClickListener(){
                                @Override
                                public void onClick(View view){
                                    Toast.makeText(getApplication(),"Snackerbar的确定按钮被点击了",Toast.LENGTH_LONG).show();
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                            .setDuration(5000)
                            .show();
                }

            }
        });

        NumberText= (TextInputLayout) findViewById(R.id.StuIDinput);
        PWText= (TextInputLayout) findViewById(R.id.PWinput);
        NText = NumberText.getEditText();
        PText = PWText.getEditText();
        NText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()!=0)
                {
                    NumberText.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        PText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()!=0)
                {
                    PWText.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });


        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int click_msg;
                getNumber = NumberText.getEditText().getText().toString();
                getPW = PWText.getEditText().getText().toString();
                if (getNumber.equals("123456") && getPW.equals("6666")) {
                    click_msg = R.string.click_msg_right;
                }
                else {
                    click_msg = R.string.click_msg_wrong;
                }
                Snackbar.make(view,click_msg,Snackbar.LENGTH_LONG)
                        .setAction(R.string.yes, new View.OnClickListener(){
                            @Override
                            public void onClick(View view){
                                Toast.makeText(getApplication(),"Snackerbar的确定按钮被点击了",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .setDuration(5000)
                        .show();

                if(getNumber.length()==0)
                {
                    NumberText.setErrorEnabled(true);
                    NumberText.setError("学号不能为空");
                }
                if(getPW.length()==0)
                {
                    PWText.setErrorEnabled(true);
                    PWText.setError("密码不能为空");
                }

            }
        });
        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int click_msg1;
                ChoiceRes = RGroup.getCheckedRadioButtonId();
                if (ChoiceRes==R.id.choice1) {
                    click_msg1 = R.string.click_msg_reject_student;
                }
                else {
                    click_msg1 = R.string.click_msg_reject_teacher;
                }
                Snackbar.make(view,click_msg1,Snackbar.LENGTH_LONG)
                        .setAction(R.string.yes, new View.OnClickListener(){
                            @Override
                            public void onClick(View view){
                                Toast.makeText(getApplication(),"Snackerbar的确定按钮被点击了",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .setDuration(5000)
                        .show();
            }
        });
    }



}
