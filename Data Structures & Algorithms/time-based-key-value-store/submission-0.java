public class TimeStampedValues{ 
    //this is a structure that ill be putting in my arraylist
int timeStamp;
String value;

 public TimeStampedValues(int timeStamp, String value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}

class TimeMap {

Map<String, ArrayList<TimeStampedValues>> entriesByKey;

    public TimeMap() {
        entriesByKey=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!entriesByKey.containsKey(key)){
            entriesByKey.put(key, new ArrayList<>());
        }
       ArrayList<TimeStampedValues> arr=entriesByKey.get(key);
       arr.add(new TimeStampedValues(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!entriesByKey.containsKey(key)){
            return "";
        }

        ArrayList<TimeStampedValues> arr=entriesByKey.get(key);

        int l=0;
        int r=arr.size()-1;

        String res="";

        while(l<=r){
            int mid=l+(r-l)/2;

            if(arr.get(mid).timeStamp<=timestamp){
                res=arr.get(mid).value;
                l=mid+1;
            }
            else 
            r=mid-1;
        }
        return res;
    }
}
