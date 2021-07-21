package test.leetcode;


import java.util.Comparator;
public class RefugeeCompare implements Comparator<Refugee> {
    @Override
    public int compare(Refugee o1, Refugee o2) {

        if (o1.getAge() > 12 && o2.getAge() <=12){
            return 1;
        }else if (o1.getAge() <= 12 && o2.getAge() <=12){
            if (o1.getPoint() > o2.getPoint()){
                return 1;
            }else {
                return -1;
            }
        }else if (o1.getSex()=="male" && o2.getSex()=="female"){
            return 1;
        }else if (o1.getSex().equals(o2.getSex())){
            if (o1.getPoint() > o2.getPoint()){
                return 1;
            }else {
                return -1;
            }
        }else {
            return -1;
        }
    }
}
