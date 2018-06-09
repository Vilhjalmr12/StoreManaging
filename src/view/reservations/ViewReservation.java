package view.reservations;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import view.main.MainMenu;
import view.zMessages.ErrorMessage;

public class ViewReservation extends JDialog {
	//Attributes
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField enField;
	private JTextField treField;
	private JTextField femField;
	private JTextField sjuField;
	private JTextField nioField;
	private JTextField tvaField;
	private JTextField fyraField;
	private JTextField sexField;
	private JTextField ottaField;
	private JTextField tioField;
	private JRadioButton enRBtn = new JRadioButton("1");
	private JRadioButton tvaRBtn = new JRadioButton("2");
	private JRadioButton treRBtn = new JRadioButton("3");
	private JRadioButton fyraRBtn = new JRadioButton("4");
	private JRadioButton femRBtn = new JRadioButton("5");
	private JRadioButton sexRBtn = new JRadioButton("6");
	private JRadioButton sjuRBtn = new JRadioButton("7");
	private JRadioButton ottaRBtn = new JRadioButton("8");
	private JRadioButton nioRBtn = new JRadioButton("9");
	private JRadioButton tioRBtn = new JRadioButton("0");
	private String date = "";

	//Show the error message and block this frame until the message is closed
  	public void errorMessage(String text) {
  		ErrorMessage msg = new ErrorMessage(this, text);
  		msg.setAlwaysOnTop(true);
  		msg.setVisible(true);
  		setEnabled(false);
  	}
  	
  	public void setNames(String names) {
  		String[] n = names.split(",");
  		if(!n[0].equals(".")) {
  			enRBtn.setSelected(true);
  			enField.setText(n[0]);
  		}
  		if(!n[1].equals(".")) {
  			tvaRBtn.setSelected(true);
  			tvaField.setText(n[1]);
  		}
  		if(!n[2].equals(".")) {
  			treRBtn.setSelected(true);
  			treField.setText(n[2]);
  		}
  		if(!n[3].equals(".")) {
  			fyraRBtn.setSelected(true);
  			fyraField.setText(n[3]);
  		}
  		if(!n[4].equals(".")) {
  			femRBtn.setSelected(true);
  			femField.setText(n[4]);
  		}
  		if(!n[5].equals(".")) {
  			sexRBtn.setSelected(true);
  			sexField.setText(n[5]);
  		}
  		if(!n[6].equals(".")) {
  			sjuRBtn.setSelected(true);
  			sjuField.setText(n[6]);
  		}
  		if(!n[7].equals(".")) {
  			ottaRBtn.setSelected(true);
  			ottaField.setText(n[7]);
  		}
  		if(!n[8].equals(".")) {
  			nioRBtn.setSelected(true);
  			nioField.setText(n[8]);
  		}
  		if(!n[9].equals(".")) {
  			tioRBtn.setSelected(true);
  			tioField.setText(n[9]);
  		}
  	}
	
	//Create the Dialog
	public ViewReservation(MainMenu caller, String reservation) {
		setResizable(false);
		setBounds(100, 100, 652, 603);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(69, 69, 69));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		//Initial SetUp
		JLabel tablesLbl = new JLabel("");
		tablesLbl.setBorder(null);
		tablesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		tablesLbl.setIcon(new ImageIcon(MainMenu.class.getResource("/view/reservations/image3.png")));
		JLabel yearLbl = new JLabel();
		yearLbl.setForeground(new Color(252, 252, 252));
		yearLbl.setHorizontalAlignment(SwingConstants.CENTER);
		yearLbl.setFont(new Font("SansSerif", Font.PLAIN, 15));
		enField = new JTextField();
		enField.setBackground(new Color(36, 36, 36));
		enField.setForeground(new Color(252, 252, 252));
		enField.setEditable(false);
		enField.setFocusable(false);
		enField.setColumns(10);
		treField = new JTextField();
		treField.setBackground(new Color(36, 36, 36));
		treField.setForeground(new Color(252, 252, 252));
		treField.setEditable(false);
		treField.setFocusable(false);
		treField.setColumns(10);
		femField = new JTextField();
		femField.setBackground(new Color(36, 36, 36));
		femField.setForeground(new Color(252, 252, 252));
		femField.setEditable(false);
		femField.setFocusable(false);
		femField.setColumns(10);
		sjuField = new JTextField();
		sjuField.setBackground(new Color(36, 36, 36));
		sjuField.setForeground(new Color(252, 252, 252));
		sjuField.setEditable(false);
		sjuField.setFocusable(false);
		sjuField.setColumns(10);
		nioField = new JTextField();
		nioField.setBackground(new Color(36, 36, 36));
		nioField.setForeground(new Color(252, 252, 252));
		nioField.setEditable(false);
		nioField.setFocusable(false);
		nioField.setColumns(10);
		tvaField = new JTextField();
		tvaField.setBackground(new Color(36, 36, 36));
		tvaField.setForeground(new Color(252, 252, 252));
		tvaField.setEditable(false);
		tvaField.setFocusable(false);
		tvaField.setColumns(10);
		fyraField = new JTextField();
		fyraField.setBackground(new Color(36, 36, 36));
		fyraField.setForeground(new Color(252, 252, 252));
		fyraField.setEditable(false);
		fyraField.setFocusable(false);
		fyraField.setColumns(10);
		sexField = new JTextField();
		sexField.setBackground(new Color(36, 36, 36));
		sexField.setForeground(new Color(252, 252, 252));
		sexField.setEditable(false);
		sexField.setFocusable(false);
		sexField.setColumns(10);
		ottaField = new JTextField();
		ottaField.setBackground(new Color(36, 36, 36));
		ottaField.setForeground(new Color(252, 252, 252));
		ottaField.setEditable(false);
		ottaField.setFocusable(false);
		ottaField.setColumns(10);
		tioField = new JTextField();
		tioField.setBackground(new Color(36, 36, 36));
		tioField.setForeground(new Color(252, 252, 252));
		tioField.setEditable(false);
		tioField.setFocusable(false);
		tioField.setColumns(10);
		CtrlReservations cont = new CtrlReservations();
		yearLbl.setText(reservation);
		try {
			date = reservation.split(" - ")[0].replaceAll("/", "");
			if (reservation.split(" - ")[2].equals("Mañana")) {date += "M";}
			else {date += "T";}
			setNames(cont.getReservationNames(date));
		} catch (IOException e1) {
			errorMessage("INTERNAL ERROR!");
		}
		
