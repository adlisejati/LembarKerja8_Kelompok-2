package lembarkerja8;

import java.io.*;

public class FileUtil {

    // 🔹 Tambah data ke file
    public static void tambahData(String file, String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error menulis file: " + e.getMessage());
        }
    }

    // 🔹 Tampilkan semua isi file
    public static void tampilData(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error membaca file: " + e.getMessage());
        }
    }

    // 🔹 Cek apakah data (berdasarkan kolom pertama) ada
    public static boolean cekData(String file, String key) {
        try {
            File f = new File(file);

            // kalau file belum ada → langsung false
            if (!f.exists()) {
                System.out.println("File tidak ditemukan: " + file);
                return false;
            }

            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue; // skip baris kosong

                String[] data = line.split("\\|");

                if (data.length > 0) {
                    if (data[0].trim().equals(key.trim())) {
                        br.close();
                        return true;
                    }
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error cek data: " + e.getMessage());
        }

        return false;
    }
}