package view.main;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Information extends JDialog {
	//Attributes
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	//Create the Dialog
	public Information(MainMenu caller) {
		setResizable(false);
		setBounds(100, 100, 570, 420);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(69, 69, 69));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//Close Button + Pressed Button Listener
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		JScrollPane infoScroll = new JScrollPane();
		JTextArea infoArea = new JTextArea();
		infoArea.setFocusable(false);
		infoArea.setEditable(false);
		infoArea.setForeground(new Color(252, 252, 252));
		infoArea.setBackground(new Color(54, 54, 54));
		infoArea.setLineWrap(true);
		infoArea.setWrapStyleWord(true);
		infoArea.setText("KekoAgenda - version 1.5 - Guillermo Martinez - Kekolandia Miniatures.\n\nPrograma de gestión de distintos aspectos de la agenda de la tienda. Al iniciar el programa se muestra la fecha actual y se indican las tareas a realizar con la fecha más cercana (se puede consultar la información de dichas tareas haciendo doble click sobre ellas)\n\n\n1.KekoAmigos\nApartado encargado de la gestión de los clientes.\n\n1.1.Añadir Cliente (Menu Principal -> KekoAmigos, Añadir)\nPermite añadir al sistema un nuevo cliente. Información requerida: nombre, teléfono, correo electrónico e intereses de la tienda. Comprueba que no haya otro cliente con el mismo nombre y lo registra. En este paso, el cliente recibirá un número único de identificación. El sistema obliga a rellenar todos los campos, no obstante si el cliente no desea dar alguno de sus datos, en el caso del teléfono se podrá registrar simplemente 000 y en el caso del correo cualquier palabra por defecto. El cliente deberá recordar el nombre con el que ha sido registrado (un cliente es referenciado por su nombre y su numero de registro).\n\n1.2.Ver Cliente (Menu Principal -> KekoAmigos, Seleccionar -> Doble click sobre cliente concreto)\nPermite consultar la información del cliente indicado. Ninguno de los campos mostrados se puede modificar en esta pantalla.\n\n1.3.Editar Cliente (Menu Principal -> KekoAmigos, Seleccionar -> Doble click sobre cliente concreto -> Editar)\nPermite modificar los campos del cliente seleccionado. Al pulsar en guardar, todos los cambios indicados serán registrados en el sistema. Ver 1.1 para referencia al llenado de campos.\n\n\n\n2.Tareas\nPermite gestionar las tareas de la tienda (útil como recordatorio y comunicación entre empleados).\n\n2.1. Añadir Tarea (Menú principal -> Tareas, Añadir)\nPermite registrar en el sistema una nueva tarea. No puede haber dos tareas con mismo nombre. La información indicable es el nombre, la fecha y la descripción de la tarea. Si no se indica una fecha, el sistema lo indicará mediante \"Ind\" en el campo de la fecha.\n\n2.2.Ver Tarea (Menú principal -> Tareas, Seleccionar -> Doble click tarea seleccionada)\nMuestra la descripción de la tarea seleccionada.\n\n2.3. Editar Tarea (Menú principal -> Tareas, Seleccionar -> Doble click tarea seleccionada -> Editar)\nPermite cambiar el nombre y la descripción de la tarea seleccionada. Los cambios son registrados en el sistema al pulsar en guardar.\n\n\n\n3.Reservas\nApartado encargado de la gestión de reservas de mesas de juego y pintura. Las reservas con fechas anteriores a la actual se indican mediante \">>>\" antes de la fecha.\n\n3.1.Añadir Reserva (Menú principal -> Reservas, Añadir)\nPermite añadir en el sistema una nueva reserva. Dicho espacio se indica en un mapa de ambas plantas. La información a añadir son el espacio reservado, la fecha y el nombre del kekoAmigo que la realiza.\n\n3.2.Ver reserva (Menú principal -> Eventos, Seleccionar, Doble click en la fecha seleccionada)\nSe mostrará un listado con las fechas que tienen alguna mesa reservada. Al hacer doble click en una de las fechas se mostrará el mapa de reservas y los nombres de quien las ha realizado. Ninguno de los campos mostrados en esta pantalla son editables.\n\n3.3.Editar Reserva (Menú principal -> Reservas,  Seleccionar -> Doble click sobre la fecha seleccionada -> Editar)\nPermite editar las reservas (espacios y clientes) de la fecha seleccionada. Ver 3.1 para referencia al llenado de campos.\n\n\nNota: Todos los registros son eliminables en las respectivas pantallas de visualización.\n\n\n\nUltima modificación: 06/03/2017");
		infoScroll.setViewportView(infoArea);
		
		//Elements Distribution
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(infoScroll, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
						.addComponent(btnCerrar))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGap(4)
					.addComponent(infoScroll, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCerrar)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
