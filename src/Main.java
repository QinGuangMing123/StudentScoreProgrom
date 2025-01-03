

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;





public class Main {
    static Connection con;
    static PreparedStatement ps;
    static ResultSet res;
    public static void main(String[] args) {
        con = Main.getCon();//完成数据库的连接
        new Login();//进入登录与注册界面







    }

    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功");
            con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentscoreprogrom","root","123456");
            System.out.println("数据库连接成功");
        } catch (Exception e) {
           e.printStackTrace();
        }
        return con;
    }
}

class Login extends JFrame{
    JButton jButton1=new JButton("注册");
    JButton jButton2= new JButton("登录");
    JTextField jTextField1=new JTextField("请输入你的账号");
    JPasswordField jTextField2= new JPasswordField();
    JLabel jLabel1=new JLabel("账号");
    JLabel jLabel2=new JLabel("密码");
    String user0;
    String password0;
    public Login(){
        Container container = getContentPane();
        container.setLayout(null);
        setTitle("学生成绩管理系统");
        setBounds(50,50,800,800);

        jLabel1.setBounds(600,135,150,15);
        jLabel2.setBounds(600,215,150,15);
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        add(jLabel1);
        add(jLabel2);

        jTextField1.setBounds(600,150,150,50);
        jTextField2.setBounds(600,230,150,50);
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        add(jTextField1);
        add(jTextField2);

        jButton1.setBounds(600,310,150,80);
        jButton2.setBounds(600,420,150,80);
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user0 = jTextField1.getText();
                password0 = jTextField2.getText();
                // 在这里处理用户和密码
                try {
                    checkUserDatabase(user0,password0,1);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user0 = jTextField1.getText();
                password0 = jTextField2.getText();
                // 在这里处理用户和密码
                try {
                    checkUserDatabase(user0,password0,2);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(jButton1);
        add(jButton2);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void checkUserDatabase(String user0,String password0,int bt) throws SQLException {
        String query ="select * from user where user = ? and password = ?";
        try {
            Main.ps=Main.con.prepareStatement(query);
            Main.ps.setString(1,user0);
            Main.ps.setString(2,password0);
            Main.res=Main.ps.executeQuery();
            if(Main.res.next()){
                if(bt==1){
                    JOptionPane.showMessageDialog(this, "用户名重复，注册失败！");
                }else{
                    JOptionPane.showMessageDialog(this, "登录成功！");
                    setVisible(false);//关闭登录窗口
                    dispose();
                    new HomePage(user0);
//
                }
            }else {
                if(bt==1){
                    String query1 ="insert into user (user,password)values(?,?)";
                    Main.ps=Main.con.prepareStatement(query1);
                    Main.ps.setString(1,user0);
                    Main.ps.setString(2,password0);
                    Main.ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "注册成功！");
                }else{
                    JOptionPane.showMessageDialog(this, "用户名或密码错误！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class HomePage extends JFrame{
    JButton jButton1=new JButton("添加数据");
    JButton jButton2=new JButton("保存数据");
    JButton jButton3=new JButton("退出系统");
    JTable table;
    public HomePage(String user1) throws SQLException {
        Container container = getContentPane();
        container.setLayout(null);
        setTitle("学生成绩管理系统");
        setBounds(50,50,1000,800);

        //连接数据库并获取表格信息
        table= connectAndUpdata(user1);

        //添加一个滚动区域
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(50,50,900,750);
        pane.setVisible(true);
        add(pane);

        jButton1.setBounds(50,10,100,30);
        jButton1.setVisible(true);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jDialog=new JDialog();
                jDialog.setSize(500,500);
                jDialog.setLocationRelativeTo(container);
                jDialog.setLayout(null);
                jDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                jDialog.setVisible(true);
                JTextField jTextField1=new JTextField();
                JTextField jTextField2=new JTextField();
                JTextField jTextField3=new JTextField();
                JTextField jTextField4=new JTextField();
                JTextField jTextField5=new JTextField();
                JTextField jTextField6=new JTextField();
                JTextField jTextField7=new JTextField();
                JTextField jTextField8=new JTextField();
                JTextField jTextField9=new JTextField();
                JTextField jTextField10=new JTextField();
                JTextField jTextField11=new JTextField();
                jTextField1.setBounds(50,10,150,50);
                jTextField2.setBounds(50,70,150,50);
                jTextField3.setBounds(50,130,150,50);
                jTextField4.setBounds(50,190,150,50);
                jTextField5.setBounds(50,250,150,50);
                jTextField6.setBounds(50,310,150,50);
                jTextField7.setBounds(300,10,150,50);
                jTextField8.setBounds(300,70,150,50);
                jTextField9.setBounds(300,130,150,50);
                jTextField10.setBounds(300,190,150,50);
                jTextField11.setBounds(300,250,150,50);
                jTextField1.setVisible(true);
                jTextField2.setVisible(true);
                jTextField3.setVisible(true);
                jTextField4.setVisible(true);
                jTextField5.setVisible(true);
                jTextField6.setVisible(true);
                jTextField7.setVisible(true);
                jTextField8.setVisible(true);
                jTextField9.setVisible(true);
                jTextField10.setVisible(true);
                jTextField11.setVisible(true);


                jDialog.add(jTextField1);
                jDialog.add(jTextField2);
                jDialog.add(jTextField3);
                jDialog.add(jTextField4);
                jDialog.add(jTextField5);
                jDialog.add(jTextField6);
                jDialog.add(jTextField7);
                jDialog.add(jTextField8);
                jDialog.add(jTextField9);
                jDialog.add(jTextField10);
                jDialog.add(jTextField11);

                JButton jButton11=new JButton("确认保存");
                jButton11.setBounds(300,310,150,50);
                jButton11.setVisible(true);
                jButton11.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String u1=jTextField1.getText();
                        String u2=jTextField2.getText();
                        String u3=jTextField3.getText();
                        String u4=jTextField4.getText();
                        String u5=jTextField5.getText();
                        String u6=jTextField6.getText();
                        String u7=jTextField7.getText();
                        String u8=jTextField8.getText();
                        String u9=jTextField9.getText();
                        String u10=jTextField10.getText();
                        String u11=jTextField11.getText();

                        String query3 ="insert into student(user,id,name,sex,class,phone,course1,score1,course2,score2,course3,score3)value(?,?,?,?,?,?,?,?,?,?,?,?)";
                        try {
                            Main.ps=Main.con.prepareStatement(query3);
                            Main.ps.setString(1,user1);
                            Main.ps.setString(2,u1);
                            Main.ps.setString(3,u2);
                            Main.ps.setString(4,u3);
                            Main.ps.setString(5,u4);
                            Main.ps.setString(6,u5);
                            Main.ps.setString(7,u6);
                            Main.ps.setString(8,u7);
                            Main.ps.setString(9,u8);
                            Main.ps.setString(10,u9);
                            Main.ps.setString(11,u10);
                            Main.ps.setString(12,u11);
                            int k=Main.ps.executeUpdate();
                            if(k>0){
                                JOptionPane.showMessageDialog(jDialog,"数据添加成功");
                                jDialog.setVisible(false);
                                jDialog.dispose();
                                table= connectAndUpdata(user1);
                                pane.setViewportView(table); // 重新设置滚动面板的视图组件为新的表格
                                pane.revalidate(); // 重新验证容器
                                pane.repaint(); // 重绘容器

                            }
                        } catch (Exception e1) {
                           e1.printStackTrace();
                        }
                    }

                });
                jDialog.add(jButton11);
            }
        });

        jButton2.setBounds(200,10,100,30);
        jButton2.setVisible(true);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //删除原来账号的所有信息
                String query4 ="delete from student where user = ? ";
                try {
                    Main.ps=Main.con.prepareStatement(query4);
                    Main.ps.setString(1,user1);
                    Main.ps.executeUpdate();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                String query5 ="insert into student(user,id,name,sex,class,phone,course1,score1,course2,score2,course3,score3)value(?,?,?,?,?,?,?,?,?,?,?,?)";
                int row=table.getRowCount();
                int column=table.getColumnCount();
                System.out.println(column);
                for(int i=0;i<row;i++){
                    String[] up=new String[column];
                    for(int j=0;j<column;j++){
                        up[j]= (String) table.getValueAt(i,j);
                    }
                    try {
                        Main.ps=Main.con.prepareStatement(query5);
                        Main.ps.setString(1,up[0]);
                        Main.ps.setString(2,up[1]);
                        Main.ps.setString(3,up[2]);
                        Main.ps.setString(4,up[3]);
                        Main.ps.setString(5,up[4]);
                        Main.ps.setString(6,up[5]);
                        Main.ps.setString(7,up[6]);
                        Main.ps.setString(8,up[7]);
                        Main.ps.setString(9,up[8]);
                        Main.ps.setString(10,up[9]);
                        Main.ps.setString(11,up[10]);
                        Main.ps.setString(12,up[11]);
                        Main.ps.executeUpdate();


                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                try {
                    table= connectAndUpdata(user1);
                    JOptionPane.showMessageDialog(container, "数据保存成功");
                    pane.setViewportView(table); // 重新设置滚动面板的视图组件为新的表格
                    pane.revalidate(); // 重新验证容器
                    pane.repaint(); // 重绘容器
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        jButton3.setBounds(350,10,100,30);
        jButton3.setVisible(true);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        add(jButton1);
        add(jButton2);
        add(jButton3);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    JTable connectAndUpdata(String user1) throws SQLException {
        String query2 ="select * from student where user = ?";
        Main.ps=Main.con.prepareStatement(query2);
        Main.ps.setString(1,user1);
        Main.res=Main.ps.executeQuery();

        int columnCount = Main.res.getMetaData().getColumnCount();
        DefaultTableModel model = new DefaultTableModel();
        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(Main.res.getMetaData().getColumnLabel(i));
        }
        while (Main.res.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                rowData[i] = Main.res.getObject(i + 1);
            }
            model.addRow(rowData);
        }


        return new JTable(model);
    }
}