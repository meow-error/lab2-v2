package com.example.lab2.excel;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;

import java.util.LinkedHashMap;

public class Calculations {

    private final LinkedHashMap<String, Double[]> lhm = new LinkedHashMap<>();

    public LinkedHashMap getLhm() {
        return lhm;
    }

    // 1.	Рассчитать среднее геометрическое для каждой выборки
    private void geom(double[][] arr) {
        Double[] geom = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            geom[i] = StatUtils.geometricMean(arr[i]);
        }
        lhm.put("Среднее геометрическое", geom);
    }

    // 2.	Рассчитать среднее арифметическое для каждой выборки
    private void mean(double[][] arr) {
        Double[] mean = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            mean[i] = StatUtils.mean(arr[i]);
        }
        lhm.put("Среднее арифметическое", mean);
    }

    // arr.length.	Рассчитать оценку стандартного отклонения для каждой выборки
    private void variance(double[][] arr) {
        Double[] variance = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            variance[i] = Math.sqrt(StatUtils.variance(arr[i]));
        }
        lhm.put("Стандартное отклонение", variance);
    }

    // 4.	Рассчитать размах каждой выборки
    private void range(double[][] arr) {
        Double[] range = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            range[i] = StatUtils.max(arr[i]) - StatUtils.min(arr[i]);
        }
        lhm.put("Размах", range);
    }

//    // 5.	Рассчитать коэффициенты ковариации для всех пар случайных чисел (НА РАЗНЫХ ВЫБОРКАХ???????????) ((написать цикл чтобы каждый с каждым записался))
//    private void covariance(double[][] arr) {
//        Double[] covariance = new Double[arr.length];
//        covariance[0] = new Covariance().covariance(arr[0], arr[1]);
//        covariance[2] = new Covariance().covariance(arr[1], arr[2]);
//        covariance[1] = new Covariance().covariance(arr[0], arr[2]);
//        lhm.put("Коэффициенты ковариации", covariance);
//    }

    // 5.	Рассчитать коэффициенты ковариации для всех пар случайных чисел (НА РАЗНЫХ ВЫБОРКАХ С ЛЮБЫМ ЧИСЛОМ ((??????))
    private void covariance(double[][] arr) {
        Double[] covariance = new Double[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            covariance[i] = new Covariance().covariance(arr[i], arr[i + 1]);
        }
        covariance[arr.length - 1] = new Covariance().covariance(arr[arr.length - 1], arr[0]);
        lhm.put("Коэффициенты ковариации", covariance);
    }

//    // 5.	Рассчитать коэффициенты ковариации для всех пар случайных чисел  (НА ОДНОЙ ВЫБОРКЕ)
//    private void covariance(double[][] arr) {
//        Double[] covariance = new Double[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            covariance[i] = new Covariance().covariance(arr[i],arr[i]);
//        }
//        lhm.put("Коэффициенты ковариации", covariance);
//    }

    // 6.	Рассчитать количество элементов в каждой выборке
    private void number(double[][] arr) {
        Double[] number = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            number[i] = (double) arr[i].length;
        }
        lhm.put("Количество элементов", number);
    }

    // 7.	Рассчитать коэффициент вариации для каждой выборки
    private void variation(double[][] arr) {
        Double[] variation = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            variation[i] = Math.sqrt(StatUtils.variance(arr[i])) / Math.abs(StatUtils.mean(arr[i]));
        }
        lhm.put("Коэффициент вариации", variation);
    }

    // 8.	Рассчитать для каждой выборки построить доверительный интервал для мат. ожидания
    private void minusInterval(double[][] arr) {
        Double[] interval = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            interval[i] = StatUtils.mean(arr[i]) - (new TDistribution(arr[i].length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(arr[i]))) / Math.sqrt(arr[i].length);
        }
        lhm.put("-Доверительный интервал", interval);
    }

    private void plusInterval(double[][] arr) {
        Double[] interval = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            interval[i] = StatUtils.mean(arr[i]) + (new TDistribution(arr[i].length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(arr[i]))) / Math.sqrt(arr[i].length);
        }
        lhm.put("+Доверительный интервал", interval);
    }

    // 9.	Рассчитать оценку дисперсии для каждой выборки
    private void dispersion(double[][] arr) {
        Double[] dispersion = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dispersion[i] = StatUtils.variance(arr[i]);
        }
        lhm.put("Оценка дисперсии", dispersion);
    }

    // 10.	Рассчитать максимумы для каждой выборки
    private void max(double[][] arr) {
        Double[] max = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            max[i] = StatUtils.max(arr[i]);
        }
        lhm.put("Максимумы", max);
    }

    // 11.	Рассчитать минимумы для каждой выборки
    private void min(double[][] arr) {
        Double[] min = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            min[i] = StatUtils.min(arr[i]);
        }
        lhm.put("Минимумы", min);
    }

    public void calc(double[][] arr) {
        geom(arr);
        mean(arr);
        variance(arr);
        range(arr);
        covariance(arr);
        number(arr);
        variation(arr);
        minusInterval(arr);
        plusInterval(arr);
        dispersion(arr);
        max(arr);
        min(arr);
    }

}

