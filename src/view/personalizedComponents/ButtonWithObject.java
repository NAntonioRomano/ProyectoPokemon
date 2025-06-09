package view.personalizedComponents;

import javax.swing.JButton;


public class ButtonWithObject extends JButton {
    private Object obj;

    public ButtonWithObject(String text, Object obj) {
        super(text);
        this.obj = obj;
    }

    public Object getObject() {
        return obj;
    }

    public void setObject(Object obj){
        this.obj = obj;
    }
    
}
