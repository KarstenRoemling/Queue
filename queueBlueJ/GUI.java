import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class GUI
{
    private JFrame frame;
    private JLabel heading;
    private JButton removeButton;
    private JButton addButton;
    private JTextField nameText;
    
    private ArrayList<JLabel> kunden;
    private Queue queue;
    
    public GUI(Queue pQueue)
    {
        queue = pQueue;
        kunden = new ArrayList<JLabel>();
        
        frame = new JFrame("Warteschlange");
        
        heading = new JLabel("Warteschlange");
        heading.setBounds(30,40,200,40);
        frame.add(heading);
        
        removeButton = new JButton("Entfernen");
        removeButton.setBounds(245,45,95,30);  
        removeButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                queue.dequeue();
                update();
            }
        });
        frame.add(removeButton);
        
        addButton = new JButton("Hinzufügen");
        addButton.setBounds(245,100,95,30);  
        addButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                Kunde kunde = new Kunde(nameText.getText());
                nameText.setText("");
                queue.enqueue(kunde);
                update();
            }
        });
        frame.add(addButton);
        
        nameText = new JTextField();
        nameText.setBounds(30,100,200,30);
        frame.add(nameText);
        
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public void update(){
        for(int i = 0; i < kunden.size(); i++){
            frame.remove(kunden.get(i));
        }
        kunden.clear();

        Kunde kunde = queue.front();
        addKunde(kunde);
        
        while(kunde != null && kunde.getNachfolger() != null){
            kunde = kunde.getNachfolger();
            addKunde(kunde);
        }
        
        nameText.setBounds(30,100 + kunden.size() * 35,200,30);
        addButton.setBounds(245,100 + kunden.size() * 35,95,30);
    }
    
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
