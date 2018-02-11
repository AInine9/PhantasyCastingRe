package hugu1026.com.github.phantasycastingre.manager;

import java.util.HashMap;
import java.util.Map;

public class materialList {

    private static Map<String, Map<Integer, Integer>> materialList = new HashMap<>();

    static {
        //(name, power or defence, durability or sharpness)
        materialList.put("石ころ", new HashMap<>());
        materialList.get("石ころ").put(2, 1);

        materialList.put("枝", new HashMap<>());
        materialList.get("枝").put(1, 2);

        materialList.put("酸化したアルミ", new HashMap<>());
        materialList.get("酸化したアルミ").put(2, 2);
    }

    public static Map<String, Map<Integer, Integer>> getMaterialList() {
        return materialList;
    }
}