package ca.gbc.mobile.karim.matchit_assignment1_karim;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/***************************************************************************************************
 * KARIM KHOJA
 * 100874100
 * Created on October 12, 2014
 * Last Modified on October 24, 2014
 **************************************************************************************************/

public class Timer extends TextView {

    private int time;

    public Timer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
        setText(Integer.toString(time));
    }

    private int MM;
    private int SS;
    private int mm;

//    public Timer(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }

    public int getMM() {
        return MM;
    }
    public int getSS() {
        return SS;
    }
    public int getmm() {
        return mm;
    }

    public void setTime(int MM, int SS, int mm) {
        this.MM = MM;
        this.SS = SS;
        this.mm = mm;
        setText(Integer.toString(MM) + " : " + Integer.toString(SS) + " : " + Integer.toString(mm));
    }
}