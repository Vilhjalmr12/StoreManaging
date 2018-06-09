package view.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import view.main.MainMenu;
import view.zMessages.ErrorMessage;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

public class ClientView extends JDialog {
	//Attributes
	private static final long serialVersionUID = 1L;
	private CtrlClients cont = new CtrlClients();
	private String[] info;
	
	//Show the error message and block this frame until the message is closed
  	public void errorMessage(String text) {
  		ErrorMessage msg = new ErrorMessage(this, text);
  		msg.setAlwaysOnTop(true);
  		msg.setVisible(true);
  		setEnabled(false);
  	}

	//Create the Dialog
	public ClientView(MainMenu caller, String client) {
		getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		getContentPane().setBackground(new Color(69, 69, 69));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBackground(new Color(69, 69, 69));
		setBounds(100, 100, 480, 450);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		//Initial SetUp
		setAlwaysOnTop(true);
		JLabel clientLbl = new JLabel(" Cliente Número:");
		clientLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		clientLbl.setForeground(new Color(252, 252, 252));
		JSeparator sep1 = new JSeparator();
		JLabel nameLbl = new JLabel(" Nombre:");
		nameLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		nameLbl.setForeground(new Color(252, 252, 252));
		JLabel telfLbl = new JLabel(" Teléfono:");
		telfLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		telfLbl.setForeground(new Color(252, 252, 252));
		JLabel mailLbl = new JLabel(" Mail:");
		mailLbl.setForeground(new Color(252, 252, 252));
		mailLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		JSeparator sep2 = new JSeparator();
		JLabel interesLbl = new JLabel(" Detalles de Interes:");
		interesLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		interesLbl.setForeground(new Color(252, 252, 252));
		JSeparator sep3 = new JSeparator();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		JTextArea textArea = new JTextArea();
		textArea.setFocusable(false);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setForeground(new Color(252, 252, 252));
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textArea.setBorder(null);
		textArea.setBackground(new Color(54, 54, 54));
		scrollPane.setViewportView(textArea);
		JLabel label = new JLabel("lllll");
		label.setOpaque(true);
		label.setForeground(new Color(54, 54, 54));
		label.setBackground(new Color(54, 54, 54));
		scrollPane.setRowHeaderView(label);
		try {
			info = cont.getInfoClient(client);
			clientLbl.setText("Cliente Número:  " + info[0]);
			nameLbl.setText(nameLbl.getText() + "   " + info[1]);
			telfLbl.setText(telfLbl.getText() + "   " + info[2]);
			mailLbl.setText(mailLbl.getText() + "   " + info[3]);
			textArea.setText(info[4]);
		} catch (IOException e1) {
			errorMessage("INTERNAL ERROR!");
		}
		
		//Edit Button + Pressed Button Listener
		JButton editBtn = new JButton("Editar");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientEdit edit = new ClientEdit(caller, info);
				edit.setVisible(true);
				edit.setAlwaysOnTop(true);
				dispose();
			}
		});
		
		//Cancel Button + Pressed Button Listener
		JButton cancelRBtn = new JButton("Cancelar");
		cancelRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		//Remove Button + Pressed Button Listener
		JButton elimBtn = new JButton("Eliminar");
		elimBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientRemove remo = new ClientRemove(caller, info);
				remo.setAlwaysOnTop(true);
				remo.setVisible(true);
				dispose();
			}
		});
		
		//Elements Distribution
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addComponent(clientLbl, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(nameLbl, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(telfLbl, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(mailLbl, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
								.addComponent(interesLbl, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(elimBtn, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
									.addGap(155)
									.addComponent(cancelRBtn, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editBtn, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
								.addComponent(sep3, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))))
					.addGap(11))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(sep1, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(sep2, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(clientLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(sep1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(nameLbl, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(telfLbl, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mailLbl, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(sep2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(interesLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sep3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(editBtn)
						.addComponent(cancelRBtn)
						.addComponent(elimBtn))
					.addGap(25))
		);
		getContentPane().setLayout(groupLayout);
	}
}
