package com.whh.algorithmlib;

/**
 * Create by huscarter@163.com on 2020/8/13
 * <p>
 * 类说明: 二分法查找
 */
public class MidJava {

    public static void main(String[] args) {

        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println("test:"+optFind(arr,1));

    }

    public static boolean optFind(int[][] arr, int target) {
        int iMid = arr.length >> 1;
        int jMid = arr[iMid].length >> 1;
        if(arr[iMid][jMid] > target){
            for(int i = iMid;i>-1;i--){
                if(optFindInner(arr[i],target)){
                    return true;
                }
            }
            return  false;
        }else if(arr[iMid][jMid] < target){
            for(int i = iMid ;i<arr.length;i++){
                if(optFindInner(arr[i],target)){
                    return true;
                }
            }
            return  false;
        }
        return true;
    }

    public static boolean optFindInner(int[] arrInner, int target){
        int innerMid = arrInner.length >> 1;
        if(arrInner[innerMid] > target){
            for (int i = innerMid--;i>-1;i--){
                if(arrInner[i] == target){
                    return true;
                }
            }
            return false;
        }else if(arrInner[innerMid]<target){
            for (int i = innerMid ++ ;i<arrInner.length;i++){
                if(arrInner[i] == target){
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
