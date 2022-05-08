package design_pattern.BuilderPattern;

/**
 * @ClassName: Builder(对套餐进行食物组合的建造者类)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
import java.util.HashMap;
import java.util.Map;

public class Builder {
    private Map<Item,Integer> items = new HashMap<>();

    public Builder build(Item item,Integer num){
        items.put(item,num);
        return this;
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items.keySet()) {
            cost += item.price()*items.get(item);
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items.keySet()) {
            System.out.print("item:"+item.name());
            System.out.print("\tnumber:"+items.get(item));
            System.out.print("\tpacking:"+item.packing().pack());
            System.out.println("\tunit-price:"+item.price());
        }
    }
}
