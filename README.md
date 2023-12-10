# Object-Oriented Programming
Object-Oriented Programming exams in VNU University of Science (2022 - 2023)

# Midterm Exam:
   - **MyList:**
      - Tạo ra một list kiểu MyArrayList có các phần tử dữ liệu kiểu Double.
        - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
        - In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
      - Tạo ra một list kiểu MyLinkedList có các phần tử dữ liệu kiểu Double.
        - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
        - In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
          
      ![image](https://github.com/dangth2011/Object-Oriented-Programming/assets/152959080/262597c7-71da-4a5e-a53d-03a09a6f8d3f)


   - **Statistics:**
      - Tạo ra một set kiểu ArrayDataSet có các phần tử dữ liệu kiểu Double.
        - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, trung vị).
      - Tạo ra một set kiểu ListDataSet có các phần tử dữ liệu kiểu Double.
        - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, trung vị).
          
      ![image](https://github.com/dangth2011/Object-Oriented-Programming/assets/152959080/9e5c1574-8488-4932-ac68-2047e305b211)


   - **Trong đó:**
      - Kỳ vọng mẫu (mean): $\overline{X} = \dfrac{1}{n}\sum\limits_{i=1}^{n} x_i$.
      - Phương sai mẫu (variance): $s^2 = \dfrac{1}{n}\sum\limits_{i=1}^{n} (x_i - \overline{X})^2$.
      - Rank được tính theo quy luật sau:
        - tập [3 1 4] có các rank [2.0 1.0 3.0].
        - tập [3 1 3 5] có các rank [2.5 1.0 4.0] (các phần tử có giá trị bằng nhau có rank được tính bằng trung bình các chỉ số của các phần tử trong tập dữ liệu, chỉ sổ bắt đầu là 1).
      - Trung vị (median) được tính theo quy luật sau:
        -  [1 3 3 6 7 8 9] thì median = 6 (giá trị của phần tử ở giữa).
        -  [1 2 3 4 5 6 8 9] thì median = $\dfrac{4+5}{2}$ = 4.5 (trung bình 2 giá trị của 2 phần tử ở giữa).
# Final Exam:
   - **IntegrationCalculator:**
      - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức, sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết giá trị của x).
      - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức, sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết giá trị của x).
      - Tạo một đa thức.
         - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
         - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
      - Các phương pháp tính tích phân tham khảo tại [đây](https://www.sfu.ca/math-coursenotes/Math%20158%20Course%20Notes/sec_Numerical_Integration.html)
        
        ![image](https://github.com/dangth2011/Object-Oriented-Programming/assets/152959080/dbeb95ef-3fe3-43ac-989c-8d636ccb08b1)


   - **Matrix:**
      - Tạo ra 2 ma trận vuông có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10]. Các phần tử của ma trận được khởi tạo ngẫu nhiên có giá trị nằm trong đoạn [1, 10].
      - Viết code thực hiện test các chức năng sau của các ma trận:
         - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
         - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
         - In ra ma trận là ma trận tổng của 2 ma trận.
         - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
         - In ra ma trận là ma trận tích của 2 ma trận.
         - Tìm và in ra một ma trận dạng hình thang theo hàng (row echelon form) dùng phép khử Gauss của 2 ma trận.
         - Tìm và in ra ma trận dạng hình thang theo hàng rút gọn (reduced row echelon form) dùng phép khử Gauss-Jordan.
      - Thuật toán khử Gauss tham khảo tại [đây](https://www.baeldung.com/cs/solving-system-linear-equations)
        
        ![image](https://github.com/dangth2011/Object-Oriented-Programming/assets/152959080/be7a78b7-4a13-48a3-b0f2-e462c90e1474)


   - **BookManager:**
      -  Hoàn thiện các hàm được cho trong các file source code mẫu được cung cấp.
      -  Thực hiện tất cả các phương thức trong lớp client App.java.
        
        ![image](https://github.com/dangth2011/Object-Oriented-Programming/assets/152959080/1f4ec8c8-37f2-490d-887f-c37502155f6c)


   - **MyBookManager:**
      - Xây dựng các List kiểu ArrayList và LinkedList để lưu trữ dữ liệu.
      - Hoàn thiện các hàm được cho trong các file source code mẫu được cung cấp.
      - Thực hiện tất cả các phương thức trong lớp client App.java.
        
        ![image](https://github.com/dangth2011/Object-Oriented-Programming/assets/152959080/42d6e552-20f2-40c1-bed2-91b37dd1e910)

