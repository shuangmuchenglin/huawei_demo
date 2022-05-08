package design_pattern.BuilderPattern;

/**
 * @ClassName: BuilderPatternDemo
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        //套餐1：VegBurger × 2 + CokeCola × 1
        System.out.println("ComboMeal1（套餐1）");
        Builder comboMeal1 = new Builder().build(new VegBurger(), 2)
                .build(new CokeCola(), 1);
        comboMeal1.showItems();
        System.out.println("Total Cost: " + comboMeal1.getCost());
        //套餐2：ChickenBurger × 3 + Pepsi × 3
        System.out.println("\nComboMeal2（套餐2）");
        Builder comboMeal2 = new Builder().build(new ChickenBurger(), 3)
                .build(new Pepsi(), 3);
        comboMeal2.showItems();
        System.out.println("Total Cost: " + comboMeal2.getCost());
        //套餐3：Chicken rolls ×1 + tea × 1
        System.out.println("\nComboMeal3（套餐3）");
        Builder comboMeal3 = new Builder().build(new ChickenRolls(), 1)
                .build(new Tea(), 1);
        comboMeal3.showItems();
        System.out.println("Total Cost: " + comboMeal3.getCost());
        //套餐4：ChickenBurger ×1 + ChickenRolls × 1 + OrangeJuice × 1
        System.out.println("\nComboMeal4（套餐4）");
        Builder comboMeal4 = new Builder().build(new ChickenBurger(), 1)
                .build(new ChickenRolls(), 1)
                .build(new OrangeJuice(), 1);
        comboMeal4.showItems();
        System.out.println("Total Cost: " + comboMeal4.getCost());
    }
}