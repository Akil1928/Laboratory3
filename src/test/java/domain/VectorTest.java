package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void vectorTest() {

        Vector vector = new Vector(50);
        util.Utility.fill(vector.getData());
        //vector.fill();//LLena el vector
for(int i = 0; i <50;i++){
    vector.add(util.Utility.random(50));
}
        System.out.println("Vector content not sorted: "+util.Utility.show(vector.getData()));
        vector.sort();
        System.out.println("Vector content sorted: "+util.Utility.show(vector.getData()));
        System.out.println("Vector size: "+vector.size());
        System.out.println(vector.isEmpty() ? "Vector is emply" : "Vector is not emply");
    }
}