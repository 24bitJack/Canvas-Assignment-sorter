
public class Assignment {
    //field
    private double difficulty;
    final String cClass;
    final String name;
    private String gendisc;
    private String URL;
    final int d_due;
    final int m_due;
    protected int d_todo;
    protected int m_todo;
    private boolean isDone;
    //constructors
    public Assignment (boolean Isdone, String Class, String name, int d_due,int m_due, String gendisc, String URL,int d_todo, int m_todo) {
        this.isDone = Isdone;
        this.name   = name;
        this.gendisc= gendisc;
        this.URL    = URL.replace("\\", "\\\\");
        this.d_due  = d_due;
        this.m_due  = m_due;
        this.d_todo = d_todo;
        this.m_todo = m_todo;
        this.cClass = Class;
    }
    
    public Assignment (boolean isDone, String Class, String name, int d_due,int m_due) {
        this.isDone = isDone;
        this.name   = name;
        this.d_due  = d_due;
        this.m_due  = m_due;
        this.cClass = Class;
    }
    //   


    public void set_toDo(int md, int dd) {
       if (m_todo == 0) {
            this.m_todo = md;
            this.d_todo = md;
       } else {
            System.out.println("this assignment already has a due date");
       }
    }
   
    public boolean isdone() {
        return this.isDone;
    }

    public void CompletedAssignment() {
        if (!this.isDone) {
            this.isDone = false;
        } else {
            System.out.println("This assignment is already completed");
        }
    }
   
    public String getName() {
        return this.name;
    }
 
    public String getGendisc() {
        return this.gendisc;
    }
    
    public double getMaxDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double diff) {
        this.difficulty = diff;
    }

    public String getClassSub() {
        return cClass;
    }

    public String getDueDate() {
        return (d_due + "/" + m_due);
    }
 
    public String getToDoDate() {
        return (d_todo + "/" + m_todo);
    }
    
    public String getURL() {
        return this.URL;
    }
    
    public void changeURL(String newURL) {
        this.URL = newURL;
    }
    
    public boolean addDisc(String disc) {
        if (this.gendisc.isEmpty()) {
            this.gendisc = disc;
            return true;
        }else {
           return false; 
        }
    }
    
    public boolean addURL(String newURL) {
        if (URL.isEmpty()) {
            this.URL = newURL;
            return true;
        }else {
            return false;
        }

    }
  
    public boolean addDateToDO(int d_todo,int m_todo) {
        if (d_todo == 0 && m_todo == 0) {
            this.d_todo = d_todo;
            this.m_todo = m_todo;
            return true; 
        } else {
            return false;
        }
    }
    
    public String toString() {
        String x = this.isDone + ";" + this.cClass + ";" + this.name;
        if (gendisc != null) {
            x += ";gendisc:" +this.gendisc ;
        } if (URL != null) {
            x+=  ";URL:" + this.URL;
        } x += ";d_due:" + this.d_due + ";m_due:" + this.m_due;
        if (this.m_todo != 0) {
            x +=  ";d_todo:" + this.d_todo + ";m_todo:" + this.m_todo;
        }
        return x;
    }
}