package com.shraeyas.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    int x=0;

    int state[] = {2,2,2,2,2,2,2,2,2};
    int win[][] = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public void restart(View view)
    {
        LinearLayout ll = (LinearLayout) findViewById(R.id.playagainlayout);
        ll.setVisibility(View.INVISIBLE);
        
        for(int i=0;i<9;i++)
            state[i]=2;
    }

    public void p_g(View view)
    {
        ImageView iv = (ImageView) view;

        String tag = iv.getTag().toString();
        int tg = Integer.parseInt(tag);

        if(x % 2 == 0 && state[tg] == 2)
        {
            iv.setImageResource(R.drawable.cir);
            state[tg]=x;
            x=1;
        }

        else if(x%2==1 && state[tg] == 2)
        {
            iv.setImageResource(R.drawable.cro);
            //iv.animate().rotation(3600).setDuration(250);

            state[tg]=x;
            x=0;
        }
        iv.animate().rotation(3600).setDuration(250);

        String str[] = {"Red ", "Yellow "};

        for(int [] winn : win)
        {
            if(state[winn[0]] == state[winn[1]] && state[winn[1]] == state[winn[2]] && state[winn[0]]!=2)
            {
                //Toast.makeText(MainActivity.this, str[state[winn[0]]] + "won!!!", Toast.LENGTH_SHORT).show();

                TextView winnermessage = (TextView) findViewById(R.id.winnermessage);
                winnermessage.setText(str[state[winn[0]]] + "won!!!");

                LinearLayout ll = (LinearLayout) findViewById(R.id.playagainlayout);
                ll.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Red Plays First", Toast.LENGTH_SHORT).show();


    }
}
