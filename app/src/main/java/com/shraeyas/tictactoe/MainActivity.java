package com.shraeyas.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    int x=0;
    public void p_g(View view)
    {
        ImageView iv = (ImageView) view;

        if(x % 2 == 0)
        {
            iv.setImageResource(R.drawable.cir);
            x=1;
        }

        else
        {
            iv.setImageResource(R.drawable.cro);
            x=0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
