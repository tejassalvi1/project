package com.hexaware.FTP109.util;
import java.util.Scanner;
import java.util.List;
import com.hexaware.FTP109.factory.MenuFactory;
import com.hexaware.FTP109.factory.CustomerFactory;
import com.hexaware.FTP109.factory.OrderFactory;
import com.hexaware.FTP109.factory.WalletFactory;
import com.hexaware.FTP109.factory.VendorFactory;
import com.hexaware.FTP109.model.Orders;
import com.hexaware.FTP109.model.Vendor;
import com.hexaware.FTP109.model.MenuDetails;
import com.hexaware.FTP109.model.OrderStatus;
import com.hexaware.FTP109.model.Customer;
import com.hexaware.FTP109.model.Wallet;
import java.text.SimpleDateFormat;
import com.hexaware.FTP109.factory.Validators;
import java.util.Date;
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
/**
 * mainMenu method  used to display the option we had in the application.
 */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("------------------------------------------------");
    System.out.println("1. Show Menu");
    System.out.println("2. Create Order");
    System.out.println("3. Order Details for Customer");
    System.out.println("4. Pending Order Details for Vendor");
    System.out.println("5. All Order Status For Vendor");
    System.out.println("6. Accept/Reject");
    System.out.println("7. Customer Details");
    System.out.println("8. Vendor Details");
    System.out.println("9. Exit");
    System.out.println("-----------------------------------------------");
    mainMenuDetails();
  }
/**
 * mainMenuDetails method  process the option selected from main menu.
 */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullMenu();
          break;
        case 2:
          createOrder();
          break;
        case 3:
          showOrderDetails();
          break;
        case 4:
          showPendingOrder();
          break;
        case 5:
          showOrderStatus();
          break;
        case 6:
          showDecision();
          break;
        case 7:
          showCustomerDetails();
          break;
        case 8:
          showFullVendorDetails();
          break;
        case 9:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Select your option");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }
