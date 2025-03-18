package entity;

import java.util.Scanner;

public interface IApp {
    float INTEREST = 1.1f;
    void inputData(Scanner scanner , boolean isUpdate);
    void displayData();
}