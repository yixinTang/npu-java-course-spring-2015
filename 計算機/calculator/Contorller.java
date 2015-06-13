/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author USER
 */
public class Contorller {
   View mv;
   Calculator mca;
    private String dot;
   

public Contorller (Calculator Model){
    mca = Model;
}
/*
傳數字
*/
public void setData (String dsata){
    mca.appendDigit(Integer.parseInt(dsata));
    
}
/*
傳小數
*/
public void setDa (String da){
        mca.appendDot(da);
    
}
/*
傳運算符號
*/
public void sent (String sent){
    mca.sent(sent);
}
/*
add View sent contorller
*/
public void newView(View vv){
    mv = vv;
    mca.getDisplay();
}

}

