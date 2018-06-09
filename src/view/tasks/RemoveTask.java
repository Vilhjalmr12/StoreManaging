package view.tasks;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.main.MainMenu;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class RemoveTask extends JDialog {
	//Attributes
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	//Create the Dialog
	public RemoveTask(MainMenu caller, String name) {
		setBounds(100, 100, 420, 108);
		setResizable(false);
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
		JLabel lblSeguroQueDeseas = new JLabel("Seguro que deseas eliminar esta tarea?");
		lblSeguroQueDeseas.setForeground(new Color(252, 252, 252));
		lblSeguroQueDeseas.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblSeguroQueDeseas.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel iconLbl = new JLabel("");
		iconLbl.setHorizontalAlignment(SwingConstants.CENTER);
		iconLbl.setIcon(new ImageIcon(MainMenu.class.getResource("/view/tasks/warning.png")));
		
		//Remove Button + Pressed Button listener
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlTasks cont = new CtrlTasks();
				try {
					if (cont.removeTask(name)) {
						caller.rightMessage("Tarea eliminada correctamente!");
					} else {
						caller.errorMessage("INTERNAL ERROR!");
					}
					cont.setTasks(caller);
					dispose();
				} catch (IOException e1) {
					caller.errorMessage("INTERNAL ERROR!");
				}
			}
		});
		
		//Cancel Button + Pressed Button listener
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		//Elements Distribution
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(95)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 102, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSeguroQueDeseas, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)))
					.addGap(410))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(iconLbl, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 64, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblSeguroQueDeseas, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(btnCancelar))))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
