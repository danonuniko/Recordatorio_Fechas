import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Clases para enviar email.
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public class Start {

	private JFrame frmRecordatorioFechas;
	private JTextField asignatura;
	private JTextField dia;
	private JTextField mes;
	private JTextField anyo;
	private JTextField hora;
	private JTextField minutos;
	private JLabel etiquetaDosPuntos_1;
	private JLabel etiquetaBarraLateral_1;
	private JLabel etiquetaBarraLateral_2;
	private JLabel etiquetaDosPuntos_2;
	private JLabel etiquetaAsignatura;
	private JLabel etiquetaMes;
	private JLabel etiquetaDia;
	private JLabel etiquetaAnyo;
	private JLabel etiquetaHoras;
	private JLabel etiquetaMinutos;
	private JButton botonAnyadir;
	private JButton botonReiniciar;
	private JLabel etiquetaCorreoElectronico;
	private JLabel etiquetaHoraAviso;
	private JTextField correoElectronico;
	private JTextField horasAviso;
	private JLabel etiquetaResultado;

	private String textoAsignatura;
	private String textoDia;
	private String textoMes;
	private String textoAnyo;
	private String textoHora;
	private String textoMinutos;
	private String textoCorreo;
	private String textoHorasPreaviso;

	Connection conexion = null;
	Statement s = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frmRecordatorioFechas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Start() {
		initialize();
	}

	private void initialize() {
		frmRecordatorioFechas = new JFrame();
		frmRecordatorioFechas.setTitle("Recordatorio Fechas");
		frmRecordatorioFechas.setBounds(100, 100, 515, 596);
		frmRecordatorioFechas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecordatorioFechas.getContentPane().setLayout(null);

		etiquetaAsignatura = new JLabel("ASIGNATURA");
		etiquetaAsignatura.setBounds(35, 38, 120, 47);
		frmRecordatorioFechas.getContentPane().add(etiquetaAsignatura);

		etiquetaMes = new JLabel("MES");
		etiquetaMes.setBounds(243, 41, 39, 41);
		frmRecordatorioFechas.getContentPane().add(etiquetaMes);

		etiquetaDia = new JLabel("D\u00CDA");
		etiquetaDia.setBounds(182, 41, 39, 41);
		frmRecordatorioFechas.getContentPane().add(etiquetaDia);

		etiquetaAnyo = new JLabel("A\u00D1O");
		etiquetaAnyo.setBounds(300, 41, 39, 41);
		frmRecordatorioFechas.getContentPane().add(etiquetaAnyo);

		asignatura = new JTextField();
		asignatura.setBounds(9, 73, 129, 20);
		frmRecordatorioFechas.getContentPane().add(asignatura);
		asignatura.setColumns(10);

		dia = new JTextField();
		dia.setHorizontalAlignment(SwingConstants.CENTER);
		dia.setColumns(10);
		dia.setBounds(171, 73, 44, 20);
		frmRecordatorioFechas.getContentPane().add(dia);

		mes = new JTextField();
		mes.setHorizontalAlignment(SwingConstants.CENTER);
		mes.setColumns(10);
		mes.setBounds(232, 73, 44, 20);
		frmRecordatorioFechas.getContentPane().add(mes);

		anyo = new JTextField();
		anyo.setHorizontalAlignment(SwingConstants.CENTER);
		anyo.setColumns(10);
		anyo.setBounds(294, 73, 44, 20);
		frmRecordatorioFechas.getContentPane().add(anyo);

		hora = new JTextField();
		hora.setHorizontalAlignment(SwingConstants.CENTER);
		hora.setColumns(10);
		hora.setBounds(364, 73, 44, 20);
		frmRecordatorioFechas.getContentPane().add(hora);

		minutos = new JTextField();
		minutos.setHorizontalAlignment(SwingConstants.CENTER);
		minutos.setColumns(10);
		minutos.setBounds(424, 73, 60, 20);
		frmRecordatorioFechas.getContentPane().add(minutos);

		etiquetaHoras = new JLabel("HORA");
		etiquetaHoras.setBounds(368, 41, 39, 41);
		frmRecordatorioFechas.getContentPane().add(etiquetaHoras);

		etiquetaMinutos = new JLabel("MINUTOS");
		etiquetaMinutos.setBounds(426, 41, 55, 41);
		frmRecordatorioFechas.getContentPane().add(etiquetaMinutos);

		etiquetaDosPuntos_1 = new JLabel(":");
		etiquetaDosPuntos_1.setBounds(141, 60, 14, 47);
		frmRecordatorioFechas.getContentPane().add(etiquetaDosPuntos_1);

		etiquetaBarraLateral_1 = new JLabel("/");
		etiquetaBarraLateral_1.setBounds(220, 60, 14, 47);
		frmRecordatorioFechas.getContentPane().add(etiquetaBarraLateral_1);

		etiquetaBarraLateral_2 = new JLabel("/");
		etiquetaBarraLateral_2.setBounds(282, 60, 17, 47);
		frmRecordatorioFechas.getContentPane().add(etiquetaBarraLateral_2);

		etiquetaDosPuntos_2 = new JLabel(":");
		etiquetaDosPuntos_2.setBounds(415, 60, 14, 47);
		frmRecordatorioFechas.getContentPane().add(etiquetaDosPuntos_2);

		botonAnyadir = new JButton("A\u00D1ADIR");
		botonAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textoAsignatura = asignatura.getText();
				textoDia = dia.getText();
				textoMes = mes.getText();
				textoAnyo = anyo.getText();
				textoHora = hora.getText();
				textoMinutos = minutos.getText();
				textoCorreo = correoElectronico.getText();
				textoHorasPreaviso = horasAviso.getText();

				if (textoAsignatura.equals("") || textoDia.equals("") || textoMes.equals("") || textoAnyo.equals("")
						|| textoHora.equals("") || textoMinutos.equals("") || textoCorreo.equals("")
						|| textoHorasPreaviso.equals("")) {
					etiquetaResultado.setText("ERROR. RELLENE TODOS LOS CAMPOS.");
				} else {

					try {

						conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/calendario", "root",
								"");
						s = (Statement) conexion.createStatement();

						String propuesta = "INSERT INTO fechas (asignatura, fecha) VALUES ('" + textoAsignatura + "', '"
								+ textoAnyo + "-" + textoMes + "-" + textoDia + " " + textoHora + ":" + textoMinutos
								+ "')";
						System.out.println(propuesta);
						int numeroCambios = s.executeUpdate(propuesta);
						s.close();
						conexion.close();

						if (numeroCambios != 0)
							etiquetaResultado.setText("Producto creado correctamente");
						else
							etiquetaResultado.setText("El producto no se ha podido crear");

						try {
							// La dirección de correo de envío
							String remitente = "dcolladovizcarro@gmail.com";
							// La clave de aplicación obtenida según se explica en este artículo:
							String claveemail = "wfqaqbuhvdgjfjmb";

							Properties props = System.getProperties();
							props.put("mail.smtp.host", "smtp.gmail.com"); // El servidor SMTP de Google
							props.put("mail.smtp.user", remitente);
							props.put("mail.smtp.clave", claveemail); // La clave de la cuenta
							props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave
							props.put("mail.smtp.starttls.enable", "true"); // Para conectar de manera segura al
																			// servidor SMTP
							props.put("mail.smtp.port", "587"); // El puerto SMTP seguro de Google

							Session session = Session.getDefaultInstance(props);
							MimeMessage message = new MimeMessage(session);

							message.setFrom(new InternetAddress(remitente));
							message.addRecipient(Message.RecipientType.TO,
									new InternetAddress("marco070593@gmail.com")); // Se podrían añadir varios de la
																					// misma manera
							message.setSubject("hola");
							message.setText("mensaje enviado desde programa JAVA");
							Transport transport = session.getTransport("smtp");
							transport.connect("smtp.gmail.com", remitente, claveemail);
							transport.sendMessage(message, message.getAllRecipients());
							transport.close();

						} catch (MessagingException mex) {
							mex.printStackTrace();
							System.out.println("El email no se pudo enviar");
						}

					} catch (Exception ex) {
						ex.printStackTrace();
						etiquetaResultado.setText("El producto no se ha podido crear. Revise los datos introducidos");
					}

				}
			}
		});
		botonAnyadir.setBounds(364, 118, 89, 23);
		frmRecordatorioFechas.getContentPane().add(botonAnyadir);

		etiquetaCorreoElectronico = new JLabel("CORREO ELECTR\u00D3NICO");
		etiquetaCorreoElectronico.setBounds(29, 104, 153, 47);
		frmRecordatorioFechas.getContentPane().add(etiquetaCorreoElectronico);

		correoElectronico = new JTextField();
		correoElectronico.setColumns(10);
		correoElectronico.setBounds(9, 144, 191, 20);
		frmRecordatorioFechas.getContentPane().add(correoElectronico);

		etiquetaHoraAviso = new JLabel("HORAS PREAVISO");
		etiquetaHoraAviso.setBounds(218, 104, 135, 47);
		frmRecordatorioFechas.getContentPane().add(etiquetaHoraAviso);

		horasAviso = new JTextField();
		horasAviso.setHorizontalAlignment(SwingConstants.CENTER);
		horasAviso.setColumns(10);
		horasAviso.setBounds(217, 144, 82, 20);
		frmRecordatorioFechas.getContentPane().add(horasAviso);

		etiquetaResultado = new JLabel("");
		etiquetaResultado.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaResultado.setBounds(29, 175, 459, 63);
		frmRecordatorioFechas.getContentPane().add(etiquetaResultado);

		botonReiniciar = new JButton("REINICIAR");
		botonReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignatura.setText("");
				dia.setText("");
				mes.setText("");
				anyo.setText("");
				hora.setText("");
				minutos.setText("");
				correoElectronico.setText("");
				horasAviso.setText("");
				etiquetaResultado.setText("");
			}
		});
		botonReiniciar.setBounds(352, 143, 118, 23);
		frmRecordatorioFechas.getContentPane().add(botonReiniciar);
	}
}
