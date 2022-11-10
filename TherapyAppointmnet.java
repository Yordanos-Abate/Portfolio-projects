//This application how patients of a psychologist make an appointment.
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class TherapyAppointmnet  extends JFrame implements ActionListener {
  
  private JLabel firstnameLabel, lastnameLabel, appdateLabel, apptimeLabel, 
                 appsessionLabel, apptypeLabel, insuranceinfoLabel, commentLabel, addressLabel, 
                 streetLabel, cityLabel, stateLabel, zipLabel, phoneLabel, cardLabel,
                 visaImageLabel,mastercardImageLabel, americanImageLabel, 
                 discoverImageLabel, cardnumberLabel, cardexpirationLabel, cvvLabel;
  private JTextField firstnameTextField, lastnameTextField, appdateTextField, streetTextField,
                     cityTextField, stateTextField, zipTextField, phoneTextField, cardnumberTextField, 
                     cardexpirationTextField, cvvTextField;
  private JPanel northPanel, northPanel2, westPanel, westPanel2, centerPanel, centerPanel2, 
                 eastPanel, eastPanel2, southPanel;
  private JComboBox apptimeBox, appsessionBox, apptypeBox, stateBox;
  private JCheckBox insuranceBox, medicationBox, therapyBox;
  private JRadioButton visaOption, mastercardOption, americanOption, discoverOption;
  private ButtonGroup cardGroup;
  private ImageIcon visaImageIcon, mastercardImageIcon, americanImageIcon, discoverImageIcon;
  private JTextArea commentBox;
  private JButton submitButton, cancelButton;
  
  public TherapyAppointmnet() {
    super("Therapy Appointmnet");
    
    firstnameLabel = new JLabel("First Name:");
    firstnameLabel.setForeground(Color.WHITE);
    firstnameTextField = new JTextField(12);
    lastnameLabel = new JLabel("Last Name:");
    lastnameLabel.setForeground(Color.WHITE);
    lastnameTextField = new JTextField(12);
    
    northPanel = new JPanel();
    northPanel.setBackground(Color.BLACK);
    northPanel.add(firstnameLabel);
    northPanel.add(firstnameTextField);
    northPanel.add(lastnameLabel);
    northPanel.add(lastnameTextField);
    northPanel2 = new JPanel();
    northPanel2.add(northPanel);
    add(northPanel2,BorderLayout.NORTH);
    
    appdateLabel = new JLabel("Appointment Date(mm/dd/yy) ");
    apptimeLabel = new JLabel("Appointment Time:");
    appdateTextField = new JTextField(12);
    String timelist [] = {"-Select Time-", "9:00 am", "10:00 am", "11:00 am",
                          "12:00 pm", "2:00 pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm"};
    //1:00-1:59pm is lunch time for the doctor
    appsessionLabel = new JLabel("Session Duration: ");
    String sessionlist [] = {"-Select-", "30 min", "45 min", "1 hour"};
    apptimeBox = new JComboBox(timelist);
    appsessionBox = new JComboBox(sessionlist);
    apptypeLabel = new JLabel ("Session Type");
    String typelist [] = {"-Select Type-", "Consultation", "On - going"};
    apptypeBox = new JComboBox(typelist);
    insuranceinfoLabel = new JLabel("Other");
    insuranceBox = new JCheckBox("Insurance");
    medicationBox = new JCheckBox("Medication");
    therapyBox = new JCheckBox("Prior therapy experience");
    commentLabel = new JLabel("\nAdditional Information: ");
    commentBox = new JTextArea(10,20);
    
    westPanel = new JPanel();
    westPanel.setLayout(new GridLayout(6,3,3,6));
    westPanel.add(appdateLabel);
    westPanel.add(apptimeLabel);
    westPanel.add(appdateTextField);
    westPanel.add(apptimeBox);
    westPanel.add(appsessionLabel);
    westPanel.add(insuranceinfoLabel);
    westPanel.add(appsessionBox);
    westPanel.add(insuranceBox);
    westPanel.add(apptypeLabel);
    westPanel.add(medicationBox);
    westPanel.add(apptypeBox);
    westPanel.add(therapyBox);
    
    westPanel2 = new JPanel();
    //westPanel2.setBackground(Color.BLUE);
    westPanel2.setLayout(new GridLayout(0,1));
    westPanel2.add(westPanel);
    westPanel2.add(commentLabel);
    westPanel2.add(commentBox);
    add(westPanel2,BorderLayout.WEST);
    
    addressLabel = new JLabel("Address");
    streetLabel = new JLabel("\nStreet:");
    streetTextField = new JTextField(15);
    cityLabel = new JLabel("City:");
    cityTextField = new JTextField(15); 
    stateLabel = new JLabel("State");
    String statelist [] = {"-Select-", "DC", "MD", "VA"};
    //doctor only accepts patients from the DMV Area
    stateBox = new JComboBox(statelist);
    zipLabel = new JLabel("ZIP:");
    zipTextField = new JTextField(15);
    phoneLabel = new JLabel("Phone:");
    phoneTextField = new JTextField(15);
    commentLabel = new JLabel("\nAdditional Information: ");
    commentBox = new JTextArea(10,20);
    
    centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(0,1));
    centerPanel.add(addressLabel);
    centerPanel.add(streetLabel);
    centerPanel.add(streetTextField);
    centerPanel.add(cityLabel);
    centerPanel.add(cityTextField);
    centerPanel.add(stateLabel);
    centerPanel.add(stateBox);
    centerPanel.add(zipLabel);
    centerPanel.add(zipTextField);
    centerPanel.add(phoneLabel);
    centerPanel.add(phoneTextField);
    centerPanel2 = new JPanel();
    centerPanel2.add(centerPanel);
    add(centerPanel2,BorderLayout.CENTER);
    
    cardLabel = new JLabel("Credit Card Information\n");
    visaOption = new JRadioButton("");
    mastercardOption = new JRadioButton("");
    americanOption = new JRadioButton("");
    discoverOption = new JRadioButton("");
    cardGroup = new ButtonGroup();
    cardGroup.add(visaOption);
    cardGroup.add(mastercardOption);
    cardGroup.add(americanOption);  
    cardGroup.add(discoverOption);
    visaImageIcon = new ImageIcon("visa.GIF");
    visaImageLabel = new JLabel(visaImageIcon);
    mastercardImageIcon = new ImageIcon("Mastercard.GIF");
    mastercardImageLabel = new JLabel(mastercardImageIcon);
    americanImageIcon = new ImageIcon("american12.GIF");
    americanImageLabel = new JLabel(americanImageIcon);
    discoverImageIcon = new ImageIcon("discover11.GIF");
    discoverImageLabel = new JLabel(discoverImageIcon);
    cardnumberLabel = new JLabel("\nCard Number:");
    cardnumberTextField = new JTextField(12);
    cardexpirationLabel = new JLabel("\nExpiration Year(mm/dd/yy):");
    cardexpirationTextField = new JTextField(12);
    
    eastPanel = new JPanel();
    eastPanel.setLayout(new GridLayout(0,1));
    eastPanel.add(cardLabel);
    eastPanel.add(visaOption);
    eastPanel.add(visaImageLabel);
    eastPanel.add(mastercardOption);
    eastPanel.add(mastercardImageLabel);
    eastPanel.add(americanOption);
    eastPanel.add(americanImageLabel);
    eastPanel.add(discoverOption);
    eastPanel.add(discoverImageLabel);
    eastPanel.add(cardnumberLabel);
    eastPanel.add(cardnumberTextField);
    eastPanel.add(cardexpirationLabel);
    eastPanel.add(cardexpirationTextField);
    eastPanel2 = new JPanel();
    eastPanel2.add(eastPanel);
    add(eastPanel2, BorderLayout.EAST);
    
    submitButton = new JButton("Submit");
    submitButton.setBackground(Color.GREEN);
    submitButton.addActionListener(this);
    cancelButton = new JButton("Cancel");
    cancelButton.setBackground(Color.RED);
    cancelButton.addActionListener(this);
    southPanel = new JPanel();
    southPanel.add(submitButton);
    southPanel.add(cancelButton);
    add(southPanel, BorderLayout.SOUTH);
    
    setSize(1000, 625);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  // the bottom part is incomplete.
  public void actionPerformed(ActionEvent event){
    if(event.getSource () == submitButton){
      String firstname = firstnameTextField.getText();
      String lastname = lastnameTextField.getText();
      String date = appdateTextField.getText();
      String street = streetTextField.getText();
      String city = cityTextField.getText();
      String zip = zipTextField.getText();
      String phone = phoneTextField.getText();
      String state = stateBox.getSelectedItem().toString();
      String time = apptimeBox.getSelectedItem().toString();
      String duration = appsessionBox.getSelectedItem().toString();
      
      
      String info = "Patient Name: " + firstname + " " + lastname +
                    "\nAddress: " + street + " " + city + " " + state + " " + zip +
                    "\nPhone: " + phone +
                    "\nAppointment Date and Time: " + date + " at " + time +
                    "\nDuration: " + duration;
      
      JOptionPane.showMessageDialog(null, info);
    }
  }
  
  
  public static void main(String [] args) {
    TherapyAppointmnet m = new TherapyAppointmnet ();
  }
}