/**
 * showFullMenu method  display the menu item stored in database.
 */
  private void showFullMenu() {

    List<MenuDetails> menuDetailsList = MenuFactory.getMenuDetails();
    System.out.println("----------------------------------------------------------------------------------------------------------");
    System.out.printf("%10s %20s %15s %15s %15s %10s", "Food_Id", "Food Name", "Food Price", "Vendor Id", "Vendor Name", "Ratings");
    System.out.println();
    System.out.println("----------------------------------------------------------------------------------------------------------");
    for (MenuDetails menuDetails: menuDetailsList) {
      System.out.format("%8d %23s %13.2f %13d %17s %8d", menuDetails.getFoodId(), menuDetails.getFoodName(), menuDetails.getFoodPrice(),
          menuDetails.getVendorId(), menuDetails.getVendorName(), menuDetails.getRatings());
      System.out.println();
    }
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println();
  }
 /**
 * createOrder method  creates the order and stores in database.
 */
  private void createOrder() {
    //int walValidate = 1;
    System.out.println("Enter customer Id");
    int custId = option.nextInt();
    System.out.println("Enter the Password...");
    String password = option.next();
    try {
      Validators.validateCustomerId(custId, password);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      mainMenu();
    }
    System.out.println("Enter vendor Id");
    int vendorId = option.nextInt();
    try {
      Validators.validateVendorId(vendorId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      mainMenu();
    }

    System.out.println("Enter Food Id");
    int foodId = option.nextInt();
    try {
      Validators.validateFoodId(foodId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      mainMenu();
    }
    try {
      Validators.validateVenFoodId(vendorId, foodId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      mainMenu();
    }
    System.out.println("Enter Quantity");
    int qty = option.nextInt();
    double foodPrice = OrderFactory.getPrice(foodId, vendorId);
    double totalPrice = foodPrice * qty;
    System.out.println("total Price= " + totalPrice);
    System.out.println("Displaying wallet details for customer ");
    List<Wallet> wallet = WalletFactory.showWallet(custId);
    System.out.println("----------------------------------------------------------------------------------------------------");
    System.out.printf("%5s %15s %15s %13s", "WalletId", "Mode Of Pay", "Wal Bal", "custId");
    System.out.println();
    System.out.println("----------------------------------------------------------------------------------------------------");
    for (Wallet w : wallet) {
      //System.out.format("%10d %10s%n %10.2f %10d", w.getWalId(), w.getModPay(), w.getWalBal(), w.getWalCusId());
      System.out.print(w.getWalId() + "\t\t");
      System.out.print(w.getModPay() + "\t\t");
      System.out.print(w.getWalBal() + "\t\t");
      System.out.print(w.getWalCusId() + "\t");
      System.out.println();
      System.out.println("----------------------------------------------------------------------------------------------------");
    }
    System.out.println("Enter Wallet Id=");
    int walId = option.nextInt();
    try {
      Validators.validateWalletId(walId, custId);
      double balance = WalletFactory.getBalance(walId);
      if (balance > totalPrice) {
        Orders newOrder = new Orders(totalPrice, walId, custId, vendorId, "comments to give");
        int orderId =  OrderFactory.placeOrder(newOrder).getOrderId();
        OrderFactory.placeOrderItems(foodId, orderId, totalPrice, qty);
        System.out.println("order has been created...");
      } else {
        System.out.println("Order not placed due to insufficient balance...");
        mainMenu();
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
  private void showOrderDetails() {
    System.out.println("Enter Customer Id :");
    try {
      int custId = option.nextInt();
      System.out.println("Enter Password :");
      String password = option.next();
      CustomerFactory.showCusId(custId, password);
      List<Orders> orders = OrderFactory.getOrderDetails(custId);
      System.out.println("------------------------------------------------------------------------------------------------");
      System.out.printf("%10s %10s %10s %15s %20s %15s", "Order_Id", "Cust_Id", "Ven_id", "Order_Price", "Order_Date", "Order_Status");
      System.out.println();
      System.out.println("-------------------------------------------------------------------------------------------------");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String s1;
      Date d;
      for (Orders o : orders) {
        d = o.getOrderDate();
        s1 = sdf.format(d);
        System.out.printf("%10d %10d %10d %15.2f %20s %15S", o.getOrderId(), o.getCusId(), o.getVenId(), o.getOrderPrice(), s1, o.getOrderStatus());
        System.out.println();
      }
      System.out.println();
      System.out.println();
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
    }
  }
  private void showPendingOrder() {
    System.out.println("Enter Vendor Id :");
    try {
      int vendorId = option.nextInt();
      System.out.println("Enter Password :");
      String password = option.next();
      VendorFactory.showVenIdPassword(vendorId, password);
      List<Orders> orders = OrderFactory.getPendingOrders(vendorId, OrderStatus.PENDING);
      System.out.println("------------------------------------------------------------------------------------------------");
      System.out.printf("%10s %10s %10s %15s %15s %20s", "Order_Id", "Cust_Id", "Ven_id", "Order_Price", "Order_status", "Cus_Name");
      System.out.println();
      System.out.println("-------------------------------------------------------------------------------------------------");
      for (Orders o : orders) {
        System.out.printf("%10d %10d %10d %15.2f %15s %20s", o.getOrderId(), o.getCusId(), o.getVenId(), o.getOrderPrice(),
            o.getOrderStatus(), o.getCusName());
        System.out.println();
      }
      System.out.println();
      System.out.println();
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
    }
  }
  /**
 * showOrderStatus method  displays the status of the order stored in database.
 */
  private void showOrderStatus() {
    System.out.println("Enter the Vendor Id to check the Status ");
    int venId = option.nextInt();
    System.out.println("Enter Password");
    String password = option.next();
    try {
      VendorFactory.showVenIdPassword(venId, password);
      List<Orders> order = OrderFactory.showOrderStatus(venId);
      System.out.println("------------------------------------------------------------------------");
      System.out.printf("%10s %10s %15s %20s", "Vendor Id", "Order Id", "Order Status", "Order Date");
      System.out.println();
      System.out.println("------------------------------------------------------------------------");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String s2;
      Date date;
      for (Orders orderDetails : order) {
        date = orderDetails.getOrderDate();
        s2 = sdf.format(date);
        System.out.printf("%10d %10d %15s %20s", orderDetails.getVenId(), orderDetails.getOrderId(), orderDetails.getOrderStatus(), s2);
        System.out.println();
      }
      System.out.println();
      System.out.println();
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
    }
  }
 /**
 * showDecision method allows vendor to accept/reject the placed order.
 */
  private void showDecision() {
    System.out.println("Enter vendor Id");
    int venId = option.nextInt();
    System.out.println("Enter Password");
    String password = option.next();
    try {
      VendorFactory.showVenIdPassword(venId, password);
      System.out.println("Enter order Id");
      int ordId = option.nextInt();
      Validators.validateVendorOrderId(venId, ordId);
      System.out.println("1. Accept ");
      System.out.println("2. Reject ");
      int decision = option.nextInt();
      option.nextLine();
      System.out.println("why do you want to accept or reject???");
      String comments = option.nextLine();
      OrderStatus status = OrderStatus.REJECTED;
      if (decision == 1) {
        status = OrderStatus.ACCEPTED;
      }
      if (decision == 1) {
        double price = OrderFactory.getOrderPrice(venId, ordId);
        int walId = OrderFactory.getWalletId(ordId);
        double balance = WalletFactory.getBalance(walId);
        if (balance > price) {
          WalletFactory.cusDebit(price, walId);
          VendorFactory.updateVendorWallet(venId, price);
        }
      }
      OrderFactory.updateOrderStatus(status, venId, ordId, comments);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }

  }
/**
 * showFullMenu method  display the menu item stored in database.
 */
  private void showCustomerDetails() {
    System.out.println("Enter Customer Id :");
    try {
      int custId = option.nextInt();
      System.out.println("Enter Password :");
      String password = option.next();
      CustomerFactory.showCusId(custId, password);
      List<Customer> customer = CustomerFactory.showCustomer(custId);
      System.out.println("--------------------------------------------------------------------------");
      System.out.printf("%10s %20s %20s %20s", "Customer_Id", "Customer_name", "Customer_mobile", "Customer_Balance");
      System.out.println();
      System.out.println("--------------------------------------------------------------------------");
      for (Customer c : customer) {
        System.out.format("%10d %20s %20s %20s", c.getCusId(), c.getCusName(), c.getCusMob(), c.getCusTotalBalance());
        System.out.println();
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    System.out.println();
    System.out.println();
  }
  /**
 * showFullVendor method  display the vendor stored in database.
 */
  private void showFullVendorDetails() {
    System.out.println("Enter vendor Id");
    int vendorId = option.nextInt();
    try {
      System.out.println("Enter Password :");
      String password = option.next();
      VendorFactory.showVenIdPassword(vendorId, password);
      //Validators.validateVendorId(vendorId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      mainMenu();
    }
    List<Vendor> vendor = VendorFactory.showVendor(vendorId);
    System.out.println("--------------------------------------------------------------------------");
    System.out.printf("%10s %20s %20s  %10s", "Ven_Id", "Ven_Name", "Ven_Mob", "Ven_Bal");
    System.out.println();
    System.out.println("--------------------------------------------------------------------------");
    for (Vendor v : vendor) {
      System.out.format("%10d %20s %20s %10.2f", v.getVenId(), v.getVenName(), v.getVenMob(), v.getVenBal());
      System.out.println();
    }
    System.out.println();
    System.out.println();
  }
/**
 * main method  is the basic entry point for the application.
 * @param args used to get the user input.
 */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
