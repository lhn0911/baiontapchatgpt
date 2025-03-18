package entity;

import java.util.Scanner;

public class main {
    private static Categories[] categories = new Categories[100];
    private static Products[] products = new Products[100];
    private static int categoryCount = 0;
    private static int productCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("*********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    manageCategories(scanner);
                    break;
                case 2:
                    manageProducts(scanner);
                    break;
                case 3:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void manageCategories(Scanner scanner) {
        while (true) {
            System.out.println("********************CATEGORIE MANAGEMENT*********************");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm danh mục theo tên");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    listCategories();
                    break;
                case 2:
                    addCategory(scanner);
                    break;
                case 3:
                    updateCategory(scanner);
                    break;
                case 4:
                    deleteCategory(scanner);
                    break;
                case 5:
                    searchCategory(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void listCategories() {
        for (int i = 0; i < categoryCount; i++) {
            categories[i].displayData();
        }
    }

    private static void addCategory(Scanner scanner) {
        if (categoryCount < categories.length) {
            Categories category = new Categories();
            category.inputData(scanner, false);
            categories[categoryCount++] = category;
        } else {
            System.out.println("Không thể thêm danh mục mới!");
        }
    }


    private static void updateCategory(Scanner scanner) {
        System.out.print("Nhập mã danh mục cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].getId_category() == id) {
                System.out.println("Nhập thông tin mới cho danh mục: ");
                categories[i].inputData(scanner, true);
                System.out.println("Cập nhật danh mục thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục!");
    }


    private static void deleteCategory(Scanner scanner) {
        System.out.print("Nhập mã danh mục cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].getId_category() == id) {
                categories[i] = categories[--categoryCount];
                System.out.println("Xóa danh mục thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục!");
    }

    private static void searchCategory(Scanner scanner) {
        System.out.print("Nhập tên danh mục cần tìm: ");
        String name = scanner.nextLine();
        for (Categories category : categories) {
            if (category != null && category.getName_category().contains(name)) {
                category.displayData();
            }
        }
    }

    private static void manageProducts(Scanner scanner) {
        while (true) {
            System.out.println("************************PRODUCT MANAGEMENT*******************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề");
            System.out.println("6. Tìm kiếm sản phẩm theo khoảng giá bán");
            System.out.println("7. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Thống kê số lượng sản phẩm theo danh mục");
            System.out.println("10. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    listProducts();
                    break;
                case 2:
                    addProduct(scanner);
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    deleteProduct(scanner);
                    break;
                case 5:
                    searchProduct(scanner);
                    break;
                case 6:
                    searchByPrice(scanner);
                    break;
                case 7:
                    sortProducts();
                    break;
                case 8:
                    sellProduct(scanner);
                    break;
                case 9:
                    statisticByCategory();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void listProducts() {
        for (int i = 0; i < productCount; i++) {
            products[i].displayData();
        }
    }

    private static void addProduct(Scanner scanner) {
        if (productCount < products.length) {
            Products product = new Products();
            product.inputData(scanner, false);
            products[productCount++] = product;
        } else {
            System.out.println("Không thể thêm sản phẩm mới!");
        }
    }


    private static void updateProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String id = scanner.nextLine().trim();

        for (int i = 0; i < productCount; i++) {
            if (products[i].getId_product().equals(id)) {
                System.out.println("Nhập thông tin mới cho sản phẩm: ");
                products[i].inputData(scanner, true);
                System.out.println("Cập nhật sản phẩm thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }


    private static void deleteProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String id = scanner.nextLine();
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId_product().equals(id)) {
                products[i] = products[--productCount];
                System.out.println("Xóa sản phẩm thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }

    private static void searchProduct(Scanner scanner) {
        System.out.print("Nhập tên hoặc tiêu đề sản phẩm");
        String name = scanner.nextLine();
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName_product().equals(name)) {
                products[i].displayData();
                return;
            }
        }
    }

    private static void searchByPrice(Scanner scanner) {
        System.out.print("Nhập khoảng giá tối thiểu: ");
        float minPrice = scanner.nextFloat();
        System.out.print("Nhập khoảng giá tối đa: ");
        float maxPrice = scanner.nextFloat();
        scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getImport_price() >= minPrice && products[i].getExport_price() <= maxPrice) {
                products[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm trong khoảng giá này!");
        }
    }

    private static void sortProducts() {
        for (int i = 0; i < productCount - 1; i++) {
            for (int j = i + 1; j < productCount; j++) {
                if (products[i].getExport_price() > products[j].getExport_price()) {
                    Products temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("Sản phẩm đã được sắp xếp theo giá bán tăng dần.");
        listProducts();
    }

    private static void sellProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần bán: ");
        String id = scanner.nextLine();

        for (int i = 0; i < productCount; i++) {
            if (products[i].getId_product().equals(id)) {
                System.out.print("Nhập số lượng cần bán: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                if (quantity <= 0) {
                    System.out.println("Số lượng không hợp lệ!");
                    return;
                }

                if (products[i].getQuantity() >= quantity) {
                    products[i].setQuantity(products[i].getQuantity() - quantity);
                    System.out.println("Bán sản phẩm thành công!");
                } else {
                    System.out.println("Số lượng sản phẩm không đủ!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }

    private static void statisticByCategory() {
        if (categoryCount == 0) {
            System.out.println("Chưa có danh mục nào!");
            return;
        }

        for (int i = 0; i < categoryCount; i++) {
            int count = 0;
            for (int j = 0; j < productCount; j++) {
                if (products[j].getId_category() == categories[i].getId_category()) {
                    count++;
                }
            }
            System.out.println("Danh mục: " + categories[i].getName_category() + " - Số lượng sản phẩm: " + count);
        }
    }


}
