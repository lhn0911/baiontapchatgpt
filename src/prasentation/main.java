package prasentation;

import entity.Categories;

import java.util.*;

public class Main {
    private static List<Categories> categories = new ArrayList<>();
    private static List<Products> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("********** SHOP MENU **********");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = getValidInt();
            switch (choice) {
                case 1 -> manageCategories();
                case 2 -> manageProducts();
                case 3 -> {
                    System.out.println("Thoát chương trình!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Quản lý danh mục
    private static void manageCategories() {
        while (true) {
            System.out.println("********** CATEGORY MANAGEMENT **********");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm danh mục");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = getValidInt();
            switch (choice) {
                case 1 -> categories.forEach(Categories::displayData);
                case 2 -> addCategory();
                case 3 -> updateCategory();
                case 4 -> deleteCategory();
                case 5 -> searchCategory();
                case 6 -> { return; }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addCategory() {
        Categories category = new Categories();
        category.inputData(scanner, false);
        categories.add(category);
        System.out.println("Thêm danh mục thành công!");
    }

    private static void updateCategory() {
        System.out.print("Nhập mã danh mục cần cập nhật: ");
        int id = getValidInt();
        Categories category = categories.stream()
                .filter(c -> c.getId_category() == id)
                .findFirst().orElse(null);

        if (category != null) {
            category.inputData(scanner, true);
            System.out.println("Cập nhật danh mục thành công!");
        } else {
            System.out.println("Không tìm thấy danh mục!");
        }
    }

    private static void deleteCategory() {
        System.out.print("Nhập mã danh mục cần xóa: ");
        int id = getValidInt();
        categories.removeIf(category -> category.getId_category() == id);
        System.out.println("Xóa danh mục thành công!");
    }

    private static void searchCategory() {
        System.out.print("Nhập tên danh mục cần tìm: ");
        String name = scanner.nextLine();
        categories.stream()
                .filter(category -> category.getName_category().contains(name))
                .forEach(Categories::displayData);
    }

    // Quản lý sản phẩm
    private static void manageProducts() {
        while (true) {
            System.out.println("********** PRODUCT MANAGEMENT **********");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = getValidInt();
            switch (choice) {
                case 1 -> products.forEach(Products::displayData);
                case 2 -> addProduct();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> searchProduct();
                case 6 -> { return; }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addProduct() {
        Products product = new Products();
        product.inputData(scanner, false);
        products.add(product);
        System.out.println("Thêm sản phẩm thành công!");
    }

    private static void updateProduct() {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String id = scanner.nextLine().trim();
        Products product = products.stream()
                .filter(p -> p.getId_product().equals(id))
                .findFirst().orElse(null);

        if (product != null) {
            product.inputData(scanner, true);
            System.out.println("Cập nhật sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    private static void deleteProduct() {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String id = scanner.nextLine();
        products.removeIf(product -> product.getId_product().equals(id));
        System.out.println("Xóa sản phẩm thành công!");
    }

    private static void searchProduct() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();
        products.stream()
                .filter(product -> product.getName_product().contains(name))
                .forEach(Products::displayData);
    }

    // Hàm hỗ trợ nhập số nguyên hợp lệ
    private static int getValidInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập số nguyên hợp lệ: ");
            }
        }
    }
}
