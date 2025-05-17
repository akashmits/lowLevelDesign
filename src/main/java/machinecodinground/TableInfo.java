package machinecodinground;

import lombok.Builder;

@Builder
public class TableInfo {
    int no; //default generated Id
    int minCapacity; //default 1
    int maxCapacity; //default 1
    boolean isOccupied; // default true
}
