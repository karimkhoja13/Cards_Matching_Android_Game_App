package ca.gbc.mobile.karim.matchit_assignment1_karim;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageButton;

/***************************************************************************************************
 * KARIM KHOJA
 * 100874100
 * Created on October 12, 2014
 * Last Modified on October 24, 2014
 **************************************************************************************************/

public class CardView extends ImageButton {
    private Integer frontsrc;
    private Integer backsrc;
    private boolean flipped = false;
    public boolean matched = false;
    public boolean enabled = true;

    public CardView(Context context) {
        super(context);
    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getAttributes(context, attrs);
    }

    public CardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        getAttributes(context, attrs);
    }

    private void getAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.CardView, 0, 0
            );
        try {
            frontsrc = a.getResourceId(R.styleable.CardView_frontsrc, R.drawable.b2fv);
            backsrc = a.getResourceId(R.styleable.CardView_backsrc, R.drawable.b1fv);
            flipped = a.getBoolean(R.styleable.CardView_flipped, false);

            if (flipped)
                setImageResource(frontsrc);
            else
                setImageResource(backsrc);
        }
        finally { a.recycle();}
    }

    public void Click() {
        flipped=!flipped;
        if (flipped) {
            setImageResource(frontsrc);
        } else {
            setImageResource(backsrc);
        }
    }

    public void Update() {
        if(this.flipped == true){
            setImageResource(frontsrc);
        } else {
            setImageResource(backsrc);
        }
    }

    public int getFrontsrc() {
        return frontsrc;
    }

    public void takeOut()
    {
        this.matched = true;
    }

    public void setFrontsrc(int frontsrc)
    {
        this.frontsrc = frontsrc;
    }

    public int getBacksrc() {
        return backsrc;
    }

    public void setBacksrc(int backsrc) {
        this.backsrc = backsrc;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
        if (flipped) {
            setImageResource(frontsrc);
        } else {
            setImageResource(backsrc);
        }
    }

    public void switchFlipped() {
        this.flipped = !flipped;
        if (flipped) {
            setImageResource(frontsrc);
        } else {
            setImageResource(backsrc);
        }
    }
}
