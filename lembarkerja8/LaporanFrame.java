package lembarkerja8;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LaporanFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    public LaporanFrame() {
        setTitle("Laporan Belum Kembali");
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Header kolom
        String[] kolom = {
                "Kode", "NIS", "Kode Buku", "Tgl Pinjam", "Tgl Kembali", "Status"
        };

        model = new DefaultTableModel(kolom, 0);
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // Tombol refresh
        JButton refresh = new JButton("Refresh");
        add(refresh, BorderLayout.SOUTH);

        refresh.addActionListener(e -> tampil());

        tampil();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void tampil() {
        model.setRowCount(0); // reset tabel

        try (BufferedReader br = new BufferedReader(new FileReader("transaksi.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;

                String[] data = line.split("\\|");

                if (data.length >= 6 && data[5].trim().equals("0")) {
                    model.addRow(data);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error membaca file!");
        }
    }
}
