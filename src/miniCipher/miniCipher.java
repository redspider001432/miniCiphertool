package miniCipher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class miniCipher extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miniCipher frame = new miniCipher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public miniCipher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 233, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlainText = new JLabel("Plain Text: ");
		lblPlainText.setBounds(0, 39, 78, 15);
		contentPane.add(lblPlainText);
		
		JLabel lblCipherText = new JLabel("Cipher Text: ");
		lblCipherText.setBounds(0, 72, 89, 15);
		contentPane.add(lblCipherText);
		
		t1 = new JTextField();
		t1.setBounds(96, 37, 114, 19);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(96, 70, 114, 19);
		contentPane.add(t2);
		
		JButton enc = new JButton("ENCRYPT");
		enc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String plain = t1.getText();
				String cipher = "";
				
				
				for (int i = 0 ; i <= plain.length() - 1; i++) {
					cipher =  cipher +  (char)((plain.charAt(i)) + 3);  // add + "$" + "@" + "#"
				}
				JOptionPane.showMessageDialog(enc,cipher);
				t1.setText(" ");
				t2.setText(cipher);
				
			}
		});
		enc.setBounds(52, 126, 117, 25);
		contentPane.add(enc);
		
		JButton dec = new JButton("DECRYPT");
		dec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cipher = t2.getText();
				String plain = " ";
//				cipher = cipher.replaceAll("$", "");
				for (int i = 0; i <= cipher.length() - 1; i++) {
					
					plain =   plain + (char)(cipher.charAt(i) - 3);
				
					
					

				}
//				cipher = cipher.replaceAll("=", "");
//				cipher = cipher.replaceAll("!", "");	
				
				JOptionPane.showMessageDialog(enc, plain);
				t2.setText(" ");
				t1.setText(plain);
				
			}
		});
		dec.setBounds(52, 181, 117, 25);
		contentPane.add(dec);
		
		JButton res = new JButton("RESET");
		res.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t1.setText(" ");
				t2.setText(" ");
			}
		});
		res.setBounds(52, 234, 117, 25);
		contentPane.add(res);
		
		JLabel lblminicipher = new JLabel("#miniCIPHER");
		lblminicipher.setForeground(Color.RED);
		lblminicipher.setBackground(Color.RED);
		lblminicipher.setBounds(70, 0, 114, 15);
		contentPane.add(lblminicipher);
	}
}
