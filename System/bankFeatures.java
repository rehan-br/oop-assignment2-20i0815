package System;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class bankFeatures {
    ArrayList < bankAccount > Account = new ArrayList < bankAccount > ();
    ArrayList < transactionalHistory > History = new ArrayList < transactionalHistory > ();
    ArrayList < allDeduction > deduction = new ArrayList < allDeduction > ();


    public int mainMenu() {
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        int choice;
        System.out.println("----------------ACCOUNT MANAEGEMENT SYSTEM-------------");

        do {
            System.out.println("Press 1 to open a New Account");
            System.out.println("Press 2 to close An Account");
            System.out.println("Press 3 to Login into specifc account");
            System.out.println("Press 4 to specify the Interest Rate, (applicable to all Saving Accounts)");
            System.out.println("Press 5 to display all account details, including the bank owner details");
            System.out.println("Press 6 to display all accounts deductions along with account details");
            System.out.println("Press 7 to exit");
            choice = input.nextInt();

            if (choice >= 1 && choice <= 7) {
                flag = true;
            } else {
                System.out.println("Please Enter a valid choice");
                flag = false;
            }
        } while (!flag);
        return choice;
    }
    public int accountMenu(String accountNumber) {
        int choice;
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        do {

            System.out.println("--------Account Menu--------");
            System.out.println("Account Number is  " + accountNumber);
            System.out.println("Below are the functions you can perform");
            System.out.println("Press 1 to deposite cash into the Account");
            System.out.println("Press 2 to withdraw cash from the Account");
            System.out.println("Press 3 to transfer cash into another Account");
            System.out.println("Press 4 to check Balance of the Account");
            System.out.println("Press 5 to Request for statement");
            System.out.println("Press 6 to calculate and pay zakat");
            System.out.println("Press 7 to calculate and pay intrest");
            System.out.println("Press 8 to display all the deductions from this account");
            System.out.println("Press 9 to go back to main menu");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 9) {
                flag = true;
            } else {
                System.out.println("Please Enter a valid choice");
                flag = false;
            }

            return choice;
        } while (!flag);
    }
    public int[] inputDate(String accountNumber) {
        boolean flag;
        boolean check = false;
        int i = 0;
        if (History.size() > 0) {
            for (i = History.size() - 1; i >= 0; i--) {
                if (accountNumber.equals(History.get(i).getCustomerDetail().getAccountNumber())) {
                    check = true;
                    break;
                }
            }
        }
        int day = 0, month = 0, year = 0;
        do {
            flag = true;
            Scanner inputDate = new Scanner(System.in);
            System.out.println("Enter the year in which the action is taking place (15-25)");
            year = inputDate.nextInt();
            if (year >= 15 && year <= 25) {

                System.out.println("Enter the month in which the action is taking place (in numbers)");
                month = inputDate.nextInt();
                if (month > 0 && month < 13) {


                    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {

                        System.out.println("Enter the day in which the action is taking place");
                        day = inputDate.nextInt();
                        if (day <= 31) {
                            flag = true;
                        } else {
                            System.out.println("You entered an invalid date");
                            flag = false;

                        }
                    } else if (month == 2) {
                        System.out.println("Enter the day in which the action is taking place");
                        day = inputDate.nextInt();
                        if (day <= 28) {
                            flag = true;
                        } else {
                            System.out.println("You entered an invalid date");
                            flag = false;
                        }

                    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                        System.out.println("Enter the day in which the action is taking place");
                        day = inputDate.nextInt();
                        if (day <= 30) {
                            flag = true;
                        } else {
                            System.out.println("You entered an invalid date");
                            flag = false;
                        }
                    } else {
                        System.out.println("You entered an invalid date");
                        flag = false;
                    }
                } else {
                    System.out.println("You entered an invalid date");
                    flag = false;
                }

            } else {
                System.out.println("You entered an invalid date");
                flag = false;

            }

            if (flag == true) {
                System.out.println("Please wait, while the system Confirms that you enetered correct Date");

                if (check == true) {
                    if (year == History.get(i).getDate().getYear()) {
                        if (month == History.get(i).getDate().getMonth()) {
                            if (History.get(i).getDate().getDay() > day) {
                                System.out.println("You entered the date that comes before the date of previous transaction. Try again!");
                                flag = false;
                            } else flag = true;
                        } else if (month < History.get(i).getDate().getMonth()) {
                            System.out.println("You entered the date that comes before the date of previous transaction. Try again!");
                            flag = false;
                        } else flag = true;

                    } else if (year < History.get(i).getDate().getYear()) {
                        System.out.println("You entered the date that comes before the date of previous transaction. Try again!");
                        flag = false;

                    } else flag = true;

                } else if (check == false) {
                    for (int j = 0; j < Account.size(); j++) {
                        if (Account.get(j).getCustomerDetail().getAccountNumber().endsWith(accountNumber)) {
                            if (year == Account.get(j).getDate().getMonth()) {
                                if (month == Account.get(j).getDate().getMonth()) {
                                    if (Account.get(j).getDate().getDay() > day) {
                                        System.out.println("You entered the date that comes before the date of previous transaction. Try again!");
                                        flag = false;
                                    } else flag = true;
                                } else if (month < Account.get(j).getDate().getMonth()) {
                                    System.out.println("You entered the date that comes before the date of previous transaction. Try again!");
                                    flag = false;
                                } else flag = true;

                            } else if (year < Account.get(j).getDate().getYear()) {
                                System.out.println("You entered the date that comes before the date of previous transaction. Try again!");
                                flag = false;

                            } else if (year > Account.get(j).getDate().getYear()) {
                                flag = true;
                            }
                        }
                    }
                }

            }
        } while (!flag);

        System.out.println("Date confirmed!");

        int[] date = {
            day,
            month,
            year
        };
        return date;
    }
    public void openAccount(float rate) {
        String accountNumber, cnic = null;
        int day = 0, month = 0, year = 0, userChoice;
        boolean flag;
        Scanner input = new Scanner(System.in);
        System.out.println("----Open A new Bank Account------");

        do {
            flag = true;
            Scanner choice = new Scanner(System.in);
            Scanner userCnic = new Scanner(System.in);

            System.out.println("press 1 for Savings Account");
            System.out.println("press 2 for Checkings Account");
            userChoice = choice.nextInt();
            if (userChoice == 1 || userChoice == 2) {
                System.out.println("Enter Cnic of customer");

                cnic = userCnic.nextLine();
                for (int i = 0; i < Account.size(); i++) {
                    if (cnic.equals(Account.get(i).getCustomerDetail().getCnic())) {
                        if (userChoice == 1) {
                            if (Account.get(i).getAccountType().equals("Savings Account")) {
                                System.out.println("The customer with this cnic already has a saving Account ");
                                flag = false;
                                break;
                            } else {
                                flag = true;
                            };

                        } else if (userChoice == 2) {
                            if (Account.get(i).getAccountType().equals("Checkings Account")) {
                                System.out.println("The customer with this cnic already has a checkings Account ");
                                flag = false;
                                break;
                            } else {
                                flag = true;
                            };
                        }
                    }

                }
            } else {
                System.out.println("enter Valid Choice");
                flag = false;
            };
        } while (!flag);

        System.out.println("Please enter Customer's full name ");
        String name = input.nextLine();
        System.out.println("Please enter Customer's full Address ");
        String address = input.nextLine();
        System.out.println("Please enter Customer's mobile number ");
        String phoneNumber = input.nextLine();
        do {
            flag = true;
            System.out.println("Please assosiate a unique Bank Account Number to this account");
            accountNumber = input.nextLine();
            for (bankAccount AllAccounts: Account) {
                if (AllAccounts.getCustomerDetail().getAccountNumber().equals(accountNumber)) {
                    System.out.print("Account number is already in used. ");
                    flag = false;
                }
            }

        } while (!flag);
        int[] date = inputDate(accountNumber);
        day = date[0];
        month = date[1];
        year = date[2];
        if (userChoice == 1) {
            System.out.println("Add money into the new Account. If you wish not to add any money, just press 0. " +
                "Note diposting money more than 20000 in your account will result in deduction of 2.5% to annual zakat charity");
            System.out.println("Intrest would also be deducted  if you wish to add money more than 10000.");
            System.out.println("Note that both zakat and intrest rate would only be deducted once a year");
        } else if (userChoice == 2)
            System.out.println("Add money into the new Account. If you wish not to add any money, just press 0.");
        double money = input.nextDouble();
        if (userChoice == 1) {
            Account.add(new bankAccount(name, cnic, address, phoneNumber, accountNumber, money, day, month, year, "Savings Account"));
        } else if (userChoice == 2) {
            Account.add(new bankAccount(name, cnic, address, phoneNumber, accountNumber, money, day, month, year, "Checkings Account"));
        }
        int i;
        if (money >= 20000 && userChoice == 1) {
            for (i = 0; i < Account.size(); i++) {
                if (Account.get(i).getCustomerDetail().getAccountNumber().equals(accountNumber)) {
                    System.out.println("Initial zakat is deducted from the account in advance. Next time, Zakat will be deducted on " +
                        Account.get(i).getDate().getDay() + "/" + Account.get(i).getDate().getMonth() +
                        "/" + (Account.get(i).getDate().getYear() + 1));
                    double zakat = (Account.get(i).getBalance() * 2.5) / 100;
                    Account.get(i).setBalance(Account.get(i).getBalance() - zakat);
                    deduction.add(new allDeduction(accountNumber, "Zakat", zakat, day, month, year));
                    break;
                }
            }
            if (money >= 1000) {
                money = Account.get(i).getBalance() * rate / 100;
                Account.get(i).setBalance(rate * Account.get(i).getBalance() - money);
                deduction.add(new allDeduction(accountNumber, "intrest", money, day, month, year));
                System.out.println("Initial intrest is also deducted. Next time, Intrest Rate will be deducted on " +
                    +Account.get(i).getDate().getDay() + "/" + Account.get(i).getDate().getMonth() +
                    "/" + (Account.get(i).getDate().getYear() + 1));
            }
        }
        System.out.println("Account Added Successfully");

    }
    public void display() {
        boolean flag = false;
        int counter = 1;
        for (int i = 0; i < Account.size(); i++) {
        	System.out.println("Data number: " + counter);
            System.out.println("Name of Account Holder: " + Account.get(i).getCustomerDetail().getName());
            System.out.println("Holder's Address: " + Account.get(i).getCustomerDetail().getAddress());
            System.out.println("Holder's number: " + Account.get(i).getCustomerDetail().getPhoneNumber());
            System.out.println("Holder's Account Number: " + Account.get(i).getCustomerDetail().getAccountNumber());
            System.out.println("Account balance: " + Account.get(i).getBalance());
            System.out.println("Account type: " + Account.get(i).getAccountType());
            System.out.println("Date when the Account was created " + Account.get(i).getDate().getDay() + "/" + Account.get(i).getDate().getMonth() + "/" + Account.get(i).getDate().getYear());
            System.out.println(" ");
            counter++;
            flag = true;
        }
        if (flag == false) {
            System.out.println("No Data found!");
        }
    }
    public void delete() {
        boolean flag;
        System.out.println("------Delete An Account------");

        do {
            flag = false;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the Account number of the customer you want to close");
            String accountNumber = input.nextLine();
            for (int i = 0; i < Account.size(); i++) {
                if (accountNumber.equals(Account.get(i).getCustomerDetail().getAccountNumber())) {
                    System.out.println("Account Number found!");
                    System.out.println("Name of holder " + Account.get(i).getCustomerDetail().getName());
                    System.out.println("Holder's Address " + Account.get(i).getCustomerDetail().getAddress());
                    System.out.println("Holder's Phone Number " + Account.get(i).getCustomerDetail().getPhoneNumber());
                    System.out.println("Holder's Account Number " + Account.get(i).getCustomerDetail().getAccountNumber());
                    System.out.println("Hodlder's Account type " + Account.get(i).getAccountType());
                    System.out.println("Date when the Account was created " + Account.get(i).getDate().getDay() + "/" + Account.get(i).getDate().getMonth() + "/" + Account.get(i).getDate().getYear());
                    System.out.println("press 1 to delete it ");
                    System.out.println("press 2 to go back to main menu");
                    Scanner choice = new Scanner(System.in);
                    int userChoice = choice.nextInt();
                    if (userChoice == 1) {
                        int k = 0;
                        while (k < History.size()) {
                            if (accountNumber.equals(History.get(k).getCustomerDetail().getAccountNumber())) {
                                History.remove(k);
                                k = 0;
                            }
                        }
                        int  l = 0;
                        while (l < deduction.size()) {
                            if (accountNumber.equals(deduction.get(l).getDeduct().getCustomerDetail().getAccountNumber())) {
                                deduction.remove(l);
                                l = 0;
                            }
                        }

                        Account.remove(i);
                        System.out.println("Data removed Successfully!");
                        flag = true;
                        break;
                    } else if (userChoice == 2) {
                        flag = true;
                        break;
                    } else {
                        System.out.println("Enter valid input");
                        flag = false;
                    }

                }

            }
            if (flag == false) {
                System.out.println("account number did not Match");
                flag = false;
            }

        } while (!flag);

    }
    public String login() {
        boolean flag;
        String accountNumber = null;
        System.out.println("-------login------");

        do {
            flag = false;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the Account number of the customer you want to log in");
            accountNumber = input.nextLine();
            for (int i = 0; i < Account.size(); i++) {
                if (accountNumber.equals(Account.get(i).getCustomerDetail().getAccountNumber())) {
                    System.out.println("Logged in successfully!");
                    System.out.println("Redirecting to the next menu.....");
                    flag = true;
                    break;
                }
            }
            if (flag == false)
                System.out.print("Account Number of the customer not found! Please re-");
        } while (!flag);

        return accountNumber;

    }
    public void add() {
        //                            name  , cnic ,         address,      phonenumber , AccNo , money , date ,       Accountype 
        Account.add(new bankAccount("umar", "331006959", "f-10, Islamabad", "090078601", "12345", 30000, 19, 2, 20, "Savings Account"));
        Account.add(new bankAccount("kamran", "4748748", "Saddar rawalpidni", "09000785673", "123", 5000, 1, 2, 17, "Checkings Account"));
        Account.add(new bankAccount("Ibrahim", "43983983", "I10-2, Islalamabad ", "031737373", "1232", 15000, 19, 12, 19, "Checkings Account"));

    }
    public void makeDeposit(String accountNumber) {
        int day = 0, month = 0, year = 0, time = 0, counter = 0;


        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        boolean flag = false;
        do {
            System.out.println("Enter the Amount of money you want to deposite into the Account");
            double money = input.nextDouble();
            if (money > 0) {

                for (int i = 0; i < Account.size(); i++) {
                    if (Account.get(i).getCustomerDetail().getAccountNumber().equals(accountNumber)) {
                        int[] date = inputDate(accountNumber);
                        day = date[0];
                        month = date[1];
                        year = date[2];
                        if (History.size() > 0) {
                            for (int k = History.size() - 1; k >= 0; k--) {
                                if (History.get(k).getCustomerDetail().getAccountNumber().equals(accountNumber) && History.get(k).getAccountType().equalsIgnoreCase("Checkings Account")) {
                                    counter = History.get(k).getTransactionEachMonth();
                                    if (year == History.get(k).getDate().getYear()) {
                                        if (month == History.get(k).getDate().getMonth()) {
                                            counter++;
                                            break;
                                        } else if (month > History.get(k).getDate().getMonth())
                                            counter = 0;
                                        counter++;
                                        break;
                                    } else if (year > History.get(k).getDate().getYear()) {
                                        counter = 0;
                                        counter++;
                                        break;
                                    }


                                }
                            }
                        }
                        System.out.println("Enter the time of trasaction in 24 hour format eg 2400");
                        time = input1.nextInt();
                        if (time >= 100 && time <= 2400) {
                            if (counter >= 2) {
                                Account.get(i).setBalance(Account.get(i).getBalance() - 10);
                            }
                            Account.get(i).setBalance(Account.get(i).getBalance() + money);
                            History.add(new transactionalHistory(Account.get(i).getCustomerDetail().getName(),
                                Account.get(i).getCustomerDetail().getCnic(),
                                Account.get(i).getCustomerDetail().getAddress(), Account.get(i).getCustomerDetail().getPhoneNumber(),
                                Account.get(i).getCustomerDetail().getAccountNumber(), Account.get(i).getBalance(), day, month, year,
                                Account.get(i).getAccountType(), money, time, "Cash deposit", counter));


                            System.out.println("Transaction compeleted!");
                            flag = true;
                            break;

                        } else {
                            System.out.println("Enter valid time");
                            flag = false;
                        }
                    }
                }
            } else {
                System.out.println("Enter valid Input");
                flag = false;
            }


        } while (!flag);
        if (counter >= 2) {
            System.out.println("10 rs were deducted from the account as you exceed the minimum free transactions a month");
            deduction.add(new allDeduction(accountNumber, "cash deposit", 10, day, month, year));
        }
    }
    public void statement(String accountNumber) {
        boolean flag = false;
        int counter = 1;
        for (int i = 0; i < History.size(); i++) {
            System.out.println("Personal infomation");
            if (History.get(i).getCustomerDetail().getAccountNumber().equals(accountNumber)) {
                System.out.println("Name of Account Holder: " + History.get(i).getCustomerDetail().getName());
                System.out.println(History.get(i).getCustomerDetail().getName() + "'s Cnin:  " + History.get(i).getCustomerDetail().getCnic());
                System.out.println(History.get(i).getCustomerDetail().getName() + "'s Address:  " + History.get(i).getCustomerDetail().getAddress());
                System.out.println(History.get(i).getCustomerDetail().getName() + "'s Phone Number:  " + History.get(i).getCustomerDetail().getPhoneNumber());
                System.out.println(History.get(i).getCustomerDetail().getName() + "'s Account Number:  " + History.get(i).getCustomerDetail().getAccountNumber());
                System.out.println(History.get(i).getCustomerDetail().getName() + "'s Account Type:  " + History.get(i).getAccountType());
                System.out.println("   ");
                break;
            }
        }
        for (int j = 0; j < History.size(); j++) {
            if (History.get(j).getCustomerDetail().getAccountNumber().equals(accountNumber)) {
                System.out.println("Transaction History number " + counter);
                System.out.println("Total balance in Account after this transaction:  " + History.get(j).getBalance());
                System.out.println("Date when the trasaction  took place: " +
                    History.get(j).getDate().getDay() + "/" + History.get(j).getDate().getMonth() + "/" +
                    History.get(j).getDate().getYear() + " at " + History.get(j).getTimeOfTransaction() + " in 24-hour format");
                System.out.println("Transaction Type: " + History.get(j).getTransactionType());
                System.out.println("Trasanction amount: " + History.get(j).getTransactionAmount());
                System.out.println(" ");
                counter++;
                flag = true;
            }
        }


        if (flag == false) {
            System.out.println("No statement available");
        }
    }
    public void makeWithdrawal(String accountNumber) {

        int day = 0, month = 0, year = 0, time = 0, counter = 0;
        double money = 0;

        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        boolean flag = false;
        boolean flag2 = false;
        do {
            System.out.println("Enter the Amount of money you want to withdraw from the Account");
            money = input.nextDouble();
            if (money > 0) {
                for (int i = 0; i < Account.size(); i++) {
                    if (Account.get(i).getCustomerDetail().getAccountNumber().equals(accountNumber)) {

                        if (Account.get(i).getAccountType().equalsIgnoreCase("Checkings Account")) {
                            if (Account.get(i).getBalance() - money >= -5000) {
                                flag2 = true;
                                break;
                            } else {
                                System.out.println("You dont have enough balance in your Account, try inputting diffrent value");
                                flag2 = false;
                                break;
                            }
                        } else if (Account.get(i).getAccountType().equalsIgnoreCase("Savings Account")) {
                            if (Account.get(i).getBalance() - money >= 0) {
                                flag2 = true;
                            } else {
                                System.out.println("You dont have enough balance in your Account, try inputting diffrent value");
                                flag2 = false;
                                break;
                            }
                        }
                    }

                }
            }

        } while (!flag2);
        do {
            for (int i = 0; i < Account.size(); i++) {
                if (Account.get(i).getCustomerDetail().getAccountNumber().equals(accountNumber)) {
                    int[] date = inputDate(accountNumber);
                    day = date[0];
                    month = date[1];
                    year = date[2];
                    if (History.size() > 0) {
                        for (int k = History.size() - 1; k >= 0; k--) {
                            if (History.get(k).getCustomerDetail().getAccountNumber().equals(accountNumber) && History.get(k).getAccountType().equals("Checkings Account")) {
                                counter = History.get(k).getTransactionEachMonth();
                                if (year == History.get(k).getDate().getYear()) {
                                    if (month == History.get(k).getDate().getMonth()) {
                                        counter++;
                                        break;
                                    } else if (month > History.get(k).getDate().getMonth())
                                        counter = 0;
                                    counter++;
                                    break;
                                } else if (year > History.get(k).getDate().getYear()) {
                                    counter = 0;
                                    counter++;
                                    break;
                                }


                            }
                        }
                    }
                    System.out.println("Enter the time of trasaction in 24 hour format eg 2400");
                    time = input1.nextInt();
                    if (time >= 100 && time <= 2400) {
                        if (counter >= 2) {
                            Account.get(i).setBalance(Account.get(i).getBalance() - 10);
                        }
                        Account.get(i).setBalance(Account.get(i).getBalance() - money);
                        History.add(new transactionalHistory(Account.get(i).getCustomerDetail().getName(),
                            Account.get(i).getCustomerDetail().getCnic(),
                            Account.get(i).getCustomerDetail().getAddress(), Account.get(i).getCustomerDetail().getPhoneNumber(),
                            Account.get(i).getCustomerDetail().getAccountNumber(), Account.get(i).getBalance(), day, month, year,
                            Account.get(i).getAccountType(), money, time, "Cash withdraw", counter));


                        System.out.println("Transaction compeleted!");
                        flag = true;
                        break;

                    } else {
                        System.out.println("Enter valid time");
                        flag = false;
                    }
                }
            }




        } while (!flag);
        if (counter >= 2) {
            System.out.println("10 rs were deducted from the account as you exceed the minimum free transactions a month");
            deduction.add(new allDeduction(accountNumber, "cash withdraw", 10, day, month, year));

        }



    }
    public void trasferAmount(String accountNumber) {
        boolean flag = false, flag1 = false;
        int i, j = 0, day = 0, month = 0, year = 0, counter = 0, counter2 = 0, time = 0;
        double money = 0;
        String accountNumber2;
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        do {
            System.out.println("Enter the Account Number of the person you want to send money to");
            accountNumber2 = input.nextLine();
            for (i = 0; i < Account.size(); i++) {
                if (Account.get(i).getCustomerDetail().getAccountNumber().equals(accountNumber2) && !(Account.get(i).getCustomerDetail().getAccountNumber().equals(accountNumber))) {
                    System.out.println("Account Number Found!");
                    System.out.println("Account holder's name " + Account.get(i).getCustomerDetail().getName());
                    System.out.println("Holder's CNIC " + Account.get(i).getCustomerDetail().getCnic());
                    flag = true;
                    break;
                }
            }
            if (accountNumber.equals(accountNumber2)) {
                System.out.println("You entered the same Account Number you are loggedin in, try again!");
                flag1 = true;
            } else if (flag == false && flag1 == false) {
                System.out.println("account number did not Match");
                flag = false;
            }
        } while (!flag);
        do {
            flag = false;
            System.out.println("Enter the amount you want to send into " + Account.get(i).getCustomerDetail().getName() + "'s Account");
            money = input2.nextDouble();
            if (money > 0) {
                for (j = 0; j < Account.size(); j++) {
                    if (Account.get(j).getCustomerDetail().getAccountNumber().equals(accountNumber)) {
                        if (Account.get(j).getAccountType().equalsIgnoreCase("Checkings Account")) {
                            if (Account.get(j).getBalance() - money >= -5000) {
                                flag = true;
                                break;
                            } else {
                                System.out.println("You dont have enough balance in your Account, try inputting diffrent value");
                                flag = false;
                                break;
                            }
                        } else if (Account.get(j).getAccountType().equalsIgnoreCase("Savings Account")) {
                            if (Account.get(j).getBalance() - money >= 0) {
                                flag = true;
                            } else {
                                System.out.println("You dont have enough balance in your Account, try inputting diffrent value");
                                flag = false;
                                break;
                            }
                        }
                    }

                }
            }
        } while (!flag);
        do {
            int[] date = inputDate(accountNumber);
            day = date[0];
            month = date[1];
            year = date[2];
            if (History.size() > 0) {
                for (int k = History.size() - 1; k >= 0; k--) {
                    if (History.get(k).getCustomerDetail().getAccountNumber().equals(accountNumber) && History.get(k).getAccountType().equals("Checkings Account")) {
                        counter = History.get(k).getTransactionEachMonth();
                        if (year == History.get(k).getDate().getYear()) {
                            if (month == History.get(k).getDate().getMonth()) {
                                counter++;
                                break;
                            } else if (month > History.get(k).getDate().getMonth())
                                counter = 0;
                            counter++;
                            break;
                        } else if (year > History.get(k).getDate().getYear()) {
                            counter = 0;
                            counter++;
                            break;
                        }


                    }
                }
            }
            System.out.println("Enter the time of trasaction in 24 hour format eg 2400");
            time = input2.nextInt();
            for (j = 0; j < Account.size(); j++) {
                if (Account.get(j).getCustomerDetail().getAccountNumber().equals(accountNumber)) {
                    break;
                }
            }
            if (time >= 100 && time <= 2400) {
                if (counter >= 2) {
                    Account.get(j).setBalance(Account.get(i).getBalance() - 10);
                }
                Account.get(j).setBalance(Account.get(j).getBalance() - money);
                History.add(new transactionalHistory(Account.get(j).getCustomerDetail().getName(),
                    Account.get(j).getCustomerDetail().getCnic(),
                    Account.get(j).getCustomerDetail().getAddress(), Account.get(i).getCustomerDetail().getPhoneNumber(),
                    Account.get(j).getCustomerDetail().getAccountNumber(), Account.get(j).getBalance(), day, month, year,
                    Account.get(j).getAccountType(), money, time, "Money Transfer to " + Account.get(i).getCustomerDetail().getName(), counter));
                Account.get(i).setBalance(Account.get(i).getBalance() + money);
                for (int k = History.size() - 1; k >= 0; k--) {
                    if (History.get(k).getCustomerDetail().getAccountNumber().equals(accountNumber2)) {
                        counter2 = History.get(k).getTransactionEachMonth();
                    }

                }

                History.add(new transactionalHistory(Account.get(i).getCustomerDetail().getName(),
                    Account.get(i).getCustomerDetail().getCnic(),
                    Account.get(i).getCustomerDetail().getAddress(), Account.get(i).getCustomerDetail().getPhoneNumber(),
                    Account.get(i).getCustomerDetail().getAccountNumber(), Account.get(i).getBalance(), day, month, year,
                    Account.get(i).getAccountType(), money, time, "Money Transfer from " + Account.get(j).getCustomerDetail().getName(), counter2));

                System.out.println("Transaction compeleted!");
                flag = true;
                break;

            } else {
                System.out.println("Enter valid time");
                flag = false;
            }

        } while (!flag);
        if (counter >= 2) {
            System.out.println("10 rs were deducted from the account as you exceed the minimum free transactions a month");
            deduction.add(new allDeduction(accountNumber, "Money transfer to " + Account.get(i).getCustomerDetail().getName() + " from " + Account.get(j).getCustomerDetail().getName(), 10, day, month, year));

        }
    }
    public void checkBalance(String accountNumber) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < Account.size(); i++) {
            if (accountNumber.equals(Account.get(i).getCustomerDetail().getAccountNumber())) {
                System.out.println("The Balance in your Account is " + Account.get(i).getBalance());
                System.out.println("Press any key to go back");
                String key = input.nextLine();
            }
        }
    }
    public void calculateZakat(String accountNumber) {
        double zakat = 0;
        long numOfDays;
        int day = 0, month = 0, year = 0, previousYear = 0, previousMonth = 0, previousDay = 0;
        boolean flag = false, flag2 = false, flag3 = false;
        for (int i = 0; i < Account.size(); i++) {
            if (accountNumber.equals(Account.get(i).getCustomerDetail().getAccountNumber()) &&
                Account.get(i).getAccountType().equalsIgnoreCase("Savings Account")) {
                System.out.println("--------Zakat Calculator-------");

                if (Account.get(i).getBalance() >= 20000) {
                    int date[] = inputDate(accountNumber);
                    day = date[0];
                    month = date[1];
                    year = date[2];
                    if (deduction.size() == 0) {
                        previousYear = Account.get(i).getDate().getYear();
                        previousMonth = Account.get(i).getDate().getMonth();
                        previousDay = Account.get(i).getDate().getDay();
                        flag2 = true;
                    } else if (deduction.size() != 0) {


                        if (flag2 == false) {
                            for (int k = deduction.size() - 1; k >= 0; k--) {
                                if (deduction.get(k).getDeduct().getCustomerDetail().getAccountNumber().equals(accountNumber) &&
                                    deduction.get(k).getDeduct().getTransactionType().equalsIgnoreCase("Zakat")) {
                                    previousYear = deduction.get(k).getDate().getYear();
                                    previousMonth = deduction.get(k).getDate().getMonth();
                                    previousDay = deduction.get(k).getDate().getDay();
                                    flag3 = true;
                                    break;
                                }
                            }
                        }
                        if (flag3 == false) {
                            previousYear = Account.get(i).getDate().getYear();
                            previousMonth = Account.get(i).getDate().getMonth();
                            previousDay = Account.get(i).getDate().getDay();

                        }


                    }

                    LocalDate nowDate = LocalDate.of(year, month, day);
                    LocalDate pastDate = LocalDate.of(previousYear, previousMonth, previousDay);
                    numOfDays = (ChronoUnit.DAYS.between(pastDate, nowDate));
                    if (numOfDays >= 365) {
                        zakat = (Account.get(i).getBalance() * (2.5 / 100));
                        System.out.println("zakat to be paid for this Account is " + zakat);
                        do {
                            flag = false;
                            Scanner input = new Scanner(System.in);
                            System.out.println("Press 1 to deduct zakat");
                            System.out.println("press 2 to go back");
                            int choice = input.nextInt();
                            if (choice == 1) {
                                Account.get(i).setBalance(Account.get(i).getBalance() - zakat);
                                deduction.add(new allDeduction(accountNumber, "Zakat", zakat, day, month, year));

                                System.out.println("zakat paid");
                                flag = true;
                                break;

                            } else if (choice == 2) {
                                flag = true;
                            } else {
                                System.out.println("Invalid Entry");
                                flag = false;
                            }
                        } while (!flag);
                    } else {
                        System.out.println("The account holder has already paid Zakat this year");
                        System.out.println("Last time the Holder paid zakat was " + previousDay + "/" + previousMonth + "/" + previousYear);
                        System.out.println("The holder will be eligible to pay zakat on " + previousDay + "/" + previousMonth + "/" + (previousYear + 1));
                        flag = true;
                    }


                } else {
                    System.out.println("The Account less than 20000 of balance");
                    flag2 = false;
                    break;
                }
            }
        }
        if (flag == false) {
            System.out.println("This Account is not a Savings Account!");
        }
    }

    public void calculateIntrest(String accountNumber, float rate) {
        double money = 0;
        boolean flag = false;
        int day = 0, month = 0, year = 0, previousYear = 0, previousMonth = 0, previousDay = 0;
        boolean flag2 = false;
        boolean flag3 = false;
        long numOfDays;
        for (int i = 0; i < Account.size(); i++) {
            if (Account.get(i).getAccountType().equalsIgnoreCase("Savings Account") && Account.get(i).getCustomerDetail().getAccountNumber().equals(accountNumber)) {
                System.out.println("--------Intrest Calculator-------");
                if (Account.get(i).getBalance() >= 10000) {
                    int date[] = inputDate(accountNumber);
                    day = date[0];
                    month = date[1];
                    year = date[2];
                    if (deduction.size() == 0) {
                        previousYear = Account.get(i).getDate().getYear();
                        previousMonth = Account.get(i).getDate().getMonth();
                        previousDay = Account.get(i).getDate().getDay();
                        flag2 = true;
                    } else if (deduction.size() != 0) {


                        if (flag2 == false) {
                            for (int k = deduction.size() - 1; k >= 0; k--) {
                                if (deduction.get(k).getDeduct().getCustomerDetail().getAccountNumber().equals(accountNumber) &&
                                    deduction.get(k).getDeduct().getTransactionType().equalsIgnoreCase("Intrest")) {
                                    previousYear = deduction.get(k).getDate().getYear();
                                    previousMonth = deduction.get(k).getDate().getMonth();
                                    previousDay = deduction.get(k).getDate().getDay();
                                    flag3 = true;
                                    break;
                                }
                            }
                        }
                        if (flag3 == false) {
                            previousYear = Account.get(i).getDate().getYear();
                            previousMonth = Account.get(i).getDate().getMonth();
                            previousDay = Account.get(i).getDate().getDay();

                        }


                    }

                    LocalDate nowDate = LocalDate.of(year, month, day);
                    LocalDate pastDate = LocalDate.of(previousYear, previousMonth, previousDay);
                    numOfDays = (ChronoUnit.DAYS.between(pastDate, nowDate));
                    if (numOfDays >= 365) {
                        money = Account.get(i).getBalance() * (rate / 100);
                        System.out.println("intrest to be paid for this Account is " + money);
                        do {
                            flag = false;
                            Scanner input = new Scanner(System.in);
                            System.out.println("Press 1 to deduct intrest");
                            System.out.println("press 2 to go back");
                            int choice = input.nextInt();
                            if (choice == 1) {
                                Account.get(i).setBalance(Account.get(i).getBalance() - money);
                                deduction.add(new allDeduction(accountNumber, "intrest", money, day, month, year));
                                System.out.println("Intrest paid");
                                flag = true;
                                break;

                            } else if (choice == 2) {
                                flag = true;
                            } else {
                                System.out.println("Invalid Entry");
                                flag = false;
                            }
                        } while (!flag);
                    } else {
                        System.out.println("The account holder has already paid intrest this year");
                        System.out.println("Last time the Holder paid intrest was " + previousDay + "/" + previousMonth + "/" + previousYear);
                        System.out.println("The holder will be eligible to pay intrest on " + previousDay + "/" + previousMonth + "/" + (previousYear + 1));
                    }
                } else
                    System.out.println("Account has less than 10000, so it is not eligible to pay intrest");

            }
        }

        if (flag == false) {
            System.out.println("This account is not a savings Account");
        }
    }
    public float intrestFormula() {
        Scanner sc = new Scanner(System.in);
        float rate;
        boolean flag;

        flag = false;
        do {
            System.out.println("Please specify the intrest rate on all savings Account");
            rate = sc.nextFloat();
            if (rate > 0 && rate < 10) {
                System.out.println("Intrest rate: " + rate + "% specfied on all savings Account");
                flag = true;
            } else {
                System.out.println("Enter only between 0% to 10%");
                flag = false;
            }

        } while (!flag);
        return rate;
    }
    public void displayDeducitons() {
        boolean flag = false;
        int counter = 0;
        for (int i = 0; i < deduction.size(); i++) {
            System.out.println("Deduction number " + counter);
            System.out.println("Holder's Account Number: " + deduction.get(i).getDeduct().getCustomerDetail().getAccountNumber());
            System.out.println("Dedcution type: " + deduction.get(i).getDeduct().getTransactionType());
            System.out.println("Money Deducted: " + deduction.get(i).getDeduct().getTransactionAmount());
            System.out.println("Date of Trasansaction: " + deduction.get(i).getDate().getDay() + "/" +
                deduction.get(i).getDate().getMonth() + "/" + deduction.get(i).getDate().getYear());
            counter++;
            System.out.println("   ");
            flag = true;

        }
        if (flag == false) {
            System.out.println("No Data found!");
        }

    }
    public void displayDeducitons(String accountNumber) {
        boolean flag = false;
        int counter = 0;
        for (int i = 0; i < deduction.size(); i++) {
            if (deduction.get(i).getDeduct().getCustomerDetail().getAccountNumber().equals(accountNumber)) {
            			System.out.println();
                System.out.println("Deduction number " + counter);
                System.out.println("Holder's Account Number: " + deduction.get(i).getDeduct().getCustomerDetail().getAccountNumber());
                System.out.println("Dedcution type: " + deduction.get(i).getDeduct().getTransactionType());
                System.out.println("Money Deducted: " + deduction.get(i).getDeduct().getTransactionAmount());
                System.out.println("Date of Trasansaction: " + deduction.get(i).getDate().getDay() + "/" +
                    deduction.get(i).getDate().getMonth() + "/" + deduction.get(i).getDate().getYear());
                System.out.println("    ");
                counter++;
                flag = true;
                

            }
        }
        if (flag == false) {
            System.out.println("No Data found!");
        }

    }

}