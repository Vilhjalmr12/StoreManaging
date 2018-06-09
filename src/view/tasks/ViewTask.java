package view.tasks;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.main.MainMenu;
import view.zMessages.ErrorMessage;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class ViewTask extends JDialog {
	//Attributes
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public void errorMessage(String text) {
  		ErrorMessage msg = new ErrorMessage(this, text);
  		msg.setAlwaysOnTop(true);
  		msg.setVisible(true);
  		setEnabled(false);
  	}
	
	//Create the Dialog
	public ViewTask(MainMenu caller, String name) {
		setResizable(false);
		setBounds(100, 100, 600, 540);
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
		
		JLabel nameLbl = new JLabel("Nombre de la nota:");
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setForeground(new Color(252, 252, 252));
		nameLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		JTextArea textArea = new JTextArea();
		textArea.setFocusable(false);
		textArea.setEditable(false);
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBackground(new Color(54, 54, 54));
		textArea.setForeground(new Color(252, 252, 252));
		scrollPane.setViewportView(textArea);
		try {
			CtrlTasks cont = new CtrlTasks();
			nameLbl.setText(name);
			textArea.setText(cont.getInfoTask(name));
		} catch (IOException e1) {
			errorMessage("INTERNAL ERROR!");
		}
		
		//Save Button + Pressed Button Listener
		JButton editBtn = new JButton("Editar");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditTask edit = new EditTask(caller, name);
			    edit.setVisible(true);
			    edit.setAlwaysOnTop(true);
			    dispose();
			}
		});
		
		//Cancel Button + Pressed Button Listener
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		JButton removeBtn = new JButton("Eliminar");
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveTask rmv = new RemoveTask(caller, name);
			    rmv.setVisible(true);
			    rmv.setAlwaysOnTop(true);
			    dispose();
			}
		});
		
		//Elements Distribution
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(removeBtn, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
							.addGap(274)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 95, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editBtn, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
						.addComponent(nameLbl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(nameLbl)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(editBtn)
						.addComponent(btnCancelar)
						.addComponent(removeBtn))
					.addGap(14))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
