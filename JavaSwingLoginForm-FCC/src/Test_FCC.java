import java.awt.*;
import java.awt.event.*;

class AWTExample {
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public AWTExample(){
        prepareGUI();
    }

    public static void main(String[] args){
        AWTExample  awtExample = new AWTExample();  
        awtExample.showEventDemo();       
    }

    private void prepareGUI(){
        mainFrame = new Frame("FCC / JAVA Utilizare interfete grafice AWT - Sorin Baloiu");
        mainFrame.setSize(600,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              System.exit(0);
           }        
        });    
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        statusLabel = new Label();        
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350,100);

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);  
    }
    private void showEventDemo(){
        headerLabel.setText("Actiuni de control: Butoane"); 

        Button okButton = new Button("OK"); 
        Button trimiteButton = new Button("TRIMITE");
        Button primesteButton = new Button("PRIMESTE");

        okButton.setActionCommand("OK");
        trimiteButton.setActionCommand("TRIMITE");
        primesteButton.setActionCommand("PRIMESTE");

        okButton.addActionListener(new ButtonClickListener()); 
        trimiteButton.addActionListener(new ButtonClickListener()); 
        primesteButton.addActionListener(new ButtonClickListener()); 

        controlPanel.add(okButton);
        controlPanel.add(trimiteButton);
        controlPanel.add(primesteButton);       

        mainFrame.setVisible(true);  
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();  
            if( command.equals( "OK" ))  {
                statusLabel.setText("S-a apasat butonul OK");
            }
            else if( command.equals( "TRIMITE" ) )  {
                statusLabel.setText("S-a apasat butonul TRIMITE"); 
            }
            else  {
                statusLabel.setText("S-a apasat butonul PRIMESTE");
            }  	
        }		
    }
}
