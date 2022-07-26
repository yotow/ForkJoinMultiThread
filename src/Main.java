public class Main {


    public static void main(String[] args) {
        ArrayCalcService arrayCalcService = new ArrayCalcService();
        int[] arr = arrayCalcService.getArray(1_000000000);
        //System.out.println(arrayCalcService.extCalcSum(arr)); //мс: 3328
        System.out.println(arrayCalcService.calcSum(arr)); //мс: 354


    }
}
