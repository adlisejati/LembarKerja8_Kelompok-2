package lembarkerja8;

import javax.swing.*;

public class BukuFrame extends JFrame {
    JTextField kode, judul, jenis;

    public BukuFrame() {
        setTitle("Buku");
        setSize(300,250);
        setLayout(null);

        add(new JLabel("Kode")).setBounds(20,20,100,25);
        add(new JLabel("Judul")).setBounds(20,50,100,25);
        add(new JLabel("Jenis")).setBounds(20,80,100,25);

        kode = new JTextField(); kode.setBounds(100,20,150,25);
        judul = new JTextField(); judul.setBounds(100,50,150,25);
        jenis = new JTextField(); jenis.setBounds(100,80,150,25);

        add(kode); add(judul); add(jenis);

        JButton btn = new JButton("Simpan");
        btn.setBounds(100,120,100,30);
        add(btn);

        btn.addActionListener(e -> {
            FileUtil.tambahData("buku.txt",
                    kode.getText()+"|"+judul.getText()+"|"+jenis.getText());
            JOptionPane.showMessageDialog(this,"Tersimpan!");
        });

        setVisible(true);
    }
}