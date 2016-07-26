import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;


/**
 * @author jwatts
 *
 */
public class main extends JFrame{
    
    // Variables declaration 
     private JCheckBox EnableAutoCorrect;
     private JTextField FileName; 
     private JButton submit; 
     private JButton browse; 
     private JPanel contentPane; 
     private JFileChooser fc;
    private JMenuBar MenuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    // End of variables declaration 
    
    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true); 
         JDialog.setDefaultLookAndFeelDecorated(true); 
         try 
         { 
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
         } 
         catch (Exception ex) 
         { 
             System.out.println("Failed loading Look and Feel: "); 
             System.out.println(ex); 
         } 
         new main(); 
    }
    public main() 
     { 
         super(); 
         initializeComponent(); 
         this.setVisible(true); 
     } 
  
     private void initializeComponent() 
     { 
         fc = new JFileChooser();
         EnableAutoCorrect = new JCheckBox();
         FileName = new JTextField(); 
         submit = new JButton(); 
         browse = new JButton(); 
         contentPane = (JPanel)this.getContentPane(); 
 
		 EnableAutoCorrect.setText("Auto Correct");
         submit.setText("Submit"); 
         submit.addActionListener(new ActionListener() { 
             public void actionPerformed(ActionEvent e) 
             { 
                 submit_actionPerformed(e); 
             } 
  
         }); 
 
         browse.setText("browse"); 
         browse.addActionListener(new ActionListener() { 
             public void actionPerformed(ActionEvent e) 
             { 
                 browse_actionPerformed(e); 
             } 
  
         }); 
         
         MenuBar = new JMenuBar();
        MenuBar.setOpaque(true);
        menu = new JMenu("Help");
        MenuBar.add(menu);
        menuItem = new JMenuItem("About");
        menuItem.setActionCommand("about");
        menuItem.addActionListener(new ActionListener() { 
             public void actionPerformed(ActionEvent e) 
             { 
                 about_actionPerformed(e); 
             } 
  
         }); 
        menu.add(menuItem);

         contentPane.setLayout(null); 
         EnableAutoCorrect.setBounds(118, 50, 100, 24);
         contentPane.add(EnableAutoCorrect);
         FileName.setBounds(16, 16, 256, 22);
         contentPane.add(FileName);
         submit.setBounds(16, 46, 84, 30);
         contentPane.add(submit);
         browse.setBounds(287, 14, 83, 28);
         contentPane.add(browse);

         
         this.setTitle("Super Awesomeness"); 
         this.setLocation(new Point(0, 0)); 
         this.setSize(new Dimension(390, 200)); 
         this.setJMenuBar(MenuBar);
     } 
  
  
     protected void about_actionPerformed(ActionEvent e) {
         JOptionPane.showMessageDialog(this, "Written by Jonathan Watts 2008\nVersion 3.3");
        
    }

     private void submit_actionPerformed(ActionEvent e) 
     { 
         try {
            doWork();
        } catch (FileNotFoundException e1) {
            JOptionPane.showMessageDialog(this, "File not found");
            e1.printStackTrace();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(this, "Error reading file");
            e1.printStackTrace();
        }
  
     } 
  
     private void browse_actionPerformed(ActionEvent e) 
     { 
         int returnVal=fc.showOpenDialog(main.this);
        if(returnVal==JFileChooser.APPROVE_OPTION){
            FileName.setText(fc.getCurrentDirectory()+"\\"+fc.getName(fc.getSelectedFile()));
        }
		
		JOptionPane.showMessageDialog(frame, FileName);
  
     } 
    
    public void doWork() throws IOException, FileNotFoundException{
        // Read in file name and open file
        BufferedReader fin = new BufferedReader(new FileReader(FileName.getText()));
        
        //Decide to use AutoCorrect or not
        boolean autoCorrect = EnableAutoCorrect.isSelected();
        
        //Get header row and print to output files
        String firstRow =fin.readLine();
        BufferedWriter fbad = new BufferedWriter(new FileWriter("Bad.txt"));
        BufferedWriter fgood = new BufferedWriter(new FileWriter("Good.txt"));
        fbad.write(firstRow);
        fbad.newLine();
        fgood.write(firstRow);
        fgood.newLine();
        
        //Parse header row to get number of parameters and order
        List<String> headerRow = Arrays.asList(firstRow.split("\t"));
        List<String> ordering = new ArrayList<String>();
        CustomerInformation ci = new CustomerInformation();
        for(String field : headerRow){
            if(ci.isHeaderFieldValid(field)){
                ordering.add(field);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Header " + field + "\n");
                return;
            }
        }
        
        //Process the file
        String dataRow;
        List<String> dataElements;
        while((dataRow=fin.readLine())!=null){
            String errors= new String();
            dataElements = Arrays.asList(dataRow.split("\t",-1));
            
            //test to see if there are the correct number of elements
            if(dataElements.size() != ordering.size()){
                errors = errors.concat("\tData row contains incorrect number of elements");
                fbad.write(dataRow+errors);
                fbad.newLine();
                continue;
            }
            
            CustomerInformation customerInformation = new CustomerInformation(autoCorrect);
            customerInformation.setOrdering(ordering);
            customerInformation.loadDataRow(dataElements);
        
            //Verify the customer information and move the line to the correct output file
            errors = errors.concat(customerInformation.verifyData());
            
            if(errors.length() == 0){
                fgood.write(autoCorrect ? customerInformation.getData(): dataRow);
                fgood.newLine();
            } else{
                fbad.write(dataRow+errors);
                fbad.newLine();
            } 
        }
        fin.close();
        fbad.close();
        fgood.close();
        JOptionPane.showMessageDialog(this, "Processing done");
        
    }
}
