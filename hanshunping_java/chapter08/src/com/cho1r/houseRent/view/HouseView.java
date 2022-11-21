package com.cho1r.houseRent.view;

import com.cho1r.houseRent.domain.House;
import com.cho1r.houseRent.service.HouseService;

import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

/**
 * Author cho1r
 * 2021/12/15 上午 11:18
 */
public class HouseView {
    // 控制循环显示菜单
    private boolean flag = true;
    // 用户输入
    private int key = 0;
    // 输入
    private Scanner scanner = new Scanner(System.in);

    private HouseService houseService = new HouseService();

    // 房屋列表
    public void listHouses() {
        System.out.println("=====房屋列表=====");
        Collection<House> list = houseService.list();
        for (House house : list) {
            System.out.println(house);
        }
    }

    // 修改房屋信息
    public void updateHouse() {
        System.out.print("id: ");
        int id = scanner.nextInt();
        scanner.nextLine();// 清除缓存区回车符
        if (id <= 0 || id > HouseService.getSize()) {
            System.out.println("=====房屋id不存在=====");
            return;
        }

        House house = HouseService.findHouse(id);
        System.out.print("name(" + house.getName() + "): ");
        String name = scanner.nextLine();

        if (!name.equals("")) {
            house.setName(name);
        }

        System.out.print("phone(" + house.getPhone() + "): ");
        String phone = scanner.nextLine();
        if (!phone.equals("")) {
            house.setPhone(phone);
        }

        System.out.print("address(" + house.getAddress() + "): ");
        String address = scanner.nextLine();
        if (!address.equals("")) {
            house.setAddress(address);
        }

        System.out.print("rent(" + house.getRent() + "): ");
        try {
            int rent = Integer.parseInt(scanner.nextLine());
            house.setRent(rent);
        } catch (Exception e) {
//            e.printStackTrace();
        }


        System.out.print("state(" + house.getState() + "): ");
        String state = scanner.nextLine();
        if (!state.equals("")) {
            house.setState(state);
        }

        System.out.println("=====房屋修改成功=====");
    }

    // 查找房屋
    public void findHouse() {
        System.out.print("id: ");
        int id = scanner.nextInt();

        if (id <= 0 || id > HouseService.getSize()) {
            System.out.println("=====房屋id不存在=====");
            return;
        }

        System.out.println(HouseService.findHouse(id));
    }

    // 删除房屋
    public void delHouse() {
        System.out.println("=====删除房屋=====");
        System.out.print("id: ");
        int id = scanner.nextInt();

        if (id <= 0 || id > HouseService.getSize()) {
            System.out.println("=====房屋id不存在=====");
            return;
        }

        HouseService.delHouse(id);
        System.out.println("=====删除房屋成功=====");
    }

    // 新增房屋
    public void addHouse() {
        System.out.println("=====新增房屋=====");
        System.out.print("name: ");
        String name = scanner.next();

        System.out.print("phone: ");
        String phone = scanner.next();

        System.out.print("address: ");
        // 吸收前一个next()残留的换行符
        scanner.nextLine();
        String address = scanner.nextLine();

        System.out.print("rent: ");
        int rent = scanner.nextInt();

        System.out.print("state: ");
        String state = scanner.next();

        houseService.addHouse(new House(name, phone, address, rent, state));

        System.out.println("=====新增房屋成功=====");
    }

    // 主菜单
    public void mainMenu() {

        do {
            System.out.println("=====房屋出租系统菜单=====");
            System.out.println("\t1 新增房源");
            System.out.println("\t2 查找房源");
            System.out.println("\t3 删除房屋信息");
            System.out.println("\t4 修改房屋信息");
            System.out.println("\t5 房屋列表");
            System.out.println("\t6 退出系统");
            System.out.print("plz input your choice: ");

            key = scanner.nextInt();
            switch (key) {
                case 1 -> addHouse();
                case 2 -> findHouse();
                case 3 -> delHouse();
                case 4 -> updateHouse();
                case 5 -> listHouses();
                case 6 -> {
                    System.out.println("6");
                    flag = false;
                }
            }
        } while (flag);
    }
}
