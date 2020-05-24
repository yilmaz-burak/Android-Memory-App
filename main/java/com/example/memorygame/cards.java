package com.example.memorygame;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatDrawableManager;

public class cards extends AppCompatButton {
    boolean isOpen = false;
    boolean turnable = true;
    int background;
    int frontImage;
    Drawable frontFace;
    Drawable backFace;

    public cards(Context context, int index, int gameMode) {
        super(context);
        setId(index);
        background = R.drawable.guitar;

        if(gameMode == 4){
            if(index%8==0)
                frontImage = R.drawable.b8;
            else if(index%8==1)
                frontImage = R.drawable.b1;
            else if(index%8==2)
                frontImage = R.drawable.b2;
            else if(index%8==3)
                frontImage = R.drawable.b3;
            else if(index%8==4)
                frontImage = R.drawable.b4;
            else if(index%8==5)
                frontImage = R.drawable.b5;
            else if(index%8==6)
                frontImage = R.drawable.b6;
            else
                frontImage = R.drawable.b7;
        }
        else if(gameMode == 6){
            if(index%12==0)
                frontImage = R.drawable.b18;
            else if(index%12==1)
                frontImage = R.drawable.b7;
            else if(index%12==2)
                frontImage = R.drawable.b8;
            else if(index%12==3)
                frontImage = R.drawable.b9;
            else if(index%12==4)
                frontImage = R.drawable.b10;
            else if(index%12==5)
                frontImage = R.drawable.b11;
            else if(index%12==6)
                frontImage = R.drawable.b12;
            else if(index%12==7)
                frontImage = R.drawable.b13;
            else if(index%12==8)
                frontImage = R.drawable.b14;
            else if(index%12==9)
                frontImage = R.drawable.b15;
            else if(index%12==10)
                frontImage = R.drawable.b16;
            else
                frontImage = R.drawable.b17;

        }

        else {
            if (index % 14 == 0)
                frontImage = R.drawable.b18;
            else if (index % 14 == 1)
                frontImage = R.drawable.b7;
            else if (index % 14 == 2)
                frontImage = R.drawable.b8;
            else if (index % 14 == 3)
                frontImage = R.drawable.b9;
            else if (index % 14 == 4)
                frontImage = R.drawable.b10;
            else if (index % 14 == 5)
                frontImage = R.drawable.b11;
            else if (index % 14 == 6)
                frontImage = R.drawable.b12;
            else if (index % 14 == 7)
                frontImage = R.drawable.b13;
            else if (index % 14 == 8)
                frontImage = R.drawable.b14;
            else if (index % 14 == 9)
                frontImage = R.drawable.b15;
            else if (index % 14 == 10)
                frontImage = R.drawable.b5;
            else if (index % 14 == 11)
                frontImage = R.drawable.b6;
            else if (index % 14 == 12)
                frontImage = R.drawable.b16;
            else
                frontImage = R.drawable.b17;
        }



        frontFace = AppCompatDrawableManager.get().getDrawable(context,frontImage);
        backFace = AppCompatDrawableManager.get().getDrawable(context,background);

        setBackground(backFace);

    }
    public void turn(){
        if(turnable){
            if(!isOpen ){
                this.setBackground(frontFace);
                isOpen = true;
            }
            else{
                this.setBackground(backFace);
                isOpen = false;
            }
        }
    }

}