package iostream;
import java.io.*;

public class size {
    public static void sizeOfFile(String path) {
        FileInputStream fis = null;
        int size = 0;

        try {
            fis = new FileInputStream(path);
            while (fis.read() != -1) {
                size++;
            }
            System.out.println("Kích thước của file là: " + size + " byte");
        } catch (IOException e) {
            System.out.println("Lỗi");
        } 
        finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                System.out.println("Lỗi");
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Nhập đường dẫn tới file: ");
            String path = reader.readLine();
            sizeOfFile(path);
        } catch (IOException e) {
            System.out.println("Lỗi");
        } 
        finally 
        {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng luồng đọc");
            }
        }
    }
}