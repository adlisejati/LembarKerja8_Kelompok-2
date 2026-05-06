package lembarkerja8;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Perpustakaan");
        setSize(400,300);
        setLayout(null);

        JButton s = new JButton("Siswa");
        JButton b = new JButton("Buku");
        JButton t = new JButton("Transaksi");
        JButton l = new JButton("Laporan");

        s.setBounds(120,30,150,30);
        b.setBounds(120,70,150,30);
        t.setBounds(120,110,150,30);
        l.setBounds(120,150,150,30);

        add(s); add(b); add(t); add(l);

        s.addActionListener(e -> new SiswaFrame());
        b.addActionListener(e -> new BukuFrame());
        t.addActionListener(e -> new TransaksiFrame());
        l.addActionListener(e -> new LaporanFrame());

        setLocationRelativeTo(null);
        setVisible(true);
    }
}