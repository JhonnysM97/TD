package edu.cecar.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import edu.cecar.componentes.baseDatos.ConectarMySQL;
import edu.cecar.conectarAPI.SingletonConectarAPI;
import logica.Buscar;
import logica.ListarTodo;
import logica.Migrar;

public class Main extends JFrame {

	private JPanel contentPane;
	static Carga carga = new Carga();
	static Loging loging ;
	private JPanel panel;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JLabel lblId;
	private JButton btnBuscar;
	private JTextField txtId;
	private JTextField txtIdS;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtGender;

	private static 	Main frame;
	
	
	private Buscar buscar1 ;
	
	private Buscar buscar2 ;


	public static void main(String[] args) throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Main();
					
					 frame.setVisible(true);	

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		SingletonConectarAPI.getConectarAPI();	
		System.out.println("holaa");
		
		carga.activar();
		
		
		
		
	}


	public Main() throws Exception {
		setResizable(false);
		ConectarMySQL.getConectarMySQL("127.0.0.1", "bdgorest", "root", "root1234");
		
		addWindowListener(new WindowAdapter() {
			
			
			
			@Override
			public void windowOpened(WindowEvent e) {


				carga.setModal(true);


				carga.setVisible(true);




			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 781);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnListarTodos = new JButton("Listar Usuarios");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = model.getRowCount()-1; i >=0 ; i--) 
					model.removeRow(i);


				ListarTodo.listar(model);

			}
		});
		btnListarTodos.setBounds(10, 193, 130, 23);
		contentPane.add(btnListarTodos);



		String col[] = {"first_name","last_name","gender","dob","email","phone","website","address","status"};



		panel = new JPanel();
		panel.setBounds(10, 227, 1010, 504);
		panel.setLayout(new BorderLayout());

		model = new DefaultTableModel();
		model.setColumnIdentifiers(col);


		JTable table = new JTable();
		//table.setEnabled(false);


		table.setModel(model);
		//	table.setBounds(1, 1, 604, 230);
		table.setRowSorter(new TableRowSorter<TableModel>(model));


		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.cyan);


		scrollPane = new JScrollPane();
		//scrollPane.setBounds(1, 0, 626, 241);

		scrollPane.setViewportView(table);		
		panel.add(scrollPane, BorderLayout.CENTER);

		contentPane.add(panel);

		lblId = new JLabel("Id:");
		lblId.setBounds(10, 11, 46, 14);
		contentPane.add(lblId);

		txtId = new JTextField();
		txtId.setBounds(42, 8, 110, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				buscar1 = new Buscar(txtId.getText().toString(), "texto");
				buscar2 = new Buscar(txtId.getText().toString(), "multimedia");
				
				buscar1.run();
				buscar2.run();

				
			}
		});
		btnBuscar.setBounds(159, 7, 89, 23);
		contentPane.add(btnBuscar);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(395, 8, 394, 208);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 44, 81, 14);
		panel_2.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 69, 81, 14);
		panel_2.add(lblLastName);

		JLabel lblId_1 = new JLabel("Id: ");
		lblId_1.setBounds(10, 19, 46, 14);
		panel_2.add(lblId_1);

		JLabel lblGender = new JLabel("Gender: ");
		lblGender.setBounds(10, 94, 57, 14);
		panel_2.add(lblGender);

		txtIdS = new JTextField();
		txtIdS.setEditable(false);
		txtIdS.setBounds(83, 13, 86, 20);
		panel_2.add(txtIdS);
		txtIdS.setColumns(10);

		txtFirst = new JTextField();
		txtFirst.setEditable(false);
		txtFirst.setBounds(83, 41, 86, 20);
		panel_2.add(txtFirst);
		txtFirst.setColumns(10);

		txtLast = new JTextField();
		txtLast.setEditable(false);
		txtLast.setBounds(83, 66, 86, 20);
		panel_2.add(txtLast);
		txtLast.setColumns(10);

		txtGender = new JTextField();
		txtGender.setEditable(false);
		txtGender.setBounds(83, 91, 86, 20);
		panel_2.add(txtGender);
		txtGender.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 129, 367, 53);
		panel_2.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Ver", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JButton btnPost = new JButton("Posts");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ImprimirResultado resultado = new ImprimirResultado("Posts");
			resultado.setModal(true);
			resultado.setVisible(true);
			
			}
		});
		panel_1.add(btnPost);

		JButton btnNewButton = new JButton("Comments");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ImprimirResultado resultado = new ImprimirResultado("Comments");
				resultado.setModal(true);
				resultado.setVisible(true);
				
			}
		});
		panel_1.add(btnNewButton);

		JButton btnAlbums = new JButton("Albums");
		btnAlbums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ImprimirResultado resultado = new ImprimirResultado("Albums");
				resultado.setModal(true);
				resultado.setVisible(true);
				
			}
		});
		panel_1.add(btnAlbums);

		JButton btnPhotos = new JButton("Photos");
		btnPhotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ImprimirResultado resultado = new ImprimirResultado("Photos");
				resultado.setModal(true);
				resultado.setVisible(true);
				
			}
		});
		panel_1.add(btnPhotos);
		
		JButton btnMigrarDatos = new JButton("Migrar Datos");
		btnMigrarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carga carga = new Carga();
				Migrar.iniciar();
				carga.activar();
				
				
			}
		});
		btnMigrarDatos.setBounds(813, 182, 150, 23);
		contentPane.add(btnMigrarDatos);


	}
}
