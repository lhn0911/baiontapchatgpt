package entity;

import java.util.Scanner;

/**
 * Lớp Categories đại diện cho danh mục sản phẩm
 * Thực thi interface IApp
 */
public class Categories implements IApp {
    private int id;
    private String name;
    private int priority;
    private String description;
    private boolean status;

    // Constructor không tham số
    public Categories() {}

    // Constructor có tham số
    public Categories(int id, String name, int priority, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.priority = Math.max(priority, 0); // Đảm bảo độ ưu tiên không âm
        this.description = limitDescription(description);
        this.status = status;
    }

    // Getter và Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) {
        if (name.length() >= 6 && name.length() <= 50) {
            this.name = name;
        } else {
            System.out.println("Tên danh mục phải từ 6 đến 50 ký tự!");
        }
    }

    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = Math.max(priority, 0); }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = limitDescription(description); }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    // Giới hạn mô tả không quá 255 ký tự
    private String limitDescription(String desc) {
        return (desc.length() > 255) ? desc.substring(0, 255) : desc;
    }

    /**
     * Nhập dữ liệu danh mục
     * @param scanner Đối tượng Scanner để nhập dữ liệu
     * @param isUpdate True nếu là cập nhật, False nếu là thêm mới
     */
    @Override
    public void inputData(Scanner scanner, boolean isUpdate) {
        if (!isUpdate) {
            System.out.print("Nhập mã danh mục: ");
            this.id = Integer.parseInt(scanner.nextLine().trim());
        }

        System.out.print("Nhập tên danh mục: ");
        setName(scanner.nextLine().trim());

        System.out.print("Nhập độ ưu tiên: ");
        setPriority(Integer.parseInt(scanner.nextLine().trim()));

        System.out.print("Nhập mô tả: ");
        setDescription(scanner.nextLine().trim());

        System.out.print("Nhập trạng thái (true/false): ");
        setStatus(Boolean.parseBoolean(scanner.nextLine().trim()));
    }

    /**
     * Hiển thị thông tin danh mục
     */
    @Override
    public void displayData() {
        System.out.printf("Mã danh mục: %d\nTên danh mục: %s\nĐộ ưu tiên: %d\nMô tả: %s\nTrạng thái: %s\n",
                id, name, priority, description, status ? "Hoạt động" : "Không hoạt động");
    }
}
