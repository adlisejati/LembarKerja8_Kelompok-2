package lembarkerja8;
import java.io.*;
import javax.swing.*;

public class TransaksiFrame extends JFrame {

    JTextField kode, nis, buku, kodeKembali;

    public TransaksiFrame() {
        setTitle("Transaksi");
        setSize(350,300);
        setLayout(null);

        // PINJAM
        add(new JLabel("Kode")).setBounds(20,20,100,25);
        add(new JLabel("NIS")).setBounds(20,50,100,25);
        add(new JLabel("Kode Buku")).setBounds(20,80,100,25);

        kode = new JTextField(); kode.setBounds(120,20,150,25);
        nis = new JTextField(); nis.setBounds(120,50,150,25);
        buku = new JTextField(); buku.setBounds(120,80,150,25);

        add(kode); add(nis); add(buku);

        JButton pinjam = new JButton("Pinjam");
        pinjam.setBounds(120,110,100,30);
        add(pinjam);

        pinjam.addActionListener(e -> pinjam());

        // KEMBALI
        add(new JLabel("Kode Transaksi")).setBounds(20,160,120,25);

        kodeKembali = new JTextField();
        kodeKembali.setBounds(140,160,130,25);
        add(kodeKembali);

        JButton kembali = new JButton("Kembalikan");
        kembali.setBounds(120,200,120,30);
        add(kembali);

        kembali.addActionListener(e -> kembali());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // PINJAM
    void pinjam() {
        String data = kode.getText()+"|"+nis.getText()+"|"+buku.getText()
                +"|2026-05-06|-|0";

        FileUtil.tambahData("transaksi.txt", data);
        JOptionPane.showMessageDialog(this,"Buku dipinjam!");
    }

    // KEMBALI
    void kembali() {
        try {
            String kodeInput = kodeKembali.getText();

            File inputFile = new File("transaksi.txt");
            File tempFile = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data[0].equals(kodeInput)) {
                    data[4] = "2026-05-06"; // tanggal kembali
                    data[5] = "1";          // status

                    line = String.join("|", data);
                }

                bw.write(line);
                bw.newLine();
            }

            br.close();
            bw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            JOptionPane.showMessageDialog(this,"Buku berhasil dikembalikan!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error pengembalian!");
        }
    }
}