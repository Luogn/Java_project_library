# Integrated English Dictionary (Từ điển Tiếng Anh Tích hợp)

## Mô tả dự án

Đây là một dự án Từ điển Tiếng Anh đa chức năng, được phát triển bởi các sinh viên Trường Đại học Công nghệ (UET). Hệ thống được xây dựng bằng Java cho phần xử lý logic và sử dụng CSS để tạo kiểu cho giao diện người dùng.

Dự án cung cấp các chức năng chính sau:

* Một từ điển tiếng Anh đa chức năng.
* Tính năng dịch văn bản.
* Các trò chơi từ vựng tương tác.

## Công nghệ sử dụng

* **Ngôn ngữ chính:** Java [cite: 1]
* **Styling Giao diện:** CSS [cite: 1]
* **Build Tool:** Apache Maven

## Cấu trúc thư mục/mã nguồn

* `pom.xml`: File cấu hình dự án cho Apache Maven, quản lý các dependency và quá trình build. [cite: 1]
* `src/main/`: Thư mục chứa mã nguồn chính của ứng dụng Java và các tài nguyên liên quan. [cite: 1]
* `.gitignore`: File định nghĩa các tệp và thư mục mà Git nên bỏ qua. [cite: 1]

## Cách cài đặt và chạy dự án

### Yêu cầu tiên quyết

1.  **Java Development Kit (JDK):** Cài đặt JDK (phiên bản phù hợp được định nghĩa trong `pom.xml`, thường là 8 trở lên).
2.  **Apache Maven:** Cài đặt Maven để build dự án.

### Các bước thực hiện

1.  **Clone repository:**
    ```bash
    git clone [https://github.com/Luogn/Java_project_library.git](https://github.com/Luogn/Java_project_library.git)
    cd Java_project_library
    ```
2.  **Build dự án:**
    Sử dụng Maven để tải các dependency và build dự án. Mở Terminal hoặc Command Prompt tại thư mục gốc của dự án và chạy:
    ```bash
    mvn clean install
    ```
    Lệnh này sẽ tạo ra một file `.jar` trong thư mục `target`.

3.  **Chạy dự án:**
    * Tìm file `.jar` đã được build trong thư mục `target`.
    * Chạy ứng dụng bằng lệnh:
        ```bash
        java -jar target/<tên-file-jar-của-bạn>.jar
        ```
    * Tên file jar và Main Class cụ thể được định nghĩa trong `pom.xml`.

## Cách sử dụng

Sau khi khởi chạy thành công, ứng dụng Từ điển Tiếng Anh sẽ mở ra. Người dùng tương tác với giao diện để tra từ, sử dụng tính năng dịch văn bản và tham gia các trò chơi từ vựng.

## Tác giả

* **Lưu Quang Khải**
* **Hồ Nguyên Lượng**
* **Nguyễn Thế Kiên**

Nhóm sinh viên UET thực hiện dự án trong khuôn khổ học phần Lập trình hướng đối tượng.

## Giấy phép

Dự án này không có giấy phép được chỉ định.
