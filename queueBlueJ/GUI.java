import javax.swing.*;
import javax.swing.table.*;
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
    private JScrollPane scroll;
    private JTable table;
    
    private GUIManager manager;
    
    //ArrayList containing all Strings that represent elements
    private ArrayList<String> elements;
    
    //Queue object to read and create data structure
    private Queue queue;
    
    /**
     * constructor: Creates and positions GUI Components, adds them to the Frame, adds ClickEvents for buttons
     */
    public GUI(GUIManager pManager)
    {
        manager = pManager;
        
        queue = pManager.getQueue();
        elements = new ArrayList<String>();
        
        //New Window (Frame) created, window title "Warteschlange"
        frame = new JFrame("Warteschlange");
        
        //Heading Text "Warteschlange"
        heading = new JLabel("Warteschlange - " + manager.getName());
        heading.setBounds(30,40,300,40);
        heading.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(heading);
        
        TableModel dataModel = new AbstractTableModel() {
            public String getColumnName(int col) {
                switch(col){
                    case 0:
                        return "Nr.";
                    case 1:
                        return "Name";
                    default:
                        return "UI-Fehler";
                }
            }
            public int getColumnCount() { return 2; }
            public int getRowCount() { return elements.size();}
            public Object getValueAt(int row, int col) {
                switch(col){
                    case 0:
                        return new Integer(row + 1);
                    case 1:
                        return new String(elements.get(row));
                    default:
                        return new String("UI-Fehler");
                }
            }
        };
        table = new JTable(dataModel);
        table.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
        TableColumn columnNr = table.getColumn("Nr.");
        columnNr.setMinWidth(50);
        columnNr.setMaxWidth(50);
        TableColumn columnName = table.getColumn("Name");
        columnName.setMinWidth(250);
        columnName.setMaxWidth(250);
        
        scroll = new JScrollPane(table);
        scroll.setBounds(30, 100, 300, 200);
        frame.add(scroll);

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
        addButton.setBounds(345,310,95,30);
        //Click event
        addButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                doAdd();
            }
        });
        frame.add(addButton);
        
        //A TextField (here the User can enter text) is created
        nameText = new JTextField();
        nameText.setBounds(30,310,300,30);
        //KeyListerner: reacts on typing enter
        nameText.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent k){
                if(k.getKeyCode() == KeyEvent.VK_ENTER){
                    doAdd();
                }
            }
        });
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
     * Adds new Element to Queue and updates UI
     */
    private void doAdd(){
        manager.create(nameText.getText());
        nameText.setText("");
        update();
        scrollToBottom();
    }
    
    /**
     * Updates the Graphical User Interface in order to represent the changed Queue object
     */
    public void update(){
        //Removes all JLabels representing an element
        elements.clear();
        
        QueueElement element = queue.getHead();
        
        //Adds all elements graphically that can be found in the Queue object
        while(element != null){
            addElement(element);
            element = element.getNachfolger();
        }
        
        table.updateUI();
    }
    
    public void scrollToBottom(){
        scroll.validate();
        JScrollBar vertical = scroll.getVerticalScrollBar();
        vertical.setValue( vertical.getMaximum() );
    }
    
    public void scrollToTop(){
        scroll.validate();
        JScrollBar vertical = scroll.getVerticalScrollBar();
        vertical.setValue( 0 );
    }
    
    /**
     * Adds one QueueElement as Text
     */
    private void addElement(QueueElement pElement){
        if(pElement == null){
            return;
        }
        
        String text = "[Für deinen Datentyp wurde kein Text gefunden]";
        if(pElement.get() instanceof NameObject){
            NameObject no = (NameObject) pElement.get();
            text = no.getName();
        }
        
        elements.add(text);
    }

}
