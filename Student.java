package xuanke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


public class Student extends JFrame {

    // �������
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfName,tfNum,allInfo;
    private JRadioButton rb1,rb2;
    private JCheckBox cb1,cb2,cb3;
    private JComboBox<String> t1,t2,t3;

    public static void main(String[] args) {
    	
     new Student();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                	Student frame=new Student();     // ����һ������
                    frame.setVisible(true);                                    // �øô���ʵ���ɼ�
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    
    public Student(){
        setTitle("ѡ��ϵͳ");                           // ����
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        setSize(600,500);                                   // ���ô��ڴ�С
        setLocationRelativeTo(null);                        // ���ô������
        contentPane=new JPanel();                           // �������
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));      // ���ò���
        setContentPane(contentPane);
        JPanel panel=new JPanel(new GridLayout(5, 1,5,10));  // 5��1�еı�񲼾�
        panel.setBorder(new TitledBorder(null,"",TitledBorder.LEADING ,TitledBorder.TOP,null,null));
        contentPane.add(panel,BorderLayout.CENTER);          // ��panel��ӱ߿�
        
        JPanel panel_1=new JPanel();
        panel.add(panel_1);
        JButton w=new JButton("ѡ��");
        panel_1.add(w);
        JButton wy=new JButton("�˿�");
        panel_1.add(wy);
      
        JPanel panel_2=new JPanel();
        panel.add(panel_2);
        cb1=new JCheckBox("java");
        panel_2.add(cb1);
        t1=new JComboBox<String >();
        t1.setModel(new DefaultComboBoxModel<String>(new String[]{"����ʦ","����ʦ","����ʦ"}));
        panel_2.add(t1);
     
        JPanel panel_3=new JPanel();
        panel.add(panel_3);
        cb2=new JCheckBox("C����");
        panel_3.add(cb2);
        t2=new JComboBox<String >();
        t2.setModel(new DefaultComboBoxModel<String >(new String[]{"л��ʦ","֣��ʦ","����ʦ"}));
        panel_3.add(t2);
        
        JPanel panel_4=new JPanel();
        panel.add(panel_4);
        cb3=new JCheckBox("����");
        panel_4.add(cb3);
        t3=new JComboBox<String >();
        t3.setModel(new DefaultComboBoxModel<String>(new String[]{"����ʦ","����ʦ"}));
        panel_4.add(t3);
      
        JPanel panel_5=new JPanel();
        panel.add(panel_5);
        JButton w1=new JButton("ȷ��");
        panel_5.add(w1);
        JButton wy1=new JButton("����");
        panel_5.add(wy1);
        JButton wyw1=new JButton("��ӡѡ����Ϣ");
        panel_5.add(wyw1);
        
        //��ӱ���
        JPanel panelNorth=new JPanel();
        contentPane.add(panelNorth,BorderLayout.NORTH);
        JLabel labelTitle=new JLabel("ѧ��ѡ��ϵͳ");
        labelTitle.setForeground(Color.DARK_GRAY);
        labelTitle.setFont(new Font("����", Font.BOLD, 20));
        panelNorth.add(labelTitle);


        w1.addActionListener(new ActionListener() {                  
           public void actionPerformed(ActionEvent e) {
        	   
           }
      });
        wy1.addActionListener(new ActionListener() {                  
            public void actionPerformed(ActionEvent e) {
         	   
            }
       });

        wyw1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
       		
        		ArrayList<Course> courseSelect = new ArrayList<Course>();
        		
        		Course java = new Course("java",t1.getSelectedItem().toString());
        		Course c = new Course("C����",t2.getSelectedItem().toString());
        		Course math = new Course("����",t3.getSelectedItem().toString());
        		
        		if(cb1.isSelected()){
        			courseSelect.add(java);
        		}
        		if (cb2.isSelected()) {
        			courseSelect.add(c);
				}
        		if (cb3.isSelected()) {
        			courseSelect.add(math);
				}
        		
        		
        		
        		//
                File f = new File("e:" + File.separator + "StuSC.txt");// ����File ����    
                // ��2����ͨ������ʵ�����������    
                Writer out = null;                 
        // ׼����һ������Ķ���    
                try {
					out = new FileWriter(f);
			        // ͨ�������̬�Խ���ʵ����    
	                // ��3��������д����    
	                String str = "";  
	                
	                for (Course course : courseSelect) {
						str+= course.getCourseName() + ":" + course.getSelected()+"\n";
					}
	        // ׼��һ���ַ���    
	                out.write(str);                    
	        // ���������    
	                out.flush();          
	                // ��4�����ر������    
	                 out.close();  
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}            
			}
        });
    }

}
