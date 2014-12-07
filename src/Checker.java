
import static java.lang.System.out;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Checker {
    DataBaseConnector db=new DataBaseConnector();
     
    int value=0;
    boolean[] status=new boolean[9];
   
    String player1,player2;
   
    URL[] image={getClass().getResource("images/f2.png"),getClass().getResource("images/f1.png")};
    
    board b;
    ArrayList<unit> row=new ArrayList<unit>();          //unit is a class which acts an int array of 4 
    ArrayList<unit> instance=new ArrayList<unit>();
    int[] p0=new int[8];        // to keep track of player 0's winning chances
    int[]p1=new int[8];
    boolean comMode;
    boolean machine; //if false, computer is the 1st player
    int i=0;
    String[] btns={"btn00","btn01","btn12","btn10","btn11","btn12","btn20","btn21","btn22"};
    
    void launch(Boolean ComMode,board b ){
   
    row.add(new unit(0,3,6,-1));  // if the 0 box is marked, 0th,3rd and 6th winning chances are affected.
    row.add(new unit(0,4,-1,-1));// so, to keep the list of the relavant chances to be updated when a box is selected,
    row.add(new unit(0,5,7,-1));    // this row array is used.
    row.add(new unit(1,3,-1,-1));
    row.add(new unit(1,4,6,7));
    row.add(new unit(1,5,-1,-1));
    row.add(new unit(2,3,7,-1));
    row.add(new unit(2,4,-1,-1));
    row.add(new unit(2,5,6,-1));
    
   db.connect();
   
    
    instance.add(new unit(0,1,2,-1));   //these are the winning chances.
    instance.add(new unit(3,4,5,-1));   //for example, if  some player marks0,1,2 boxes , that player wins
    instance.add(new unit(6,7,8,-1));
    instance.add(new unit(0,3,6,-1));
    instance.add(new unit(1,4,7,-1));
    instance.add(new unit(2,5,8,-1));
    instance.add(new unit(0,4,8,-1));
    instance.add(new unit(2,4,6,-1));
           
        
   
    this.comMode=ComMode;
   
   this.b=b;
    
    
    }
    
           
           
          
         
void check(int box,int p)  //p is always 0 or 1
{   int i=0,a; 
    // final JPanel panel = new JPanel();
    
    if(p==0)
       {
          a=row.get(box).rr(i);
          while(a!=-1)
              {
                  p0[a]++;
                 
                  if(p0[a]>=3)
                  {
                     if(!comMode)
                     JOptionPane.showMessageDialog(b,player1+"  won!!!!", "Congrats!!! :)", JOptionPane.INFORMATION_MESSAGE);
                     else
                      JOptionPane.showMessageDialog(b,player1+"  won!!!!", "Sorry,but next time hopefully :)", JOptionPane.INFORMATION_MESSAGE);   
                     if(!comMode)
                     {
                        if(!db.search(player1))
                                db.update(player1, 10);

                        else
                        {
                            int score=db.getScore(player1);
                            db.update(player1, score+10);
                        }
                     }
       b.dispose();
       PlayerSelection p2=new PlayerSelection();
       p2.setVisible(true);
       p2.setLocationRelativeTo(null);
       

                  } 
                 else
                 {
                  i++;
                   a=row.get(box).rr(i);
                   continue;
                 }
                 break;
              }

       }
   else if(p==1)
   {
       
       i=0;
        a=row.get(box).rr(i);
      while(a!=-1)
          {
              p1[a]++;
              
              if(p1[a]>=3)
              {
                  
                  JOptionPane.showMessageDialog(null,player2+"  won!!!!", "Congrats!!!", JOptionPane.INFORMATION_MESSAGE);
                  
                            if(!db.search(player2))
                                db.update(player2, 10);

                        else
                        {
                            int score=db.getScore(player2);
                            db.update(player2, score+10);
                        }
                  
                b.setVisible(false);
       PlayerSelection p2=new PlayerSelection();
       p2.setVisible(true);
       p2.setLocationRelativeTo(null);
                  
              }  
               else
                 {
                  i++;
                   a=row.get(box).rr(i);
                   continue;
                 }
                 break;
          }
       
   }
 if(value==8)
    {
        JOptionPane.showMessageDialog(null," The game tied.", "", JOptionPane.INFORMATION_MESSAGE);
         b.setVisible(false);
       PlayerSelection p2=new PlayerSelection();
       p2.setVisible(true);
       p2.setLocationRelativeTo(null);
    } 
  
}

    void setnames(String player1name, String player2name) {
        this.player1=player1name;
        this.player2=player2name;
       
    }
    
    void mark(int box,JButton btn,Boolean temp)
    {
        
        
            int t=0;
            if(!status[box]){
               
               
              btn.setIcon(new ImageIcon(image[value%2]));
              this.check(box,value%2);
              value++;
              status[box]=Boolean.TRUE;
           //btn01.setIcon(new javax.swing.ImageIcon(image[value%2]));
           }
                          //to prevent machine executing continuously
            if(temp && comMode)
            {
                Boolean state=Boolean.FALSE;
                int j;
                i=0;
                
                for(int k=0;k<8;k++)        //instances
                {
                    if(p0[k]==2)            //winning chance
                    {
                       
                        for(i=0;i<3;i++)
                        {
                            j=instance.get(k).rr(i);
                            
                            
                            if(j!=-1 && status[j]==Boolean.FALSE)
                                {b.mark(j);
                                state=Boolean.TRUE;
                                }
                        }       
                    
                    }
                }
                 
                for(i=0;i<4 && !state;i++)        //there are atmost 4 instances associated with any box
                    {                                   //to block
                        t=row.get(box).rr(i);
                        if(t!=-1 && p1[t]==2)
                        {
                            for(int a=0;a<3;a++)
                            {
                                 j=instance.get(t).rr(a);
                                if(j!=-1 && status[j]==Boolean.FALSE)
                                {b.mark(j);
                                state=Boolean.TRUE;
                                }    
                                    
                            }
                            
                        }
                    }
                 
                 
                 if(!state)
                 {
                     if(status[8]==Boolean.FALSE)
                     {b.mark(8);
                      state=Boolean.TRUE;
                     }
                }
                 
                 if(!state)
                 {
                      if(status[7]==Boolean.TRUE&& status[5]==Boolean.TRUE&& status[4]==Boolean.FALSE)
                     {b.mark(4);
                      state=Boolean.TRUE;
                     }                          
                 }
                  if(!state)
                 {
                     if(status[2]==Boolean.FALSE)
                     {b.mark(2);
                      state=Boolean.TRUE;
                     }
                }
                   if(!state)
                 {
                     if(status[4]==Boolean.FALSE)
                     {b.mark(0);
                      state=Boolean.TRUE;
                     }
                }
                   if(!state)
                   {
                       for(int a=0;a<8;a++)
                           if(status[a]==Boolean.FALSE)
                           {
                               b.mark(a);
                               state=Boolean.TRUE;
                           }
                   
                   }
            
            }
    

    }       
}

class unit
{
    int[] u=new int[4];
   unit(int a,int b,int c,int d)
    {
        u[0]=a;
        u[1]=b;
        u[2]=c;
        u[3]=d;
        
        //return u;
    }
   int rr(int i)
   {
      if(i==0) return u[0];
      else if(i==1) return u[1];
      else if(i==2) return u[2];
      else if(i==3) return u[3];
      else return -1;
      
      
   }
   int search(int i)
   {
       int a;
       for(a=0;u[a]!=-1;a++)
           if(u[a]==i)
               return a;
       return -1;
   }
  
}

    
