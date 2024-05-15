package iostream;
import java.io.*;
import java.util.*;

public class delete {
	public static void Delete_File(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null) {
				for (int i = 0; i<files.length;i++) {
					Delete_File(files[i]);
				}
			}
		}
		file.delete();
		System.out.println(file.getName() + " đã được xoá");
		
	}
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Nhập đường dẫn của thư mục hoặc tệp cần xoá: ");
            String path = reader.readLine();
            File file = new File(path);

            if (!file.exists()) {
                System.out.println("Thư mục hoặc tệp không tồn tại");
            } 
            else {
            	Delete_File(file);
            }
        } catch (IOException e) {
            System.out.println("Lỗi");    
        } 
        
        finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng luồng đọc");
            }
        }
	}
}