package entity;

import java.util.Scanner;

public class Product implements IApp {
    private static final int MIN_NAME_LENGTH = 10;
    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_TITLE_LENGTH = 200;
    private static final float INTEREST_RATE = 1.2f;

    private String idProduct;
    private String nameProduct;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String description;
    private int quantity;
    private int categoryId;
    private int status;

    public Product() {}

    public Product(String idProduct, String nameProduct, float importPrice, float exportPrice,
                   String title, String description, int quantity, int categoryId, int status) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.status = status;
    }

    // Getter & Setter
    public String getIdProduct() { return idProduct; }
    public void setIdProduct(String idProduct) { this.idProduct = idProduct; }
    public String getNameProduct() { return nameProduct; }
    public void setNameProduct(String nameProduct) { this.nameProduct = nameProduct; }
    public float getImportPrice() { return importPrice; }
    public void setImportPrice(float importPrice) { this.importPrice = importPrice; }
    public float getExportPrice() { return exportPrice; }
    public void setExportPrice(float exportPrice) { this.exportPrice = exportPrice; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    @Override
    public void inputData(Scanner scanner, boolean isUpdate) {
        if (!isUpdate) {
            this.idProduct = inputProductId(scanner);
        }
        this.nameProduct = inputProductName(scanner);
        this.importPrice = inputPrice(scanner, "Nhập giá nhập (lớn hơn 0): ", 0);
        this.exportPrice = inputPrice(scanner, "Nhập giá xuất (lớn hơn giá nhập * " + INTEREST_RATE + "): ", this.importPrice * INTEREST_RATE);
        this.title = inputText(scanner, "Nhập tiêu đề sản phẩm: ", MAX_TITLE_LENGTH);
        this.description = inputText(scanner, "Nhập mô tả sản phẩm: ", Integer.MAX_VALUE);
        this.quantity = (int) inputPrice(scanner, "Nhập số lượng sản phẩm: ", 0);
        this.categoryId = (int) inputPrice(scanner, "Nhập mã danh mục: ", 0);
        this.status = inputStatus(scanner);
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " + idProduct);
        System.out.println("Tên sản phẩm: " + nameProduct);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Mô tả: " + description);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mã danh mục: " + categoryId);
        System.out.println("Trạng thái: " + getStatusText());
    }

    private String inputProductId(Scanner scanner) {
        while (true) {
            System.out.print("Nhập mã sản phẩm (5 ký tự bắt đầu bằng C, E, hoặc T): ");
            String id = scanner.nextLine().trim();
            if (id.matches("^[CET]\\w{4}$")) {
                return id;
            }
            System.out.println("Mã sản phẩm không hợp lệ. Hãy thử lại!");
        }
    }

    private String inputProductName(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên sản phẩm (10-100 ký tự): ");
            String name = scanner.nextLine().trim();
            if (name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH) {
                return name;
            }
            System.out.println("Tên sản phẩm không hợp lệ. Hãy thử lại!");
        }
    }

    private float inputPrice(Scanner scanner, String message, float minValue) {
        while (true) {
            System.out.print(message);
            try {
                float price = Float.parseFloat(scanner.nextLine().trim());
                if (price > minValue) {
                    return price;
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Giá không hợp lệ. Hãy thử lại!");
        }
    }

    private String inputText(Scanner scanner, String message, int maxLength) {
        System.out.print(message);
        String text = scanner.nextLine().trim();
        return text.length() > maxLength ? text.substring(0, maxLength) : text;
    }

    private int inputStatus(Scanner scanner) {
        while (true) {
            System.out.print("Nhập trạng thái sản phẩm (0 - Đang hoạt động, 1 - Hết hàng, 2 - Không hoạt động): ");
            try {
                int status = Integer.parseInt(scanner.nextLine().trim());
                if (status >= 0 && status <= 2) {
                    return status;
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Trạng thái không hợp lệ. Hãy thử lại!");
        }
    }

    private String getStatusText() {
        return switch (status) {
            case 0 -> "Đang hoạt động";
            case 1 -> "Hết hàng";
            case 2 -> "Không hoạt động";
            default -> "Không xác định";
        };
    }
}
