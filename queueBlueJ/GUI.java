import javax.swing.*;
import java.awt.Font;
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
    
    //ArrayList containing all JLabels (Texts) that represent elements
    private ArrayList<JLabel> elements;
    
    //Queue object to read and create data structure
    private Queue queue;
    
    /**
     * constructor: Creates and positions GUI Components, adds them to the Frame, adds ClickEvents for buttons
     */
    public GUI(GUIManager pManager)
    {
        queue = pManager.getQueue();
        elements = new ArrayList<JLabel>();
        
        //New Window (Frame) created, window title "Warteschlange"
        frame = new JFrame("Warteschlange");
        
        //Heading Text "Warteschlange"
        heading = new JLabel("Warteschlange - " + pManager.getName());
        heading.setBounds(30,40,300,40);
        heading.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(heading);
        
        //Button to dequeue the first element.
        removeButton = new JButton("Entfernen");
        removeButton.setBounds(345,45,95,30);
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
        
        //Button to enqueue a new Element.
        addButton = new JButton("Hinzufügen");
        //Click event
        addButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                //When the Button is clicked, an new QueueElement is created and added to the Queue with the name inputted in the TextField
                pManager.create(nameText.getText());
                //The Text Field is made empty again
                nameText.setText("");
                //After that, the GUI is updated
                update();
            }
        });
        frame.add(addButton);
        
        //A TextField (here the User can enter text) is created
        nameText = new JTextField();
        frame.add(nameText);
        
        //The  frames size is set
        frame.setSize(600, 400);
        
        //Layout is set to custom layout one (no default layout)
        frame.setLayout(null);
        
        update();
        
        //Window is made visible
        frame.setVisible(true);
    }
    
    /**
     * Updates the Graphical User Interface in order to represent the changed Queue object
     */
    public void update(){
        //Removes all JLabels representing an element
        for(int i = 0; i < elements.size(); i++){
            frame.remove(elements.get(i));
        }
        elements.clear();
        
        QueueElement element = queue.getHead();
        
        //Adds all elements graphically that can be found in the Queue object
        while(element != null){
            addElement(element);
            element = element.getNachfolger();
        }
        
        //Updates the position of the input field and the add button
        nameText.setBounds(30,100 + elements.size() * 35,300,30);
        addButton.setBounds(345,100 + elements.size() * 35,95,30);
    }
    
    /**
     * Adds one QueueElement as a JLabel to the JFrame
     */
    public void addElement(QueueElement pElement){
        if(pElement == null){
            return;
        }
        
        String text = "[Für deinen Datentyp wurde kein Text gefunden]";
        if(pElement.get() instanceof NameObject){
            NameObject no = (NameObject) pElement.get();
            text = no.getName();
        }
        
        JLabel elementLabel = new JLabel(text);
        elementLabel.setBounds(30,100 + elements.size() * 35,300,30);
        
        elements.add(elementLabel);
        frame.add(elementLabel);
    }

}
