package homeWorks.hw7.task2.domain;

import homeWorks.hw7.task2.entitys.Counter;
import homeWorks.hw7.task2.entitys.TakerFromAGround;
import homeWorks.hw7.task2.entitys.TakerFromStorage;
import homeWorks.hw7.task2.statuses.Has;
import homeWorks.hw7.task2.statuses.Take;

/**
 * Тема: многопоточность.
 * б) Первая военная задача. Темной-темной ночью прапорщики Иванов,
 * Петров и Нечепорчук занимаются хищением военного имущества со склада родной военной части.
 * Будучи умными людьми и отличниками боевой и строевой подготовки, прапорщики ввели разделение труда:
 * Иванов выносит имущество со склада, Петров грузит его в грузовик, а Нечепорчук подсчитывает рыночную стоимость добычи.
 * Требуется составить многопоточное приложение, моделирующее деятельность прапорщиков.
 * При решении использовать парадигму «производитель-потребитель» с активным ожиданием.
 *
 * @author Jesus Raichuk
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Take process
         */
        Take t = new Take();
        /**
         * Count process
         */
        Has h = new Has();
        /**
         * Create new Person will take boxes from warehouse
         */
        new TakerFromStorage(t);
        /**
         * Create new Person will take boxes from ground ad put it to the car
         */
        new TakerFromAGround(t, h);
        /**
         * Create new Person will count sum of these boxes
         */
        new Counter(h);
    }
}

