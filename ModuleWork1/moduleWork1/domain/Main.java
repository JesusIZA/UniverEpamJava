package moduleWork1.domain;

/**
 * 10.	Таксопарк.
 * Определить иерархию легковых автомобилей.
 * Создать таксопарк.
 * Посчитать стоимость автопарка.
 * Провести сортировку автомобилей парка по расходу топлива.
 * Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
 *
 * @author Jesus Raichuk
 */
public class Main {


    public static void main(String[] args) {
        CommandListener commandListener = new CommandListener();
        commandListener.start();
    }
}
