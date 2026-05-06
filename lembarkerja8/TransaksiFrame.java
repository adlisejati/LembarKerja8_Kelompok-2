package lembarkerja8;

import javax.swing.*;

public class TransaksiFrame extends JFrame {
    JTextField kode, nis, buku;

    public TransaksiFrame() {
        setTitle("Transaksi");
        setSize(300,250);
        setLayout(null);

        add(new JLabel("Kode")).setBounds(20,20,100,25);
        add(new JLabel("NIS")).setBounds(20,50,100,25);
        add(new JLabel("Kode Buku")).setBounds(20,80,100,25);

        kode = new JTextField(); kode.setBounds(100,20,150,25);
        nis = new JTextField(); nis.setBounds(100,50,150,25);
        buku = new JTextField(); buku.setBounds(100,80,150,25);

        add(kode); add(nis); add(buku);

        JButton btn = new JButton("Pinjam");
        btn.setBounds(100,120,100,30);
        add(btn);

        btn.addActionListener(e -> {
            String data = kode.getText()+"|"+nis.getText()+"|"+buku.getText()
                    +"|2026-05-06|-|0";
            FileUtil.tambahData("transaksi.txt", data);
            JOptionPane.showMessageDialog(this,"Berhasil pinjam!");
        });

        setVisible(true);
    }
}