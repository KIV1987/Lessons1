package lesson8;

public class CarShop {
    private Car car;
    public CarShop(Car car){
        this.car = car;
    }

    public void SellCar() throws NegativeNumberException{
        if (car.getCost()<0) {
            throw new NegativeNumberException("Здравствуй клиент, цена этого авто неизвестна мне. Хотите посмотреть другое авто?");
        }
        System.out.println("Здравствуй клиент, цена этого авто " + car.getCost() + " Хотите купить авто?");
    }
}
