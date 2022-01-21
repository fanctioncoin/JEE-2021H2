package com.example.test;

import com.example.test.dto.CarDto;
import com.example.test.dto.ResultDto;
import com.example.test.model.Car;
import com.example.test.model.CarType;
import com.example.test.repos.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

public class Runner {
    public static void main(String[] args) {
        EntityManager em = EntityManagerHelper.getInstance().getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
/**
 * Сценарий №1
 * Выбираем тачки все которые имеют скорость более 200 км/ч
 * select left outer explicit join with dto
**/

    TypedQuery<ResultDto> query = em.createQuery(
                "select new com.example.test.dto.ResultDto(c.name, ct.name, c.speed,c.weight) from Car c, CarType ct where c.carType = ct and c.speed > 200", ResultDto.class);
        query.getResultList().forEach(Runner::printWithPrefix);

/**
 * Сценарий №2
 * Выбираем тачки, выводим данные из двух таблиц, без какого либо условия
 * select left outer explicit join with dto
 **/

//        TypedQuery<ResultDto> query = em.createQuery(
//                "select new com.example.test.dto.ResultDto(c.name, ct.name, c.speed,c.weight) from Car c join c.carType ct", ResultDto.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

/**
* Сценарий №3
* работа с join fetch и Set cars
 * select left outer explicit join with dto
**/

//        TypedQuery<CarType> query = em.createQuery(
//                "select ct from CarType ct join fetch ct.cars", CarType.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

/**
 * Сценарий №4
 * просто обычный from всей таблицы(кстати связь в таблице CarType видит и тоже выводит значение)
 */

//        TypedQuery<Car> query = em.createQuery("from Car ", Car.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

/**
 * Cценарий №5 неявный join двух таблиц
 */

//        TypedQuery<CarType> query = em.createQuery("select c.carType from Car c", CarType.class);
//        query.getResultList().forEach(Runner::printWithPrefix);

/**
 * Сценарии Named Query №1
 * Named Query select several fields with filtering by param
 */

//        TypedQuery<CarDto> query = em.createNamedQuery("byName", CarDto.class);
//        query.setParameter("name", "MAN");
//        query.getResultList().forEach(Runner::printWithPrefix);

/**
 * Cценарий с Named Query №2
 * передаем значение по которому будем фильтровать, тут по скорости которые разгонятся свыше 200 км/ч
 */
//        TypedQuery<CarDto> query = em.createNamedQuery("bySpeed_200", CarDto.class);
//        query.setParameter("speed", 200);
//        query.getResultList().forEach(Runner::printWithPrefix);
/**
 * Сценарий  CriteriaBuilder № 1
 * фильтр все имена машин начинаются на "B"
 */
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Car> query = cb.createQuery(Car.class);
//        Root<Car> carRoot = query.from(Car.class);
//        ParameterExpression<String> nameExpression = cb.parameter(String.class, "name");
//        query.select(carRoot).where(cb.like(carRoot.get("name"), nameExpression));
//        em.createQuery(query).setParameter("name", "B%").getResultList().forEach(Runner::printWithPrefix);

/**
 * Сценарий  CriteriaBuilder № 2
 * вывод всех имен таблицы Car
 */
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Car> query = cb.createQuery(Car.class);
//        Root<Car> carRoot = query.from(Car.class);
//        CompoundSelection<Car> name = cb.construct(Car.class, carRoot.get("name"));
//        query.select(name);
//        em.createQuery(query).getResultList().forEach(product -> printWithPrefix(product.getName()));


/**
 * Сценарий  CriteriaBuilder № 3
 * вывод всех car таблицы Car
 */
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Car> query = cb.createQuery(Car.class);
//        Root<Car> carRoot = query.from(Car.class);
//        query.select(carRoot);
//        em.createQuery(query).getResultList().forEach(Runner::printWithPrefix);
//        tx.commit();
//        em.close();
    }

    private static void printWithPrefix(Object obj) {
        System.out.println("!!!" + obj);
    }
}


