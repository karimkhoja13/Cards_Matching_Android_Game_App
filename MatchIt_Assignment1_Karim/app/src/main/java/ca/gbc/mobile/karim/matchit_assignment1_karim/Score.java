package ca.gbc.mobile.karim.matchit_assignment1_karim;

/***************************************************************************************************
 * KARIM KHOJA
 * 100874100
 * Created on October 12, 2014
 * Last Modified on October 24, 2014
 **************************************************************************************************/

public class Score {
    private long id;
    private String name;
    private String time;

    public Score()
    {}

    public Score(long id, String pName, String time)
    {
        this.id = id;
        this.name = pName;
        this.time = time;
    }

    public Score(String pName, String time)
    {
        this.name = pName;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString(){
        return (name + "  " + time);
    }
}