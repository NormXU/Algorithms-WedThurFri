# Parking Lot

```java
public enum VehicleSize{
    Compact(1);
    Large(2);
    
    private final int size;
    
    VehicleSize(int size){
        this.size = size;
    }
    
    public int getSize(){
        return size;
    }
}
```

```java
public abstract class Vehicle{
    public abstract VehicleSize getSize();
} 
```

```java
public class Car extends Vehicle{
    @Override
    public VehicleSize getSize(){
        return VehicleSize.Compact;
    }
}
```

```java
public class Truck extends Vehicle{
    @Override
    public VehicleSize getSize(){
        return VehicleSize.Large;
    }
}
```

```java
class ParkingSpot{
    // Spot 的属性:
    // parking spot 的size
    // 是否能停进去 ？
    // 停车
    // 离开
    private final VehicleSize size;
    private Vehicle currentVehicle;
    
    ParkingSpot(VehicleSize size){
        this.size = size;
    }
    
    boolean fit(Vehicle v){
        return currentVehicle == null && size.getSize() >= v.getSize().getSize();
    }
    
    void park(Vehicle v){
        currentVehicle = v;
    }
    
    void leave(){
        currentVehicle = null;
    }
    
    Vehicle getVehicle(){
        return currentVehicle;
    }
    
}
```

```java
class Level{
    private final List<ParkingSpot> spots;
    
    Level(int numOfSpots){
        List<ParkingSpot> list = new ArrayList<>(numOfSpots);
        int i = 0;
        // 一半小车车位
        for(; i < numOfSpots/2; i++){
            list.add(new ParkingSpot(VehicleSize.Compact));
        }
        // 一半大车车位
        for(; i < numOfSpots; i++){
            list.add(new ParkingSpot(VehicleSize.Large));
        }
        // 把一个list变成不可改变的list
        spots = Collections.unmodifiableList(list);
        
    }
    
    boolean hasSpot(Vehicle v){
        for(ParkingSpot s : spots){
            if(s.fit(v)){
                return true;
            }
        }
        return false;
    }
    
    boolean park(Vehicle v){
        for(ParkingSpot s : spots){
            if(s.fit(v)){
               s.park(v);
               return true;
            }
        }
        return false;
    }
    
    boolean leave(Vehicle v){
        for(ParkingSpot s : spots){
            if(s.getVehicle == v){
                s.leave();
                return true;
            }
        }
        return false;
    }
    
}
```

```java
public class ParkingLot{
    private final Level[] levels;
    public ParkingLot(int numLevels, int numSpotsPerLevel){
        levels = new Level[numLevels];
        for(int i = 0; i < numLevels; i++){
            levels[i] = new Level(numSpotsPerLevel);
        }
    }
    
    public boolean hasSpot(Vehicle v){
        for(Level l : levels){
            if(l.hasSpot(v)){
                return true;
            }
        }
        return false;
    }
    
    
    public boolean park(Vehicle v){
        for(Level l : levels){
            if(l.park(v)){
                return true;
            }
        }
        return false;
    }
    
    
    public boolean leave(Vehicle v){
        for(Level l : levels){
            if(l.leave(v)){
                return true;
            }
        }
        return false;
    }
}
```

