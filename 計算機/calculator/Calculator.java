/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
/**
 * The model class of the calculator application.
 */
public class Calculator extends java.util.Observable{
    
    String data ="";
     double x,y,a,b =0,c;
     String z = "",r = "0";

    void appendDot(String da) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
    
    /**
    click number
    */
    
    public void appendDigit(int digit) {
        // TODO code application logic here
        data += String.valueOf(digit);
        getDisplay();
    }
    
    

    /**
     *click dot
     * @param da
     
     */
    
    public void appendDa(String da) {
        // TODO code application logic here
        data += da;
        getDisplay();
    }
    /**
     * any operation
     * @param operator 
     */
    public void performOperation(Operator operator) {
        // TODO code application logic here
        /**
         * CE
         */
        if(operator == operator.CLEAR_ENTRY)
        {
            data = "0";
            getDisplay();
            data ="";
        }
        if(operator == operator.CLEAR)
        {
            data = "0";
            b = 0;
            getDisplay();
            data ="";
        }
        /**
         * +-        
        */
        if(operator == operator.PLUS_MINUS)
            if(data == "")
            {
                
            }else
                if(Double.parseDouble(data)>0)
                {
                    data = "-"+ data;
                    getDisplay();
                    }else{
                    data = String.valueOf(Math.abs(Double.parseDouble(data)));
                       if(data.indexOf("0")==data.length()-2)
                       {
                           data = String.valueOf((int)Math.abs(Double.parseDouble(data)));
                           getDisplay();
                       }
                }
        /*
        plus
        */
        if(operator == operator.PLUS)
        {
            if(data.length()>0)
            {
                x =Double.parseDouble(data);
                data = "";
                z = "+";
            }else
            {
                x =b;
                b= 0;
                data ="";
                z=  "+";
            }
        }
    /*
        -
        */
        if(operator == operator.MINUS)
        {
            if(data.length()>0)
            {
                x = Double.parseDouble(data);
                data = "";
                z ="-";
            }else
                x = b;
                b = 0;
                data = "";
                z = "-";
        }
        /**
         * Times
         */
        if(operator == operator.TIMES)
        {
            if(data.length()>0)
            {
                x = Double.parseDouble(data);
                data = "";
                z = "*";
            }else
                x = b;
            b = 0;
            data = "";
            z = "*";
        }
        /**
         * click OVER
         */
        if(operator == operator.OVER)
        {
            if(data.length()>0)
            {
                x = Double.parseDouble(data);
                data = "";
                z = "/";
            }else
            {
                x = b;
                data = "";
                z = "/";
            }
        }
        /**
         * EQUAL
         */
        if(operator == operator.EQUAL)
        {
            if(z == "+")
            {
                y =Double.parseDouble(data);
                data =String.valueOf(x+y);
                if(data.indexOf(".0")==data.length()-2)
                {
                    data = String.valueOf((int)(x+y));
                    getDisplay();
                    b = Double.parseDouble(data);
                    data = "";
                }
                else
                {
                    getDisplay();
                    b = Double.parseDouble(data);
                    data = "";
                    
                }
            }
            if(z =="-")
            {
               y =Double.parseDouble(data);
                data =String.valueOf(x-y);
                if(data.indexOf(".0")==data.length()-2)
                {
                    data = String.valueOf((int)(x-y));
                    getDisplay();
                    b = Double.parseDouble(data);
                    data = "";
                }
                    else
                {
                    getDisplay();
                    b = Double.parseDouble(data);
                    data = "";
                }
        }
            if(z == "*")
            {
                y =Double.parseDouble(data);
                data =String.valueOf(x*y);
                if(data.indexOf(".0")==data.length()-2)
                {
                    data = String.valueOf((int)(x*y));
                    getDisplay();
                    b = Double.parseDouble(data);
                    data = "";
                }else
                {
                    getDisplay();
                    b = Double.parseDouble(data);
                    data = "";
                }
            }
            if(z =="/")
            {
               y =Double.parseDouble(data);
                data =String.valueOf(x/y);
                if(data.indexOf(".0")==data.length()-2)
                {
                    data = String.valueOf((int)(x/y));
                    getDisplay();
                    b = Double.parseDouble(data);
                    data = "";
                }
                    else
                {
                    getDisplay();
                    b = Double.parseDouble(data);
                    data = "";
                }
        }
    }
    
    /**
     *
     * @return
     */
    
    
        
    }
    public void sent(String sent){
        if(sent == "+") performOperation (Operator.PLUS);
        if(sent == "-") performOperation (Operator.MINUS);
        if(sent == "X") performOperation (Operator.TIMES);
        if(sent == "/") performOperation (Operator.OVER);
        if(sent == "C") performOperation (Operator.CLEAR);
        if(sent == "CE") performOperation (Operator.CLEAR_ENTRY);
        if(sent == "±") performOperation (Operator.PLUS_MINUS);
        if(sent == "=") performOperation (Operator.EQUAL);
        if(sent == "%") performOperation (Operator.PERCENT);
        
    }
   
    /**
     *
     * @return
     */
   public String getDisplay() {
        // TODO code application logic here
        setChanged();
        notifyObservers(data);
        return null;
   }}

    /**
     * @param args the command line arguments
     */
   