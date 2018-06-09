package view.logIn;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import view.main.MainMenu;
import view.zMessages.ErrorMessage;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class LogIn extends JFrame {
	private static final long serialVersionUID = 1L;
	//Attributes
	private JPanel contentPane;
	private JLabel infoLbl;
	
    //Show the error message and block this frame until the message is closed
  	private void errorMessage(String text) {
  		ErrorMessage msg = new ErrorMessage(this, text);
  		msg.setAlwaysOnTop(true);
  		msg.setVisible(true);
  		setEnabled(false);
  	}
	
  	//Create the Frame
	public LogIn() {
		setBackground(new Color(216, 216, 216));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 90);
		setResizable(false);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(69, 69, 69));
		setContentPane(contentPane);
    	
    	//Labels
    	infoLbl = new javax.swing.JLabel();
    	infoLbl.setForeground(new Color(252, 252, 252));
    	infoLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	infoLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    	infoLbl.setText("Introduce la Contraseña");
    	infoLbl.setFocusable(false);
        
        //Password field + Key pressed "Enter" listener 
    	JPasswordField passwordField = new JPasswordField();
    	passwordField.setHorizontalAlignment(SwingConstants.CENTER);
    	passwordField.setForeground(new Color(252, 252, 252));
    	passwordField.setCaretColor(new Color(255, 255, 204));
        passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        passwordField.setBackground(new java.awt.Color(36, 36, 36));
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
            	int KeyCode = evt.getKeyCode();
                if (KeyCode == KeyEvent.VK_ENTER) {
                	CheckPassController pc = new CheckPassController();
					try {
						if (pc.checkLogIn(String.valueOf(passwordField.getPassword()))) {
							MainMenu m = new MainMenu();
							m.setVisible(true);
						    dispose();
						} else {
						    errorMessage("LOGIN ERROR: Contraseña Incorrecta");
						    passwordField.setText(null);
						}
					} catch (UnsupportedEncodingException e) {}
                }
            }
        });
        
        //Elements Distribution
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(infoLbl, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
					.addGap(6))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(infoLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