		//Client Field 1
		enRBtn.setEnabled(false);
		enRBtn.setFocusable(false);
		enRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		enRBtn.setForeground(new Color(252, 252, 252));
		enRBtn.setBackground(new Color(252, 252, 252));
		enRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));

		//Client Field 2
		tvaRBtn.setEnabled(false);
		tvaRBtn.setFocusable(false);
		tvaRBtn.setForeground(new Color(252, 252, 252));
		tvaRBtn.setBackground(new Color(252, 252, 252));
		tvaRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		tvaRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		//Client Field 3
		treRBtn.setEnabled(false);
		treRBtn.setFocusable(false);
		treRBtn.setForeground(new Color(252, 252, 252));
		treRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		treRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		//Client Field 4
		fyraRBtn.setEnabled(false);
		fyraRBtn.setFocusable(false);
		fyraRBtn.setForeground(new Color(252, 252, 252));
		fyraRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		fyraRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		//Client Field 5
		femRBtn.setEnabled(false);
		femRBtn.setFocusable(false);
		femRBtn.setForeground(new Color(252, 252, 252));
		femRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		femRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		//Client Field 6
		sexRBtn.setEnabled(false);
		sexRBtn.setFocusable(false);
		sexRBtn.setForeground(new Color(252, 252, 252));
		sexRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		sexRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		//Client Field 7
		sjuRBtn.setEnabled(false);
		sjuRBtn.setFocusable(false);
		sjuRBtn.setForeground(new Color(252, 252, 252));
		sjuRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		sjuRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		//Client Field 8
		ottaRBtn.setEnabled(false);
		ottaRBtn.setFocusable(false);
		ottaRBtn.setForeground(new Color(252, 252, 252));
		ottaRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		ottaRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		//Client Field 9
		nioRBtn.setEnabled(false);
		nioRBtn.setFocusable(false);
		nioRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		nioRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		nioRBtn.setForeground(new Color(252, 252, 252));
		
		//Client Field 10
		tioRBtn.setEnabled(false);
		tioRBtn.setFocusable(false);
		tioRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		tioRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tioRBtn.setForeground(new Color(252, 252, 252));
		
		//Edit Button + Pressed Button Listener
		JButton confirmBtn = new JButton("Editar");
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditReservation edit = new EditReservation(caller, reservation);
			    edit.setVisible(true);
			    edit.setAlwaysOnTop(true);
			    dispose();
			}
		});
		
		//Cancel Button + Pressed Button Listener
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		//Remove Button + Pressed Button Listener
		JButton removeBtn = new JButton("Eliminar");
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveReservation remo = new RemoveReservation(caller, date, reservation);
				remo.setAlwaysOnTop(true);
				remo.setVisible(true);
				dispose();
			}
		});
		
		//Elements Distribution
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(yearLbl, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(nioRBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
								.addComponent(sjuRBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
								.addComponent(femRBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
								.addComponent(treRBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
								.addComponent(enRBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(enField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
								.addComponent(treField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
								.addComponent(femField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
								.addComponent(sjuField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
								.addComponent(nioField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(tioRBtn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
								.addComponent(ottaRBtn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
								.addComponent(sexRBtn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
								.addComponent(fyraRBtn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
								.addComponent(tvaRBtn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(tvaField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
								.addComponent(fyraField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
								.addComponent(sexField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
								.addComponent(ottaField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
								.addComponent(tioField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)))
						.addComponent(tablesLbl, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(removeBtn, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(271)
							.addComponent(cancelBtn, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(confirmBtn, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tablesLbl)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(yearLbl)
					.addGap(20)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(enRBtn, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(tvaRBtn, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(enField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(tvaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(treRBtn)
						.addComponent(fyraRBtn)
						.addComponent(treField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fyraField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(femRBtn)
						.addComponent(sexRBtn)
						.addComponent(femField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(sexField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(sjuRBtn)
						.addComponent(ottaRBtn)
						.addComponent(sjuField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ottaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(nioRBtn)
						.addComponent(tioRBtn)
						.addComponent(nioField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tioField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(confirmBtn)
						.addComponent(cancelBtn)
						.addComponent(removeBtn))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		contentPanel.setLayout(gl_contentPanel);
	}
}
