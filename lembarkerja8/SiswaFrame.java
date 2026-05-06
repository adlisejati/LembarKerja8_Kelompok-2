package lembarkerja8;

import javax.swing.*;

public class SiswaFrame extends JFrame {
    JTextField nis, nama, alamat;

    public SiswaFrame() {
        setTitle("Siswa");
        setSize(300,250);
        setLayout(null);

        add(new JLabel("NIS")).setBounds(20,20,100,25);
        add(new JLabel("Nama")).setBounds(20,50,100,25);
        add(new JLabel("Alamat")).setBounds(20,80,100,25);

        nis = new JTextField(); nis.setBounds(100,20,150,25);
        nama = new JTextField(); nama.setBounds(100,50,150,25);
        alamat = new JTextField(); alamat.setBounds(100,80,150,25);

        add(nis); add(nama); add(alamat);

        JButton btn = new JButton("Simpan");
        btn.setBounds(100,120,100,30);
        add(btn);

        btn.addActionListener(e -> {
            FileUtil.tambahData("siswa.txt",
                    nis.getText()+"|"+nama.getText()+"|"+alamat.getText());
            JOptionPane.showMessageDialog(this,"Tersimpan!");
        });

        setVisible(true);
    }
}