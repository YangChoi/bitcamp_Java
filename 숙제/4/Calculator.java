import java.awt.*;

class Calculator extends Frame {
    private Label dispL, inputL;
    private Button[] button = new Button[16];
    private String[] str = new String[]{"7","8","9","/","4","5","6","*","1","2","3","-",".","0","=","+"};
    private Button button1, button2;

    public Calculator(){
        super("미니계산기");

        //Label 설정
        dispL = new Label();
        dispL.setBackground(new Color(223, 225, 229));
        dispL.setBounds(10, 40, 330, 60);
        add(dispL);

        inputL = new Label();
        inputL.setBackground(new Color(223, 225, 229));            
        inputL.setBounds(10, 108, 330, 60); 
        add(inputL);

        //pannel 설정
        Panel pn1 = new Panel();
        pn1.setBounds(15, 175, 320, 50);
        pn1.setLayout(new GridLayout(1,2,5,0));

        Panel pn2 = new Panel();
        pn2.setBounds(15, 230, 320, 205);
        pn2.setLayout(new GridLayout(4,4,5,5));

        //button 설정 
        add(pn1);
        button1 = new Button("←");
        button1.setBackground(new Color(241, 243, 244));
        button2 = new Button("C");
        button2.setBackground(new Color(241, 243, 244));
        pn1.add(button1);
        pn1.add(button2);

        add(pn2);
        for(int i = 0; i < 16; ++i){
            button[i] = new Button(str[i]);
            button[i].setBackground(new Color(241, 243, 244));
            pn2.add(button[i]);
        }

        //Frame 설정 
        setLayout(null);
        setBounds(900, 200, 350, 450); //x y w h 
        setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
    }
}
