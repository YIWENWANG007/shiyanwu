package xuanke;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Login extends JFrame{
	JLabel label,name,pass;
	JButton login;
	JTextField Name;
	JPasswordField password;
	JPanel panel,jp1,jp2;

	public Login(){
		this.setSize( 300, 200);
		this.setTitle("ѧ��ѡ��ϵͳ��¼");
		this.setLayout(new BorderLayout());
		label = new JLabel("��¼",SwingConstants.CENTER);
		label.setFont(new Font("����",Font.BOLD,30));
		name = new JLabel("�� ��");
		pass = new JLabel("�� ��");
		Name = new JTextField(12);
		Name.setText("");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		password = new JPasswordField(12);
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setEchoChar('*');		//���û����ַ�

		panel = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		panel.setLayout(new BorderLayout());
		jp1.add(Name);
		jp1.add(name);
		jp1.add(password);
		jp1.add(pass);
		panel.add(jp1);
		login = new JButton("��¼");
		jp2.add(login);
		panel.add(jp2,BorderLayout.SOUTH);
		this.add(label,BorderLayout.NORTH);
		this.add(panel);		
		MyEvent();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void MyEvent(){
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String name="abc";
				String word = "123456";	// ��ȷ����
				String str = new String(password.getPassword());
				if(str.equals(word)){
					new Login().setVisible(true);
				}
				else{
					String str1 = "����������벻��ȷ��ԭ������ǣ�\n" 
				+  "1���������룻\n" + "2��δ����С���̣�\n" 
							+ "3����Сдδ���֡�";//���������ʾ
					JOptionPane.showMessageDialog(null, str1);
             	
				}
				Login.this.dispose();
				new Student().show();//��תѧ��ѡ�ν���
			}
		});
	}
	public static void main(String[] args){
		new Login();
	}

}