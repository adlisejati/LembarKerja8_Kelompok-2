package lembarkerja8;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LaporanFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    public LaporanFrame() {
        setTitle("Laporan Perpustakaan");
        setSize(650, 400);
        setLayout(new BorderLayout());

        String[] kolom = {
                "Kode", "NIS", "Kode Buku", "Tgl Pinjam", "Tgl Kembali", "Status"
        };

        model = new DefaultTableModel(kolom, 0);
        table = new JTable(model);

        // Styling biar makin enak dilihat
        table.setRowHeight(25);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        add(new JScrollPane(table), BorderLayout.CENTER);

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

                if (data.length >= 6) {

                    // 🔥 UBAH STATUS JADI TEKS
                    if (data[5].trim().equals("0")) {
                        data[5] = "Belum Kembali";
                    } else {
                        data[5] = "Sudah Kembali";
                    }

                    model.addRow(data);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error membaca file!");
        }
    }
}