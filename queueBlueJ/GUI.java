import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Graphical User Interface.
 * Frame with Text representing the Customers, allows User Interaction.
 */
public class GUI
{
    //Swing Components
    private JFrame frame;
    private JLabel heading;
    private JButton removeButton;
    private JButton addButton;
    private JTextField nameText;
    
    //ArrayList containing all JLabels (Texts) that represent customers
    private ArrayList<JLabel> kunden;
    
    //Queue object to read and create data structure
    private Queue queue;
    
    /**
     * constructor: Creates and positions GUI Components, adds them to the Frame, adds ClickEvents for buttons
     */
    public GUI(Queue pQueue)
    {
        queue = pQueue;
        kunden = new ArrayList<JLabel>();
        
        //New Window (Frame) created, window title "Warteschlange"
        frame = new JFrame("Warteschlange");
        
        //Heading Text "Warteschlange"
        heading = new JLabel("Warteschlange");
        heading.setBounds(30,40,200,40);
        frame.add(heading);
        
        //Button to dequeue the first customer.
        removeButton = new JButton("Entfernen");
        removeButton.setBounds(245,45,95,30);
        //Click event
        removeButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                //When Button is clicked, the Queue data structure dequeues the first element
                queue.dequeue();
                //After that, the GUI is updated
                update();
            }
        });
        frame.add(removeButton);
        
        //Button to enqueue a new Customer.
        addButton = new JButton("Hinzufügen");
        addButton.setBounds(245,100,95,30);
        //Click event
        addButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                //When the Button is clicked, an new Customer is created with the name inputted in the TextField
                Kunde kunde = new Kunde(nameText.getText());
                //The Text Field is made empty again
                nameText.setText("");
                //the created Customer object is added to the Queue data structure.
                queue.enqueue(kunde);
                //After that, the GUI is updated
                update();
            }
        });
        frame.add(addButton);
        
        //A TextField (here the User can enter text) is created
        nameText = new JTextField();
        nameText.setBounds(30,100,200,30);
        frame.add(nameText);
        
        //The  frames size is set
        frame.setSize(400, 400);
        
        //Layout is set to custom layout one (no default layout)
        frame.setLayout(null);
        
        //Window is made visible
        frame.setVisible(true);
    }
    
    /**
     * Updates the Graphical User Interface in order to represent the changed Queue object
     */
    public void update(){
        //Removes all JLabels representing a customer
        for(int i = 0; i < kunden.size(); i++){
            frame.remove(kunden.get(i));
        }
        kunden.clear();
        
        Kunde kunde = queue.front();
        addKunde(kunde);
        
        //Adds all customers graphically that can be found in the Queue object
        while(kunde != null && kunde.getNachfolger() != null){
            kunde = kunde.getNachfolger();
            addKunde(kunde);
        }
        
        //Updates the position of the input field and the add button
        nameText.setBounds(30,100 + kunden.size() * 35,200,30);
        addButton.setBounds(245,100 + kunden.size() * 35,95,30);
    }
    
    /**
     * Adds one Customer as a JLabel to the JFrame
     */
    public void addKunde(Kunde pKunde){
        if(pKunde == null){
            return;
        }
        
        JLabel kundeLabel = new JLabel(pKunde.getName());
        kundeLabel.setBounds(30,100 + kunden.size() * 35,200,30);
        
        kunden.add(kundeLabel);
        frame.add(kundeLabel);
    }

}
