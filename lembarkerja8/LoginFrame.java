package lembarkerja8;

import javax.swing.*;

public class LoginFrame extends JFrame {
    JTextField nip;

    public LoginFrame() {
        setTitle("Login");
        setSize(300,150);
        setLayout(null);

        JLabel l = new JLabel("NIP:");
        l.setBounds(20,20,100,25);
        add(l);

        nip = new JTextField();
        nip.setBounds(100,20,150,25);
        add(nip);

        JButton btn = new JButton("Login");
        btn.setBounds(90,60,100,30);
        add(btn);

        btn.addActionListener(e -> login());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void login() {
        if (FileUtil.cekData("pegawai.txt", nip.getText())) {
            JOptionPane.showMessageDialog(this, "Login berhasil!");
            new MainFrame();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Login gagal!");
        }
    }
}