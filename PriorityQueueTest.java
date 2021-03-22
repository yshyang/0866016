import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {
    private static Stream<Arguments> IntListProvider(){
        return Stream.of(
                Arguments.of(new int[]{5,3,2},new int[]{2,3,5}),
                Arguments.of(new int[]{-5,-4,10},new int[]{-5,-4,10}),
                Arguments.of(new int[]{1,0,-1,-2},new int[]{-2,-1,0,1}),
                Arguments.of(new int[]{1,6,7,8},new int[]{1,6,7,8}),
                Arguments.of(new int[]{5,4,3,0},new int[]{0,3,4,5})
        );
    }
    @ParameterizedTest
    @MethodSource("IntListProvider")
    public void ParameterTest(int[] input,int[] expected){
        PriorityQueue Queuetestdata = new PriorityQueue();
        for(int e:input){
            Queuetestdata.offer(e);
            }
        for(int e:expected){
            assertEquals(e,Queuetestdata.poll());
        }
    }
    @Test
    public void QueueExceptionTest(){
        Exception exception1 =assertThrows(NullPointerException.class,()->{
            new PriorityQueue().offer(null);
        });
        Exception exception2 =assertThrows(IllegalArgumentException.class,()->{
            new PriorityQueue(-1,null);
        });
        Exception exception3 =assertThrows(NullPointerException.class,()->{
            new PriorityQueue().add(null);
        });

    }
}




