package lesson8;

public class Runner {
    public static void main(String[] args) {
        Car volvo = new Car();
        volvo.setCost(1000);
        CarShop carshop = new CarShop(volvo);
        try {
            carshop.SellCar();
        } catch (NegativeNumberException e) {
            System.out.println("Здравствуй клиент, цена этого авто неизвестна мне. Хотите посмотреть другое авто?");
        }
    }
}
